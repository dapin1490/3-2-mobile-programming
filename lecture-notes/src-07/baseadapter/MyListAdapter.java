package com.example.baseadapterdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<MyItem> arrayList;

    public MyListAdapter(Context context, int layout, 
			ArrayList<MyItem> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i).name;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos = i;
        if (view == null)
            view = View.inflate(context, layout, null);

        ImageView img = view.findViewById(R.id.img);
        img.setImageResource(arrayList.get(pos).icon);

        TextView text = view.findViewById(R.id.text);
        text.setText(arrayList.get(pos).name);

        Button btn = view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = arrayList.get(pos).name + "를 주문합니다.";
                Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
