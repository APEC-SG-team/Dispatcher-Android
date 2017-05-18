package ui.itemdetail;

import java.util.List;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public interface PackageDetailInteractor {
    interface OnReceivePackageDetailListener {
        void onSuccess(List<Object> inboxList);

        void onFailure(Error e);
    }

    void getPackageList(String id, final OnReceivePackageDetailListener onReceivePackageDetailListener);
}
