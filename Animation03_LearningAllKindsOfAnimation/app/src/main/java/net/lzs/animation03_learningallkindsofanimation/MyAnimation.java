package net.lzs.animation03_learningallkindsofanimation;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by LEE on 2015/6/22.
 */
public class MyAnimation extends Animation {

    /**
     * 通过该方法来获取当前控件的长度和宽度
     * @param width
     * @param height
     * @param parentWidth
     * @param parentHeight
     */
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    /**
     *
     * @param interpolatedTime 整个动画的执行时间百分比，从0.0到1.0
     *                         可以用该参数做很多渐变的事情
     *                         比如：利用该参数就能实现AlphaAnimation的效果了
     *
     * @param t 通过该参数来设置动画效果
     *          注意设置透明度效果用t来设置，
     *          但是其他的变化（如旋转缩放等）需要通过t.getMatrix()来进行设置
     */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);


        t.setAlpha(interpolatedTime);

//        t.getMatrix().setTranslate(200*interpolatedTime,200*interpolatedTime);

        //利用正弦函数来实现周期变化运动
        t.getMatrix().setTranslate((float) (Math.sin(interpolatedTime * 30) * 20),0);

    }
}
