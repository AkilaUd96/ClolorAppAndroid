package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnTakeAPicture;
    private Button btnSaveThePicture;
    private ImageView imgPhoto;
    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;
    private TextView txtRedColourValue;
    private TextView txtGreenColourValue;
    private TextView txtBlueColourValue;

    private static final int CAMERA_IMAGE_REQUEST_CODE = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTakeAPicture = (Button) findViewById(R.id.btnTakeAPicture);
        btnSaveThePicture = (Button) findViewById(R.id.btnSaveThePicture);
        imgPhoto = (ImageView) findViewById(R.id.imgPhoto);
        redSeekBar = (SeekBar) findViewById(R.id.redColourSeekBar);
        greenSeekBar = (SeekBar) findViewById(R.id.greenColourSeekBar);
        blueSeekBar = (SeekBar) findViewById(R.id.blueColourSeekBar);
        txtRedColourValue = (TextView) findViewById(R.id.redColourValue);
        txtGreenColourValue = (TextView) findViewById(R.id.greenColourValue);
        txtBlueColourValue = (TextView) findViewById(R.id.blueColourValue);

        btnTakeAPicture.setOnClickListener(MainActivity.this);
        btnSaveThePicture.setOnClickListener(MainActivity.this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnTakeAPicture) {
            int permissionResult = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA);
            if (permissionResult == PackageManager.PERMISSION_GRANTED){

                PackageManager packageManager = getPackageManager();
                if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)){
                    Intent cameraintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraintent,CAMERA_IMAGE_REQUEST_CODE );


                }else{
                    Toast.makeText(MainActivity.this, "Your Device does not have a Camera", Toast.LENGTH_SHORT).show();
                }

            }else{
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.CAMERA},
                        1);
            }

        }else if (view.getId() == R.id.btnSaveThePicture){


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_IMAGE_REQUEST_CODE && resultCode == RESULT_OK){

        }
    }
}