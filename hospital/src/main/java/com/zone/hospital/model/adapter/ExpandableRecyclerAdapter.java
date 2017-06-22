package com.zone.hospital.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.util.RecyclerViewUtils;
import com.zone.hospital.utils.L;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class ExpandableRecyclerAdapter<T extends ExpandableRecyclerAdapter.ListItem> extends RecyclerView.Adapter<ExpandableRecyclerAdapter.ViewHolder> {
    protected Context mContext;
    protected List<T> allItems = new ArrayList<>();
    protected List<T> visibleItems = new ArrayList<>();
    private List<Integer> indexList = new ArrayList<>();//用于记录那些要显示的item在allItems中的position，且用于展开另外一个Header view的时候取出他的child vjiew
    private SparseIntArray expandMap = new SparseIntArray();
    private int mode;

    public static final int TYPE_HEADER = 1000;

    private static final int ARROW_ROTATION_DURATION = 150;

    public static final int MODE_NORMAL = 0;
    public static final int MODE_ACCORDION = 1;

    public ExpandableRecyclerAdapter(Context context) {
        mContext = context;
    }

    public static class ListItem implements Serializable{
        public int ItemType;
        public ListItem(int itemType) {
            ItemType = itemType;
        }
    }

    public void handleClick(RecyclerView recyclerView, RecyclerView.ViewHolder holder) {
        toggleExpandedItems(RecyclerViewUtils.getLayoutPosition(recyclerView, holder)-1, false);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return visibleItems == null ? 0 : visibleItems.size();
    }

    protected View inflate(int resourceID, ViewGroup viewGroup) {
        return LayoutInflater.from(mContext).inflate(resourceID, viewGroup, false);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }




    public class HeaderViewHolder extends ViewHolder {
        ImageView arrow;
        LRecyclerView recyclerView;

        public HeaderViewHolder(View view, final ImageView arrow, final LRecyclerView recyclerView) {
            super(view);

            this.arrow = arrow;
            this.recyclerView = recyclerView;

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (arrow != null) {
                        handleClick();
                    }
                }
            });
        }

        protected void handleClick() {
            if (toggleExpandedItems(RecyclerViewUtils.getLayoutPosition(recyclerView,this), false)) {
                openArrow(arrow);
            } else {
                closeArrow(arrow);
            }
        }

        public void bind(int position) {
            arrow.setRotation(isExpanded(position) ? 90 : 0);
        }
    }

    public boolean toggleExpandedItems(int position, boolean notify) {//可扩展item的开关
        L.d("==toggleExpandedItems==1>   "+String.valueOf(position));
        if (isExpanded(position)) {//如果是展开的，则闭合它
            collapseItems(position, notify);
            return false;
        } else {
            expandItems(position, notify);

            if (mode == MODE_ACCORDION) {//闭合除了这个item以外的其他item
                collapseAllExcept(position);
            }

            return true;
        }
    }

    public void expandItems(int position, boolean notify) {//展开item
        int count = 0;
        int index = indexList.get(position);//通过参数position取出该item在allItems中的position
        int insert = position;

        for (int i=index+1; i<allItems.size() && allItems.get(i).ItemType != TYPE_HEADER; i++) {
            insert++;
            count++;
            visibleItems.add(insert, allItems.get(i));
            indexList.add(insert, i);
        }

        notifyItemRangeInserted(position + 1, count);

        int allItemsPosition = indexList.get(position);
        expandMap.put(allItemsPosition, 1);

        if (notify) {
            notifyItemChanged(position);
        }
    }

    public void collapseItems(int position, boolean notify) {//闭合item
        int count = 0;
        int index = indexList.get(position);

        for (int i=index+1; i<allItems.size() && allItems.get(i).ItemType != TYPE_HEADER; i++) {
            count++;
            visibleItems.remove(position + 1);
            indexList.remove(position + 1);
        }

        notifyItemRangeRemoved(position + 1, count);

        int allItemsPosition = indexList.get(position);
        expandMap.delete(allItemsPosition);

        if (notify) {
            notifyItemChanged(position);
        }
    }

    public class StaticViewHolder extends ViewHolder {
        public StaticViewHolder(View view) {
            super(view);
        }
    }

    public class ItemViewHolder extends ViewHolder {
        public ItemViewHolder(View view) {
            super(view);
        }
    }

    protected boolean isExpanded(int position) {
        int allItemsPosition = indexList.get(position);
        return expandMap.get(allItemsPosition, -1) >= 0;
    }

    @Override
    public int getItemViewType(int position) {
        return visibleItems.get(position).ItemType;
    }

    public void setItems(List<T> items) {
        allItems = items;//记录所有的item
        List<T> visibleItems = new ArrayList<>();
        expandMap.clear();
        indexList.clear();

        for (int i=0; i<items.size(); i++) {
            if (items.get(i).ItemType == TYPE_HEADER) {
                indexList.add(i);//记录的是要显示出来的item的position
                visibleItems.add(items.get(i));//将type是Header的item加到visibleItems里面
            }
        }

        this.visibleItems = visibleItems;
        notifyDataSetChanged();
    }

    protected void notifyItemInserted(int allItemsPosition, int visiblePosition) {
        incrementIndexList(allItemsPosition, visiblePosition, 1);
        incrementExpandMapAfter(allItemsPosition, 1);

        if (visiblePosition >= 0) {
            notifyItemInserted(visiblePosition);
        }
    }

    protected void removeItemAt(int visiblePosition) {
        int allItemsPosition = indexList.get(visiblePosition);

        allItems.remove(allItemsPosition);
        visibleItems.remove(visiblePosition);

        incrementIndexList(allItemsPosition, visiblePosition, -1);
        incrementExpandMapAfter(allItemsPosition, -1);

        notifyItemRemoved(visiblePosition);
    }

    private void incrementExpandMapAfter(int position, int direction) {
        SparseIntArray newExpandMap = new SparseIntArray();

        for (int i=0; i<expandMap.size(); i++) {
            int index = expandMap.keyAt(i);
            newExpandMap.put(index < position ? index : index + direction, 1);
        }

        expandMap = newExpandMap;
    }

    private void incrementIndexList(int allItemsPosition, int visiblePosition, int direction) {
        List<Integer> newIndexList = new ArrayList<>();

        for (int i=0; i<indexList.size(); i++) {
            if (i == visiblePosition) {
                if (direction > 0) {
                    newIndexList.add(allItemsPosition);
                }
            }

            int val = indexList.get(i);
            newIndexList.add(val < allItemsPosition ? val : val + direction);
        }

        indexList = newIndexList;
    }

    public void collapseAll() {//闭合所有item，因为position不存在-1
        collapseAllExcept(-1);
    }

    public void collapseAllExcept(int position) {//闭合除了position以外的其他item
        for (int i=visibleItems.size()-1; i>=0; i--) {
            if (i != position && getItemViewType(i) == TYPE_HEADER) {
                if (isExpanded(i)) {
                    collapseItems(i, true);
                }
            }
        }
    }

    public void expandAll() {//展开所有item
        for (int i=visibleItems.size()-1; i>=0; i--) {
            if (getItemViewType(i) == TYPE_HEADER) {
                if (!isExpanded(i)) {
                    expandItems(i, true);
                }
            }
        }
    }

    public static void openArrow(View view) {//展开箭头
        view.animate().setDuration(ARROW_ROTATION_DURATION).rotation(90);
    }

    public static void closeArrow(View view) {//闭合箭头
        view.animate().setDuration(ARROW_ROTATION_DURATION).rotation(0);
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
}
