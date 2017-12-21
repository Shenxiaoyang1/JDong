package com.example.jdong.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jdong.R;
import com.example.jdong.presenter.LoginPresenter;
import com.example.jdong.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView{
    private TextView tv_zhuce;
    private EditText et_name,et_password;
    private Button bt_login;
    private LoginPresenter loginPresenter;
    private String mobile,pass;
    private ImageView iv_exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        iv_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        tv_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegActivity.class);
                startActivity(intent);
            }
        });
        loginPresenter=new LoginPresenter(this);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobile = et_name.getText().toString();
                pass = et_password.getText().toString();
                loginPresenter.getLoginBean(mobile,pass);
            }
        });
    }

    private void init() {
        tv_zhuce = (TextView) findViewById(R.id.tv_zhuce);
        iv_exit = (ImageView) findViewById(R.id.iv_exit);
        bt_login = (Button) findViewById(R.id.bt_login);
        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
    }

    @Override
    public void show(String code, String msg) {
        if (code.equals("0")){
            Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
            if (msg.equals("登录成功")){
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }else {
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
            et_name.setText("");
            et_password.setText("");
        }
    }
}
