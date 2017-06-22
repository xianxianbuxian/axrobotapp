package com.zone.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.zone.hospital.base.BaseActivity2;
import com.zone.hospital.model.adapter.LrvCommentAdapter;
import com.zone.hospital.model.adapter.LrvHolder;
import com.zone.hospital.model.bean.StuDirBean;
import com.zone.hospital.myApplication.MyApplication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class HealthConsultingActivity extends BaseActivity2 {

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.tv_title)
    TextView mTvTitle;
    private LRecyclerView mLrvHealthDir;

    @Override
    public int setLayoutId() {
        return R.layout.activity_health_consulting;
    }

    @Override
    public void init() {

        mToolbar.setTitle("");
        mTvTitle.setText("健康咨询");
        mLrvHealthDir = (LRecyclerView) findViewById(R.id.lrv_health);
        mLrvHealthDir.setLayoutManager(new LinearLayoutManager(this));
        mLrvHealthDir.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mLrvHealthDir.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
        List<StuDirBean> list = new ArrayList<>();
        list.add(new StuDirBean("疾病库"));
        list.add(new StuDirBean("药物库"));
        list.add(new StuDirBean("急救库"));

        mSpeechSynthesizer.speak("这是健康咨询，选择你所需的查询");
        setLrvAdapter(list);
    }

    @Override
    public boolean isUseToolbar() {
        return true;
    }

    public void setLrvAdapter(List<StuDirBean> list) {
        LrvCommentAdapter<StuDirBean> lrvCommentAdapter = new LrvCommentAdapter<StuDirBean>(HealthConsultingActivity.this, R.layout.item_stu_dir, list) {
            @Override
            protected void convert(LrvHolder holder, final StuDirBean stuDirBean, final int position) {
                holder.setText(R.id.tv_title, stuDirBean.getTitle());
                holder.setOnClickListener(R.id.card_view, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast("click");
                        Intent intent = new Intent(HealthConsultingActivity.this, HealthConsulting2Activity.class);
                        intent.putExtra("title", stuDirBean.getTitle());
                        if (position==0){
                            MyApplication.setListTag("10");

                        }if(position==1){
                            MyApplication.setListTag("11");

                        }if(position==2){
                            MyApplication.setListTag("12");

                        }
//                        intent.putExtra("url", stuDirBean.getAddress());
                        startActivity(intent);
                    }
                });
                holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showToast("click");
                        Intent intent = new Intent(HealthConsultingActivity.this, HealthConsulting2Activity.class);
                        intent.putExtra("title", stuDirBean.getTitle());
//                        intent.putExtra("url", stuDirBean.getAddress());
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
