package ui.profile;

import java.util.List;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public interface ProfileListInteractor {
    interface OnReceiveProfileListListener {
        void onSuccess(List<Object> profileList);

        void onFailure(Error e);
    }

    void getInboxList(String id, final OnReceiveProfileListListener onReceiveProfileListListener);
}
