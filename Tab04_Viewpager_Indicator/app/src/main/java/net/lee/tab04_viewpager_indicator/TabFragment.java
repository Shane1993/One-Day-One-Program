package net.lee.tab04_viewpager_indicator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by LEE on 2015/6/6.
 */
public class TabFragment extends Fragment {

    private TextView tv;
    private int position;

    public TabFragment(int position) {

        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag, container, false);
        tv = (TextView) view.findViewById(R.id.id_tv);
        tv.setText(TabAdapter.TITLES[position]);

        return view;
    }
}
