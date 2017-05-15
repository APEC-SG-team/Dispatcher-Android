package inbox;

import java.util.List;

import base.BaseView;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public interface InboxListPresenter {

    void getAllInboxList();

    interface View extends BaseView {
        void OnInboxListRetrieved(List<Object> inboxList);
    }
}
