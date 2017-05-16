package ui.inbox;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.apec.dispatcher.R;

import java.util.List;

import base.EndlessRecyclerViewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import ui.adapters.InboxListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class InboxListFragment extends Fragment implements InboxListPresenter.View {

    private InboxListPresenter presenter;
    private InboxListInteractor inboxListInteractor;

    private int mCounter = 1;

    private List<Object> mInboxList;

    @BindView(R.id.rvInboxList)
    RecyclerView mInboxListView;


    @BindView(R.id.progressView)
    FrameLayout mProgressView;

    @BindView(R.id.errView)
    FrameLayout mErrorView;

    @BindView(R.id.tvErrorText)
    TextView tvErrorText;

    private InboxListAdapter mInboxListAdapter;
    private EndlessRecyclerViewAdapter mEndlessRecyclerViewAdapter;


    public InboxListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_inbox_list, container, false);
        ButterKnife.bind(this, v);

        inboxListInteractor = new InboxListInteractorImpl();
        presenter = new InboxListPresenterImpl(this, inboxListInteractor);

        init();
        return v;
    }

    void init() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        mInboxListAdapter = new InboxListAdapter();
        mInboxListView.setLayoutManager(mLayoutManager);
        this.showProgress();
        mEndlessRecyclerViewAdapter = new EndlessRecyclerViewAdapter(this.getActivity(), mInboxListAdapter, new EndlessRecyclerViewAdapter.RequestToLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {

                if (mCounter == 1) {
                    presenter.getInboxList("3");
                } else {
                    presenter.getInboxList("3");

                }
            }
        });
        InboxListFragment.this.hideProgress();
        mInboxListView.setAdapter(mEndlessRecyclerViewAdapter);
    }


    @Override
    public void setInboxList(List<Object> inboxList) {
        //TODO bind data from api to list View here

        if (inboxList.size() > 0) {
            if (mCounter == 1) {
                this.mInboxList = inboxList;
            } else {

                this.mInboxList.addAll(inboxList);

            }
            mInboxListAdapter.setmInboxList(this.mInboxList);
            mEndlessRecyclerViewAdapter.onDataReady(true);
            mCounter++;

        } else {
            mEndlessRecyclerViewAdapter.onDataReady(false);
        }
    }

    @Override
    public void showProgress() {
        mProgressView.setVisibility(View.VISIBLE);
        mInboxListView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        mProgressView.setVisibility(View.GONE);
        mInboxListView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String message) {
        mProgressView.setVisibility(View.GONE);
        mInboxListView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
        tvErrorText.setText(message);
    }

    @Override
    public void hideError(String message) {
        mErrorView.setVisibility(View.GONE);
        mInboxListView.setVisibility(View.VISIBLE);
        tvErrorText.setText(message);
    }
}
