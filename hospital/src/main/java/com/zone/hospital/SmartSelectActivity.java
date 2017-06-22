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
import com.zone.hospital.model.SmartConsultModel;
import com.zone.hospital.model.StringBean;
import com.zone.hospital.model.adapter.LrvCommentAdapter;
import com.zone.hospital.model.adapter.LrvHolder;
import com.zone.hospital.model.bean.SicknissBean;
import com.zone.hospital.model.bean.StuDirBean;
import com.zone.hospital.myApplication.MyApplication;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class SmartSelectActivity extends BaseActivity2 {

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
        mTvTitle.setText(MyApplication.getWhere());
        mLrvHealthDir = (LRecyclerView) findViewById(R.id.lrv_health);
        mLrvHealthDir.setLayoutManager(new LinearLayoutManager(this));
        mLrvHealthDir.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mLrvHealthDir.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
        //studir标题设置bean
        List<StuDirBean> list = new ArrayList<>();
        SmartConsultModel smartConsultModel = new SmartConsultModel();
        //添加标题
        list.add(new StuDirBean(SmartConsultModel.getHandAndFootList().get(0).getSickniss()));
//        list.add(new StuDirBean("指端皮肤色泽改变"));
//        list.add(new StuDirBean("肩关节疼痛"));
        switch (MyApplication.getListTag()) {
            case "1":
                setLrvAdapter(SmartConsultModel.getManList());

                break;
            case "2":
                setLrvAdapter(SmartConsultModel.getWomanList());

                break;
            case "3":
                setLrvAdapter(SmartConsultModel.getHandAndFootList());

                break;
            case "4":
                setLrvAdapter(SmartConsultModel.getBackList());

                break;
            case "5":
                if (MyApplication.getSex().equals("男")) {
                    showToast("男");
                } else if (MyApplication.getSex().equals("女")) {
                    showToast("女");

                }
                setLrvAdapter(SmartConsultModel.getBellyList());

                break;
            case "6":
                setLrvAdapter(SmartConsultModel.getUpHeadList());

                break;
            case "7":
                setLrvAdapter(SmartConsultModel.getDownHeadList());

                break;
            case "8":
                setLrvAdapter(SmartConsultModel.getManChestList());

                break;
            case "9":
                setLrvAdapter(SmartConsultModel.getWomanChestList());
                break;
            case "10":
                setLrvAdapter(SmartConsultModel.getArseList());
                break;
        }
        switch (MyApplication.getWheretag()) {
            case "1":
                mSpeechSynthesizer.speak("这是脸部,请选择你需要了解的症状");
                break;
            case "2":
                mSpeechSynthesizer.speak("这是后脑,请选择你需要了解的症状");
                break;
            case "3":
                mSpeechSynthesizer.speak("这是腹部,请选择你需要了解的症状");
                break;
            case "4":
                mSpeechSynthesizer.speak("这是背部,请选择你需要了解的症状");
                break;
            case "5":
                mSpeechSynthesizer.speak("这是左手臂,请选择你需要了解的症状");
                break;
            case "6":
                mSpeechSynthesizer.speak("这是右手臂,请选择你需要了解的症状");
                break;
            case "7":
                mSpeechSynthesizer.speak("这是左手,请选择你需要了解的症状");
                break;
            case "8":
                mSpeechSynthesizer.speak("这是右手,请选择你需要了解的症状");
                break;
            case "9":
                mSpeechSynthesizer.speak("这是左腿,请选择你需要了解的症状");
                break;
            case "10":
                mSpeechSynthesizer.speak("这是右腿,请选择你需要了解的症状");
                break;
            case "11":
                mSpeechSynthesizer.speak("这是左脚,请选择你需要了解的症状");
                break;
            case "12":
                mSpeechSynthesizer.speak("这是右脚,请选择你需要了解的症状");
                break;
            case "13":
                mSpeechSynthesizer.speak("请选择你需要了解的症状");
                break;
        }
    }

    @Override
    public boolean isUseToolbar() {
        return true;
    }

    private List<StringBean> toArray(String[] question1) {
        List<StringBean> list = new ArrayList<>();
        for (int i = 0; i < question1.length; i++) {
            list.add(new StringBean(question1[i]));
        }
        return list;
    }

    public void setLrvAdapter(List<SicknissBean> list) {
        LrvCommentAdapter<SicknissBean> lrvCommentAdapter = new LrvCommentAdapter<SicknissBean>(SmartSelectActivity.this, R.layout.item_stu_dir, list) {
            @Override
            protected void convert(LrvHolder holder, final SicknissBean sicknissBean, int position) {
                holder.setText(R.id.tv_title, sicknissBean.getSickniss());
                holder.setOnClickListener(R.id.card_view, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        showToast("click");
                        List<StringBean> dataList = toArray(sicknissBean.getQuestion1());
                        List<StringBean> dataList2 = toArray(sicknissBean.getQuestion2());
                        List<StringBean> dataList3 = toArray(sicknissBean.getQuestion3());
                        if (dataList.size() == 0 && dataList2.size() == 0 && dataList3.size() == 0) {
                            Intent intent = new Intent(SmartSelectActivity.this, SmartSelect3Activity.class);
                            intent.putExtra("title", "");
                            intent.putExtra("sickniss", sicknissBean);
                            startActivity(intent);
                            return;
                        }
                        Intent intent = new Intent(SmartSelectActivity.this, SmartSelect2Activity.class);
                        intent.putExtra("title", sicknissBean.getSickniss());
                        intent.putExtra("sickniss", sicknissBean);
//                        intent.putExtra("url", stuDirBean.getAddress());
                        startActivity(intent);
                    }
                });


            }
        };
        mLrvHealthDir.setAdapter(new LRecyclerViewAdapter(lrvCommentAdapter));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);

    }
}
