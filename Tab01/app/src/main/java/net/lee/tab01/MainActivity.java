package net.lee.tab01;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener{

    private ViewPager mViewPager;

    private PagerAdapter mAdapter;
    private List<View> mView = new ArrayList<View>();

    //Tab
    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    //ImageButton
    private ImageButton mWeixinImg;
    private ImageButton mFrdImg;
    private ImageButton mAddressImg;
    private ImageButton mSettingImg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();

        //��ʼ���¼������ӵ��Ч����
        initEvent();


    }

    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_setting);

        mWeixinImg = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mFrdImg = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mAddressImg = (ImageButton) findViewById(R.id.id_tab_address_img);
        mSettingImg = (ImageButton) findViewById(R.id.id_tab_setting_img);

        LayoutInflater mInflater = LayoutInflater.from(this);
        View tab01 = mInflater.inflate(R.layout.tab01, null);
        View tab02 = mInflater.inflate(R.layout.tab02, null);
        View tab03 = mInflater.inflate(R.layout.tab03, null);
        View tab04 = mInflater.inflate(R.layout.tab04,null);

        //�����������ļ���ӵ�����Դ
        mView.add(tab01);
        mView.add(tab02);
        mView.add(tab03);
        mView.add(tab04);

        mAdapter = new PagerAdapter() {

            /**
             * ��ȡ����Դ�����ݵ�����
             * @return
             */
            @Override
            public int getCount() {
                return mView.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            /**
             * �ݻ���
             * @param container
             * @param position
             * @param object
             */
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {

               container.removeView( mView.get(position));

            }

            /**
             * ��ʼ����
             * @param container
             * @param position
             * @return
             */
            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                View view = mView.get(position);
                container.addView(view);

                return view;
            }
        };
        mViewPager.setAdapter(mAdapter);
        /**
         * ���Կ���adapter�Ĺ������̶���һ����
         * ���ǻ�ȡ����Դ
         * Ȼ������Դ��adapter�����
         * ��󽫿ؼ�����adapter
         */

    }

    private void initEvent() {

        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);

        //����pager�仯ʱ�Ĳ���������ı����ImageView����ɫ��
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                int currentItem = mViewPager.getCurrentItem();
                resetImg();

                switch (currentItem)
                {
                    case 0:
                        mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
                        break;
                    case 1:
                        mFrdImg.setImageResource(R.drawable.tab_find_frd_pressed);
                        break;
                    case 2:
                        mAddressImg.setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 3:
                        mSettingImg.setImageResource(R.drawable.tab_setting_pressed);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onClick(View v) {

        resetImg();

        switch (v.getId())
        {
            case R.id.id_tab_weixin:
                mViewPager.setCurrentItem(0);
                mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case R.id.id_tab_frd:
                mViewPager.setCurrentItem(1);
                mFrdImg.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case R.id.id_tab_address:
                mViewPager.setCurrentItem(2);
                mAddressImg.setImageResource(R.drawable.tab_address_pressed);
                break;
            case R.id.id_tab_setting:
                mViewPager.setCurrentItem(3);
                mSettingImg.setImageResource(R.drawable.tab_setting_pressed);
                break;
        }
    }

    /**
     * �����е�ͼƬ�л�����ɫ
     */
    private void resetImg() {
        mWeixinImg.setImageResource(R.drawable.tab_weixin_normal);
        mFrdImg.setImageResource(R.drawable.tab_find_frd_normal);
        mAddressImg.setImageResource(R.drawable.tab_address_normal);
        mSettingImg.setImageResource(R.drawable.tab_setting_normal);

    }
}
