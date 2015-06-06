package net.lee.tab04_viewpager_indicator;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Window;

import com.viewpagerindicator.TabPageIndicator;


public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    private TabPageIndicator tabPageIndicator;
//    private List<Fragment> mFragments;
    private TabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();


    }

    private void initView() {

        viewPager = (ViewPager) findViewById(R.id.id_viewpagerr);
        tabPageIndicator = (TabPageIndicator) findViewById(R.id.id_indicator);
        tabAdapter = new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);

        tabPageIndicator.setViewPager(viewPager,0);

    }
}
