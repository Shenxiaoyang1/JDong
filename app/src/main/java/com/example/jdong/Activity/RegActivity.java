package com.example.jdong.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jdong.R;
import com.example.jdong.presenter.RegPresenter;
import com.example.jdong.view.IRegView;

public class RegActivity extends AppCompatActivity implements IRegView{
    RegPresenter regPrensenter;
    private Button bt_zhuce;
    private EditText et_name,et_pass;
    private String mobile,pass;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        init();
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(RegActivity.this,LoginActivity.class);
                startActivity(it);
                finish();
            }
        });
        bt_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mobile = et_name.getText().toString();
                pass = et_pass.getText().toString();
                regPrensenter.getRegBean(mobile,pass);
            }
        });
    }

    private void init() {
        iv = (ImageView) findViewById(R.id.iv_exit);
        bt_zhuce = (Button) findViewById(R.id.bt_zhuce);
        et_name = (EditText) findViewById(R.id.et_name);
        et_pass = (EditText) findViewById(R.id.et_password);
    }

    @Override
    public void show(String data, String msg) {
        if (data.equals("0")){
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
            if (msg.equals("注册成功")){
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }else {
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
            et_name.setText("");
            et_pass.setText("");
        }
    }
}
