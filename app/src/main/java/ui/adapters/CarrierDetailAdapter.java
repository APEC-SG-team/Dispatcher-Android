package ui.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apec.dispatcher.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import base.BaseAdapter;
import behaviour.CircleTransform;
import butterknife.BindView;
import butterknife.ButterKnife;
import model.SettingItem;

/**
 * Created by winhtaikaung on 18/5/17.
 */

public class CarrierDetailAdapter extends BaseAdapter<BaseAdapter.BaseViewHolder> {
    private int PROFILE_HEADER_VIEW = 000;
    private int RATING_VIEW = 111;
    private int VERIFICATION_STATUS = 222;
    private int MAKE_OFFER = 333;

    Context mContext;
    List<Object> mProfileList;
    Fragment mFragment;
    private boolean onBind;

    public CarrierDetailAdapter(Fragment fragment) {

        mProfileList = new ArrayList<>();
        mFragment = fragment;
    }

    public void setmItemDetailViewList(List<Object> profileList) {
        if (!onBind) {
            this.mProfileList = profileList;
            notifyDataSetChanged();
        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        if (viewType == PROFILE_HEADER_VIEW) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.profile_item_header_view, parent, false);
            return new CarrierDetailAdapter.HeaderViewHolder(view, this);
        } else if (viewType == RATING_VIEW) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.courierdetail_item_review_view, parent, false);
            return new CarrierDetailAdapter.RatingViewHolder(view, this);
        } else if (viewType == VERIFICATION_STATUS) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.courierdetail_verification_status_view, parent, false);
            return new CarrierDetailAdapter.VerificationViewHolder(view, this);
        } else if (viewType == MAKE_OFFER) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.courierdetail_make_offer_view, parent, false);
            return new CarrierDetailAdapter.MakeOfferViewHolder(view, this);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.courierdetail_make_offer_view, parent, false);
            return new CarrierDetailAdapter.MakeOfferViewHolder(view, this);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == PROFILE_HEADER_VIEW) {
            HeaderViewHolder vh = (HeaderViewHolder) holder;
            SettingItem viewItem = (SettingItem) mProfileList.get(position);
            Picasso.with(mContext).load(viewItem.getAvatarUrl())
                    .placeholder(mContext.getResources().getDrawable(R.mipmap.ic_profile)).transform(new CircleTransform())
                    .into(vh.ivAvatar);
            vh.tvName.setText(viewItem.getUserName());
        }
    }

    @Override
    public int getItemCount() {
        return mProfileList.size();
    }

    @Override
    public int getItemViewType(int position) {
        int viewType = 0;
        switch (position) {
            case 0:
                viewType = PROFILE_HEADER_VIEW;
                break;
            case 1:
                viewType = RATING_VIEW;
                break;
            case 2:
                viewType = VERIFICATION_STATUS;
                break;
            case 3:
                viewType = MAKE_OFFER;
                break;
        }
        return viewType;

    }

    class HeaderViewHolder extends BaseViewHolder {
        @BindView(R.id.avatar_iv)
        ImageView ivAvatar;

        @BindView(R.id.name_tv)
        TextView tvName;

        public HeaderViewHolder(View itemView, CarrierDetailAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }

    class RatingViewHolder extends BaseViewHolder {


        public RatingViewHolder(View itemView, CarrierDetailAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }

    class VerificationViewHolder extends BaseViewHolder {
        public VerificationViewHolder(View itemView, CarrierDetailAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }

    class LocationViewHolder extends BaseViewHolder {
        public LocationViewHolder(View itemView, CarrierDetailAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }

    class MakeOfferViewHolder extends BaseViewHolder {
        public MakeOfferViewHolder(View itemView, CarrierDetailAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }
}
