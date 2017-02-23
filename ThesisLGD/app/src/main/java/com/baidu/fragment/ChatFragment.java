package com.baidu.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baidu.thesislgd.R;

public class ChatFragment extends BaseFragment {

    ImageView iv_actionbar_left;
    ImageView iv_actionbar_right;
    public ChatFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        contentView = inflater.inflate(R.layout.fragment_chat, container, false);
        initUI();
        return contentView;
    }

      //初始化头部件
    private void initUI() {
        actionBar = (LinearLayout) contentView.findViewById(R.id.include_actionbar);
        drawTopView(R.drawable.favo , "会话~" , R.drawable.ic_add);
        iv_actionbar_left = (ImageView) contentView.findViewById(R.id.iv_actionbar_left);
        iv_actionbar_right = (ImageView) contentView.findViewById(R.id.iv_actionbar_right);
        iv_actionbar_right.setColorFilter(Color.WHITE);
        iv_actionbar_left.setColorFilter(Color.WHITE);
    }
}
