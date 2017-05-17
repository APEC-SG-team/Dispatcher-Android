package ui.profile;


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
import ui.adapters.ProfileViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements ProfileListPresenter.View {

    private ProfileListPresenter presenter;
    private ProfileListInteractor inboxListInteractor;

    private int mCounter = 1;

    private List<Object> mInboxList;

    @BindView(R.id.rvProfileList)
    RecyclerView mProfileListView;

    @BindView(R.id.progressView)
    FrameLayout mProgressView;

    @BindView(R.id.errView)
    FrameLayout mErrorView;

    @BindView(R.id.tvErrorText)
    TextView tvErrorText;

    private ProfileViewAdapter mProfileListAdapter;
    private EndlessRecyclerViewAdapter mEndlessRecyclerViewAdapter;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, v);

        inboxListInteractor = new ProfileListInteractorImpl();
        presenter = new ProfileListPresenterImpl(this, inboxListInteractor);

        init();
        return v;        // Inflate the layout for this fragment
    }

    void init() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        mProfileListAdapter = new ProfileViewAdapter();
        mProfileListView.setLayoutManager(mLayoutManager);
        this.showProgress();
        mEndlessRecyclerViewAdapter = new EndlessRecyclerViewAdapter(this.getActivity(), mProfileListAdapter, new EndlessRecyclerViewAdapter.RequestToLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {

                if (mCounter == 1) {
                    presenter.getProfile("3");
                }
            }
        });
        ProfileFragment.this.hideProgress();
        mProfileListView.setAdapter(mEndlessRecyclerViewAdapter);
    }

    @Override
    public void setProfileList(List<Object> profileList) {
        if (profileList.size() > 0) {
            if (mCounter == 1) {
                this.mInboxList = profileList;
            } else {

//                this.mInboxList.addAll(profileList);

            }
            mProfileListAdapter.setmProfileList(this.mInboxList);
            mEndlessRecyclerViewAdapter.onDataReady(false);
//            mCounter++;

        } else {
            mEndlessRecyclerViewAdapter.onDataReady(false);
        }
    }

    @Override
    public void showProgress() {
        mProgressView.setVisibility(View.VISIBLE);
        mProfileListView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        mProgressView.setVisibility(View.GONE);
        mProfileListView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String message) {
        mProgressView.setVisibility(View.GONE);
        mProfileListView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
        tvErrorText.setText(message);
    }

    @Override
    public void hideError(String message) {
        mErrorView.setVisibility(View.GONE);
        mProfileListView.setVisibility(View.VISIBLE);
        tvErrorText.setText(message);
    }
}
