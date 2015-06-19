package net.lzs.recycleview01_basicuse;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by LEE on 2015/6/19.
 */
public class MyAdapter extends RecyclerView.Adapter {

    private List<CellData> lists;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public MyAdapter(List<CellData> lists)
    {
        this.lists = lists;
    }

    public MyAdapter(List<CellData> lists, OnItemClickListener onItemClickListener)
    {
        this.lists = lists;
        this.onItemClickListener = onItemClickListener;
    }


    /**
     * 以下两个方法相当于BaseAdapter中的getView分割成两个方法而已
     * @param parent
     * @param viewType
     * @return
     */

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cell,null);

        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.setOnViewHolderClickListener(new ViewHolder.OnViewHolderClickListener() {
            @Override
            public void onViewHodlerClick(int position) {
                if (onItemClickListener != null)
                {
                    onItemClickListener.onItemClick(position);
                }
            }

        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;

        CellData data = lists.get(position);

        viewHolder.tv_title.setText(data.getTitle());;
        viewHolder.tv_content.setText(data.getContent());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public static interface OnItemClickListener
    {
        void onItemClick(int position);
    }
}
