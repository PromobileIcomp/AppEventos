package com.example.appeventosteste.beans;


import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appeventosteste.R;

public class DetailTSession extends Item{

	private String titleSession;
	private String chair;
	private String local;
	private ArrayList<Paper> arrayPapers;
	
	public String getChair() {
		return chair;
	}

	public void setChair(String chair) {
		this.chair = chair;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public ArrayList<Paper> getArrayPapers() {
		return arrayPapers;
	}

	public void setArrayPapers(ArrayList<Paper> arrayPapers) {
		this.arrayPapers = arrayPapers;
	}

	@Override
	public View getLayout(Context context, ViewGroup container) {
		View myView = LayoutInflater.from(context).inflate(R.layout.layout_item_details_session, container, false);
		
		
		TextView tv = (TextView) myView.findViewById(R.id.idTextViewTitleSession);
		tv.setText(this.getTitleSession());
		
		
		TextView tv2 = (TextView) myView.findViewById(R.id.idTextViewDetailsSession);
		String t = "Chair: " + this.getChair() + "\n Local: " + this.getLocal();
		tv2.setText(t);
		
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

	public String getTitleSession() {
		return titleSession;
	}

	public void setTitleSession(String titleSession) {
		this.titleSession = titleSession;
	}

}
