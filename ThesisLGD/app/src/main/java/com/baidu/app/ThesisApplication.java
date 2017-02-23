package com.baidu.app;

import android.app.Application;

import cn.bmob.v3.Bmob;
import cn.smssdk.SMSSDK;

/**
 * Created by Administrator on 2017/2/16.
 */

public class ThesisApplication extends Application {
    public boolean isTeed=false;
    public static ThesisApplication thesisApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        thesisApplication=this;
        isTeed=true;
        SMSSDK.initSDK(this,"1b8796b8f16f8","1c2f65544400e8456eac8881515fb5f9");
        Bmob.initialize(this, "1ca9acffc8b7e39db19e88fbe76c657c");
    }
    public boolean getIsTeed(){
        return isTeed;
    }
    public static ThesisApplication getInstance(){
        return thesisApplication;
    }
}
