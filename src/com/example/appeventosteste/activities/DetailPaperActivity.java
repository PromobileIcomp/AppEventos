package com.example.appeventosteste.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appeventosteste.R;
import com.example.appeventosteste.adapters.ListViewAdapter;
import com.example.appeventosteste.beans.Author;
import com.example.appeventosteste.beans.Item;
import com.example.appeventosteste.beans.Paper;

public class DetailPaperActivity extends Activity {

	private static Paper paper;
	private static Context context;
	private static ListView lv;
	private static ListViewAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_paper);
		
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

	
	
	public static ArrayList<Item> convertObjectConjuntoDeSessoesInArrayItens(Paper obj){
		ArrayList <Item> arrayListItens =  new ArrayList<Item>(); 
		
		
		
		for(Author author: obj.getArrayAuthors()){ //null 
		//	if(day.getDate().equals(date)){
				arrayListItens.add(author);
		//	}
		}
	
			
		return arrayListItens;
	}

}
