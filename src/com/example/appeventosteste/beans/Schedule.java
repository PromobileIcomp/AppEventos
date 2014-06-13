package com.example.appeventosteste.beans;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appeventosteste.R;

public class Schedule extends Item {
	
	private String start;
	private String end;
	private ArrayList <Item> arrayDeEventos;
	
	public Schedule(){}

	@Override
	public View getLayout(Context context, ViewGroup container) {
		// TODO Auto-generated method stub
		View myView = LayoutInflater.from(context).inflate(R.layout.layout_item_schedule, container, false);
		TextView tv = (TextView)myView.findViewById(R.id.IdTextViewSchedule);
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
		return getStart()+ "-"+ getEnd();
	}
	
	@Override
	public void setDateAndSchedule(String date, String schedule) {
		// TODO Auto-generated method stub
		
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public ArrayList<Item> getArrayDeEventos() {
		return arrayDeEventos;
	}

	public void setArrayDeEventos(ArrayList<Item> arrayDeEventos) {
		this.arrayDeEventos = arrayDeEventos;
	}

}
