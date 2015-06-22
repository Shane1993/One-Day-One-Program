package net.lzs.animation03_learningallkindsofanimation;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener{

    private AlphaAnimation alphaAnimation;
    private TranslateAnimation translateAnimation;
    private ScaleAnimation scaleAnimation;
    private ScaleAnimation scaleAnimation_2;
    private AnimationSet animationSet;
    private AnimationSet animationSet_2;
    private MyAnimation myAnimation;

    private Button btn_alpha,btn_translate,btn_scale,btn_scale_2,btn_set,btn_set_2,btn_myanimation;

    private MyRectangle myRectangle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_alpha = (Button) findViewById(R.id.btn_alpha);
        btn_translate = (Button) findViewById(R.id.btn_translate);
        btn_scale = (Button) findViewById(R.id.btn_scale);
        btn_scale_2 = (Button) findViewById(R.id.btn_scale_2);
        btn_set = (Button) findViewById(R.id.btn_animationset);
        btn_set_2 = (Button) findViewById(R.id.btn_animationset_2);
        btn_myanimation = (Button) findViewById(R.id.btn_custom);

        myRectangle = (MyRectangle) findViewById(R.id.my_rect);

        btn_alpha.setOnClickListener(this);
        btn_translate.setOnClickListener(this);
        btn_scale.setOnClickListener(this);
        btn_scale_2.setOnClickListener(this);
        btn_set.setOnClickListener(this);
        btn_set_2.setOnClickListener(this);
        btn_myanimation.setOnClickListener(this);

        //使用程序设置动画属性
        alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(1000);

        //使用xml设置动画属性
        translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(MainActivity.this,R.anim.animation_translate);

        /**
         *  使用程序设置属性，关键是那两个属性pivotXValue，意思是中心轴的x轴
         *      这里Animation.RELATIVE_TO_SELF的意思是相对于自己，后面的0.5说明以自己高度的一般作为x轴
         *      当然还有一个参数是相对于父控件的，这里就不介绍了
         */
        scaleAnimation = new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(2000);

        //这里还是设置scaleAnimation的属性，不过是通过xml来设置的
        //主要是想说明在xml中可以用50%来表示上面Animation.RELATIVE_TO_SELF,0.5f的意思
        scaleAnimation_2 = (ScaleAnimation) AnimationUtils.loadAnimation(MainActivity.this,R.anim.animation_scale);

        /**
         * 使用AnimationSet的一个需要注意，那就是动画补间
         *
         */
        animationSet = new AnimationSet(true);
        animationSet.setDuration(2000);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);

        //注意在xml中不要漏了shareInterpolator这个动画补间的属性
        animationSet_2 = (AnimationSet) AnimationUtils.loadAnimation(MainActivity.this,R.anim.animation_set);

        myAnimation = new MyAnimation();
        myAnimation.setDuration(1000);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_alpha:

                myRectangle.startAnimation(alphaAnimation);
                break;
            case R.id.btn_translate:
                myRectangle.startAnimation(translateAnimation);

                break;
            case R.id.btn_scale:
                myRectangle.startAnimation(scaleAnimation);

                break;
            case R.id.btn_scale_2:
                myRectangle.startAnimation(scaleAnimation_2);

                break;
            case R.id.btn_animationset:
                myRectangle.startAnimation(animationSet);

                break;
            case R.id.btn_animationset_2:
                myRectangle.startAnimation(animationSet_2);

                break;
            case R.id.btn_custom:
                myRectangle.startAnimation(myAnimation);

                break;
        }
    }
}
