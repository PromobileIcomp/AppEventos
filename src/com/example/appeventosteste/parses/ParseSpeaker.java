package com.example.appeventosteste.parses;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import android.content.Context;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.util.Log;
import android.util.Xml;

import com.example.appeventosteste.beans.Speaker;

public class ParseSpeaker {

	private static Speaker palestrante;
	private static InputStream inputStream;
	
	public static Speaker parse(Context context, String xmlFile) throws IOException, SAXException {
		
		final RootElement root = new RootElement("speaker");
        
		palestrante = new Speaker();
		Log.e("StringXmlfile",xmlFile);
		inputStream = context.getResources().getAssets().open(xmlFile);
		
		root.getChild("photo").setStartElementListener(new StartElementListener() {
			
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				String tagIsShareable = attributes.getValue("isShareable");
				palestrante.setPhotoIsShareable(tagIsShareable.trim());
			}
		});
		
		root.getChild("photo").setEndTextElementListener(new EndTextElementListener(){
            public void end(String photo) {
                palestrante.setPhoto(photo);
            }
		});
		
		root.getChild("name").setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				palestrante.setNameIsShareable(attributes.getValue("isShareable"));
			}
		});
		
		root.getChild("name").setEndTextElementListener(new EndTextElementListener(){
            public void end(String name) {
                palestrante.setName(name);
            }
		});
		
		root.getChild("filiation").setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				palestrante.setFiliationIsShareable(attributes.getValue("isShareable"));
			}
		});
		
		root.getChild("filiation").setEndTextElementListener(new EndTextElementListener(){
            public void end(String filiation) {
                palestrante.setFiliation(filiation);
            }		
        });
		
		root.getChild("title").setStartElementListener(new StartElementListener() {	
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				palestrante.setTitleIsShareable(attributes.getValue("isShareable"));
			}
		});
		
		root.getChild("title").setEndTextElementListener(new EndTextElementListener(){
            public void end(String title) {
                palestrante.setTitle(title);
            }
		});
		
		root.getChild("resume").setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				palestrante.setResumeIsShareable(attributes.getValue("isShareable"));
			}
		});
		
		root.getChild("resume").setEndTextElementListener(new EndTextElementListener(){
            public void end(String resume) {
                palestrante.setResume(resume);
            }
		});
		
		root.getChild("biography").setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				palestrante.setBiographyIsShareable(attributes.getValue("isShareable"));
			}
		});
		
		root.getChild("biography").setEndTextElementListener(new EndTextElementListener(){
            public void end(String biography) {
                palestrante.setBiography(biography);
            }
		});
		
		Xml.parse(inputStream, Xml.Encoding.UTF_8, root.getContentHandler());
			
		return palestrante;
	}
}
