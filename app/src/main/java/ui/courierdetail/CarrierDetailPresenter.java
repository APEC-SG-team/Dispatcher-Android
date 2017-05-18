package ui.courierdetail;

import java.util.List;

import base.BasePresenter;
import base.BaseView;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public interface CarrierDetailPresenter extends BasePresenter {

    void getPackageDetailList(String id);


    interface View extends BaseView {
        void setPackageDetail(List<Object> packageDetail);

    }
}
