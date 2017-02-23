package com.baidu.thesislgd.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.baidu.thesislgd.R;
import com.baidu.util.AppUtil;

public class LoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
    }
    public void onLoadRegist(View view){
        AppUtil.navegrteTo(LoadActivity.this,RegistActivity.class,null);
    }
}
