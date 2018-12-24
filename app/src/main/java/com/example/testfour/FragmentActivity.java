package com.example.testfour;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentActivity extends AppCompatActivity {
    private Button cancleRmb,cancleAuto;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        init();
        cancleRmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("isCheckedRmbLogin",false);
                editor.apply();
            }
        });
        cancleAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("isCheckedAutoLogin",false);
                editor.apply();
            }
        });
    }
    public void init(){
        cancleAuto=(Button) findViewById(R.id.cancleAuto);
        cancleRmb=(Button) findViewById(R.id.cancleRmb);
        editor=getSharedPreferences("data",MODE_PRIVATE).edit();
    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,fragment);
        fragmentTransaction.commit();
    }
}
