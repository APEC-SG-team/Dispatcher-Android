package ui.itemdetail;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public class PackageDetailInteractorImpl implements PackageDetailInteractor {

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
        for (int i = 0; i < 8; i++) {
            Object dummy = new Object();
            dummyList.add(dummy);
        }
        return dummyList;
    }


}
