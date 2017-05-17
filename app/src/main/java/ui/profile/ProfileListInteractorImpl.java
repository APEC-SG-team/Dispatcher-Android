package ui.profile;

import android.os.Handler;

import com.apec.dispatcher.R;

import java.util.ArrayList;
import java.util.List;

import model.SettingItem;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public class ProfileListInteractorImpl implements ProfileListInteractor {

    @Override
    public void getInboxList(String id, final OnReceiveProfileListListener onReceiveProfileListListener) {
        // Fetch data from server here with Retrofit
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onReceiveProfileListListener.onSuccess(createDummyInboxList());
            }
        }, 1000);

    }

    private List<Object> createDummyInboxList() {
        List<Object> dummyList = new ArrayList<>();
        dummyList.add(new SettingItem().SettingAvatarItem("https://randomuser.me/api/portraits/men/1.jpg", "Tom"));
        String[] mSettingListTitle = {"Settings", "Help", "Give Us a feedback"};
        int[] mSettingListIcons = {R.drawable.ic_settings, R.drawable.ic_help, R.drawable.ic_feed_back};
        for (int i = 0; i < mSettingListTitle.length; i++) {
            Object dummy = new SettingItem().SettingListItem(mSettingListTitle[i], mSettingListIcons[i]);
            dummyList.add(dummy);
        }
        dummyList.add(new SettingItem().SettingListItem("Want to merchant ?", R.mipmap.ic_content, true));
        return dummyList;
    }
}
