package ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.apec.dispatcher.R;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import ui.courierdetail.CourierDetailFragment;
import ui.itemdetail.PackageDetailFragment;

public class DetailActivity extends BaseActivity {

    @BindView(R.id.container)
    FrameLayout viewContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Fragment newFragment = null;
        if (savedInstanceState == null) {
            Intent intent = getIntent();
            if (!intent.getBooleanExtra("IS_COURIER", false)) {
                newFragment = new PackageDetailFragment();
                this.getSupportActionBar().setTitle("Copper 5 tons");
            } else {
                newFragment = new CourierDetailFragment();
                this.getSupportActionBar().setTitle("");

            }
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, newFragment).commit();
        }

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_detail;
    }


}
