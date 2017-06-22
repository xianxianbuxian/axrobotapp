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
import com.zone.hospital.model.adapter.LrvCommentAdapter;
import com.zone.hospital.model.adapter.LrvHolder;
import com.zone.hospital.model.bean.Healthbean;
import com.zone.hospital.model.bean.StuDirBean;
import com.zone.hospital.myApplication.MyApplication;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class HealthConsulting2Activity extends BaseActivity2 {

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    private LRecyclerView mLrvHealthDir;
    @InjectView(R.id.tv_title)
    TextView mTvTitle;
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
       switch (MyApplication.getListTag()){
           case "10":
               setLrvAdapter(HealConsultModel.getillnessList());
               break;
           case "11":
               setLrvAdapter(HealConsultModel.getaidList());
               break;
           case "12":
               setLrvAdapter(HealConsultModel.getdrugList());
               break;
       }

    }

    @Override
    public boolean isUseToolbar() {
        return true;
    }

    public void setLrvAdapter(final List<Healthbean> list) {
        LrvCommentAdapter<Healthbean> lrvCommentAdapter = new LrvCommentAdapter<Healthbean>(HealthConsulting2Activity.this, R.layout.item_stu_dir, list) {
            @Override
            protected void convert(LrvHolder holder, final Healthbean healthbean, final int position) {
                holder.setText(R.id.tv_title, healthbean.getSickness());
                holder.setOnClickListener(R.id.card_view, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast("click");
                        Intent intent = new Intent(HealthConsulting2Activity.this, HealthConsulting3Activity.class);
                        intent.putExtra("title", list.get(position).getSickness());
//                        intent.putExtra("url", stuDirBean.getAddress());
                        intent.putExtra("sickness",healthbean);
                        startActivity(intent);
                    }
                });
                holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(HealthConsulting2Activity.this, HealthConsulting3Activity.class);
                        intent.putExtra("title", list.get(position).getSickness());
//                        intent.putExtra("url", stuDirBean.getAddress());
                        intent.putExtra("sickness",healthbean);
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
}
