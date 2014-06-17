package com.example.appeventosteste.beans;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appeventosteste.R;

public class DayOfTalks extends Item {
	private String date;
	private String url;
	private ArrayList<ScheduleOfTalks> arrayOfScheduleOfTalks;

	public DayOfTalks(){}
	
	@Override
	public View getLayout(Context context, ViewGroup container) {
		// TODO Auto-generated method stub
		View myView = LayoutInflater.from(context).inflate(R.layout.layout_item_title, container, false) ; 
		TextView tv = (TextView)myView.findViewById(R.id.IdTextViewTitle);
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
	public String getTitle() {
		// TODO Auto-generated method stub
		return getDate();
	}
	
	@Override
	public void setDateAndSchedule(String date, String schedule) {
		// TODO Auto-generated method stub
		
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ArrayList<ScheduleOfTalks> getArrayOfScheduleOfTalks() {
		return arrayOfScheduleOfTalks;
	}

	public void setArrayOfScheduleOfTalks(
			ArrayList<ScheduleOfTalks> arrayOfScheduleOfTalks) {
		this.arrayOfScheduleOfTalks = arrayOfScheduleOfTalks;
	}

}
