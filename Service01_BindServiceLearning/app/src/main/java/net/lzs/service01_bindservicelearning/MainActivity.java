package net.lzs.service01_bindservicelearning;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements ServiceConnection {


    private Button btn_bindservice,btn_unbindservicee,btn_sync;
    private TextView tv;
    private EditText et;
    private MyService.MyBinder binder;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String data = bundle.getString("data");
            tv.setText(data);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_bindservice = (Button) findViewById(R.id.btn_bindservice);
        btn_unbindservicee = (Button) findViewById(R.id.btn_unbindservice);
        btn_sync = (Button) findViewById(R.id.btn_sync);
        tv = (TextView) findViewById(R.id.tv);
        et = (EditText) findViewById(R.id.et);

        btn_bindservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bindService(new Intent(MainActivity.this,MyService.class),MainActivity.this,BIND_AUTO_CREATE);
            }
        });

        btn_unbindservicee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                unbindService(MainActivity.this);

            }
        });

        btn_sync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binder != null) {
                    binder.setData(et.getText().toString());
                }
            }
        });
    }


    /**
     * 在执行bindService之后便会执行该方法以得到Service里面的Binder对象
     * 然后通过binder对象便可以与Service进行通信了
     * @param componentName
     * @param iBinder
     */
    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

        System.out.println("---------------------this is onServiceConnected");

        binder = (MyService.MyBinder) iBinder;

        MyService service = binder.getService();
        service.setCallback(new MyService.Callback() {
            @Override
            public void onDataChange(String data) {

                Bundle bundle = new Bundle();
                bundle.putString("data", data);
                Message msg = new Message();
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        });

    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

        System.out.println("---------------------this is onServiceDisconnected");
    }
}
