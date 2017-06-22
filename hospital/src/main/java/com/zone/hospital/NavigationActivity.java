package com.zone.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.zone.hospital.base.BaseActivity2;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class NavigationActivity extends BaseActivity2 {

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.tv_first)
    TextView mTvFirst;
    @InjectView(R.id.tv_title)
    TextView mTvTitle;

    @Override
    public int setLayoutId() {
        return R.layout.activity_navigation;
    }

    @Override
    public void init() {
        mToolbar.setTitle("");
        mTvTitle.setText("问诊导航");
        mSpeechSynthesizer.speak("这是问诊导航");
    }

    @Override
    public boolean isUseToolbar() {
        return true;
    }


    @OnClick(R.id.tv_first)
    public void onClick() {
        startActivity(new Intent(NavigationActivity.this, NavigationDetailActivity.class));
    }


}
