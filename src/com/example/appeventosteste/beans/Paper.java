package com.example.appeventosteste.beans;
import java.io.Serializable;
import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appeventosteste.R;
import com.example.appeventosteste.activities.DetailPaperActivity;


public class Paper extends Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titlePaper;
	private String abstractPaper;
	private ArrayList<Author> arrayAuthors;
	
	public String getTitlePaper() {
		return titlePaper;
	}
	
	public void setTitlePaper(String titlePaper) {
		this.titlePaper = titlePaper;
	}
	
	public String getAbstractPaper() {
		return abstractPaper;
	}
	
	public void setAbstractPaper(String abstractPaper) {
		this.abstractPaper = abstractPaper;
	}
	
	public ArrayList<Author> getArrayAuthors() {
		return arrayAuthors;
	}
	
	public void setArrayAuthors(ArrayList<Author> arrayAuthors) {
		this.arrayAuthors = arrayAuthors;
	}

	@Override
	public View getLayout(Context context, ViewGroup container) {
		View myView = LayoutInflater.from(context).inflate(R.layout.layout_item_label, container, false);
		
		TextView tv = (TextView) myView.findViewById(R.id.idTextviewLabel);
		
		tv.setText(getTitlePaper());
		
		return myView;
	}

	@Override
	public void starctActivity(Context context) {
		// TODO Auto-generated method stub
		
		Bundle bundle = new Bundle();
		
		bundle.putSerializable("PaperObject", this);
		
		Intent intent = new Intent(context, DetailPaperActivity.class);
		
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
