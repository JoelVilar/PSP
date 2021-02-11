package com.example.musicplayer_jvg.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.musicplayer_jvg.R;
import com.example.musicplayer_jvg.resources.UrlValues;
import com.example.musicplayer_jvg.resources.Values;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.acl.Permission;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getName();
    private ImageView ourImg1;
    private ImageView ourImg2;
    private ImageView ourImg3;
    private ImageView[] imgList = new  ImageView[Values.NUM_OF_IMGS];
    private final AtomicInteger cont = new AtomicInteger(Values.CONT_INICIO);
    private int lastIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conectaConInterfaz();
    }

    protected void conectaConInterfaz(){

        Button btnSaveImg = (Button)findViewById(R.id.btnSave);
        btnSaveImg.setOnClickListener(v->{
            saveImg();
        });

        Button btnDown = (Button)findViewById(R.id.btnDownload);
        loadImgs();
        btnDown.setOnClickListener(v->{
            Toast.makeText(getApplicationContext(),getString(R.string.on_download), Toast.LENGTH_LONG).show();
            changeImg();
            btnDown.setClickable(false);
            btnSaveImg.setClickable(true);
        });

        Button btnAdd = (Button)findViewById(R.id.btnPermissions);
        btnAdd.setOnClickListener(v->{
            grantPermissions();
        });
    }

    protected  void loadImgs(){
        ourImg1 = (ImageView) findViewById(R.id.img);
        ourImg2 = (ImageView) findViewById(R.id.img2);
        ourImg3 = (ImageView) findViewById(R.id.img3);

        imgList[Values.FIRST_ON_ARRAY]=ourImg1;
        imgList[Values.SECOND_ON_ARRAY]=ourImg2;
        imgList[Values.THIRD_ON_ARRAY]=ourImg3;

        String[] uris = {UrlValues.GARY_MOORE,
                            UrlValues.PINK_FLOYD,
                            UrlValues.METALLICA
        };

        for (int x=Values.CONT_INICIO;x<imgList.length;x++){
            Picasso.get().load(uris[x]).placeholder(R.drawable.ic_launcher_background).into(imgList[x]);
        }
    }

    protected  void changeImg(){
        imgList[Values.CONT_INICIO].setVisibility(View.INVISIBLE);
        Timer cronometro = new Timer();
        Intent browseVideo=new Intent(Intent.ACTION_VIEW);
        String[] urlVideos={UrlValues.GARY_MOORE_SONG,
                UrlValues.PINK_FLOYD_SONG,
                UrlValues.METALLICA_SONG
        };
        TimerTask setImg = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    imgList[lastIndex].setVisibility(View.GONE);
                    imgList[cont.get()].setVisibility(View.VISIBLE);
                    imgList[cont.get()].setOnClickListener(v->{
                        browseVideo.setData(Uri.parse(urlVideos[lastIndex]));
                        startActivity(browseVideo);
                    });
                    lastIndex=cont.get();
                    if(cont.get()<Values.CONT_LIMIT)cont.getAndIncrement();
                        else cont.set(Values.CONT_INICIO);
                });
            }
        };
        cronometro.schedule(setImg,Values.TIME_DELAY_IMG,Values.TIME_BETWEEN_IMG);
    }

    public void grantPermissions(){
        if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String []{Manifest.permission.WRITE_EXTERNAL_STORAGE},Values.REQUEST_CODE);
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},Values.REQUEST_CODE);
        }else {
            Toast.makeText(getApplicationContext(),getString(R.string.permissions_already_granted),Toast.LENGTH_SHORT).show();
        }
    }

    public void saveImg(){
        BitmapDrawable drawable = (BitmapDrawable) imgList[lastIndex].getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        //imgList[lastIndex].buildDrawingCache();
        //Bitmap bitmap = imgList[lastIndex].getDrawingCache();
        File carpetaDescarga = new File(getString(R.string.folder_path));
        if(!carpetaDescarga.exists()) carpetaDescarga.mkdir();
        int fileSize=carpetaDescarga.list().length;
        String fileName = fileSize!=Values.EMPTY ? getString(R.string.img_name) + String.valueOf(fileSize) : getString(R.string.img_name);
        File newImg = new File(carpetaDescarga, fileName + getString(R.string.extension));
        OutputStream writer=null;
        try{
            writer = new FileOutputStream(newImg);
            bitmap.compress(Bitmap.CompressFormat.JPEG,Values.QUALITY,writer);
            Toast.makeText(getApplicationContext(),newImg.getName() + getString(R.string.save_ok), Toast.LENGTH_SHORT).show();
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            Log.d(TAG, e.getMessage());
        } catch (IOException e) {
            Log.d(TAG, e.getMessage());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}