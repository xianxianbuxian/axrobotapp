package com.zone.hospital;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zone.hospital.base.BaseFragmtnt2;
import com.zone.hospital.weidge.ProgressWebView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * Created by john on 2016/7/14.
 */
public class HospotalFragment extends BaseFragmtnt2 {
    @InjectView(R.id.wv)
    ProgressWebView wv;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_hospital;
    }

    @Override
    public void initView() {
        String title = "";
        String url = "http://dr.trickyedecay.me/intro.html";
        String from = "";
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
    }

    @Override
    public void initData() {
//        T.showShort(getContext(), "lazyLoad");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick(R.id.layout_return)
    public void onClick() {
        if (wv.canGoBack()) {
            wv.goBack();
        } else {
            ((MainActivity) getActivity()).mVpPage.setCurrentItem(0);
        }
    }

}
