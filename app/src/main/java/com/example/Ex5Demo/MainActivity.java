package com.example.Ex5Demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button loginbtn;
    EditText name;
    EditText pwd;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginbtn =findViewById(R.id.btn_login);
        name =findViewById(R.id.account_input);
        pwd =findViewById(R.id.password_input);

        sp = getSharedPreferences("setting", Context.MODE_PRIVATE);
        String n = sp.getString("name",null);
        String pwd= sp.getString("password",null);
        name.setText(n);
        this.pwd.setText(pwd);
        loginbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_login :
            /**完成代码***/
            String account= name.getText().toString();
            String password= pwd.getText().toString();
            if ( account.isEmpty()|| password.isEmpty()){
                Toast.makeText(this, "输入为空", Toast.LENGTH_SHORT).show();
                return;
            }
                //获取SharePreference对象的编辑对象，才能进行数据的存储
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name",account).commit();
                editor.putString("password",password).commit();
                Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

    }
}
