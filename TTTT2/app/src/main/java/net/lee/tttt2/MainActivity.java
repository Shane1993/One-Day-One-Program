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
        //设置模式，是在左边呢还是右边等等
        slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);
        //设置偏移的大小，利用自定义在R.dimen的大小，默认是0
        //!!!注意这个大小是指slidingmenu出现后偏移的大小，默认是0，意思也就是如果不设置的话会铺满全屏
            //也就是说，该偏移大小越小，slidingmenu所占的空间就越大
            //偏移越大，slidingmenu所占的空间就越小
        slidingMenu.setBehindOffsetRes(R.dimen.sliding_menu_offset);
        //设置触摸模式(即对SlidingMenu滑动生效的位置)
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //附加到当前的Activity
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setFadeDegree(0.35f);
        //设置布局资源
        slidingMenu.setMenu(R.layout.slidingmenu);
        //设置右边的slidingmenu
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
