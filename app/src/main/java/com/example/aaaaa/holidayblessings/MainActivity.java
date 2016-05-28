package com.example.aaaaa.holidayblessings;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {
    //初始化ImageView
    private ImageView mPhoto;
    private EditText mword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPhoto= (ImageView) findViewById(R.id.photo);
        mPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击打开图册
                Intent intent=new Intent(Intent.ACTION_PICK,null);
                //获取手机图册信息
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                startActivityForResult(intent,100);


            }
        });
        mword= (EditText) findViewById(R.id.word);
        //替换字体
        mword.setTypeface(Typeface.createFromAsset(getAssets(),"assets/test.ttf"));
    }
//取得图片
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==RESULT_OK && requestCode==100){
            if (data!=null){
                mPhoto.setImageURI(data.getData());
            }
        }
    }
}
