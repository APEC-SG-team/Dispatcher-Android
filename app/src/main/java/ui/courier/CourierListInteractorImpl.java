package ui.courier;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import model.Courier;

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

    public List<Object> createDummyInboxList() {
        List<Object> dummyList = new ArrayList<>();

        String[] names ={"Thomson Trading Pte.Ltd","Robinson Trading Pte.Ltd","Raffles Trading Pte.Ltd","Ang Tong Han Pte.Ltd","JP morgan Export Import Pte.Ltd"};
        String[] from = {"England","Vietnam","New Zealand","Indonesia","Singapore"};
        String[] date = {"12-05-2017","20-05-2017","09-07-2017","08-09-2017","06-11-2017"};
        for (int i = 0; i < 5; i++) {
            Object dummy = new Courier(names[i],from[i],"Singapore",date[i]);
            dummyList.add(dummy);
        }
        return dummyList;
    }
}
