package ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.apec.dispatcher.R;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import ui.adapters.ViewPagerAdapter;

public class MainActivity extends BaseActivity {
    @BindView(R.id.pager)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tabLayout;


    String[] titles = {"FAVOURITES", "PARKINGS", "FAVOURITES", "PARKINGS", "FAVOURITES"};
    private int[] tabIcons = {
            R.mipmap.ic_product,
            R.mipmap.ic_content,
            R.mipmap.ic_inbox,
            R.mipmap.ic_search,
            R.mipmap.ic_profile

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), titles);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();



    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    public void setDisplayHomeEnabled(boolean b) {
        super.setDisplayHomeEnabled(false);
    }


    private void setupTabIcons() {

        for (int i = 0; i < 5; i++) {
            View iconView = getLayoutInflater().inflate(R.layout.custom_tab, null);
            iconView.findViewById(R.id.icon).setBackgroundResource(tabIcons[i]);
            tabLayout.getTabAt(i).setCustomView(iconView);
        }

    }

}
