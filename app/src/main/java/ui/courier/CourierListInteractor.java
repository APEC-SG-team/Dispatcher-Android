package ui.courier;

import java.util.List;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public interface CourierListInteractor {
    interface OnReceiveCourierListListener {
        void onSuccess(List<Object> courierList);

        void onFailure(Error e);
    }

    void getInboxList(String id, final OnReceiveCourierListListener onReceiveCourierListListener);
}
