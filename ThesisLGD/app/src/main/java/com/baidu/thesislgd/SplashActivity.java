package com.baidu.thesislgd;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.baidu.app.ThesisApplication;
import com.baidu.thesislgd.login.LoadActivity;
import com.baidu.util.AppUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        int waittime= ThesisApplication.getInstance().getIsTeed() ? 0:1000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AppUtil.navegrteTo(SplashActivity.this,LoadActivity.class,null);
            }
        },waittime);
    }
}
