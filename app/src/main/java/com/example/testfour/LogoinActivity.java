package com.example.testfour;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LogoinActivity extends AppCompatActivity {
    private EditText userLogin,psdLogin;
    private Button btn;
    private CheckBox autoLogin,rmbLogin;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logoin);
        init();
        if(preferences.getBoolean("isCheckedRmbLogin",false)){
            rmbLogin.setChecked(true);
            userLogin.setText(preferences.getString("user",""));
            psdLogin.setText(preferences.getString("psd",""));
        }
        if (preferences.getBoolean("isCheckedAutoLogin",false)){
            if(userLogin.getText().toString().equals("admin")&&psdLogin.getText().toString().equals("admin")){
                startActivity(new Intent(LogoinActivity.this,FragmentActivity.class));
                finish();
            }
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final String user=userLogin.getText().toString(),psd=psdLogin.getText().toString();
                if(user.equals("admin")&&psd.equals("admin")){
                    if(rmbLogin.isChecked()){
                        editor.putBoolean("isCheckedRmbLogin",true);
                        editor.putString("user",user);
                        editor.putString("psd",psd);
                        editor.apply();
                    }else {
                        editor.clear();
                    }
                    if(autoLogin.isChecked()){
                        editor.putBoolean("isCheckedAutoLogin",true);
                        editor.apply();
                    }
                    startActivity(new Intent(LogoinActivity.this,FragmentActivity.class));
                    finish();
                }else {
                    Toast.makeText(LogoinActivity.this,"用户名或者密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void init(){
        userLogin=(EditText) findViewById(R.id.user);
        psdLogin=(EditText) findViewById(R.id.password);
        btn=(Button) findViewById(R.id.login);
        autoLogin=(CheckBox) findViewById(R.id.auto);
        rmbLogin=(CheckBox) findViewById(R.id.rmb);
        preferences=getSharedPreferences("data",MODE_PRIVATE);
        editor=getSharedPreferences("data",MODE_PRIVATE).edit();
    }

}
