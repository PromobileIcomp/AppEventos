package com.example.appeventosteste.activities;

import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.SAXException;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.appeventosteste.R;
import com.example.appeventosteste.adapters.ListViewAdapter;
import com.example.appeventosteste.beans.DayTechSession;
import com.example.appeventosteste.beans.HeadLineTSessions;
import com.example.appeventosteste.beans.Item;
import com.example.appeventosteste.beans.ProgramacaoTechSessions;
import com.example.appeventosteste.beans.ScheduleTechSession;
import com.example.appeventosteste.parses.ParseTechSessionsMain;

public class TechSessionsActivity extends Activity {

	private static ProgramacaoTechSessions sessionsProgram;
	private static Context context;
	private static ListView lv;
	private static ListViewAdapter adapter;
	private static String xmlFile = "techsessions.xml";
	private static String date;
	private static String schedule;
	private static String[] horario;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_session);
		
		context = this;
		Bundle bundle = getIntent().getExtras();
		xmlFile = bundle.getString("xmlFile");
		date = bundle.getString("date");
		schedule = bundle.getString("schedule");
		horario = schedule.split("-");
		
		lv = (ListView)findViewById(R.id.listView1);
		lv.setDivider(null);
		ParseTechSessions();
	}
	
	public static ArrayList<Item> convertObjectConjuntoDeSessoesInArrayItens(ProgramacaoTechSessions obj){
		ArrayList <Item> arrayListItens =  new ArrayList<Item>(); 
		
		
		for(DayTechSession day: obj.getArrayDaysTechSessions()){
			if(day.getDate().equals(date)){
				arrayListItens.add(day);
			}
			for(ScheduleTechSession schedule: day.getArraySchedulesTechSession()){
				if(day.getDate().equals(date) && schedule.getStartTime().trim().equals(horario[0].trim()) && schedule.getEndTime().trim().equals(horario[1].trim())){
					arrayListItens.add(schedule);
				}
				for(HeadLineTSessions headLine: schedule.getarrayHeadLineTSessions()){
					if(day.getDate().equals(date) && schedule.getStartTime().trim().equals(horario[0].trim()) && schedule.getEndTime().trim().equals(horario[1].trim())){
						arrayListItens.add(headLine);
					}
				}
			}
		}
	
			
		return arrayListItens;
	}
	
	public static void ParseTechSessions(){
		new AsyncTask<Void, Void, Void>() {
		
			@Override
			protected void onPostExecute(Void result) {
				super.onPostExecute(result);
				ArrayList<Item> listaDoListView = convertObjectConjuntoDeSessoesInArrayItens(sessionsProgram);
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
					sessionsProgram = ParseTechSessionsMain.parse(context,xmlFile);
					if(sessionsProgram.equals(null)){
						Log.e("NULO? ", "ta vindo nulo");
					}
					else{
						Log.e("NULO? ", "nao ta vindo nulo");
					}
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
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
}
