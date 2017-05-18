package ui.courierdetail;

import java.util.List;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public class CarrierDetailPresenterImpl implements CarrierDetailPresenter, CarrierDetailInteractor.OnReceivePackageDetailListener {

    private View mInboxPresenterView;
    private CarrierDetailInteractor mInboxListInteractor;

    public CarrierDetailPresenterImpl(View view, CarrierDetailInteractor inboxListInteractor) {
        this.mInboxPresenterView = view;
        this.mInboxListInteractor = inboxListInteractor;
    }


    @Override
    public void onSuccess(List<Object> inboxList) {

        mInboxPresenterView.setPackageDetail(inboxList);
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

    @Override
    public void getPackageDetailList(String id) {
        mInboxListInteractor.getPackageList(id, this);
    }
}
