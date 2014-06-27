package com.example.appeventosteste.parses;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.SAXException;

import android.content.Context;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.util.Xml;

import com.example.appeventosteste.beans.MinicursoDetail;

public class ParseMinicursoDetail{
	private static MinicursoDetail minicursoDetail;
	private static InputStream inputStream;
		
		
		
			
	public static MinicursoDetail parse(Context context, String xmlFile) throws IOException, SAXException {
		
		//inicia root
		final RootElement root = new RootElement("minicursodetail");
		
		minicursoDetail = new MinicursoDetail();
		inputStream = context.getResources().getAssets().open(xmlFile);
		
		root.getChild("resume").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				minicursoDetail.setResume(body);
			}
		});

		Xml.parse(inputStream, Xml.Encoding.UTF_8, root.getContentHandler());
				
		return minicursoDetail;
	
	}
}
