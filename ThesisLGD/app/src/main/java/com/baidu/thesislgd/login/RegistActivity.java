package com.baidu.thesislgd.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.baidu.thesislgd.R;
import com.baidu.thesislgd.login.bean.Student;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.smssdk.EventHandler;
import cn.smssdk.OnSendMessageHandler;
import cn.smssdk.SMSSDK;

public class RegistActivity extends AppCompatActivity {

    EditText edit_username;
    EditText edit_yanzhengma;
    EditText edit_password;
    Button bt_regist;
    Button bt_getyanzhengma;
    String username;//用户名
    String yanzhengma;//验证码
    String passsword;//密码
    EventHandler eh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigst);
        initUI();
    }

    private void initUI() {
        edit_username = (EditText) findViewById(R.id.edit_regist_username);
        edit_yanzhengma = (EditText) findViewById(R.id.edit_regist_yanzheng);
        edit_password = (EditText) findViewById(R.id.edit_regist_password);


    }
    public void getYanzhengma(View view){
        username = edit_username.getText().toString();
        SMSSDK.getVerificationCode("86", username, new OnSendMessageHandler() {
            @Override
            public boolean onSendMessage(String s, String s1) {
                Log.d("sendRAG",s+s1);
                Toast.makeText(RegistActivity.this,"发送验证码",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
    public void onRegist(View view){
        yanzhengma = edit_yanzhengma.getText().toString();
        passsword = edit_password.getText().toString();
        SMSSDK.submitVerificationCode("86", username , yanzhengma);
        eh=new EventHandler(){
            @Override
            public void afterEvent(int event, int result, Object data) {

                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        //提交验证码成功
                        Log.d("TAG",username+yanzhengma+passsword);
                    }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                        //获取验证码成功
                        Log.d("TAG","hhh"+username+yanzhengma+passsword);
                    }else if (event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){
                        //返回支持发送验证码的国家列表
                    }
                }else{
                    ((Throwable)data).printStackTrace();
                }
            }
        };
        SMSSDK.registerEventHandler(eh);

        Student student=new Student();
        student.setUsername(username);
        student.setPassword(passsword);
        student.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(null == e){
                    Log.d("TAG","注册成功");
                }else{
                    Log.d("TAG","失败"+e.getMessage());
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SMSSDK.unregisterEventHandler(eh);
    }
}
