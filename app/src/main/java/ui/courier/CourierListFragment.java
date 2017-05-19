package ui.courier;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.apec.dispatcher.R;

import java.util.ArrayList;
import java.util.List;

import base.EndlessRecyclerViewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import model.Courier;
import ui.DetailActivity;
import ui.adapters.CourierMerchantListAdapter;
import utils.MySharedPreference;

import static ui.profile.ProfileFragment.IS_MERCHANT;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourierListFragment extends Fragment implements CourierListPresenter.View, AdapterView.OnItemClickListener {

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

    void init() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        if (!MySharedPreference.getInstance(this.getContext()).getBooleanPreference(IS_MERCHANT, false)) {
            mCouruerMerchantAdapter = new CourierMerchantListAdapter(true);
        }else{
            mCouruerMerchantAdapter = new CourierMerchantListAdapter(false);
        }
        mInboxListView.setLayoutManager(mLayoutManager);
        this.showProgress();
        mCouruerMerchantAdapter.setOnItemClickListener(this);
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
        if (!MySharedPreference.getInstance(this.getContext()).getBooleanPreference(IS_MERCHANT, false)) {
            //if merchant is true
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
        } else {
            //if merchant is false
            if (courierList.size() > 0) {
                if (mCounter == 1) {
                    this.mCourierList = createItemList();
                } else {
                    this.mCourierList.addAll(createItemList());
                }
                mCouruerMerchantAdapter.setCourierMerchantList(this.mCourierList);

                mEndlessRecyclerViewAdapter.onDataReady(true);
                mCounter++;

            } else {
                mEndlessRecyclerViewAdapter.onDataReady(false);
            }
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        if (!MySharedPreference.getInstance(this.getContext()).getBooleanPreference(IS_MERCHANT, false)) {
            Intent intent = new Intent(this.getActivity(), DetailActivity.class);
            intent.putExtra("IS_COURIER", true);

            startActivity(intent);
        }else{
            Intent intent = new Intent(this.getActivity(), DetailActivity.class);
            intent.putExtra("IS_COURIER", false);

            startActivity(intent);
        }
    }

    private List<Object> createItemList() {
        List<Object> dummyList = new ArrayList<>();

        String[] names = {"Copper 5 tons", "Alluminium 10 tons", "Office Paper 6 tons", "Vending Machine 2000", "Refrigerator"};
        String[] from = {"England", "Vietnam", "New Zealand", "Indonesia", "Malaysia"};
        String[] date = {"12-05-2017", "20-05-2017", "09-07-2017", "08-09-2017", "06-11-2017"};
        String[] imGurls = {"http://energyandgold.com/wp-content/uploads/2016/11/oxygen_free_copper_rod.png",
                "https://www.etfsecurities.com/media/352268/aluminium.jpg",
                "http://www.staples-3p.com/s7/is/image/Staples/s0691352_sc7?$splssku$",
                "http://pic.made-in-china.com/6f3j00fMnTCYwdracK/Packing-of-Vending-Machine.jpg",
                "http://www.worldshipping.org/images/ReeferContainer01.jpg"};
        for (int i = 0; i < 5; i++) {
            Object dummy = new Courier(names[i], from[i], "Singapore", date[i], imGurls[i]);
            dummyList.add(dummy);
        }
        return dummyList;
    }
}
