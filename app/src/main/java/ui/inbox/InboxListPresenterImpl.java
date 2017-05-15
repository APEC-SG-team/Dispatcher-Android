package ui.inbox;

import java.util.List;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public class InboxListPresenterImpl implements InboxListPresenter, InboxListInteractor.OnReceiveInboxListListener {

    private InboxListPresenter.View mInboxPresenterView;
    private InboxListInteractor mInboxListInteractor;

    public InboxListPresenterImpl(InboxListPresenter.View view, InboxListInteractor inboxListInteractor) {
        this.mInboxPresenterView = view;
        this.mInboxListInteractor = inboxListInteractor;
    }


    @Override
    public void getInboxList(String id) {
        mInboxListInteractor.getInboxList(id, this);
    }


    @Override
    public void onSuccess(List<Object> inboxList) {

        mInboxPresenterView.setInboxList(inboxList);
        mInboxPresenterView.hideProgress();
    }

    @Override
    public void onFailure(Error e) {
        mInboxPresenterView.showError(e.getMessage());
    }

    @Override
    public void resume() {
//        mInboxPresenterView.showProgress();
    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {
        mInboxPresenterView = null;
    }

    @Override
    public void onError(String message) {
        mInboxPresenterView.showError(message);
    }
}
