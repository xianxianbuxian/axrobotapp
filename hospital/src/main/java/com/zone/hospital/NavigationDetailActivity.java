package com.zone.hospital;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zone.hospital.base.BaseActivity2;
import com.zone.hospital.utils.okhttppostjson;

import org.json.JSONObject;

import java.util.HashMap;

import butterknife.InjectView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;


public class NavigationDetailActivity extends BaseActivity2 {
 private int i;
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.tv_first)
    TextView mTvFirst;
    @InjectView(R.id.tv_second)
    TextView mTvSecond;
    @InjectView(R.id.tv_there)
    TextView mTvThere;
    @InjectView(R.id.tv_four)
    TextView mTvFour;
    @InjectView(R.id.tv_five)
    TextView mTvFive;
    @InjectView(R.id.tv_six)
    TextView mTvSix;

    @InjectView(R.id.tv_title)
    TextView mTvTitle;
    private okhttppostjson post;

    @Override
    public int setLayoutId() {
        return R.layout.activity_navigation;
    }

    @Override
    public void init() {
        mTvTitle.setText("导诊");
        mTvFirst.setText("缴费处");
        mTvSecond.setText("缴费处1");
        mTvThere.setText("缴费处2");
        mTvFour.setText("缴费处3");
        mTvFive.setText("缴费处4");
        mTvSix.setText("缴费处5");
        post = new okhttppostjson();
    }

    @Override
    public boolean isUseToolbar() {
        return true;
    }



    @OnClick({R.id.tv_first,R.id.tv_second})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_first:
                i=1;
                showToast("click");
                showAlertDialog("缴费处","您确定要去缴费处吗");
                mSpeechSynthesizer.speak("确定要去交费处吗");
                break;
            case R.id.tv_second:
                i=2;
                showToast("click");
                showAlertDialog("缴费处","您确定要去缴费处吗");
                mSpeechSynthesizer.speak("确定要去交费处2吗");
                break;
        }

    }
    public void showAlertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (i){
                    case 1:
                        HashMap<String, String> params = new HashMap<>();
                        params.put("name", "餐厅11");
                        params.put("x", "1.0");
                        params.put("y", "1.0");
                        params.put("yaw", "1.0");
                        JSONObject jsonObject = new JSONObject(params);
                        post.postjson(jsonObject);
                        break;
                    case 2:
                        HashMap<String, String> params1 = new HashMap<>();
                        params1.put("name", "餐厅22");
                        params1.put("x", "1.0");
                        params1.put("y", "1.0");
                        params1.put("yaw", "1.0");
                        JSONObject jsonObject1 = new JSONObject(params1);
                        post.postjson(jsonObject1);
                        break;
                }

                mSpeechSynthesizer.speak("请跟我来");
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
