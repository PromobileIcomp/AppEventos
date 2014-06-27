package com.example.appeventosteste.activities;

import java.io.IOException;

import org.xml.sax.SAXException;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import com.example.appeventosteste.R;
import com.example.appeventosteste.beans.Speaker;
import com.example.appeventosteste.parses.ParseSpeaker;
import com.example.appeventosteste.share.Share;

public class DetailsActivityPalestrante extends Activity {

	private static Speaker palestrante;
	private static Context context;
	private static String xmlFile;
	
	private static TextView nomeSpeaker;
	private static TextView filiacaoSpeaker;
	private static TextView tituloSpeaker;
	private static TextView resumoSpeaker;
	private static TextView biografiaSpeaker;
	private static ImageView foto;

	private static ShareActionProvider provider;
	private static Share share = new Share();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_palestrante_details);
		context = this;
		Bundle bundle = getIntent().getExtras();
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		xmlFile = bundle.getString("xmlFile");
		Log.e("XMLFIle",xmlFile);
		nomeSpeaker = (TextView)findViewById(R.id.IDNome);
		filiacaoSpeaker = (TextView)findViewById(R.id.IDFiliacao);
		tituloSpeaker = (TextView)findViewById(R.id.IDTitulo);
		resumoSpeaker = (TextView)findViewById(R.id.IDResumo);
		biografiaSpeaker = (TextView)findViewById(R.id.IDBiografia);
		foto = (ImageView)findViewById(R.id.imagem);
		
		ParseDoPalestrante();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail_palestrante, menu);
		
		MenuItem item= menu.findItem(R.id.menu_share);
	      
	    provider = (ShareActionProvider) item.getActionProvider();

		
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

	
	public void ParseDoPalestrante (){
		new AsyncTask<Void, Void, Void>() {
			@Override
			protected void onPostExecute(Void result) {
				super.onPostExecute(result);
				
				nomeSpeaker.setText(palestrante.getName());
				filiacaoSpeaker.setText(palestrante.getFiliation());
				tituloSpeaker.setText(palestrante.getTitle());
				resumoSpeaker.setText(palestrante.getResume());
				biografiaSpeaker.setText(palestrante.getBiography());
				String photo = palestrante.getPhoto();
				
				int idImagem = getResources().getIdentifier(photo , "drawable", getPackageName());
				
				if(photo==null){
					foto.setImageResource(R.drawable.ic_launcher);
				}
				else{
					foto.setImageResource(idImagem);
				}

				share.setShareIntent(provider, share.createShareString(palestrante.getContentShareable()));
			}
			
			@Override
			protected Void doInBackground(Void... arg) {
				try {
					palestrante = ParseSpeaker.parse(context,xmlFile.trim());
					if(palestrante != null)
						Log.e("Palestrante diz:","nAo sou nulo");
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

}


