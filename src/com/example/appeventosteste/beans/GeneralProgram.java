package com.example.appeventosteste.beans;

import java.util.ArrayList;

public class GeneralProgram {
	
	private String url;
	private ArrayList<Day> arrayDeDias;
	
	
	public GeneralProgram(){}

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
}
