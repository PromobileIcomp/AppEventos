package com.example.appeventosteste.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.appeventosteste.beans.Item;

public class ListViewAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<Item> arrayItens;
	
	
	public ListViewAdapter(Context context, ArrayList<Item> arrayItens){
		this.context = context;
		this.arrayItens = arrayItens;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrayItens.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return arrayItens.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = arrayItens.get(position).getLayout(context, parent); 
		return view;
	}

}
