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
import utils.Utils;

import static base.EndlessRecyclerViewAdapter.TYPE_PENDING;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public class InboxListAdapter extends BaseAdapter<BaseAdapter.BaseViewHolder> {

    Context mContext;
    List<Object> mInboxList;


    public InboxListAdapter() {
        mInboxList = new ArrayList<>();
    }

    public void setmInboxList(List<Object> inboxList) {
        this.mInboxList = inboxList;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.inbox_item_view, parent, false);
        return new ViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (getItemViewType(position) != TYPE_PENDING) {
            ViewHolder vh = (ViewHolder) holder;
            if (vh != null) {
                if (mInboxList.get(position) != null) {
                    Object inbox = mInboxList.get(position);
                    vh.ivBgProfile.setImageDrawable(Utils.getRandomDrawableBg(mContext));

                }
            }
        }

    }

    @Override
    public int getItemCount() {
        return mInboxList != null ? mInboxList.size() : 0;
    }

    class ViewHolder extends BaseViewHolder {
        @BindView(R.id.from)
        TextView tvFrom;

        @BindView(R.id.txt_primary)
        TextView tvPrimrary;

        @BindView(R.id.txt_secondary)
        TextView tvSecondary;

        @BindView(R.id.icon_text)
        TextView tvIconText;

        @BindView(R.id.icon_profile)
        ImageView ivProfile;

        @BindView(R.id.ivBgProfile)
        ImageView ivBgProfile;

        public ViewHolder(View itemView, InboxListAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }
}
