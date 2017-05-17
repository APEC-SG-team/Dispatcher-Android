package ui.profile;

import java.util.List;

import base.BasePresenter;
import base.BaseView;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public interface ProfileListPresenter extends BasePresenter {

    void getProfile(String id);


    interface View extends BaseView {
        void setProfileList(List<Object> ProfileList);
    }
}
