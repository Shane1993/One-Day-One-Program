package net.lee.fragment2;

import android.app.Activity;
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

    private OnButtonClickListener listener;

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
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof OnButtonClickListener)
        {
            listener = (OnButtonClickListener) activity;
        }else
        {
            throw new ClassCastException(activity.toString() + " must implement Fragment1.OnButtonClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onClick(View v) {
        updateDetail();
    }

    public void updateDetail()
    {
        listener.onButtonClick(++count);
    }

    public interface OnButtonClickListener
    {
        public void onButtonClick(int count);
    }
}
