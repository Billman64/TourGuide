package com.example.bill.tourguide;

/*  Columbus, OH TourGuide app
 * coded by: Bill Lugo
 * Images, including from www.experiencecolumbus.com, is/are property of their owner(s).
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // capture ViewPager
        ViewPager vp = (ViewPager) findViewById(R.id.viewpager);

        // set up TabLayout
        TabLayout tabLayout = (TabLayout) (findViewById(R.id.tab_layout));
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(vp);

        tabLayout.setTabTextColors(R.color.colorPrimary,R.color.colorAccent);   //TODO: fix problem of tab text not showing

        // create fragmentPagerAdapter
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = new Fragment();

                // tab ordering
                switch (position){
                    case 0:
                        fragment = new FunFragment();
                        break;
                    case 1:
                        fragment = new RestaurantFragment();
                        break;
                    case 2:
                        fragment = new NightlifeFragment();
                        break;
                    case 3:
                        fragment = new EventsFragment();
                        break;
                    default:
                        fragment = new FunFragment();
                        break;
                }
                return fragment;
            };

            @Override
            public int getCount() {
                return 4;
            }
        };

        // set up ViewPager with fragmentPagerAdapter
        vp.setAdapter(fragmentPagerAdapter);
    }
}
