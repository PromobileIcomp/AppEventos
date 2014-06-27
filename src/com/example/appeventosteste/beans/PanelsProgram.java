package com.example.appeventosteste.beans;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class PanelsProgram extends Item {
	
	private ArrayList<DayOfPanel> arrayDayPanels;

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

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DayOfPanel> getArrayDayPanels() {
		return arrayDayPanels;
	}

	public void setArrayDayPanels(ArrayList<DayOfPanel> arrayDayPanels) {
		this.arrayDayPanels = arrayDayPanels;
	}

}
