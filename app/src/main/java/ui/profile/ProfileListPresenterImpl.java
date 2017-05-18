package ui.profile;

import java.util.List;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public class ProfileListPresenterImpl implements ProfileListPresenter, ProfileListInteractor.OnReceiveProfileListListener {

    private View mProfileListPresenterView;
    private ProfileListInteractor mProfileListInteractor;

    public ProfileListPresenterImpl(View view, ProfileListInteractor profileListInteractor) {
        this.mProfileListPresenterView = view;
        this.mProfileListInteractor = profileListInteractor;
    }


    @Override
    public void getProfile(String id) {
        mProfileListInteractor.getInboxList(id, this);
    }


    @Override
    public void onSuccess(List<Object> profileList) {
        mProfileListPresenterView.setProfileList(profileList);
        mProfileListPresenterView.hideProgress();
    }

    @Override
    public void onFailure(Error e) {
        mProfileListPresenterView.showError(e.getMessage());
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {
        mProfileListPresenterView = null;
    }

    @Override
    public void onError(String message) {
        mProfileListPresenterView.showError(message);
    }
}
