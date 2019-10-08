package host.atar.com.plugin_apk.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import host.atar.com.plugin_apk.fragment.ActivityFragment;
import host.atar.com.plugin_apk.fragment.BroadcastFragment;
import host.atar.com.plugin_apk.fragment.ServiceFragment;
import host.atar.com.plugin_apk.R;
public class MainActivity extends FragmentActivity {

    public static final String ACTION_BROADCAST_MSG = MainActivity.class.getSimpleName();

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new ComponentFragmentPagerAdapter(getSupportFragmentManager()));
    }

    class ComponentFragmentPagerAdapter extends FragmentPagerAdapter {

        public ComponentFragmentPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ActivityFragment();
                case 1:
                    return new ServiceFragment();
                case 2:
                    return new BroadcastFragment();
                default:
                    // should not reach here
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Activity";
                case 1:
                    return "Service";
                case 2:
                    return "Broadcast";
                default:
                    // should not reach here
                    return "";
            }
        }
    }
}
