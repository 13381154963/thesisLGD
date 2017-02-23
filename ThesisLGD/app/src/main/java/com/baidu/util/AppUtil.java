package com.baidu.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2017/2/16.
 */

public class AppUtil {
    public static void navegrteTo(Activity from, Class<?> target, Bundle bundle){
        if(from==null || target==null){
            return;
        }
        Intent intent=new Intent();
        if(bundle != null){
            intent.putExtras(bundle);
        }
        if(Activity.class.isAssignableFrom(target)){
            intent.setClass(from,target);
        }else{
            return;
        }
        from.startActivity(intent);
        from.finish();
    }
}
