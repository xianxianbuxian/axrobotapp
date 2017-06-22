package com.zone.hospital.base;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.TtsMode;
import com.zone.hospital.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.ButterKnife;

/**
 * Created by john on 2016/11/19.
 */
public abstract class BaseFragmtnt2 extends Fragment  {


    private boolean isVisible = false;
    private boolean isInitView = false;
    private boolean isFirstLoad= true;

    public abstract int setLayoutId();
    public abstract void initView();
    public abstract void initData();
//    public abstract void initView();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isVisible = true;
            lazyLoad();
        } else {
            isVisible = false;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayoutId(), container, false);
        ButterKnife.inject(this, view);
        isInitView = true;
        initView();
        lazyLoad();

        return view;
    }

    private void lazyLoad() {
        if (!isVisible || !isInitView || !isFirstLoad) {
            return;
        }
        initData();
        isFirstLoad = false;

    }





    /*
     * @param v
     */

    }



