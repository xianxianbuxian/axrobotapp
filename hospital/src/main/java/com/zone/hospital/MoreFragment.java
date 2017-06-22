package com.zone.hospital;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zone.hospital.base.BaseFragmtnt;

import butterknife.ButterKnife;


/**
 * Created by john on 2016/7/14.
 */
public class MoreFragment extends BaseFragmtnt  {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View meView = inflater.inflate(R.layout.fragment_more, container, false);
        ButterKnife.inject(this, meView);
        return meView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


}
