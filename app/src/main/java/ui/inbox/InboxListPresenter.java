package ui.inbox;

import java.util.List;

import base.BasePresenter;
import base.BaseView;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public interface InboxListPresenter extends BasePresenter {

    void getInboxList(String id);

    interface View extends BaseView {
        void setInboxList(List<Object> inboxList);
    }
}
