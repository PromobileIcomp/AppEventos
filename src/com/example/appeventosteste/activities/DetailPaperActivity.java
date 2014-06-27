package com.example.appeventosteste.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import com.example.appeventosteste.R;
import com.example.appeventosteste.adapters.ListViewAdapter;
import com.example.appeventosteste.beans.Author;
import com.example.appeventosteste.beans.Item;
import com.example.appeventosteste.beans.Paper;
import com.example.appeventosteste.share.Share;

public class DetailPaperActivity extends Activity {

	private static Paper paper;
	private static Context context;
	private static ListView lv;
	private static ListViewAdapter adapter;
	private static ShareActionProvider provider;
	private static Share share= new Share();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_paper);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		context = this;
		Bundle bundle = getIntent().getExtras();
		
		paper = (Paper) bundle.getSerializable("PaperObject");
		
		TextView tvTitle = (TextView) findViewById(R.id.idTextViewTitleSession);
		TextView tvAbstract = (TextView) findViewById(R.id.idTextViewDetailsSession);
		
		tvTitle.setText(paper.getTitlePaper());
		tvAbstract.setText(paper.getAbstractPaper());
		
		Log.e("AQUII", paper.getTitlePaper() + paper.getAbstractPaper());
		
		lv = (ListView)findViewById(R.id.listView1);
		lv.setDivider(null);
		adapter = new ListViewAdapter(context, convertObjectConjuntoDeSessoesInArrayItens(paper));
		lv.setAdapter(adapter);
	}

	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.detail_session, menu);
		
		MenuItem itemP= menu.findItem(R.id.menu_share);
	      
	    provider = (ShareActionProvider) itemP.getActionProvider();
	    
	    share.setShareIntent(provider, share.createShareString(paper.getContentShareable()));
	    
		return true;
	}

	
	public static ArrayList<Item> convertObjectConjuntoDeSessoesInArrayItens(Paper obj){
		ArrayList <Item> arrayListItens =  new ArrayList<Item>(); 
		
		
		
		for(Author author: obj.getArrayAuthors()){ //null 
		//	if(day.getDate().equals(date)){
				arrayListItens.add(author);
		//	}
		}
	
			
		return arrayListItens;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    // Id correspondente ao botão Up/Home da actionbar
	    case android.R.id.home:
	       finish();
	    }
	    return super.onOptionsItemSelected(item);
	}

}
