package com.zone.hospital;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zone.hospital.base.BaseFragmtnt;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

//import com.zone.hospital.model.bean.Author;
//import com.zone.hospital.model.bean.AuthorDao;
//import com.zone.hospital.model.bean.DaoMaster;
//import com.zone.hospital.model.bean.DaoSession;
//import com.zone.hospital.model.bean.Post;
//import com.zone.hospital.model.bean.PostDao;
//import com.zone.hospital.model.bean.ScoreBean;
//import com.zone.hospital.model.bean.ScoreBeanDao;
//import com.zone.hospital.model.bean.StudentMsgBean;
//import com.zone.hospital.model.bean.StudentMsgBeanDao;
//import org.greenrobot.greendao.query.Query;
//import org.greenrobot.greendao.query.QueryBuilder;
//import org.greenrobot.greendao.rx.RxDao;
//import org.greenrobot.greendao.rx.RxQuery;


/**
 * Created by john on 2016/7/14.
 */
public class HomeFragment extends BaseFragmtnt {


    @InjectView(R.id.ivBt1)
    CardView mIvBt1;
    @InjectView(R.id.ivBt2)
    CardView mIvBt2;
    @InjectView(R.id.ivBt3)
    CardView mIvBt3;
    @InjectView(R.id.ivBt4)
    CardView mIvBt4;
    @InjectView(R.id.ivBt5)
    CardView mIvBt5;
    @InjectView(R.id.ivBt6)
    CardView mIvBt6;
    @InjectView(R.id.ivBt7)
    CardView mIvBt7;
    @InjectView(R.id.ivBt8)
    CardView mIvBt8;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View meView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.inject(this, meView);
        return meView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    @OnClick({R.id.ivBt1, R.id.ivBt2, R.id.ivBt3, R.id.ivBt4, R.id.ivBt5, R.id.ivBt6, R.id.ivBt7, R.id.ivBt8})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBt1:
                mSpeechSynthesizer.speak("这是医院介绍");

                Log.e("text","这是医院介绍");
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("title", "医院介绍");
                intent.putExtra("url", "http://www.mxqfby.com/about.asp");
                startActivity(intent);
                break;
            case R.id.ivBt2:
                Log.e("text","这是医生简介");
                mSpeechSynthesizer.speak("这是医生简介");
                Intent intent3 = new Intent(getActivity(), WebViewActivity.class);
                intent3.putExtra("title", "医生简介");
                intent3.putExtra("url", "http://www.mxqfby.com/td.asp");
                startActivity(intent3);
                break;
            case R.id.ivBt3:
                Log.e("text","这是问诊导航");

                startActivity(new Intent(getActivity(), NavigationActivity.class));

                break;
            case R.id.ivBt4:


                startActivity(new Intent(getActivity(), SmartDiagnosisActivity.class));
                break;
            case R.id.ivBt5:

                startActivity(new Intent(getActivity(), HealthConsultingActivity.class));
                break;
            case R.id.ivBt6:
                mSpeechSynthesizer.speak("这是办事流程");
                Intent intent4 = new Intent(getActivity(), WebViewActivity.class);
                intent4.putExtra("title", "办事流程");
                intent4.putExtra("url", "http://dr.trickyedecay.me/gp.html");
                startActivity(intent4);
                break;
            case R.id.ivBt7:
                mSpeechSynthesizer.speak("这是保健知识");
                Intent intent2 = new Intent(getActivity(), WebViewActivity.class);
                intent2.putExtra("title", "保健知识");
                intent2.putExtra("url", "http://dr.trickyedecay.me/knowledge.html");
                startActivity(intent2);
                break;
            case R.id.ivBt8:

                startActivity(new Intent(getActivity(), ServiceEvalateActivity.class));
                break;
        }
    }
}
