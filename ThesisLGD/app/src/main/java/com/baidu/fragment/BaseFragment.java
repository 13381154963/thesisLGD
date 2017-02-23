package com.baidu.fragment;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.thesislgd.R;

/**
 * Created by Administrator on 2017/2/16.
 */

public abstract class BaseFragment extends Fragment {

    public View contentView = null;
    public LinearLayout actionBar;

    protected void drawTopView(int leftId, String title, int rightId){

        if(actionBar == null){
            return;
        }
        ImageView iv_left = (ImageView) actionBar.findViewById(R.id.iv_actionbar_left);
        TextView tv_title = (TextView) actionBar.findViewById(R.id.tv_actionbar_title);
        ImageView iv_right = (ImageView) actionBar.findViewById(R.id.iv_actionbar_right);

        if(leftId == -1){
            iv_left.setVisibility(View.INVISIBLE);
        }else{
            iv_left.setVisibility(View.VISIBLE);
        }

        if(TextUtils.isEmpty(title)){
            title = String.valueOf(R.string.totle_name);
        }

        if(rightId == -1){
            iv_right.setVisibility(View.INVISIBLE);
        }else{
            iv_right.setVisibility(View.VISIBLE);
        }
    }

}
