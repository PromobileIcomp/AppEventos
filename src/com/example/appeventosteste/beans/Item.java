package com.example.appeventosteste.beans;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public abstract class Item {
	public abstract View getLayout(Context context, ViewGroup container);
	public abstract void  starctActivity(Context context);
	public abstract boolean isClickable();
	public abstract boolean isShareable();
	public abstract String getContentShareable();
	public abstract void setDateAndSchedule(String date, String schedule);
	public abstract String getTitle();
}
