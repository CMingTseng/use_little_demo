package com.aohuan.dodo.viewdemo.tab;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aohuan.dodo.common.utils.base.ABaseAutoActivity;
import com.aohuan.dodo.common.utils.base.AhView;
import com.aohuan.dodo.viewdemo.R;
import com.aohuan.dodo.viewdemo.tab.frag.FragmentOut4;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

@AhView(R.layout.activity_tabstrip04)
public class TabStrip04Activity extends ABaseAutoActivity {

    @InjectView(R.id.tab_main)
    TabLayout tabMain;
    @InjectView(R.id.m_viewpager)
    ViewPager mViewpager;

    private List<Fragment> fagList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        initFrag();
        initPager();
    }

    private void initFrag() {
        FragmentOut4 fo1 = new FragmentOut4();
        FragmentOut4 fo2 = new FragmentOut4();
        fagList.add(fo1);
        fagList.add(fo2);
    }

    private void initPager() {
        mViewpager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tabMain.setupWithViewPager(mViewpager);
        for(int i=0; i<mViewpager.getAdapter().getCount(); i++){
            tabMain.getTabAt(i).setText(mViewpager.getAdapter().getPageTitle(i));
        }
    }


    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fagList.get(position);
        }

        @Override
        public int getCount() {
            return fagList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "dodo  " + position;
        }
    }

}
