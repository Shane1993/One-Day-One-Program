package net.lee.tab02_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class MainActivity extends FragmentActivity implements View.OnClickListener {

    //�ײ��ĸ��ؼ��Ĳ���
    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    private ImageButton mImgWeixin;
    private ImageButton mImgFrd;
    private ImageButton mImgAddress;
    private ImageButton mImgSetting;

    //Fragment
    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;
    private Fragment mTab04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
        setSelect(0);
    }

    private void initView() {

        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_setting);

        mImgWeixin = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mImgFrd = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mImgAddress = (ImageButton) findViewById(R.id.id_tab_address_img);
        mImgSetting = (ImageButton) findViewById(R.id.id_tab_setting_img);

    }


    private void initEvent() {

        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.id_tab_weixin:
                setSelect(0);
                break;
            case R.id.id_tab_frd:
                setSelect(1);
                break;
            case R.id.id_tab_address:
                setSelect(2);
                break;
            case R.id.id_tab_setting:
                setSelect(3);
                break;
            default:
                break;
        }
    }

    /**
     * ��ͼƬ����Ϊ����
     * ������������
     * @param i
     */
    private void setSelect(int i) {

        //������ͼƬ�䰵
        resetImg();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //�������е�Fragment
        hideFragment(fragmentTransaction);

        switch (i) {
            case 0:
                //��ѡ�е�ͼƬ��ɫ
                mImgWeixin.setImageResource(R.drawable.tab_weixin_pressed);
                //ת������Ӧ�Ľ���
                if (mTab01 == null)
                {
                    mTab01 = new WeixinFragment();
                    System.out.println("This is 0");
                    fragmentTransaction.add(R.id.id_content,mTab01);
                }else
                {
                    fragmentTransaction.show(mTab01);
                }

                break;
            case 1:
                mImgFrd.setImageResource(R.drawable.tab_find_frd_pressed);
                if (mTab02 == null)
                {
                    mTab02 = new FriendFragment();
                    fragmentTransaction.add(R.id.id_content,mTab02);

                }else
                {
                    fragmentTransaction.show(mTab02);
                }
                break;
            case 2:
                mImgAddress.setImageResource(R.drawable.tab_address_pressed);
                if (mTab03 == null)
                {
                    mTab03 = new AddressFragment();
                    fragmentTransaction.add(R.id.id_content,mTab03);

                }else
                {
                    fragmentTransaction.show(mTab03);
                }
                break;
            case 3:
                mImgSetting.setImageResource(R.drawable.tab_setting_pressed);
                if (mTab04 == null)
                {
                    mTab04 = new SettingFragment();
                }else
                {
                    fragmentTransaction.show(mTab04);
                    fragmentTransaction.add(R.id.id_content, mTab04);
                }
                break;
            default:
                break;
        }

        //��Ҫ�����ύtransaction
        fragmentTransaction.commit();
    }


    /**
     * �����е�ͼƬ�л�����ɫ
     */
    private void resetImg() {
        mImgWeixin.setImageResource(R.drawable.tab_weixin_normal);
        mImgFrd.setImageResource(R.drawable.tab_find_frd_normal);
        mImgAddress.setImageResource(R.drawable.tab_address_normal);
        mImgSetting.setImageResource(R.drawable.tab_setting_normal);

    }

    private void hideFragment(FragmentTransaction fragmentTransaction) {

        if (mTab01 != null)
        {
            fragmentTransaction.hide(mTab01);
        }
        if (mTab02 != null)
        {
            fragmentTransaction.hide(mTab02);
        }
        if (mTab03 != null)
        {
            fragmentTransaction.hide(mTab03);
        }
        if (mTab04 != null)
        {
            fragmentTransaction.hide(mTab04);
        }
    }
}
