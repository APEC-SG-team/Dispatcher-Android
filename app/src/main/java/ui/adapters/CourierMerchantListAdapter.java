package ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apec.dispatcher.R;

import java.util.ArrayList;
import java.util.List;

import base.BaseAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by winhtaikaung on 16/5/17.
 */

public class CourierMerchantListAdapter extends BaseAdapter<BaseAdapter.BaseViewHolder> {

    private int COURIER_VIEW_HOLDER = 111;
    private int MERCHANT_VIEW_HOLDER = 222;

    Context mContext;
    List<Object> mCourierMerchantList;
    boolean isCourierAdapter = true;

    /**
     * is Courier Adapter
     *
     * @param isCourieradapter
     */
    public CourierMerchantListAdapter(boolean isCourieradapter) {
        mCourierMerchantList = new ArrayList<>();
        isCourierAdapter = isCourieradapter;
    }

    public void setCourierMerchantList(List<Object> courierMerchantList) {
        this.mCourierMerchantList = courierMerchantList;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = null;
        if (viewType == COURIER_VIEW_HOLDER) {
            view = LayoutInflater.from(mContext).inflate(R.layout.courier_item_view, parent, false);
            return new CourierViewHolder(view, this);
        } else if (viewType == MERCHANT_VIEW_HOLDER) {
            return null;
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (holder.getItemViewType() == COURIER_VIEW_HOLDER) {
            CourierViewHolder vh = (CourierViewHolder) holder;
            //TODO data Binding for Courier View Holder
        } else if (holder.getItemViewType() == MERCHANT_VIEW_HOLDER) {

        } else {
//            return null;
        }
    }

    @Override
    public int getItemCount() {
        return mCourierMerchantList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isCourierAdapter) {
            return COURIER_VIEW_HOLDER;
        } else {
            return MERCHANT_VIEW_HOLDER;
        }
    }


    class CourierViewHolder extends BaseViewHolder {
        @BindView(R.id.imageView)
        ImageView ivCourier;

        @BindView(R.id.tv_title)
        TextView tvTitle;

        @BindView(R.id.tv_Subtitle)
        TextView tvSubtitle;

        @BindView(R.id.tv_delivery)
        TextView tvDelivery;

        public CourierViewHolder(View itemView, CourierMerchantListAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }
}
