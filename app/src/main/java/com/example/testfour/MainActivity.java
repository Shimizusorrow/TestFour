package com.example.testfour;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences=getSharedPreferences("data",MODE_PRIVATE);
        editor=getSharedPreferences("data",MODE_PRIVATE).edit();
//        editor.clear();
//        editor.apply();
        if(!preferences.getBoolean("isChecked",false)){
            editor.putBoolean("isChecked",true);
            editor.apply();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(MainActivity.this,LogoinActivity.class));
                    finish();
                }
            },5000);
        }else {
            startActivity(new Intent(MainActivity.this,LogoinActivity.class));
            finish();
        }
    }
}
