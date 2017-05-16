package ui.courier;


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
import ui.adapters.CourierMerchantListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourierListFragment extends Fragment implements CourierListPresenter.View {

    private CourierListPresenter presenter;
    private CourierListInteractor courierListInteractor;

    private CourierMerchantListAdapter mCouruerMerchantAdapter;
    private EndlessRecyclerViewAdapter mEndlessRecyclerViewAdapter;

    private int mCounter = 1;

    private List<Object> mCourierList;

    @BindView(R.id.rvCourierList)
    RecyclerView mInboxListView;


    @BindView(R.id.progressView)
    FrameLayout mProgressView;

    @BindView(R.id.errView)
    FrameLayout mErrorView;

    @BindView(R.id.tvErrorText)
    TextView tvErrorText;

    public CourierListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_courier_list, container, false);
        ButterKnife.bind(this, v);
        courierListInteractor = new CourierListInteractorImpl();
        presenter = new CourierListPresenterImpl(this, courierListInteractor);
        init();
        return v;
    }

    void init(){
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        mCouruerMerchantAdapter = new CourierMerchantListAdapter(true);
        mInboxListView.setLayoutManager(mLayoutManager);
        this.showProgress();
        mEndlessRecyclerViewAdapter = new EndlessRecyclerViewAdapter(this.getActivity(), mCouruerMerchantAdapter, new EndlessRecyclerViewAdapter.RequestToLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {

                if (mCounter == 1) {
                    presenter.getCourierList("3");
                } else {
                    presenter.getCourierList("3");

                }
            }
        });
        CourierListFragment.this.hideProgress();
        mInboxListView.setAdapter(mEndlessRecyclerViewAdapter);
    }

    @Override
    public void setCourierList(List<Object> courierList) {
        //TODO bind data from api to list View here

        if (courierList.size() > 0) {
            if (mCounter == 1) {
                this.mCourierList = courierList;
            } else {

                this.mCourierList.addAll(courierList);

            }
            mCouruerMerchantAdapter.setCourierMerchantList(this.mCourierList);
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
