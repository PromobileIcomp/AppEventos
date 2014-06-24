package com.example.appeventosteste.beans;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appeventosteste.R;

public class DayTechSession extends Item{
	private String date;
	private String weekDay;
	private String url;
	private ArrayList<ScheduleTechSession> arraySchedulesTechSession;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}
	

	public ArrayList<ScheduleTechSession> getArraySchedulesTechSession() {
		return arraySchedulesTechSession;
	}
	public void setArraySchedulesTechSession(
			ArrayList<ScheduleTechSession> arraySchedulesTechSession) {
		this.arraySchedulesTechSession = arraySchedulesTechSession;
	}
	
	@Override
	public View getLayout(Context context, ViewGroup container) {
		// TODO Auto-generated method stub
		View myView = LayoutInflater.from(context).inflate(R.layout.layout_item_title, container, false);
		
		TextView tv = (TextView) myView.findViewById(R.id.IdTextViewTitle);
		
		tv.setText(getDate());
		
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
		return null;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}	
}
