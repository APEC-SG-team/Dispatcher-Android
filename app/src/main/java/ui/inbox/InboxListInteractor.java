package ui.inbox;

import java.util.List;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public interface InboxListInteractor {
    interface OnReceiveInboxListListener {
        void onSuccess(List<Object> inboxList);

        void onFailure(Error e);
    }

    void getInboxList(String id, final OnReceiveInboxListListener onReceiveInboxListListener);
}
