package com.example.appeventosteste.beans;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appeventosteste.R;

public class ScheduleTechSession extends Item{
	private String startTime;
	private String endTime;
	private ArrayList<HeadLineTSessions> arrayHeadLineTSessions;
	
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public ArrayList<HeadLineTSessions> getarrayHeadLineTSessions() {
		return arrayHeadLineTSessions;
	}
	public void setArrayHeadLineTSessions(ArrayList<HeadLineTSessions> arrayHeadLineTSessions) {
		this.arrayHeadLineTSessions = arrayHeadLineTSessions;
	}
	@Override
	public View getLayout(Context context, ViewGroup container) {
		// TODO Auto-generated method stub
		View myView = LayoutInflater.from(context).inflate(R.layout.layout_item_schedule, container, false);
		
		TextView tv = (TextView) myView.findViewById(R.id.IdTextViewSchedule);
		
		tv.setText(getStartTime() + "-" + getEndTime());
		
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
	
}
