package com.example.appeventosteste.activities;

import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.SAXException;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.appeventosteste.R;
import com.example.appeventosteste.adapters.ListViewAdapter;
import com.example.appeventosteste.beans.DayOfTalks;
import com.example.appeventosteste.beans.HeadLineSpeaker;
import com.example.appeventosteste.beans.Item;
import com.example.appeventosteste.beans.ScheduleOfTalks;
import com.example.appeventosteste.beans.TalksProgram;
import com.example.appeventosteste.parses.ParseTalks;


public class TalksActivity extends Activity {

	private static TalksProgram talksProgram;
	private static Context context;
	private static ListView lv;
	private static ListViewAdapter adapter;
	private static String xmlFile;
	private static String date;
	private static String schedule;
	private static String[] horario;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_palestrante_main);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		context = this;
		Bundle bundle = getIntent().getExtras();
		
		xmlFile = bundle.getString("xmlFile");
		date = bundle.getString("date");
		schedule = bundle.getString("schedule");
		horario = schedule.split("-");
		//xmlFile = "palestrantes.xml";
		lv = (ListView)findViewById(R.id.listView1);
		lv.setDivider(null);
		ParseDosPalestrantes();
	}
	
	public static ArrayList<Item> convertObjectConjuntoDePalestrantesInArrayItens(TalksProgram obj){
		ArrayList <Item> arrayListItens =  new ArrayList<Item>(); 
		
		for(DayOfTalks day: obj.getArrayOfDaysOfTalk()){
			if(day.getDate().equals(date)){
				arrayListItens.add(day);
			}
			for(ScheduleOfTalks schedule: day.getArrayOfScheduleOfTalks()){
				if(day.getDate().equals(date) && schedule.getStart().trim().equals(horario[0].trim()) && schedule.getEnd().trim().equals(horario[1].trim())){
					arrayListItens.add(schedule);
				}
				for(HeadLineSpeaker headLine: schedule.getArrayHeadLines()){
					if(day.getDate().equals(date) && schedule.getStart().trim().equals(horario[0].trim()) && schedule.getEnd().trim().equals(horario[1].trim())){
						arrayListItens.add(headLine);
					}
				}
			}
		}
			
		return arrayListItens;
	}

	
	public static void ParseDosPalestrantes (){
		new AsyncTask<Void, Void, Void>() {
		
			@Override
			protected void onPostExecute(Void result) {
				super.onPostExecute(result);
				ArrayList<Item> listaDoListView = convertObjectConjuntoDePalestrantesInArrayItens(talksProgram);
				adapter = new ListViewAdapter(context, listaDoListView);
				lv.setAdapter(adapter);
				lv.setOnItemClickListener(new OnItemClickListener() {
					public void onItemClick(AdapterView<?>parent, View view, int position, long id){
						Item item = (Item)parent.getAdapter().getItem(position);
						item.starctActivity(context);	
					}
				});
				
			}
			
			@Override
			protected Void doInBackground(Void... arg) {
				try {
					talksProgram = ParseTalks.parse(context,xmlFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return null;
			}
		}.execute();
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	    // Id correspondente ao botão Up/Home da actionbar
	    case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        return true;
	    }
	    return super.onOptionsItemSelected(item);
	}


}
