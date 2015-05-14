package net.lee.fragment2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by LEE on 2015/5/14.
 */
public class Fragment1 extends Fragment implements View.OnClickListener{

    TextView tv ;
    Button button;

    private static int count = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_1,container,false);

        tv = (TextView) rootView.findViewById(R.id.fragmentTv);
        button = (Button) rootView.findViewById(R.id.fragmentBtn);

        button.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fragmentBtn)
        {
            tv.setText(++count + "");
        }
    }
}
