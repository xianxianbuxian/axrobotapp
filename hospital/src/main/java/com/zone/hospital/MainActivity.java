package com.zone.hospital;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zone.hospital.base.BaseActivity2;
import com.zone.hospital.model.adapter.MyFragmentPageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity2 {
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.vp_page)
    ViewPager mVpPage;
    @InjectView(R.id.layout_home)
    LinearLayout mLayoutHome;
    @InjectView(R.id.layout_hospital)
    LinearLayout mLayoutHospital;
    @InjectView(R.id.layout_person)
    LinearLayout mLayoutPerson;
    @InjectView(R.id.layout_more)
    LinearLayout mLayoutMore;
    @InjectView(R.id.tv_title)
    TextView mTvTitle;
//    @InjectView(R.id.ivHome)
//    ImageView mIvHome;
//    @InjectView(R.id.ivHospital)
//    ImageView mIvHospital;

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
//        mToolbar.setTitle("奥讯机器人智能导诊系统");
        HomeFragment homeFragment = new HomeFragment();
        HospotalFragment hospotalFragment = new HospotalFragment();
        PersonFragment personFragment = new PersonFragment();
        MoreFragment moreFragment = new MoreFragment();
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(homeFragment);
        fragmentList.add(hospotalFragment);
        fragmentList.add(personFragment);
        fragmentList.add(moreFragment);
        MyFragmentPageAdapter mFragmentAdapter = new MyFragmentPageAdapter(getSupportFragmentManager(), fragmentList);
        mVpPage.setAdapter(mFragmentAdapter);
        mLayoutHome.setBackgroundColor(getResources().getColor(R.color.colorBackGround));
        mVpPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetTabBackGround();
                switch (position) {
                    case 0:
                        mLayoutHome.setBackgroundColor(getResources().getColor(R.color.colorBackGround));

                        break;
                    case 1:
                        mLayoutHospital.setBackgroundColor(getResources().getColor(R.color.colorBackGround));

                        break;
                    case 2:
                        mLayoutPerson.setBackgroundColor(getResources().getColor(R.color.colorBackGround));

                        break;
                    case 3:
                        mLayoutMore.setBackgroundColor(getResources().getColor(R.color.colorBackGround));

                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public boolean isUseToolbar() {
        return false;
    }


    @OnClick({R.id.layout_home, R.id.layout_hospital, R.id.layout_person, R.id.layout_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_home:
                mVpPage.setCurrentItem(0);
                resetTabBackGround();
                mLayoutHome.setBackgroundColor(getResources().getColor(R.color.colorBackGround));
                break;
            case R.id.layout_hospital:
                resetTabBackGround();
                mLayoutHospital.setBackgroundColor(getResources().getColor(R.color.colorBackGround));

                mVpPage.setCurrentItem(1);
                break;
            case R.id.layout_person:
                resetTabBackGround();
                mLayoutPerson.setBackgroundColor(getResources().getColor(R.color.colorBackGround));

                mVpPage.setCurrentItem(2);
                break;
            case R.id.layout_more:
                resetTabBackGround();
                mLayoutMore.setBackgroundColor(getResources().getColor(R.color.colorBackGround));

                mVpPage.setCurrentItem(3);

                break;
        }
    }

    private void resetTabBackGround() {
        mLayoutHome.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        mLayoutHospital.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        mLayoutMore.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        mLayoutPerson.setBackgroundColor(getResources().getColor(R.color.colorWhite));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }
}
