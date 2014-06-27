package com.example.appeventosteste.parses;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import android.content.Context;
import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.util.Xml;

import com.example.appeventosteste.beans.PanelDetail;

public class ParsePanelDetails {
	
	private static PanelDetail panelDetail;
	private static ArrayList<String> arrayBiographies;
	private static InputStream inputStream;
		
		
		
			
	public static PanelDetail parse(Context context, String xmlFile) throws IOException, SAXException {
		
		//inicia root
		final RootElement root = new RootElement("paneldetail");
        
		panelDetail = new PanelDetail();
		inputStream = context.getResources().getAssets().open(xmlFile);
		
		//inicia e fecha tag resume
		root.getChild("resume").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				panelDetail.setResume(body);
			}
		});
		
		//inicia tag biographies
		Element tagBiographies = root.getChild("biographies");
		tagBiographies.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				arrayBiographies = new ArrayList<String>();
			}
		});
		
		//inicia e fecha tag biography
		Element tagBiography = tagBiographies.getChild("biography");
		tagBiography.setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				arrayBiographies.add(body);
			}
		});
		
		//fecha tag biographies
		tagBiographies.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				panelDetail.setBiographies(arrayBiographies);
			}
		});
		Xml.parse(inputStream, Xml.Encoding.UTF_8, root.getContentHandler());
			
		return panelDetail;

	}
	
}
