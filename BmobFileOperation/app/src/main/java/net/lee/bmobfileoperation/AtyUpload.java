package net.lee.bmobfileoperation;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UploadFileListener;

/**
 * Created by LEE on 2015/5/19.
 */
public class AtyUpload extends Activity {

    private static final int RESULT_LOAD_IMAGE = 1;
    ImageView imageView;
    Button selectBtn, uploadBtn;

    String picturePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploadpic);

        imageView = (ImageView) findViewById(R.id.imageView);
        selectBtn = (Button) findViewById(R.id.selectPicBtn);
        uploadBtn = (Button) findViewById(R.id.upload);

        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,RESULT_LOAD_IMAGE);

            }
        });

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(picturePath != null)
                {
                    //Send the file to server
                    final BmobFile file = new BmobFile(new File(picturePath));

                    file.upload(AtyUpload.this, new UploadFileListener() {
                        @Override
                        public void onSuccess() {
                            //Set as an attribute of TestModel
                            TestModel model = new TestModel();
                            model.setName("LZS");
                            model.setAge(21);
                            model.setIcon(file);

                            model.save(AtyUpload.this, new SaveListener() {
                                @Override
                                public void onSuccess() {
                                    System.out.println("Success");
                                    finish();
                                }

                                @Override
                                public void onFailure(int i, String s) {

                                }
                            });
                        }

                        @Override
                        public void onFailure(int i, String s) {

                        }
                    });
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null)
        {
            Uri selectedImage = data.getData();

            Cursor cursor = getContentResolver().query(selectedImage,
                    null, null, null, null);
            if(cursor.moveToFirst()) {
                picturePath = cursor.getString(cursor.getColumnIndex("_data"));
                cursor.close();

                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            }
        }
    }
}
