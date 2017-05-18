package ui.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.apec.dispatcher.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import base.BaseAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by winhtaikaung on 18/5/17.
 */

public class ItemDetailAdapter extends BaseAdapter<BaseAdapter.BaseViewHolder> {

    private int ITEM_IMG_VIEW = 000;
    private int ITEM_DESCRIPTION_VIEW = 111;
    private int ITEM_SIZE_VIEW = 222;
    private int ITEM_IS_FRAGILE_VIEW = 333;
    private int ITEM_WEIGHT_VIEW = 444;
    private int DELIVERY_VIEW = 555;
    private int STATUS_VIEW = 666;
    private int MAKE_OFFER = 777;


    Context mContext;
    List<Object> mItemDetailViewList;
    private boolean onBind;
    Fragment mFragment;

    public ItemDetailAdapter() {
        mItemDetailViewList = new ArrayList<>();
    }

    public ItemDetailAdapter(Fragment fragment) {

        mItemDetailViewList = new ArrayList<>();
        mFragment = fragment;
    }

    public void setmItemDetailViewList(List<Object> profileList) {
        if (!onBind) {
            this.mItemDetailViewList = profileList;
            notifyDataSetChanged();
        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        if (viewType == ITEM_IMG_VIEW) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.packagedetail_item_img_view, parent, false);
            return new ItemDetailAdapter.ItemImageViewHolder(view, this);
        } else if (viewType == ITEM_DESCRIPTION_VIEW) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.packagedetail_item_description_view, parent, false);
            return new ItemDetailAdapter.ItemDescriptionViewHolder(view, this);
        } else if (viewType == ITEM_SIZE_VIEW) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.packagedetail_item_size_view, parent, false);
            return new ItemDetailAdapter.ItemSizeViewHolder(view, this);
        } else if (viewType == ITEM_IS_FRAGILE_VIEW) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.packagedetail_item_fraglile_view, parent, false);
            return new ItemDetailAdapter.ItemIsFraglieViewHolder(view, this);
        } else if (viewType == ITEM_WEIGHT_VIEW) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.packagedetail_item_weight_view, parent, false);
            return new ItemDetailAdapter.ItemWeightViewHolder(view, this);
        } else if (viewType == DELIVERY_VIEW) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.packagedetail_item_delivery_view, parent, false);
            return new ItemDetailAdapter.ItemDeliveryViewHolder(view, this);
        } else if (viewType == STATUS_VIEW) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.packagedetail_item_status_view, parent, false);
            return new ItemDetailAdapter.ItemStatusViewHolder(view, this);
        } else if (viewType == MAKE_OFFER) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.packagedetail_item_make_offer_view, parent, false);
            return new ItemDetailAdapter.ItemMakeOfferViewHolder(view, this);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.packagedetail_item_make_offer_view, parent, false);
            return new ItemDetailAdapter.ItemMakeOfferViewHolder(view, this);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int view = getItemViewType(position);
        if (view == ITEM_IMG_VIEW) {
            ItemImageViewHolder vh = (ItemImageViewHolder) holder;
            Picasso.with(mContext).load("https://ae01.alicdn.com/kf/HTB1afDYQFXXXXXKXpXXq6xXFXXXj/Homgeek-Mini-Portable-Compact-Manual-Espresso-Maker-Black-Coffee-Maker-Hand-Operated-Coffee-Machine-Cappuccino-For.jpg")

                    .into(vh.itemView);
        }

    }

    @Override
    public int getItemViewType(int position) {
        int view = 0;
        switch (position) {
            case 0:
                view = ITEM_IMG_VIEW;
                break;
            case 1:
                view = ITEM_DESCRIPTION_VIEW;
                break;
            case 2:
                view = ITEM_SIZE_VIEW;
                break;
            case 4:
                view = ITEM_IS_FRAGILE_VIEW;
                break;
            case 3:
                view = ITEM_WEIGHT_VIEW;
                break;
            case 5:
                view = DELIVERY_VIEW;
                break;
            case 6:
                view = STATUS_VIEW;
                break;
            case 7:
                view = MAKE_OFFER;
                break;
        }
        return view;
    }

    @Override
    public int getItemCount() {
        return mItemDetailViewList.size();
    }

    class ItemImageViewHolder extends BaseViewHolder {
        @BindView(R.id.ivItem)
        ImageView itemView;

        public ItemImageViewHolder(View itemView, ItemDetailAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }

    class ItemDescriptionViewHolder extends BaseViewHolder {

        public ItemDescriptionViewHolder(View itemView, ItemDetailAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }

    class ItemSizeViewHolder extends BaseViewHolder {

        public ItemSizeViewHolder(View itemView, ItemDetailAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }

    class ItemIsFraglieViewHolder extends BaseViewHolder {

        public ItemIsFraglieViewHolder(View itemView, ItemDetailAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }

    class ItemWeightViewHolder extends BaseViewHolder {

        public ItemWeightViewHolder(View itemView, ItemDetailAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }

    class ItemDeliveryViewHolder extends BaseViewHolder {

        public ItemDeliveryViewHolder(View itemView, ItemDetailAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }

    class ItemStatusViewHolder extends BaseViewHolder {

        public ItemStatusViewHolder(View itemView, ItemDetailAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }

    class ItemMakeOfferViewHolder extends BaseViewHolder {

        public ItemMakeOfferViewHolder(View itemView, ItemDetailAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }


}
