package ui.adapters;

import android.content.Context;
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
import butterknife.BindView;
import butterknife.ButterKnife;
import model.Courier;

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
            view = LayoutInflater.from(mContext).inflate(R.layout.courier_item_view, parent, false);
            return new MerchantViewHolder(view, this);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (holder.getItemViewType() == COURIER_VIEW_HOLDER) {
            CourierViewHolder vh = (CourierViewHolder) holder;
            //TODO data Binding for Courier View Holder
            Courier c =(Courier) mCourierMerchantList.get(position);
            vh.tvTitle.setText(c.getName());
            vh.tvSubtitle.setText(c.getFrom() +" - "+c.getTo());
            vh.tvDelivery.setText("Etm Departure date "+c.getEtmDelivaryDate());
//            Picasso.with(mContext).load("https://randomuser.me/api/portraits/men/" + position+1 + ".jpg").into(vh.ivCourier);
            vh.ivCourier.setVisibility(View.GONE);
        } else if (holder.getItemViewType() == MERCHANT_VIEW_HOLDER) {
            MerchantViewHolder vh = (MerchantViewHolder) holder;
            //TODO data Binding for Courier View Holder
            Courier c =(Courier) mCourierMerchantList.get(position);
            vh.tvTitle.setText(c.getName());
            vh.tvSubtitle.setText(c.getFrom() +" - "+c.getTo());
            vh.tvDelivery.setText("Etm Departure date "+c.getEtmDelivaryDate());
            Picasso.with(mContext).load(c.getImgUrl()).into(vh.ivCourier);
//            vh.ivCourier.setVisibility(View.GONE);
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

    class MerchantViewHolder extends BaseViewHolder {
        @BindView(R.id.imageView)
        ImageView ivCourier;

        @BindView(R.id.tv_title)
        TextView tvTitle;

        @BindView(R.id.tv_Subtitle)
        TextView tvSubtitle;

        @BindView(R.id.tv_delivery)
        TextView tvDelivery;

        public MerchantViewHolder(View itemView, CourierMerchantListAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }
}
