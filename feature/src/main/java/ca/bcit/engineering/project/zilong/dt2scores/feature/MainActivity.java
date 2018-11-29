package ca.bcit.engineering.project.zilong.dt2scores.feature;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.multidex.MultiDex;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import ca.bcit.engineering.project.zilong.dt2scores.feature.model.Match;

public class MainActivity extends AppCompatActivity implements OnListFragmentInteractionListener, OnFragmentInteractionListener {

    private MenuItem menuItem;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.ViewPager);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setupViewPager(mViewPager, navigation);
    }

    private void setupViewPager(ViewPager viewPager, final BottomNavigationView bottomNavigationView) {

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


        BottomAdapter adapter = new BottomAdapter(getSupportFragmentManager());

        adapter.addFragment(new MatchFragment());
        adapter.addFragment(new NewsFragment());
        adapter.addFragment(new VideoFragment());
        viewPager.setAdapter(adapter);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.navigation_score) {
                //loadMainPage();
                mViewPager.setCurrentItem(0);
                return true;
            } else if (id == R.id.navigation_news) {
                //loadNewsPage();
                mViewPager.setCurrentItem(1);
                return true;
            } else if (id == R.id.navigation_video) {
                //loadVideoPage();
                mViewPager.setCurrentItem(2);
                return true;
            }
            return false;
        }
    };

    @Override
    public void onListFragmentInteraction(Match item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
