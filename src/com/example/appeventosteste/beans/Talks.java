package com.example.appeventosteste.beans;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appeventosteste.R;
import com.example.appeventosteste.activities.TalksActivity;

public class Talks extends Item {
	
	private String xmlFile;
	private String icon;
	private String title;
	private String date;
	private String schedule;
	
	
	@Override
	public View getLayout(Context context, ViewGroup container) {
		// TODO Auto-generated method stub
		View myView = LayoutInflater.from(context).inflate(R.layout.layout_item_clickable, container, false);
		 
		TextView tv = (TextView)myView.findViewById(R.id.idTextViewItemClickable);
		ImageView iv = (ImageView)myView.findViewById(R.id.idImageViewItemClickable);
		ImageView ivSeta = (ImageView)myView.findViewById(R.id.idSetaImageviewClickable); 
		 
		int idImagem = context.getResources().getIdentifier(getIcon() , "drawable", context.getPackageName());
		iv.setImageResource(idImagem);
		
		tv.setText(getTitle());
		
		ivSeta.setImageResource(R.drawable.petita_right_arrow);
		 
		
		return myView;
	}

	@Override
	public void starctActivity(Context context) {
		// TODO Auto-generated method stub
		Bundle bundle = new Bundle();
		bundle.putString("xmlFile", getXmlFile());
		bundle.putString("date", getDate());
		bundle.putString("schedule", getSchedule());
		Intent intent = new Intent(context,TalksActivity.class);
		intent.putExtras(bundle);
		context.startActivity(intent);
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
		this.date = date;
		this.schedule = schedule;
	}

	public String getXmlFile() {
		return xmlFile;
	}

	public void setXmlFile(String xmlFile) {
		this.xmlFile = xmlFile;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

}
