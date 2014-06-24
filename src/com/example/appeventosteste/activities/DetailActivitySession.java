package com.example.appeventosteste.activities;

import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.SAXException;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ShareActionProvider;

import com.example.appeventosteste.R;
import com.example.appeventosteste.adapters.ListViewAdapter;
import com.example.appeventosteste.beans.DetailTSession;
import com.example.appeventosteste.beans.Item;
import com.example.appeventosteste.beans.Paper;
import com.example.appeventosteste.parses.ParseDetailSessions;
import com.example.appeventosteste.share.Share;

public class DetailActivitySession extends Activity {

	private static DetailTSession techSession;
	private static Context context;
	private static ListView lv;
	private static ListViewAdapter adapter;
	private static String xmlFile;
	private static String titleSession;
	private static ShareActionProvider provider;
	private static Share share = new Share();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_tech_sessions);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		context = this;
		Bundle bundle = getIntent().getExtras();
		xmlFile = bundle.getString("xmlFile");
		titleSession = bundle.getString("title");		
		
		lv = (ListView)findViewById(R.id.listView1);
		lv.setDivider(null);
		
		
		ParseTechSessions();

	}
	
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.detail_session, menu);
		
		MenuItem itemP= menu.findItem(R.id.menu_share);
	      
	    provider = (ShareActionProvider) itemP.getActionProvider();
	    
		return true;
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
				
				share.setShareIntent(provider, share.createShareString(techSession.getContentShareable()));
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
		switch (item.getItemId()) {
	    // Id correspondente ao botão Up/Home da actionbar
	    case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        return true;
	    }
	    return super.onOptionsItemSelected(item);
	}

}
