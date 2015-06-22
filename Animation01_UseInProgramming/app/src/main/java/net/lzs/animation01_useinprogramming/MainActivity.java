package net.lzs.animation01_useinprogramming;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ll = (LinearLayout) findViewById(R.id.container);

        ScaleAnimation sa = new ScaleAnimation(0,1,0,1);
        sa.setDuration(1000);

        /**
         * �÷����ĵڶ���������ָ��һ�����ֵĿؼ���Ҫ�����һ���ؼ����ֵ�ʱ���ӳٶ��ٰٷֱ�
         * ����0.5��ʾ��һ���ؼ�����һ�����һ���ؼ���ʼ����
         */
        LayoutAnimationController lac = new LayoutAnimationController(sa,0.5f);

        ll.setLayoutAnimation(lac);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
