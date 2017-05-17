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
import behaviour.CircleTransform;
import butterknife.BindView;
import butterknife.ButterKnife;
import model.SettingItem;

/**
 * Created by winhtaikaung on 17/5/17.
 */

public class ProfileViewAdapter extends BaseAdapter<BaseAdapter.BaseViewHolder> {

    private int HEADER_VIEW = 000;
    private int DETAIL_ITEM_VIEW = 111;

    Context mContext;
    List<Object> mProfileList;

    public ProfileViewAdapter() {
        mProfileList = new ArrayList<>();
    }

    public void setmProfileList(List<Object> profileList) {
        this.mProfileList = profileList;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        if (viewType == HEADER_VIEW) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.profile_item_header_view, parent, false);
            return new ProfileViewAdapter.HeaderViewHolder(view, this);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.profile_item_detail_view, parent, false);
            return new ProfileViewAdapter.DetailListItemViewHolder(view, this);
        }

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == HEADER_VIEW) {
            HeaderViewHolder vh = (HeaderViewHolder) holder;
            SettingItem viewItem = (SettingItem) mProfileList.get(position);
            Picasso.with(mContext).load(viewItem.getAvatarUrl())
                    .placeholder(mContext.getResources().getDrawable(R.mipmap.ic_profile)).transform(new CircleTransform())
                    .into(vh.ivAvatar);
            vh.tvName.setText(viewItem.getUserName());
        } else {
            DetailListItemViewHolder vh = (DetailListItemViewHolder) holder;
            SettingItem viewItem = (SettingItem) mProfileList.get(position);
            vh.tvTitle.setText(viewItem.getSettingTitle());
            Picasso.with(mContext).load(viewItem.getIconResId()).into(vh.ivItem);
        }

    }

    @Override
    public int getItemCount() {
        return mProfileList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADER_VIEW;
        } else {
            return DETAIL_ITEM_VIEW;
        }
    }

    class HeaderViewHolder extends BaseViewHolder {
        @BindView(R.id.avatar_iv)
        ImageView ivAvatar;

        @BindView(R.id.name_tv)
        TextView tvName;

        public HeaderViewHolder(View itemView, ProfileViewAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }

    class DetailListItemViewHolder extends BaseViewHolder {

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        @BindView(R.id.ivItem)
        ImageView ivItem;

        public DetailListItemViewHolder(View itemView, ProfileViewAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }
}
