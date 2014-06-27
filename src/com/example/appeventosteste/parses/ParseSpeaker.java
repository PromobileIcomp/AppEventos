package com.example.appeventosteste.parses;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.SAXException;

import android.content.Context;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
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
		
		
		root.getChild("photo").setEndTextElementListener(new EndTextElementListener(){
            public void end(String photo) {
                palestrante.setPhoto(photo);
            }
		});
		
		
		root.getChild("name").setEndTextElementListener(new EndTextElementListener(){
            public void end(String name) {
                palestrante.setName(name);
            }
		});
		
		
		root.getChild("filiation").setEndTextElementListener(new EndTextElementListener(){
            public void end(String filiation) {
                palestrante.setFiliation(filiation);
            }		
        });
		
		root.getChild("title").setEndTextElementListener(new EndTextElementListener(){
            public void end(String title) {
                palestrante.setTitle(title);
            }
		});
				
		root.getChild("resume").setEndTextElementListener(new EndTextElementListener(){
            public void end(String resume) {
                palestrante.setResume(resume);
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
