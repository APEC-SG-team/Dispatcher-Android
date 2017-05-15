package inbox;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apec.dispatcher.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InboxListFragment extends Fragment implements InboxListPresenter.View {


    public InboxListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inbox_list, container, false);
    }

    @Override
    public void OnInboxListRetrieved(List<Object> inboxList) {
        // TODO All
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void hideError(String message) {

    }
}
