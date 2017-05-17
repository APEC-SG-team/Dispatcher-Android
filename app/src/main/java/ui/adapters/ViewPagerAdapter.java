package ui.adapters;

/**
 * Created by win on 3/25/17.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;

import ui.courier.CourierListFragment;
import ui.inbox.InboxListFragment;
import ui.profile.ProfileFragment;
import ui.search.SearchFragment;


/**
 * Created by winhtaikaung on 2/27/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    String[] mtitles;
    FragmentManager fragManager;
    FragmentTransaction ft;

    public ViewPagerAdapter(FragmentManager fm, String[] titles) {
        super(fm);
        this.fragManager = fm;
        this.ft = fragManager.beginTransaction();

        this.mtitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        switch (position) {
            case 0:
                return new CourierListFragment();
            case 1:
                return new InboxListFragment();

            case 2:
                return new InboxListFragment();

            case 3:
                return new SearchFragment();

            case 4:
                return new ProfileFragment();

        }
        return null;

    }

    @Override
    public int getCount() {
        return mtitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return "";
    }
}

