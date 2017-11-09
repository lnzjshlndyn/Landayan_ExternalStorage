package com.landayan.landayan_externalstorage;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText et_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_data = (EditText) findViewById(R.id.et_data);
    }
    //internalcache
    public void InternalCache(View view){
        File folder = getCacheDir();
        File file = new File(folder, "internalcache.txt");
        String data = et_data.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(data.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Successfully saved in Internal Cache.", Toast.LENGTH_LONG).show();
    }

    //externalcache
    public void ExternalCache(View view){
        File folder = getExternalCacheDir();
        File file = new File(folder, "externalcache.txt");
        String data = et_data.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(data.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Successfully saved in External Cache.", Toast.LENGTH_LONG).show();
    }

    //externalstorage
    public void ExternalStorage(View view){
        File folder = getExternalFilesDir("Temp");
        File file = new File(folder, "externalstorage.txt");
        String data = et_data.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(data.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Successfully saved in External Storage.", Toast.LENGTH_LONG).show();
    }


    //externalstorage
    public void ExtPublicStorage(View view){
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(folder, "extpublicstorage.txt");
        String data = et_data.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(data.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Successfully saved in External Public Storage.", Toast.LENGTH_LONG).show();
    }

    //next
    public void Next(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        finish();
    }

}
