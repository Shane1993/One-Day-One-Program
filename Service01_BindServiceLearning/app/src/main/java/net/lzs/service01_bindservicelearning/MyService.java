package net.lzs.service01_bindservicelearning;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

    private boolean running = false;
    private String data = "default information";
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public MyService() {
    }

    public class MyBinder extends Binder
    {
        public void setData(String data)
        {
            MyService.this.data = data;
        }

        public MyService getService()
        {
            return MyService.this;
        }
    }

    /**
     * 在Activity中执行bindService之后便会执行该onBind函数返回一个IBinder对象给Activity用于与Service进行通信
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {

        System.out.println("-------------------------this is bindservice");

        return new MyBinder();
    }

    /**
     * Activity中bindService之后同时还会启动onCreate函数，所以onBind和onCreate都会执行，注:onCreate比onBind先执行
     */
    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println("-------------------------this is service onCreate");

        new Thread(new Runnable() {
            @Override
            public void run() {

                int i = 0;

                running = true;
                while (running) {
                    String str = ++i + " : " + data;

                    if (callback != null)
                    {
                        callback.onDataChange(str);
                    }

                    System.out.println(str);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("-------------------------this is service onDestroy");
        running = false;

    }

    public static interface Callback
    {
        void onDataChange(String data);
    }
}
