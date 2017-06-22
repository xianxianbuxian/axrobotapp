package com.zone.hospital;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.zone.hospital.base.BaseActivity2;
import com.zone.hospital.model.SmartConsultModel;
import com.zone.hospital.model.StringBean;
import com.zone.hospital.model.adapter.LrvCommentAdapter;
import com.zone.hospital.model.adapter.LrvHolder;
import com.zone.hospital.model.bean.SicknissBean;
import com.zone.hospital.model.bean.StuDirBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;


public class SmartSelect3Activity extends BaseActivity2 {

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.tv_title)
    TextView mTvTitle;

    private LRecyclerView mLrvHealthDir;
    SicknissBean mSicknissBean;


    @Override
    protected void onResume() {
        super.onResume();
        mSicknissBean = (SicknissBean) getIntent().getSerializableExtra("sickniss");
        List<StringBean> dataList = toArray(mSicknissBean.getDiaSickniss());
        setLrvAdapter(dataList);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_health_consulting;
    }

    @Override
    public void init() {

        mSicknissBean = (SicknissBean) getIntent().getSerializableExtra("sickniss");

        mToolbar.setTitle("");
        mTvTitle.setText(mSicknissBean.getSickniss());


        mLrvHealthDir = (LRecyclerView) findViewById(R.id.lrv_health);
        mLrvHealthDir.setLayoutManager(new LinearLayoutManager(this));
        mLrvHealthDir.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mLrvHealthDir.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
        List<StuDirBean> list = new ArrayList<>();
        SmartConsultModel smartConsultModel = new SmartConsultModel();
    }

    private List<StringBean> toArray(String[] question1) {
        List<StringBean> list = new ArrayList<>();

        for (int i = 0; i < question1.length; i++) {
            list.add(new StringBean(question1[i]));
        }
        return list;
    }

    @Override
    public boolean isUseToolbar() {
        return true;
    }

    public void setLrvAdapter(List<StringBean> list) {
        LrvCommentAdapter<StringBean> lrvCommentAdapter = new LrvCommentAdapter<StringBean>(SmartSelect3Activity.this, R.layout.item_stu_dir, list) {
            @Override
            protected void convert(LrvHolder holder, final StringBean sicknissBean, int position) {
                holder.setText(R.id.tv_title, sicknissBean.getContent());
                holder.setOnClickListener(R.id.card_view, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast("click");
                        Intent intent = new Intent(SmartSelect3Activity.this, SmartDetailActivity.class);
                        intent.putExtra("title", "");
                        intent.putExtra("sickness", sicknissBean.getContent());
                        startActivity(intent);
                    }
                });


            }
        };
        mLrvHealthDir.setAdapter(new LRecyclerViewAdapter(lrvCommentAdapter));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSpeechSynthesizer.speak("选择病症查看详情");
    }
}
