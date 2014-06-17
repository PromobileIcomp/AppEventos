package com.example.appeventosteste.beans;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class Speaker extends Item{
	private String photo;
	private String name;
	private String filiation;
	private String title;
	private String resume;
	private String biography;
	
	

	@Override
	public View getLayout(Context context, ViewGroup container) {
		// TODO Auto-generated method stub
		return null;
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
	
public Speaker(){}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}


}
