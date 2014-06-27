package com.example.appeventosteste.beans;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class GeneralProgramWorkshop extends Item {
	
	private String url;
	private ArrayList<Day> arrayDeDias;
	
	
	public GeneralProgramWorkshop(){}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ArrayList<Day> getArrayDeDias() {
		return arrayDeDias;
	}

	public void setArrayDeDias(
			ArrayList<Day> arrayDeDias) {
		this.arrayDeDias = arrayDeDias;
	}

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
		return true;
	}

	@Override
	public String getContentShareable() {
		
		String t = "Confira a programação do EPA! 2014: " + getUrl();
		
		return t;
	}

	@Override
	public void setDateAndSchedule(String date, String schedule) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
}
