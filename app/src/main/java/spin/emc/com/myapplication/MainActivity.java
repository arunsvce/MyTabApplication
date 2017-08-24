package spin.emc.com.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import spin.emc.com.myapplication.adapter.FragmentAdapter;
import spin.emc.com.myapplication.fragment.TabFourFragment;
import spin.emc.com.myapplication.fragment.TabOneFragment;
import spin.emc.com.myapplication.fragment.TabThreeFragment;
import spin.emc.com.myapplication.fragment.TabTwoFragment;
import spin.emc.com.myapplication.widgets.CustomViewPager;


public class MainActivity extends FragmentActivity {

    private TabLayout mTabLayout;
    private CustomViewPager mViewPager;
    private FragmentAdapter adapter;

    private List<Fragment> mFragments;
    private int mTabIndHeight = 5;
    private String mTabIndColor = "#ff0000";
    private boolean mIsCanSwip = false;


    private int[] mImgs = new int[]{R.drawable.selector_tab_default, R.drawable.selector_tab_friends, R.drawable.selector_tab_find,
            R.drawable.selector_tab_me};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (CustomViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);


        mFragments = new ArrayList<>();
        TabOneFragment tabOneFragment = TabOneFragment.newInstance(0);
        TabTwoFragment tabTwoFragment = TabTwoFragment.newInstance(1);
        TabThreeFragment tabThreeFragment = TabThreeFragment.newInstance(2);
        TabFourFragment tabFourFragment = TabFourFragment.newInstance(3);
        mFragments.add(tabOneFragment);
        mFragments.add(tabTwoFragment);
        mFragments.add(tabThreeFragment);
        mFragments.add(tabFourFragment);
        adapter = new FragmentAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(0);

        mTabLayout.setupWithViewPager(mViewPager);


        for (int i = 0; i < mImgs.length; i++) {

            TabLayout.Tab itemTab = mTabLayout.getTabAt(i);
            if (itemTab != null) {

                itemTab.setCustomView(R.layout.item_tab);

                ImageView imageView = (ImageView) itemTab.getCustomView().findViewById(R.id.iv_img);
                imageView.setImageResource(mImgs[i]);
            }
        }
        mTabLayout.getTabAt(0).getCustomView().setSelected(true);
        mViewPager.setPagingEnabled(mIsCanSwip);
        mTabLayout.setSelectedTabIndicatorHeight((int) (mTabIndHeight * getResources().getDisplayMetrics().density));
        mTabLayout.setSelectedTabIndicatorColor(Color.parseColor(mTabIndColor));
    }
}
