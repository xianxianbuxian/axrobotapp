package com.zone.hospital;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.tts.client.SpeechSynthesizer;
import com.zone.hospital.base.BaseActivity2;
import com.zone.hospital.myApplication.MyApplication;
import com.zone.hospital.utils.ScreenUtils;
import com.zone.hospital.weidge.FlashPoit;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class SmartDiagnosisActivity extends BaseActivity2 {

    @InjectView(R.id.tv_sex)
    TextView mTvSex;
    @InjectView(R.id.layout_up)
    LinearLayout mLayoutUp;
    @InjectView(R.id.layout_down)
    LinearLayout mLayoutDown;
    @InjectView(R.id.activity_main)
    LinearLayout mActivityMain;
 //  @InjectView(R.id.tv_up_head)
   FlashPoit mTvUpHead;
  // @InjectView(R.id.tv_up_left_arm)
    FlashPoit mTvUpLeftArm;
   // @InjectView(R.id.tv_up_back)
    FlashPoit mTvUpBack;
   //@InjectView(R.id.tv_up_right_arm)
    FlashPoit mTvUpRightArm;
  //  @InjectView(R.id.tv_up_left_hand)
    FlashPoit mTvUpLeftHand;
  // @InjectView(R.id.tv_up_left_pap)
    FlashPoit mTvUpLeftPap;
   // @InjectView(R.id.tv_up_right_pap)
    FlashPoit mTvUpRightPap;
    //@InjectView(R.id.tv_up_right_hand)
    FlashPoit mTvUpRightHand;
   // @InjectView(R.id.tv_up_left_leg)
    FlashPoit mTvUpLeftLeg;
  //  @InjectView(R.id.tv_up_right_leg)
    FlashPoit mTvUpRightLeg;
  //  @InjectView(R.id.tv_up_left_foot)
    FlashPoit mTvUpLeftFoot;
   // @InjectView(R.id.tv_up_right_foot)
    FlashPoit mTvUpRightFoot;
       // @InjectView(R.id.tv_down_head)
        FlashPoit mTvDownHead;
   // @InjectView(R.id.tv_down_left_arm)
    FlashPoit mTvDownLeftArm;
   // @InjectView(R.id.tv_down_back)
    FlashPoit mTvDownBack;
   // @InjectView(R.id.tv_down_right_arm)
    FlashPoit mTvDownRightArm;
   // @InjectView(R.id.tv_down_left_hand)
    FlashPoit mTvDownLeftHand;
   // @InjectView(R.id.tv_down_left_pap)
    FlashPoit mTvDownLeftPap;
   // @InjectView(R.id.tv_down_right_pap)
    FlashPoit mTvDownRightPap;
   // @InjectView(R.id.tv_down_right_hand)
    FlashPoit mTvDownRightHand;
   //@InjectView(R.id.tv_down_left_leg)
    FlashPoit mTvDownLeftLeg;
 //  @InjectView(R.id.tv_down_right_leg)
    FlashPoit mTvDownRightLeg;
  // @InjectView(R.id.tv_down_left_foot)
    FlashPoit mTvDownLeftFoot;
 //  @InjectView(R.id.tv_down_right_foot)
    FlashPoit mTvDownRightFoot;
    private boolean isMan;

    @Override
    public int setLayoutId() {
        return R.layout.activity_smart_diagnosis;
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void init() {
        isMan = true;
      // MyApplication.setAge("25");
        MyApplication.setSex("男");
        mSpeechSynthesizer.speak("点击闪烁除查看部位症状");
          mTvDownLeftFoot= (FlashPoit) findViewById(R.id.tv_down_left_foot);
       mTvDownBack=  (FlashPoit) findViewById(R.id.tv_down_back);
       mTvDownHead= (FlashPoit) findViewById(R.id.tv_down_head);
       mTvDownLeftArm= (FlashPoit) findViewById(R.id.tv_down_left_arm);
       mTvDownLeftHand= (FlashPoit) findViewById(R.id.tv_down_left_hand);
       mTvDownLeftLeg= (FlashPoit) findViewById(R.id.tv_down_left_leg);
       mTvDownLeftPap =(FlashPoit) findViewById(R.id.tv_down_left_pap);
       mTvDownRightArm= (FlashPoit) findViewById(R.id.tv_down_right_arm);
      mTvDownRightFoot=  (FlashPoit) findViewById(R.id.tv_down_right_foot);
      mTvDownRightLeg=  (FlashPoit) findViewById(R.id.tv_down_right_leg);
      mTvDownRightPap=  (FlashPoit) findViewById(R.id.tv_down_right_pap);
        mTvDownRightHand=(FlashPoit) findViewById(R.id.tv_down_right_hand);

      mTvUpBack= (FlashPoit) findViewById(R.id.tv_up_back);
      mTvUpHead=  (FlashPoit) findViewById(R.id.tv_up_head);
      mTvUpLeftArm = (FlashPoit) findViewById(R.id.tv_up_left_arm);
       mTvUpLeftFoot= (FlashPoit) findViewById(R.id.tv_up_left_foot);
       mTvUpLeftHand= (FlashPoit) findViewById(R.id.tv_up_left_hand);
       mTvUpLeftLeg=  (FlashPoit) findViewById(R.id.tv_up_left_leg);
       mTvUpLeftPap= (FlashPoit) findViewById(R.id.tv_up_left_pap);
        mTvUpRightArm= (FlashPoit) findViewById(R.id.tv_up_right_arm);
       mTvUpRightFoot= (FlashPoit) findViewById(R.id.tv_up_right_foot);
       mTvUpRightHand= (FlashPoit) findViewById(R.id.tv_up_right_hand);
     mTvUpRightLeg=   (FlashPoit) findViewById(R.id.tv_up_right_leg);

startanim();
    }

    private void startanim() {
        mTvDownLeftFoot.startAnimation(initscaleanim());
        mTvDownBack.startAnimation(initscaleanim());
        mTvDownHead.startAnimation(initscaleanim());
        mTvDownLeftLeg.startAnimation(initscaleanim());
        mTvDownLeftHand.startAnimation(initscaleanim());
        mTvDownLeftArm.startAnimation(initscaleanim());
        mTvDownLeftPap.startAnimation(initscaleanim());
        mTvDownRightArm.startAnimation(initscaleanim());
        mTvDownRightFoot.startAnimation(initscaleanim());
        mTvDownRightHand.startAnimation(initscaleanim());
        mTvDownRightLeg.startAnimation(initscaleanim());
        mTvDownRightPap.startAnimation(initscaleanim());

        mTvUpBack.startAnimation(initscaleanim());
        mTvUpHead.startAnimation(initscaleanim());
        mTvUpLeftArm.startAnimation(initscaleanim());
        mTvUpLeftFoot.startAnimation(initscaleanim());
        mTvUpLeftHand.startAnimation(initscaleanim());
        mTvUpLeftLeg.startAnimation(initscaleanim());
        mTvUpLeftPap.startAnimation(initscaleanim());
        mTvUpRightArm.startAnimation(initscaleanim());
        mTvUpRightFoot.startAnimation(initscaleanim());
        mTvUpRightHand.startAnimation(initscaleanim());
        mTvUpRightLeg.startAnimation(initscaleanim());

    }

    private ScaleAnimation initscaleanim() {
        ScaleAnimation mSaim= new ScaleAnimation(0.5f,1.0f,0.5f,1.0f, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        mSaim.setDuration(1000);
        mSaim.setRepeatMode(ScaleAnimation.INFINITE);
        mSaim.setRepeatCount(Integer.MAX_VALUE);
        mSaim.setFillAfter(true);
        return  mSaim;
    }
    @Override
    public boolean isUseToolbar() {
        return false;
    }


    @OnClick({R.id.layout_return,R.id.tv_sex, R.id.tv_up_head, R.id.tv_up_left_arm, R.id.tv_up_back, R.id.tv_up_right_arm, R.id.tv_up_left_hand, R.id.tv_up_left_pap, R.id.tv_up_right_pap, R.id.tv_up_right_hand, R.id.tv_up_left_leg, R.id.tv_up_right_leg, R.id.tv_up_left_foot, R.id.tv_up_right_foot, R.id.tv_down_head, R.id.tv_down_left_arm, R.id.tv_down_back, R.id.tv_down_right_arm, R.id.tv_down_left_hand, R.id.tv_down_left_pap, R.id.tv_down_right_pap, R.id.tv_down_right_hand, R.id.tv_down_left_leg, R.id.tv_down_right_leg, R.id.tv_down_left_foot, R.id.tv_down_right_foot})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_return:
                onBackPressed();
                break;
            case R.id.tv_sex:
                if (isMan) {
                   mSpeechSynthesizer.speak("女");
//                    showToast("转为女");
                    MyApplication.setSex("女");
//                    mTvUpRightFoot.setLayoutParams(new ViewGroup.LayoutParams());
                    mLayoutUp.setBackgroundResource(R.mipmap.bg_women_body_up);

                    ObjectAnimator animator = ObjectAnimator.ofFloat(mLayoutUp, "alpha", 0f, 180f);
                    animator.setDuration(1500);
                    animator.start();
                    mLayoutDown.setBackgroundResource(R.mipmap.bg_women_body_down);
                   // mTvSex.setBackgroundResource(R.drawable.bg_sex_feman);
                    isMan = false;

//                    float screenHeight = ScreenUtils.getScreenHeight(this);

//                    FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (screenHeight / 13), 1);
//                    lp.setMargins(0, (i - 1) * ((int) (screenHeight / 13) + 1), 0, 1);
                } else {
                   mSpeechSynthesizer.speak("男");
                    MyApplication.setSex("男");
//                    showToast("转为男");
                    ObjectAnimator animator = ObjectAnimator.ofFloat(mLayoutUp, "alpha", 0f, 180f);
                    animator.setDuration(1500);
                    animator.start();
                 //   mTvSex.setBackgroundResource(R.drawable.bg_sex_man);
                    mLayoutUp.setBackgroundResource(R.mipmap.bg_man_body_up);
                    mLayoutDown.setBackgroundResource(R.mipmap.bg_man_body_down);
                    isMan = true;
                }
                break;


            case R.id.tv_up_head:

         //   mSpeechSynthesizer.speak("这是脸部");
                MyApplication.setWhere("脸");
                MyApplication.setListTag("6");
                MyApplication.setWheretag("1");
              //  super.m
                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
            case R.id.tv_down_head:

         //   mSpeechSynthesizer.speak("这是后脑");
                MyApplication.setWhere("后脑");
                MyApplication.setListTag("7");
                MyApplication.setWheretag("2");
                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
            case R.id.tv_up_back:
               // mSpeechSynthesizer.speak("这是腹部");
                MyApplication.setWhere("腹部");
                MyApplication.setListTag("5");
                MyApplication.setWheretag("3");
                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
            case R.id.tv_down_back:
             //   mSpeechSynthesizer.speak("这是背部");
                MyApplication.setWhere("背");
                MyApplication.setWheretag("4");
                MyApplication.setListTag("4");
                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;


//          pap
            case R.id.tv_up_left_pap:
                MyApplication.setWheretag("13");
                MyApplication.setWhere("会阴");
                if (MyApplication.getSex().equals("男")) {
                    MyApplication.setListTag("1");
                } else if (MyApplication.getSex().equals("女")) {
                    showToast("女");
                    MyApplication.setListTag("2");
                }
                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
            case R.id.tv_up_right_pap:
                MyApplication.setWheretag("13");
                MyApplication.setWhere("右屁股");
                if (MyApplication.getSex().equals("男")) {
                    MyApplication.setListTag("10");
                } else if (MyApplication.getSex().equals("女")) {
                    MyApplication.setListTag("10");
                }
                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
            case R.id.tv_down_left_pap:
                MyApplication.setWheretag("13");
                MyApplication.setListTag("10");
                MyApplication.setWhere("左屁股");
                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
            case R.id.tv_down_right_pap:
                MyApplication.setWheretag("13");
                MyApplication.setListTag("10");
                MyApplication.setWhere("右屁股");
                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));
                break;


            //            手臂
            case R.id.tv_up_left_arm:
              //  mSpeechSynthesizer.speak("这是左手臂");
                MyApplication.setWheretag("5");
                MyApplication.setWhere("左臂");
                MyApplication.setListTag("3");

                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
            case R.id.tv_up_right_arm:
              //  mSpeechSynthesizer.speak("这是右手臂");
                MyApplication.setWhere("右臂");
                MyApplication.setWheretag("6");
                MyApplication.setListTag("3");

                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
            case R.id.tv_down_left_arm:
               // mSpeechSynthesizer.speak("这是左手臂");
                MyApplication.setWheretag("5");
                MyApplication.setWhere("左臂");
                MyApplication.setListTag("3");

                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
            case R.id.tv_down_right_arm:
             //   mSpeechSynthesizer.speak("这是右手臂");
                MyApplication.setWheretag("6");
                MyApplication.setWhere("右臂");
                MyApplication.setListTag("3");

                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;

//            手
            case R.id.tv_up_left_hand:
              //  mSpeechSynthesizer.speak("这是左手");
                MyApplication.setWheretag("7");
                MyApplication.setWhere("左手");
                MyApplication.setListTag("3");

                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
            case R.id.tv_up_right_hand:
              //  mSpeechSynthesizer.speak("这是右手");
                MyApplication.setWheretag("8");
                MyApplication.setWhere("右手");
                MyApplication.setListTag("3");

                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
            case R.id.tv_down_left_hand:
               // mSpeechSynthesizer.speak("这是左手");
                MyApplication.setWheretag("7");
                MyApplication.setWhere("左手");
                MyApplication.setListTag("3");

                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
            case R.id.tv_down_right_hand:
             //   mSpeechSynthesizer.speak("这是右手");
                MyApplication.setWheretag("8");
                MyApplication.setWhere("右手");
                MyApplication.setListTag("3");

                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;


//            腿
            case R.id.tv_up_left_leg:
              //  mSpeechSynthesizer.speak("这是左腿");
                MyApplication.setWheretag("9");
                MyApplication.setWhere("左腿");
                MyApplication.setListTag("3");

                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
            case R.id.tv_up_right_leg:
               // mSpeechSynthesizer.speak("这是右腿");
                MyApplication.setWheretag("10");
                MyApplication.setWhere("右腿");
                MyApplication.setListTag("3");

                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
            case R.id.tv_down_left_leg:
              //  mSpeechSynthesizer.speak("这是左腿");
                MyApplication.setWheretag("9");
                MyApplication.setWhere("左腿");
                MyApplication.setListTag("3");

                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
            case R.id.tv_down_right_leg:
               // mSpeechSynthesizer.speak("这是右腿");
                MyApplication.setWheretag("10");
                MyApplication.setWhere("右腿");
                MyApplication.setListTag("3");

                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;


//            脚
            case R.id.tv_up_left_foot:
              //  mSpeechSynthesizer.speak("这是左脚");
                MyApplication.setWheretag("11");
                MyApplication.setWhere("左脚");
                MyApplication.setListTag("3");

                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
            case R.id.tv_up_right_foot:
                //mSpeechSynthesizer.speak("这是右脚");
                MyApplication.setWheretag("12");
                MyApplication.setWhere("右脚");
                MyApplication.setListTag("3");
                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
            case R.id.tv_down_left_foot:
               // mSpeechSynthesizer.speak("这是左脚");
                MyApplication.setWheretag("11");
                MyApplication.setWhere("左脚");
                MyApplication.setListTag("3");

                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
            case R.id.tv_down_right_foot:
                //mSpeechSynthesizer.speak("这是右脚");
                MyApplication.setWheretag("12");
                MyApplication.setWhere("右脚");
                MyApplication.setListTag("3");
                startActivity(new Intent(SmartDiagnosisActivity.this, SmartSelectActivity.class));

                break;
        }
    }




}
