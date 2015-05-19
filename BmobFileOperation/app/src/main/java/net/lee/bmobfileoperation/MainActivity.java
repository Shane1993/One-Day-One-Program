package net.lee.bmobfileoperation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

import cn.bmob.v3.AsyncCustomEndpoints;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.CloudCodeListener;
import cn.bmob.v3.listener.GetListener;

public class MainActivity extends Activity {

    Button uploadBtn,downloadBtn,thumbnailBtn;
    ImageView iconImageView;

    //BmobӦ��ID
    private String Bmob_AppId = "1b31c55348aeab1a15e5263e668fb88a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This is about Bmob
        Bmob.initialize(MainActivity.this,Bmob_AppId);

        uploadBtn = (Button) findViewById(R.id.uploadFileBtn);
        downloadBtn = (Button) findViewById(R.id.downloadFileBtn);
        thumbnailBtn = (Button) findViewById(R.id.loadThumbnailBtn);
        iconImageView = (ImageView) findViewById(R.id.iconImageView);

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,AtyUpload.class);
                startActivity(intent);

            }
        });

        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRequestCloudCode("LZS");
            }
        });

        thumbnailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onRequestCloudCodeThumbnail("LZS");
            }
        });

    }

    private void onRequestCloudCode(String name) {

        // cloudCodeName��Ӧ��ոմ������ƶ˴�������
        String cloudCodeName = "testFile";
        JSONObject params = new JSONObject();
        try {

            params.put("action","getObjectId");
            params.put("name",name);


        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // �����ƶ˴������
        AsyncCustomEndpoints cloudCode = new AsyncCustomEndpoints();

        // �첽�����ƶ˴���
        cloudCode.callEndpoint(MainActivity.this, cloudCodeName, params,
                new CloudCodeListener() {

                    @Override
                    public void onSuccess(Object result) {
                        // TODO Auto-generated method stub

                        System.out.println(result.toString());

                        try {
                            JSONObject jsonObject = new JSONObject(result.toString());
                            int status = jsonObject.getInt("status");
                            if (status == 1) {
                                String objectId = jsonObject.getString("objectId");

                                //��ȡICON
                                BmobQuery<TestModel> query = new BmobQuery<TestModel>();
                                query.getObject(MainActivity.this, objectId, new GetListener<TestModel>() {
                                    @Override
                                    public void onSuccess(TestModel testModel) {
                                        //��ȡ��BmobFile
                                        BmobFile icon = testModel.getIcon();
//                                        //��ȡUrl
//                                        String url = icon.getFileUrl(MainActivity.this);
                                        //��ͼƬ���ص�ָ����ImageView
                                        icon.loadImage(MainActivity.this, iconImageView);
                                    }

                                    @Override
                                    public void onFailure(int i, String s) {

                                    }
                                });

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(int i, String s) {

                        System.out.println(s);
                    }

                });
    }

    private void onRequestCloudCodeThumbnail(String name) {

        // cloudCodeName��Ӧ��ոմ������ƶ˴�������
        String cloudCodeName = "testFile";
        JSONObject params = new JSONObject();
        try {

            params.put("action","getObjectId");
            params.put("name",name);


        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // �����ƶ˴������
        AsyncCustomEndpoints cloudCode = new AsyncCustomEndpoints();

        // �첽�����ƶ˴���
        cloudCode.callEndpoint(MainActivity.this, cloudCodeName, params,
                new CloudCodeListener() {

                    @Override
                    public void onSuccess(Object result) {
                        // TODO Auto-generated method stub

                        System.out.println(result.toString());

                        try {
                            JSONObject jsonObject = new JSONObject(result.toString());
                            int status = jsonObject.getInt("status");
                            if(status == 1)
                            {
                                String objectId = jsonObject.getString("objectId");

                                //��ȡICON
                                BmobQuery<TestModel> query = new BmobQuery<TestModel>();
                                query.getObject(MainActivity.this, objectId, new GetListener<TestModel>() {
                                    @Override
                                    public void onSuccess(TestModel testModel) {
                                        //��ȡ��BmobFile
                                        BmobFile icon = testModel.getIcon();
//                                        //��ȡUrl
//                                        String url = icon.getFileUrl(MainActivity.this);
                                        //��ͼƬ���ص�ָ����ImageView
                                        icon.loadImageThumbnail(MainActivity.this,iconImageView,100,100,100);
                                    }

                                    @Override
                                    public void onFailure(int i, String s) {

                                    }
                                });

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(int i, String s) {

                        System.out.println(s);
                    }

                });
    }

}