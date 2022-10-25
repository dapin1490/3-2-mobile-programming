package com.example.week08midtest221025;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
	Context maincon;
	LayoutInflater Inflater;
	List<MyItem> arSrc;

	public MyAdapter(Context context, List<MyItem> aarSrc) {
		maincon = context;
		Inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		arSrc = aarSrc;
	}

	public int getCount() {
		return arSrc.size();
	}

	public String getItem(int position) {
		return arSrc.get(position).name;
	}

	public long getItemId(int position) {
		return position;
	}

	// 각 항목의 뷰 생성
	public View getView(int position, View convertView, ViewGroup parent) {
		final int pos = position;
		if (convertView == null) {
			convertView = Inflater.inflate(R.layout.row, parent, false);
		}

		TextView name = (TextView) convertView.findViewById(R.id.name);
		name.setText(arSrc.get(position).name);

		TextView phone = (TextView) convertView.findViewById(R.id.phone);
		phone.setText(arSrc.get(position).phone);

		TextView email = (TextView) convertView.findViewById(R.id.email);
		email.setText(arSrc.get(position).email);

		return convertView;
	}
}
