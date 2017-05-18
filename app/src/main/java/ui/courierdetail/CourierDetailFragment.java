package ui.courierdetail;

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
import ui.adapters.CarrierDetailAdapter;


public class CourierDetailFragment extends Fragment implements CarrierDetailPresenter.View {

    private CarrierDetailPresenter presenter;
    private CarrierDetailInteractor inboxListInteractor;

    private int mCounter = 1;
    private List<Object> mItemDetailList;

    @BindView(R.id.rvPackageDetailViewList)
    RecyclerView rvPackageDetail;


    @BindView(R.id.progressView)
    FrameLayout mProgressView;

    @BindView(R.id.errView)
    FrameLayout mErrorView;

    @BindView(R.id.tvErrorText)
    TextView tvErrorText;
    private CarrierDetailAdapter mInboxListAdapter;
    private EndlessRecyclerViewAdapter mEndlessRecyclerViewAdapter;

    public CourierDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_courier_detail, container, false);
        ButterKnife.bind(this, v);
        inboxListInteractor = new CarrierDetailInteractorImpl();
        presenter = new CarrierDetailPresenterImpl(this, inboxListInteractor);
        init();
        return v;
    }

    private void init() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        mInboxListAdapter = new CarrierDetailAdapter(this);
        rvPackageDetail.setLayoutManager(mLayoutManager);
        this.showProgress();
        mEndlessRecyclerViewAdapter = new EndlessRecyclerViewAdapter(this.getActivity(), mInboxListAdapter, new EndlessRecyclerViewAdapter.RequestToLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {

                if (mCounter == 1) {
                    presenter.getPackageDetailList("3");
                } else {
                    presenter.getPackageDetailList("3");
                }
            }
        });
        CourierDetailFragment.this.hideProgress();
        rvPackageDetail.setAdapter(mEndlessRecyclerViewAdapter);
    }

    @Override
    public void setPackageDetail(List<Object> packageDetail) {
        if (packageDetail.size() > 0) {
            if (mCounter == 1) {
                this.mItemDetailList = packageDetail;
            } else {

//                this.mItemDetailList.addAll(packageDetail);

            }
            mInboxListAdapter.setmItemDetailViewList(this.mItemDetailList);
            mEndlessRecyclerViewAdapter.onDataReady(false);
            mCounter++;

        } else {
            mEndlessRecyclerViewAdapter.onDataReady(false);
        }
    }

    @Override
    public void showProgress() {
        mProgressView.setVisibility(View.VISIBLE);
        rvPackageDetail.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        mProgressView.setVisibility(View.GONE);
        rvPackageDetail.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String message) {
        mProgressView.setVisibility(View.GONE);
        rvPackageDetail.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
        tvErrorText.setText(message);
    }

    @Override
    public void hideError(String message) {
        mErrorView.setVisibility(View.GONE);
        rvPackageDetail.setVisibility(View.VISIBLE);
        tvErrorText.setText(message);
    }
}
