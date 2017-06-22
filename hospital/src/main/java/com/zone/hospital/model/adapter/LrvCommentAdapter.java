package com.zone.hospital.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by john on 2016/11/2.
 */
public abstract class LrvCommentAdapter<T extends Entity> extends ListBaseAdapter<T>{
    protected Context mContext;
    protected int mLayoutId;
//    private LayoutInflater mLayoutInflater;

    public LrvCommentAdapter(final Context context, final int layoutId, List<T> datas) {
//        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
        mLayoutId = layoutId;
        setDataList(datas);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return LrvHolder.createLrvHolder(mContext, parent, mLayoutId);
//                new LrvHolder(mContext,mLayoutInflater.inflate(mLayoutId, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        convert((LrvHolder) holder,mDataList.get(position),position);
    }



    protected abstract void convert(LrvHolder holder, T t, int position);
}
