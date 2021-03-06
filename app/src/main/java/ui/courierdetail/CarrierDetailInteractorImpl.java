package ui.courierdetail;

import android.os.Handler;

import com.apec.dispatcher.R;

import java.util.ArrayList;
import java.util.List;

import model.SettingItem;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public class CarrierDetailInteractorImpl implements CarrierDetailInteractor {

    @Override
    public void getPackageList(String id, final OnReceivePackageDetailListener onReceivePackageDetailListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onReceivePackageDetailListener.onSuccess(createDummyInboxList());
            }
        }, 2000);
    }

    private List<Object> createDummyInboxList() {
        List<Object> dummyList = new ArrayList<>();
        dummyList.add(new SettingItem().SettingAvatarItem("https://randomuser.me/api/portraits/men/10.jpg", "William Alexandre"));
        String[] mSettingListTitle = {"Settings", "Help", "Give Us a feedback"};
        int[] mSettingListIcons = {R.drawable.ic_settings, R.drawable.ic_help, R.drawable.ic_feed_back};
        for (int i = 0; i < 3; i++) {
            Object dummy = new SettingItem().SettingListItem("demo", 0);
            dummyList.add(dummy);
        }

//        dummyList.add(new SettingItem().SettingListItem("Want to merchant ?", R.mipmap.ic_content, true, true));
        return dummyList;
    }


}
