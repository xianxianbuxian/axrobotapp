package com.zone.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
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

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class SmartSelect2Activity extends BaseActivity2 {

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.tv_title)
    TextView mTvTitle;
    @InjectView(R.id.tv_last_page)
    TextView mTvLastPage;
    @InjectView(R.id.tv_page)
    TextView mTvPage;
    @InjectView(R.id.tv_next_page)
    TextView mTvNextPage;
    private LRecyclerView mLrvHealthDir;
    SicknissBean mSicknissBean;
    int pageCount = 0;
    int currentPage = 1;
    List<List<StringBean>> totalData;


    @Override
    protected void onResume() {

        super.onResume();
        pageCount = 0;
        currentPage = 1;


        List<StringBean> dataList = toArray(mSicknissBean.getQuestion1());
        List<StringBean> dataList2 = toArray(mSicknissBean.getQuestion2());
        List<StringBean> dataList3 = toArray(mSicknissBean.getQuestion3());
        totalData = new ArrayList<>();
        totalData.add(dataList);
        totalData.add(dataList2);
        totalData.add(dataList3);

        setLrvAdapter(dataList);

        mTvPage.setText(currentPage+"/"+pageCount);
        if (dataList.size() == 0 && dataList2.size() == 0 && dataList3.size() == 0) {
            Intent intent = new Intent(SmartSelect2Activity.this, SmartSelect3Activity.class);
            intent.putExtra("title", "");
            intent.putExtra("sickniss", mSicknissBean);
            startActivity(intent);
        }
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_health_consult_select;
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
        list.add(new StuDirBean(SmartConsultModel.getHandAndFootList().get(0).getSickniss()));
//        list.add(new StuDirBean("指端皮肤色泽改变"));
//        list.add(new StuDirBean("肩关节疼痛"));


    }

    private List<StringBean> toArray(String[] question1) {
        List<StringBean> list = new ArrayList<>();
        if (question1.length != 0) {
            pageCount++;
        }
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
        LrvCommentAdapter<StringBean> lrvCommentAdapter = new LrvCommentAdapter<StringBean>(SmartSelect2Activity.this, R.layout.item_select, list) {
            @Override
            protected void convert(final LrvHolder holder, final StringBean sicknissBean, int position) {
                holder.setText(R.id.tv_title, sicknissBean.getContent());
                holder.setOnClickListener(R.id.card_view, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       // TODO: 2017/5/19 0019
                          showToast("选择症状");
                     //   SmartSelect2Activity.super.mSpeechSynthesizer.speak("选择症状");
                        holder.setChecked(R.id.checkBox,true);
                    }
                });


            }
        };
        mLrvHealthDir.setAdapter(new LRecyclerViewAdapter(lrvCommentAdapter));
    }


    @OnClick({R.id.tv_last_page, R.id.tv_next_page})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_last_page:
                if (currentPage == 1) {
                    onBackPressed();
                }
                if (currentPage > 0) {
                    currentPage--;
                    mTvPage.setText(currentPage+"/"+pageCount);
                    setLrvAdapter(totalData.get(currentPage));

                }


                break;
            case R.id.tv_next_page:
                if (currentPage == pageCount) {
                    Intent intent = new Intent(SmartSelect2Activity.this, SmartSelect3Activity.class);
                    intent.putExtra("title", "");
                    intent.putExtra("sickniss", mSicknissBean);
                    startActivity(intent);
                }
//                showToast(String.valueOf(currentPage));
//                showToast(String.valueOf(pageCount));

                if (currentPage < pageCount) {
                    currentPage++;
//                    showToast(String.valueOf(currentPage));
                    mTvPage.setText(currentPage+"/"+pageCount);
                    setLrvAdapter(totalData.get(currentPage-1));
                }

                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSpeechSynthesizer.speak("选择你的症状，选择下一题");
    }
}
