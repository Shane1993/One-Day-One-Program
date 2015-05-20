package net.lee.bmobfileoperation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.InputStream;

import cn.bmob.v3.AsyncCustomEndpoints;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.CloudCodeListener;
import cn.bmob.v3.listener.GetListener;

public class MainActivity extends Activity {

    Button uploadBtn,downloadBtn,thumbnailBtn;
    Button saveBtn,getFileBtn;
    ImageView iconImageView;

    //Bmob应用ID
    private String Bmob_AppId = "1b31c55348aeab1a15e5263e668fb88a";

    String url = "";

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

        saveBtn = (Button) findViewById(R.id.saveFileBtn);
        getFileBtn = (Button) findViewById(R.id.getFileBtn);

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

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        FileUtils fileUtils = new FileUtils();
                        System.out.println(fileUtils.downFile(url, "BmobFile", "LZSIcon.jpg"));
                    }
                };
                new Thread(runnable).start();

            }
        });

        getFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileUtils fileUtils = new FileUtils();
                File file = fileUtils.getFile("BmobFile", "LZSIcon.jpg");
                System.out.println("Name : " + file.getName() +"  ,Path:"+ file.getAbsolutePath());

                iconImageView.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
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

        // cloudCodeName对应你刚刚创建的云端代码名称
        String cloudCodeName = "testFile";
        JSONObject params = new JSONObject();
        try {

            params.put("action","getObjectId");
            params.put("name",name);


        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 创建云端代码对象
        AsyncCustomEndpoints cloudCode = new AsyncCustomEndpoints();

        // 异步调用云端代码
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

                                //获取ICON
                                BmobQuery<TestModel> query = new BmobQuery<TestModel>();
                                query.getObject(MainActivity.this, objectId, new GetListener<TestModel>() {
                                    @Override
                                    public void onSuccess(TestModel testModel) {
                                        //获取到BmobFile
                                        BmobFile icon = testModel.getIcon();
//                                        //获取Url
                                        url = icon.getFileUrl(MainActivity.this);
                                        System.out.println("url------>" + url);
                                        //将图片加载到指定的ImageView
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

        // cloudCodeName对应你刚刚创建的云端代码名称
        String cloudCodeName = "testFile";
        JSONObject params = new JSONObject();
        try {

            params.put("action","getObjectId");
            params.put("name",name);


        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 创建云端代码对象
        AsyncCustomEndpoints cloudCode = new AsyncCustomEndpoints();

        // 异步调用云端代码
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

                                //获取ICON
                                BmobQuery<TestModel> query = new BmobQuery<TestModel>();
                                query.getObject(MainActivity.this, objectId, new GetListener<TestModel>() {
                                    @Override
                                    public void onSuccess(TestModel testModel) {
                                        //获取到BmobFile
                                        BmobFile icon = testModel.getIcon();
//                                        //获取Url
//                                        String url = icon.getFileUrl(MainActivity.this);
                                        //将图片加载到指定的ImageView
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
