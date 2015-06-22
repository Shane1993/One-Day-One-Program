package net.lzs.animation03_learningallkindsofanimation;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by LEE on 2015/6/22.
 */
public class MyAnimation extends Animation {

    /**
     * ͨ���÷�������ȡ��ǰ�ؼ��ĳ��ȺͿ��
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
     * @param interpolatedTime ����������ִ��ʱ��ٷֱȣ���0.0��1.0
     *                         �����øò������ܶཥ�������
     *                         ���磺���øò�������ʵ��AlphaAnimation��Ч����
     *
     * @param t ͨ���ò��������ö���Ч��
     *          ע������͸����Ч����t�����ã�
     *          ���������ı仯������ת���ŵȣ���Ҫͨ��t.getMatrix()����������
     */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);


        t.setAlpha(interpolatedTime);

//        t.getMatrix().setTranslate(200*interpolatedTime,200*interpolatedTime);

        //�������Һ�����ʵ�����ڱ仯�˶�
        t.getMatrix().setTranslate((float) (Math.sin(interpolatedTime * 30) * 20),0);

    }
}
