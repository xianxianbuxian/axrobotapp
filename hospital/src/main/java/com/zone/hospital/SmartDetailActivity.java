package com.zone.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.zone.hospital.base.BaseActivity2;
import com.zone.hospital.model.bean.SicknessModel;
import com.zone.hospital.model.bean.SicknissBean;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class SmartDetailActivity extends BaseActivity2 {

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.tv_general)
    TextView mTvGeneral;
    @InjectView(R.id.tv_apartment)
    TextView mTvApartment;
    @InjectView(R.id.tv_description)
    TextView mTvDescription;
    @InjectView(R.id.tv_title)
    TextView mTvTitle;

    @Override
    public int setLayoutId() {
        return R.layout.activity_smart_detail;
    }

    @Override
    public void init() {
        mToolbar.setTitle(getIntent().getStringExtra("title"));
        String sickness = getIntent().getStringExtra("sickness");
        SicknessModel model = new SicknessModel();
        for (int i = 0; i < model.getList().size(); i++) {
            if (sickness.contains(model.getList().get(i).getSickness())) {
                mTvGeneral.setText(model.getList().get(i).getGeneral());
                mTvApartment.setText(model.getList().get(i).getApartment());
                mTvDescription.setText(model.getList().get(i).getDescription());
                showToast(model.getList().get(i).getGeneral());
                showToast(model.getList().get(i).getApartment());
                showToast(model.getList().get(i).getDescription());
                break;
            }
        }

    }

    @Override
    public boolean isUseToolbar() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
        mSpeechSynthesizer.speak("病症详情如下");
    }

    @OnClick(R.id.layout_home)
    public void onClick() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }

}
