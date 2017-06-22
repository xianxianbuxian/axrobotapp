package com.zone.hospital;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;

import com.zone.hospital.base.BaseActivity2;

import butterknife.InjectView;
import butterknife.OnClick;


public class ServiceEvalateActivity extends BaseActivity2 {
    @InjectView(R.id.tv_title)
    TextView mTvTitle;
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.client_feedback)
    EditText et_content;
    @Override
    public int setLayoutId() {
        return R.layout.activity_service_evaluate;
    }

    @Override
    public void init() {

        mToolbar.setTitle("");
        mTvTitle.setText("服务评价");
        mSpeechSynthesizer.speak("这是服务评价");

    }

    @Override
    public boolean isUseToolbar() {
        return true;
    }

    @OnClick(R.id.cv_submit)
    public void onClick() {
        if (!et_content.getText().toString().trim().equals("")){
            mSpeechSynthesizer.speak("谢谢您的评价");
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finish();
                }
            });

        }

    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_navigation);
//    }
}
