package ui.courier;

import java.util.List;

import base.BasePresenter;
import base.BaseView;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public interface CourierListPresenter extends BasePresenter {

    void getCourierList(String id);


    interface View extends BaseView {
        void setCourierList(List<Object> courierList);

    }
}
