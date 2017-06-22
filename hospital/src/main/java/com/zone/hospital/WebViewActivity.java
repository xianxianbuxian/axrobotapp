package com.zone.hospital;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zone.hospital.base.BaseActivity;
import com.zone.hospital.myApplication.MyApplication;
import com.zone.hospital.utils.SPUtils;
import com.zone.hospital.weidge.ProgressWebView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by john on 2016/7/18.
 */
public class WebViewActivity extends BaseActivity {


    ProgressWebView wv;
    @InjectView(R.id.tv_title)
    TextView mTvTitle;
    private long djtime[] = new long[2];
    private Toolbar toolbar;
    private String from;
    private ValueAnimator mAnimator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        setTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.inject(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        wv = (ProgressWebView) findViewById(R.id.wv);
        iniBase();
        String title = getIntent().getStringExtra("title");
        String url = getIntent().getStringExtra("url");
        toolbar.setTitle("");
        mTvTitle.setText(title);
        wv.setWebViewClient(new WebViewClient() {//防止调用系统的浏览器
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
//        wv.setWebChromeClient(new WebChromeClient(){
//            @Override
//            public void onProgressChanged(WebView view, int newProgress) {
//                //get the newProgress and refresh progress bar
//                L.d("==progress==>"+String.valueOf(newProgress));
//            }
//
//            @Override
//            public void onReceivedTitle(WebView view, String title) {
//                super.onReceivedTitle(view, title);
//                L.d("==Title==>"+title);
//
//            }
//        });
        wv.getSettings().setDefaultTextEncodingName("utf-8");
        //支持js
        wv.getSettings().setJavaScriptEnabled(true);
        //设置背景颜色 透明
//        wv.setBackgroundColor(Color.argb(0, 0, 0, 0));
        WebSettings webSettings = wv.getSettings();
        webSettings.setSupportZoom(true);
        //启用数据库
//        webSettings.setDatabaseEnabled(true);
//
////设置定位的数据库路径
//
//        String dir = this.getApplicationContext().getDir("database", Context.MODE_PRIVATE).getPath();
//
//        webSettings.setGeolocationDatabasePath(dir);
//启用地理定位
        webSettings.setGeolocationEnabled(true);
//开启DomStorage缓存

        webSettings.setDomStorageEnabled(true);

//        wv.setWebChromeClient(new WebChromeClient() {//有这个好像就能通过webview定位了
//
//            @Override
//            public void onReceivedIcon(WebView view, Bitmap icon) {
//                super.onReceivedIcon(view, icon);
//            }
//
//            @Override
//            public void onGeolocationPermissionsShowPrompt(String origin,GeolocationPermissions.Callback callback) {
//                callback.invoke(origin, true, false);
//                super.onGeolocationPermissionsShowPrompt(origin, callback);
//            }
//        });
        wv.loadUrl(url);


//        mAnimator = ValueAnimator.ofFloat(0, 180);
//        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float value = (float) animation.getAnimatedValue();
//                mLayoutReturn.setAlpha(value);
//            }
//        });
//        mAnimator.setDuration(2000);
//        mAnimator.setRepeatCount(ValueAnimator.INFINITE);
//        mAnimator.setRepeatMode(ValueAnimator.REVERSE);
//        mAnimator.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mAnimator != null) {

            mAnimator.cancel();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mAnimator != null) {
            mAnimator.cancel();
        }
    }

    @Override
    protected void onResume() {
//        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        }
        super.onResume();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && wv.canGoBack()) {
            wv.goBack();
            return true;
        } else {
            System.arraycopy(djtime, 1, djtime, 0, djtime.length - 1);
            djtime[djtime.length - 1] = SystemClock.uptimeMillis();
            if (djtime[0] >= (SystemClock.uptimeMillis() - 1000)) {
                finish();
            } else {
                Toast.makeText(this, "再按一次返回", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    }

    private void toNextActivity() {//判断去登录界面还是主界面
        Intent intent = null;
        String token = (String) SPUtils.get(WebViewActivity.this, "token", "");
        if (TextUtils.isEmpty(token)) {
            intent = new Intent(WebViewActivity.this, LoginActivity.class);
        } else {
            intent = new Intent(WebViewActivity.this, MainActivity.class);
            MyApplication.setToken(token);
        }
        startActivity(intent);
    }


    @OnClick(R.id.layout_return)
    public void onClick() {
        onBackPressed();
    }
}
