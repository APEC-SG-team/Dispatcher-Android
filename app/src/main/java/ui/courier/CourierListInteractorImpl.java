package ui.courier;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winhtaikaung on 15/5/17.
 */

public class CourierListInteractorImpl implements CourierListInteractor {

    @Override
    public void getInboxList(String id, final OnReceiveCourierListListener onReceiveCourierListListener) {
        // Fetch data from server here with Retrofit
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onReceiveCourierListListener.onSuccess(createDummyInboxList());
            }
        }, 2000);

    }

    private List<Object> createDummyInboxList() {
        List<Object> dummyList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Object dummy = new Object();
            dummyList.add(dummy);
        }
        return dummyList;
    }
}
