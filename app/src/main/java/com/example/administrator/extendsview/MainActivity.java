package com.example.administrator.extendsview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // 自定义Lv
    private CustomListView mCustomLv;
    // 自定义适配器
    private CustomListViewAdapter mAdapter;
    // 内容列表
    private List<String> contentList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initContentList();

        mCustomLv = (CustomListView) findViewById(R.id.custom_lv);
        mCustomLv.setOnDeleteListener(new CustomListView.OnDeleteListener() {

            @Override
            public void onDelete(int index) {
                contentList.remove(index);
                mAdapter.notifyDataSetChanged();
            }
        });

        mAdapter = new CustomListViewAdapter(this, 0, contentList);
        mCustomLv.setAdapter(mAdapter);
    }

    // 初始化内容列表
    private void initContentList() {
        for (int i = 0; i < 20; i++) {
            contentList.add("内容项" + i);
        }
    }

    @Override
    public void onBackPressed() {
        if (mCustomLv.isDeleteShown()) {
            mCustomLv.hideDelete();
            return;
        }
        super.onBackPressed();
    }
}
