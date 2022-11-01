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
		phone.setText(arSrc.get(position).phone); // 수정 못해서 name으로 제출했음

		TextView email = (TextView) convertView.findViewById(R.id.email);
		email.setText(arSrc.get(position).email); // 수정 못해서 name으로 제출했음

		return convertView;
	}
}

/*
// 풀이

package com.example.week09lecture;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    // 코드 추가
	Context c;
	List<MyItem> a;

	public MyAdapter(Context c, List<MyItem> a) {
		this.c = c;
		this.a = a;
	}

	@Override
	public int getCount() {
		return a.size();
	}

	@Override
	public Object getItem(int position) {
		return a.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = View.inflate(c, R.layout.row, null);
		}
		TextView name = convertView.findViewById(R.id.name);
		name.setText(a.get(position).name);

		TextView phone = convertView.findViewById(R.id.phone);
		phone.setText(a.get(position).phone);

		TextView email = convertView.findViewById(R.id.email);
		email.setText(a.get(position).email);

		return convertView;
	}
}
*/