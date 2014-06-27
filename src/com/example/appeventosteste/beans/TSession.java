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
import com.example.appeventosteste.activities.DetailActivitySession;

public class TSession extends Item {
	
	private String xmlFile;
	private String title;
	private String icon;
	
	
	public TSession(){}
	
	@Override
	public View getLayout(Context context, ViewGroup container) {
		// TODO Auto-generated method stub
		View myView = LayoutInflater.from(context).inflate(R.layout.layout_item_clickable, container, false);
		TextView tv = (TextView)myView.findViewById(R.id.idTextViewItemClickable);
		ImageView im1 = (ImageView)myView.findViewById(R.id.idImageViewItemClickable);
		ImageView im2 = (ImageView)myView.findViewById(R.id.idSetaImageviewClickable);
		int idImagem = context.getResources().getIdentifier(getIcon() , "drawable", context.getPackageName());
		im1.setImageResource(idImagem);
		tv.setText(getTitle());
		im2.setImageResource(R.drawable.petita_right_arrow);
		return myView;
		
	}

	@Override
	public void starctActivity(Context context) {
		// TODO Auto-generated method stub
		Bundle bundle = new Bundle();
		bundle.putString("xmlFile", this.getXmlFile());
		bundle.putString("title", this.getTitle());
		Intent intent = new Intent(context,DetailActivitySession.class);
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
		return true;
	}

	@Override
	public String getContentShareable() {
		// TODO Auto-generated method stub
		return title;
	}
	
	@Override
	public void setDateAndSchedule(String date, String schedule) {
		// TODO Auto-generated method stub
		
	}

	public String getXmlFile() {
		return xmlFile;
	}

	public void setXmlFile(String xmlFile) {
		this.xmlFile = xmlFile;
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
