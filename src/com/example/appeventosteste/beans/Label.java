package com.example.appeventosteste.beans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appeventosteste.R;

public class Label extends Item {

	private String title;
	private String icon;
	
	public Label(){}
	
	@Override
	public View getLayout(Context context, ViewGroup container) {
		// TODO Auto-generated method stub
		View myView = LayoutInflater.from(context).inflate(R.layout.layout_item_label, container, false);
		ImageView im= (ImageView)myView.findViewById(R.id.idIconeLabel);
		TextView  tv = (TextView)myView.findViewById(R.id.idTextviewLabel);
		
		int idImagem = context.getResources().getIdentifier(getIcon() , "drawable", context.getPackageName());
		im.setImageResource(idImagem);
		
		tv.setText(getTitle());
		return myView;
	}

	@Override
	public void starctActivity(Context context) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isClickable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isShareable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getContentShareable() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setDateAndSchedule(String date, String schedule) {
		// TODO Auto-generated method stub
		
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	

}
