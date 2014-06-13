package com.example.appeventosteste.beans;

import java.io.Serializable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appeventosteste.R;

public class Author extends Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String afiliation;
	private String email;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAfiliation() {
		return afiliation;
	}
	public void setAfiliation(String afiliation) {
		this.afiliation = afiliation;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public View getLayout(Context context, ViewGroup container) {
		// TODO Auto-generated method stub
		View myView = LayoutInflater.from(context).inflate(R.layout.layout_item_label, container, false);
		
		TextView tv = (TextView) myView.findViewById(R.id.idTextviewLabel);
		
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
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return ("Nome: " + this.getName() + "\nAfiliation: " + this.getAfiliation() + "Email: " + this.getEmail());
	}
}
