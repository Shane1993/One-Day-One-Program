package net.lzs.paint01_basicuseofpaintingapi;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;


public class MainActivity extends ActionBarActivity {

    private EditText et_x,et_y;
    private MyPoint mp;
    private RelativeLayout rl;
    private int max_x,max_y;
    private float input_x,input_y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_x = (EditText) findViewById(R.id.et_x);
        et_y = (EditText) findViewById(R.id.et_y);
        mp = (MyPoint) findViewById(R.id.mp);
        rl = (RelativeLayout) findViewById(R.id.container);

        findViewById(R.id.btn_commit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (max_x == 0 && max_y == 0) {
                    max_x = rl.getWidth();
                    max_y = rl.getHeight();
                    System.out.println(max_x + "-----------------------------" + max_y);
                }

                if (!TextUtils.isEmpty(et_x.getText().toString()) && !TextUtils.isEmpty(et_y.getText().toString())) {

                    input_x = Float.parseFloat(et_x.getText().toString());
                    input_y = Float.parseFloat(et_y.getText().toString());

                    if (input_x >= 0.0 && input_x <= 100.0 && input_y >= 0.0 && input_y <= 100) {
                        mp.setX(input_x * max_x / 100.0f);
                        mp.setY(input_y * max_y / 100.0f);
                    }
                }
            }
        });
    }

}
