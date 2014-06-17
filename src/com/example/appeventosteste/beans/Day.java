package com.example.appeventosteste.beans;

import java.util.ArrayList;

import com.example.appeventosteste.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Day extends Item {
	
	private String data;
	private String diaDaSemana;
	private ArrayList<Schedule> arrayDeHorarios;
	
	public Day(){}
	
	@Override
	public View getLayout(Context context, ViewGroup container) {
		// TODO Auto-generated method stub
		View myView = LayoutInflater.from(context).inflate(R.layout.layout_item_title, container, false);
		TextView tv = (TextView)myView.findViewById(R.id.IdTextViewTitle);
		tv.setText(getData());
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
		return getDiaDaSemana();
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(String diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public ArrayList<Schedule> getArrayDeHorarios() {
		return arrayDeHorarios;
	}

	public void setArrayDeHorarios(
			ArrayList<Schedule> arrayDeHorarios) {
		this.arrayDeHorarios = arrayDeHorarios;
	}

}
