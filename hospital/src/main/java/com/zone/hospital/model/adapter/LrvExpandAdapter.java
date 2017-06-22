package com.zone.hospital.model.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.zone.hospital.utils.L;

import java.util.List;

/**
 * Created by john on 2016/11/4.
 */
public abstract class LrvExpandAdapter<T extends ExpandableRecyclerAdapter.ListItem> extends ExpandableRecyclerAdapter<T> {

    public static final int TYPE_CHILD = 1001;

    private LRecyclerView recyclerView;
    private Context mcontext;
    private int headLayoutID;
    private int childLayoutID;

    public LrvExpandAdapter(Context context,LRecyclerView recyclerView, int headLayoutID, int childLayoutID, List<T> datas) {
        super(context);
        mcontext = context;
        this.headLayoutID = headLayoutID;
        this.childLayoutID = childLayoutID;
        this.recyclerView = recyclerView;
        setItems(datas);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case TYPE_HEADER:
                return LrvHolder.createLrvHolder(mcontext,parent,headLayoutID);
            case TYPE_CHILD:
            default:
                return LrvHolder.createLrvHolder(mcontext,parent,childLayoutID);

        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                ((LrvHolder)holder).getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        handleClick(recyclerView,holder);
                    }
                });
                convertHead((LrvHolder) holder, visibleItems.get(position), position);
                L.d("==parent==1>   "+String.valueOf(position));

                break;
            case TYPE_CHILD:
            default:
                convertChild((LrvHolder) holder, visibleItems.get(position), position);
                L.d("==parent==2>   "+String.valueOf(position));
                break;
        }
    }

    protected abstract void convertHead(LrvHolder holder, T t, int position);

    protected abstract void convertChild(LrvHolder holder, T t, int position);


}
