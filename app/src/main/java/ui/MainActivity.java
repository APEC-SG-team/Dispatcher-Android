package ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;

import com.apec.dispatcher.R;

import base.BaseActivity;
import ui.inbox.InboxListFragment;

public class MainActivity extends BaseActivity {
    LinearLayout mViewContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewContainer = (LinearLayout) findViewById(R.id.viewContainer);
        Fragment newFragment = new InboxListFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.viewContainer, newFragment).commit();


    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    public void setDisplayHomeEnabled(boolean b) {
        super.setDisplayHomeEnabled(false);
    }
}
