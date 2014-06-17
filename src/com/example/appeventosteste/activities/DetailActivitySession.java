package com.example.appeventosteste.activities;

import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.SAXException;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.appeventosteste.R;
import com.example.appeventosteste.adapters.ListViewAdapter;
import com.example.appeventosteste.beans.DetailTSession;
import com.example.appeventosteste.beans.Item;
import com.example.appeventosteste.beans.Paper;
import com.example.appeventosteste.parses.ParseDetailSessions;

public class DetailActivitySession extends Activity {

	private static DetailTSession techSession;
	private static Context context;
	private static ListView lv;
	private static ListViewAdapter adapter;
	private static String xmlFile;
	private static String titleSession;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_tech_sessions);
		
		context = this;
		Bundle bundle = getIntent().getExtras();
		xmlFile = bundle.getString("xmlFile");
		titleSession = bundle.getString("titleSession");		
		
		lv = (ListView)findViewById(R.id.listView1);
		lv.setDivider(null);
		ParseTechSessions();
	}
	
	public static ArrayList<Item> convertObjectConjuntoDeSessoesInArrayItens(DetailTSession obj){
		ArrayList <Item> arrayListItens =  new ArrayList<Item>(); 
		
		arrayListItens.add(obj);
		
		for(Paper paper: obj.getArrayPapers()){
				arrayListItens.add(paper);
		}
	
			
		return arrayListItens;
	}
	
	public static void ParseTechSessions(){
		new AsyncTask<Void, Void, Void>() {
		
			@Override
			protected void onPostExecute(Void result) {
				super.onPostExecute(result);
				
				ArrayList<Item> listaDoListView = convertObjectConjuntoDeSessoesInArrayItens(techSession);
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
					techSession = ParseDetailSessions.parse(context,xmlFile);
					techSession.setTitleSession(titleSession);  ///ASDASDASDAS
					if(techSession.equals(null)){
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
