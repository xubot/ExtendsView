package com.example.administrator.extendsview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * 用途：
 * 作者：xuBoTao
 * 时间：2017/4/7 15:05
 */

public class CustomListViewAdapter extends ArrayAdapter<String> {

    public CustomListViewAdapter(Context context, int textViewResourceId, List<String> objects) {
        super(context, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.custom_listview_item, null);
        } else {
            view = convertView;
        }

        TextView contentTv = (TextView) view.findViewById(R.id.content_tv);
        contentTv.setText(getItem(position));

        return view;
    }

}
