package ui.courier;

import java.util.List;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public class CourierListPresenterImpl implements CourierListPresenter, CourierListInteractor.OnReceiveCourierListListener {

    private View mCourierPresenterView;
    private CourierListInteractor mCourierListInteractor;

    public CourierListPresenterImpl(View view, CourierListInteractor inboxListInteractor) {
        this.mCourierPresenterView = view;
        this.mCourierListInteractor = inboxListInteractor;
    }


    @Override
    public void getCourierList(String id) {
        mCourierListInteractor.getInboxList(id, this);
    }


    @Override
    public void onSuccess(List<Object> inboxList) {

        mCourierPresenterView.setCourierList(inboxList);
        mCourierPresenterView.hideProgress();
    }

    @Override
    public void onFailure(Error e) {
        mCourierPresenterView.showError(e.getMessage());
    }

    @Override
    public void resume() {
//        mCourierPresenterView.showProgress();
    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {
        mCourierPresenterView = null;
    }

    @Override
    public void onError(String message) {
        mCourierPresenterView.showError(message);
    }
}
