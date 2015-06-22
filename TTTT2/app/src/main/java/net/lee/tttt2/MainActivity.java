package net.lee.tttt2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;


public class MainActivity extends Activity {

    private SlidingMenu slidingMenu;
    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slidingMenu = new SlidingMenu(this);
        //����ģʽ����������ػ����ұߵȵ�
        slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);
        //����ƫ�ƵĴ�С�������Զ�����R.dimen�Ĵ�С��Ĭ����0
        //!!!ע�������С��ָslidingmenu���ֺ�ƫ�ƵĴ�С��Ĭ����0����˼Ҳ������������õĻ�������ȫ��
            //Ҳ����˵����ƫ�ƴ�СԽС��slidingmenu��ռ�Ŀռ��Խ��
            //ƫ��Խ��slidingmenu��ռ�Ŀռ��ԽС
        slidingMenu.setBehindOffsetRes(R.dimen.sliding_menu_offset);
        //���ô���ģʽ(����SlidingMenu������Ч��λ��)
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //���ӵ���ǰ��Activity
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setFadeDegree(0.35f);
        //���ò�����Դ
        slidingMenu.setMenu(R.layout.slidingmenu);
        //�����ұߵ�slidingmenu
        slidingMenu.setSecondaryMenu(R.layout.rightmenu);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("HHAHAHAHAHAHHA");
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("NONONONONO");
            }
        });

    }

}
