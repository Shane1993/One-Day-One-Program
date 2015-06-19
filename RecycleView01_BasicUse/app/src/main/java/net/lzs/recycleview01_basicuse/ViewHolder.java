package net.lzs.recycleview01_basicuse;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by LEE on 2015/6/19.
 */
class ViewHolder extends RecyclerView.ViewHolder implements View.OnTouchListener {

    TextView tv_title, tv_content;
    OnViewHolderClickListener onViewHolderClickListener;

    public void setOnViewHolderClickListener(OnViewHolderClickListener onViewHolderClickListener) {
        this.onViewHolderClickListener = onViewHolderClickListener;
    }

    public ViewHolder(View itemView) {
        super(itemView);

        tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        tv_content = (TextView) itemView.findViewById(R.id.tv_content);

        itemView.setOnTouchListener(this);

    }

    public ViewHolder(final View itemView, OnViewHolderClickListener onViewHolderClickListener) {
        super(itemView);

        this.onViewHolderClickListener = onViewHolderClickListener;
        tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        tv_content = (TextView) itemView.findViewById(R.id.tv_content);

        itemView.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                itemView.setBackgroundColor(Color.BLUE);
                break;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_CANCEL:
                itemView.setBackgroundColor(Color.TRANSPARENT);
                break;
            case MotionEvent.ACTION_UP:
                itemView.setBackgroundColor(Color.TRANSPARENT);

                if (onViewHolderClickListener != null) {
                    onViewHolderClickListener.onViewHodlerClick(getLayoutPosition());
                }
                break;
            default:
                break;
        }

        return true;
    }

    public static interface OnViewHolderClickListener {
        public void onViewHodlerClick(int position);
    }
}
