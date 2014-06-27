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

import com.example.appeventosteste.beans.Author;
import com.example.appeventosteste.beans.DetailTSession;
import com.example.appeventosteste.beans.Paper;

public class ParseDetailSessions {
	private static DetailTSession techSession;
	private static ArrayList<Paper> arrayPapers;
	private static Paper paper; 
	private static ArrayList<Author> arrayAuthors;
	private static Author author;
	
	private static InputStream inputStream;
	
	public static DetailTSession parse(Context context, String xmlFile) throws IOException, SAXException {
		
		techSession = new DetailTSession();
		
		final RootElement root = new RootElement("session");
		
		inputStream = context.getResources().getAssets().open(xmlFile);
		
		
		//inicia e fecha tag chair
		root.getChild("chair").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String chair) {
				// TODO Auto-generated method stub
				techSession.setChair(chair);
			}
		});
		
		//inicia e fecha tag local
		root.getChild("local").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String local) {
				// TODO Auto-generated method stub
				techSession.setLocal(local);
			}
		});
		
		//inicia tag papers
		Element papers = root.getChild("papers");
		papers.setStartElementListener(new StartElementListener() {	
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				arrayPapers = new ArrayList<Paper>();
				
			}
		});
		
			//inicia tag paper
			Element tagPaper = papers.getChild("paper");
			tagPaper.setStartElementListener(new StartElementListener() {
				@Override
				public void start(Attributes attributes) {
					// TODO Auto-generated method stub
					paper = new Paper();
				}
			});
			
				//inicia e fecha tag title
				tagPaper.getChild("title").setEndTextElementListener(new EndTextElementListener() {
					@Override
					public void end(String title) {
						// TODO Auto-generated method stub
						paper.setTitlePaper(title);
					}
				});
			
				//inicia e fecha tag abstract
				tagPaper.getChild("abstract").setEndTextElementListener(new EndTextElementListener() {
					@Override
					public void end(String abstrac) {
						// TODO Auto-generated method stub
						paper.setAbstractPaper(abstrac);
					}
				});
				
				//inicia tag authors
				Element authors = tagPaper.getChild("authors");
				authors.setStartElementListener(new StartElementListener() {
					@Override
					public void start(Attributes attributes) {
						// TODO Auto-generated method stub
						arrayAuthors = new ArrayList<Author>();
					}
				});
				
					//inicia tag author
					Element tagAuthor = authors.getChild("author");
					tagAuthor.setStartElementListener(new StartElementListener() {
						@Override
						public void start(Attributes attributes) {
							// TODO Auto-generated method stub
							author = new Author();
						}
					});
					
						//inicia e fecha tag name
						tagAuthor.getChild("name").setEndTextElementListener(new EndTextElementListener() {
							@Override
							public void end(String name) {
								// TODO Auto-generated method stub
								author.setName(name);
							}
						});
						
						//inicia e fecha tag afiliation
						tagAuthor.getChild("afiliation").setEndTextElementListener(new EndTextElementListener() {
							@Override
							public void end(String afiliation) {
								// TODO Auto-generated method stub
								author.setAfiliation(afiliation);
								
							}
						});
						
						//inicia e fecha tag email
						tagAuthor.getChild("email").setEndTextElementListener(new EndTextElementListener() {
							@Override
							public void end(String email) {
								// TODO Auto-generated method stub
								author.setEmail(email);
								
							}
						});
					
					//fecha tag author
					tagAuthor.setEndElementListener(new EndElementListener() {
						@Override
						public void end() {
							// TODO Auto-generated method stub
							arrayAuthors.add(author);
						}
					});
							
						
				//fecha tag authors
				authors.setEndElementListener(new EndElementListener() {
					@Override
					public void end() {
						// TODO Auto-generated method stub
						paper.setArrayAuthors(arrayAuthors);
					}
				});
							
						
			//fecha tag paper
			tagPaper.setEndElementListener(new EndElementListener() {
				@Override
				public void end() {
					// TODO Auto-generated method stub
					arrayPapers.add(paper);
				}
			});
			
		//fecha tag papers
		papers.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				techSession.setArrayPapers(arrayPapers);
			}
		});
						
					
		Xml.parse(inputStream, Xml.Encoding.UTF_8, root.getContentHandler());
			
		return techSession;
	}
}
