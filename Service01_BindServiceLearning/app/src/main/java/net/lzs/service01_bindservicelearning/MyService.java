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
     * ��Activity��ִ��bindService֮����ִ�и�onBind��������һ��IBinder�����Activity������Service����ͨ��
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {

        System.out.println("-------------------------this is bindservice");

        return new MyBinder();
    }

    /**
     * Activity��bindService֮��ͬʱ��������onCreate����������onBind��onCreate����ִ�У�ע:onCreate��onBind��ִ��
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
