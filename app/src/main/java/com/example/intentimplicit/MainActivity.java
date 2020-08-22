package com.example.intentimplicit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtName;
    Button btnName, btnImage;
    ImageView imgImage;
    int REQUEST_CODE_EDIT = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.txt_Name);
        btnName = findViewById(R.id.btn_Name);
        btnImage = findViewById(R.id.btn_Image);
        imgImage = findViewById(R.id.img_Image);
        /*//sendString
        sendTo();
        */
        takePhoto();
    }


    /*
    //sendString
    private void sendTo() {
        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Edit.class);
                startActivityForResult(intent, REQUEST_CODE_EDIT);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_EDIT && resultCode == RESULT_OK && data != null){
            String ten = data.getStringExtra("tenmoine");
            txtName.setText(ten);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    */
    //takePhotos
    private void takePhoto() {
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE_EDIT);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_EDIT && resultCode == RESULT_OK && data != null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data"); // key default
            imgImage.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    //takePhotos
}