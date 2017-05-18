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
import ui.profile.ProfileFragment;

import static ui.profile.ProfileFragment.IS_MERCHANT;

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener, ProfileFragment.IChangeNavIcon {
    @BindView(R.id.pager)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tabLayout;


    String[] titles = {"Carrier", "Inbox", "Search", "Profile"};
    private int[] tabIcons = {
            R.drawable.ic_carrier,
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
        viewPager.setOnPageChangeListener(this);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        viewPager.setCurrentItem(0);


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

        for (int i = 0; i < tabIcons.length; i++) {
            View iconView = getLayoutInflater().inflate(R.layout.custom_tab, null);
            iconView.findViewById(R.id.icon).setBackgroundResource(tabIcons[i]);
            tabLayout.getTabAt(i).setCustomView(iconView);
        }
        if (this.getSharedPref().getBooleanPreference(IS_MERCHANT, false)) {
            this.titles[0] = "Packages";
            changeBottomNavIcon(0, R.mipmap.ic_product);
        } else {
            this.titles[0] = "Carrier";
            changeBottomNavIcon(0, R.drawable.ic_carrier);
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        this.setTitle(titles[position]);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void changeBottomNavIcon(int iconPositon, int resourceId) {
        if (this.getSharedPref().getBooleanPreference(IS_MERCHANT, false)) {
            this.titles[0] = "Packages";
        } else {
            this.titles[0] = "Carrier";
        }
        tabLayout.getTabAt(iconPositon).getCustomView().findViewById(R.id.icon).setBackgroundResource(resourceId);
    }
}
