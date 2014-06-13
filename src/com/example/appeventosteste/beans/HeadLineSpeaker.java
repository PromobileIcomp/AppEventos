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
import com.example.appeventosteste.activities.DetailsActivityPalestrante;

public class HeadLineSpeaker extends Item {
	
	private String xmlFile;
	private String name;
	private String filiation;
	private String photo;
	private String title;
	
	public HeadLineSpeaker(){}
	
	
	@Override
	public View getLayout(Context context,ViewGroup container) {
		// TODO Auto-generated method stub
		View myView = LayoutInflater.from(context).inflate(R.layout.layout_item_clickable, container, false);
		TextView tv = (TextView)myView.findViewById(R.id.idTextViewItemClickable);
		ImageView im1 = (ImageView)myView.findViewById(R.id.idImageViewItemClickable);
		ImageView im2 = (ImageView)myView.findViewById(R.id.idSetaImageviewClickable);
		int idImagem = context.getResources().getIdentifier(getPhoto() , "drawable", context.getPackageName());
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
			Intent intent = new Intent(context,DetailsActivityPalestrante.class);
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
		return null;
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setDateAndSchedule(String date, String schedule) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title+ ", "+ getName()+", "+getFiliation();
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getXmlFile() {
		return xmlFile;
	}
	public void setXmlFile(String xmlFile) {
		this.xmlFile = xmlFile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFiliation() {
		return filiation;
	}
	public void setFiliation(String filiation) {
		this.filiation = filiation;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
