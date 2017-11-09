package com.landayan.landayan_externalstorage;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static android.R.attr.data;

public class SecondActivity extends AppCompatActivity {

    TextView tv_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv_display = (TextView) findViewById(R.id.tv_display);
    }

    public void getInternalCache(View view){
        StringBuffer buffer = new StringBuffer();
        File dir = getCacheDir();
        int read = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(getCacheDir(), "internalcache.txt"));
            while((read = fis.read()) != -1){
                buffer.append((char)read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv_display.setText(buffer.toString());
    }

    public void getExternalCache(View view){
        StringBuffer buffer = new StringBuffer();
        File dir = getExternalCacheDir();
        int read = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(getExternalCacheDir(), "externalcache.txt"));
            while((read = fis.read()) != -1){
                buffer.append((char)read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv_display.setText(buffer.toString());
    }

    public void getExternalStorage(View view){
        StringBuffer buffer = new StringBuffer();
        File dir = getExternalFilesDir("Temp");
        int read = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(getExternalFilesDir("Temp"), "externalstorage.txt"));
            while((read = fis.read()) != -1){
                buffer.append((char)read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv_display.setText(buffer.toString());
    }

    public void getExtPublicStorage(View view){
        StringBuffer buffer = new StringBuffer();
        File dir = getExternalFilesDir("Temp");
        int read = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "extpublicstorage.txt"));
            while((read = fis.read()) != -1){
                buffer.append((char)read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv_display.setText(buffer.toString());
    }

    public void Back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
