package ui.courierdetail;

import java.util.List;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public interface CarrierDetailInteractor {
    interface OnReceivePackageDetailListener {
        void onSuccess(List<Object> inboxList);

        void onFailure(Error e);
    }

    void getPackageList(String id, final OnReceivePackageDetailListener onReceivePackageDetailListener);
}
