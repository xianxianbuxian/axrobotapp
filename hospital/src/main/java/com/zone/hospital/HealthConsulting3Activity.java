package com.zone.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.zone.hospital.base.BaseActivity2;
import com.zone.hospital.model.HealConsultModel;
import com.zone.hospital.model.StringBean;
import com.zone.hospital.model.adapter.LrvCommentAdapter;
import com.zone.hospital.model.adapter.LrvHolder;
import com.zone.hospital.model.bean.Healthbean;
import com.zone.hospital.model.bean.StuDirBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class HealthConsulting3Activity extends BaseActivity2 {

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    private LRecyclerView mLrvHealthDir;
    @InjectView(R.id.tv_title)
    TextView mTvTitle;
    private Healthbean mHealthean;

    @Override
    public int setLayoutId() {
        return R.layout.activity_health_consulting;
    }

    @Override
    public void init() {
        mToolbar.setTitle(getIntent().getStringExtra("title"));
        mTvTitle.setText(getIntent().getStringExtra("title"));
        mLrvHealthDir = (LRecyclerView) findViewById(R.id.lrv_health);
        mLrvHealthDir.setLayoutManager(new LinearLayoutManager(this));
        mLrvHealthDir.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mLrvHealthDir.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
        List<StuDirBean> list = new ArrayList<>();
        HealConsultModel healConsultModel=new HealConsultModel();
    }

    @Override
    public boolean isUseToolbar() {
        return true;
    }

    public void setLrvAdapter(List<StringBean> list) {
        LrvCommentAdapter<StringBean> lrvCommentAdapter = new LrvCommentAdapter<StringBean>(HealthConsulting3Activity.this, R.layout.item_stu_dir, list) {
            @Override
            protected void convert(LrvHolder holder, final StringBean stringBean, int position) {
                holder.setText(R.id.tv_title, stringBean.getContent());
                holder.setOnClickListener(R.id.card_view, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast("click");
                        Intent intent = new Intent(HealthConsulting3Activity.this, HealthDetailActivity.class);
                        intent.putExtra("title", "");
                       intent.putExtra("sickness",stringBean.getContent());
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
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHealthean = (Healthbean) getIntent().getSerializableExtra("sickness");
        List<StringBean> datalist=toArray(mHealthean.getquestion());
        setLrvAdapter(datalist);
    }

    private List<StringBean> toArray(String[] question1) {
        List<StringBean> list = new ArrayList<>();

        for (int i = 0; i < question1.length; i++) {
            list.add(new StringBean(question1[i]));
        }
        return list;
    }
}
