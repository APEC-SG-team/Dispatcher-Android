package ui.inbox;

import java.util.Arrays;
import java.util.List;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public class InboxListInteractorImpl implements InboxListInteractor {

    @Override
    public void getInboxList(String id, OnReceiveInboxListListener onReceiveInboxListListener) {
        // Fetch data from server here
        onReceiveInboxListListener.onSuccess(createDummyInboxList());
    }

    private List<Object> createDummyInboxList() {
        Object inbox1 = new Object();
        Object inbox2 = new Object();
        Object inbox3 = new Object();
        return Arrays.asList(inbox1, inbox2, inbox3);
    }
}
