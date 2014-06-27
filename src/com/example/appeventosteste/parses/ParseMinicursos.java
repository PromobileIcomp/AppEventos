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

import com.example.appeventosteste.beans.DayOfMinicurso;
import com.example.appeventosteste.beans.HeadLineMinicurso;
import com.example.appeventosteste.beans.MinicursosProgram;
import com.example.appeventosteste.beans.ScheduleOfMinicursos;

public class ParseMinicursos {
	
	private static MinicursosProgram minicursoProgram;
	private static DayOfMinicurso dayOfMinicurso;
	private static ScheduleOfMinicursos scheduleOfMinicursos;
	private static HeadLineMinicurso headLineMinicurso;
	private static ArrayList<DayOfMinicurso> arrayDaysOfMinicursos;
	private static ArrayList<ScheduleOfMinicursos> arraySchedulesOfMinicursos;
	private static ArrayList<HeadLineMinicurso> arrayOfHeadLinesMinicurso;
	private static ArrayList<String> arrayAuthors;
	private static InputStream inputStream;
	
	
	
		
	public static MinicursosProgram parse(Context context, String xmlFile) throws IOException, SAXException {
		
		//inicia root
		final RootElement root = new RootElement("minicursosprogram");
        
		minicursoProgram = new MinicursosProgram();
		inputStream = context.getResources().getAssets().open(xmlFile);
			
		//inicia tag days
		Element tagDays = root.getChild("days");
		tagDays.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				arrayDaysOfMinicursos = new ArrayList<DayOfMinicurso>();
			}
		});
		
		//inicia tag Day
		Element tagDay = tagDays.getChild("day");
		tagDay.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stubs
				dayOfMinicurso = new DayOfMinicurso();
			}
		});
		
		//inicia e fecha tag date
		tagDay.getChild("date").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				dayOfMinicurso.setDate(body);
			}
		});
		
		//inicia e fecha tag url
		tagDay.getChild("url").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				dayOfMinicurso.setUrl(body);
			}
		});
		
		//inicia tag schedules
		Element tagSchedules = tagDay.getChild("schedules");
		tagSchedules.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				arraySchedulesOfMinicursos = new ArrayList<ScheduleOfMinicursos>();
			}
		});
		
		//inicia tag schedule
		Element tagSchedule = tagSchedules.getChild("schedule");
		tagSchedule.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				scheduleOfMinicursos = new ScheduleOfMinicursos();
			}
		});
		
		//inicia e fecha tag start
		tagSchedule.getChild("start").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				scheduleOfMinicursos.setStart(body);
			}
		});
		
		//inicia e fecha tag end
		tagSchedule.getChild("end").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				scheduleOfMinicursos.setEnd(body);
			}
		});
				
		//inica tag headlilnes
		Element tagHeadlines = tagSchedule.getChild("headlines");
		tagHeadlines.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				arrayOfHeadLinesMinicurso = new ArrayList<HeadLineMinicurso>();
			}
		});
		
		//inicia tag headline
		Element tagHeadline = tagHeadlines.getChild("headline");
		tagHeadline.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				headLineMinicurso = new HeadLineMinicurso();
			}
		});
		
		//inicia e fecha tag name
		tagHeadline.getChild("name").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				headLineMinicurso.setName(body);
			}
		});
		
		//inicia e fecha tag title
		tagHeadline.getChild("title").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				headLineMinicurso.setTitle(body);
			}
		});
		
		
		//inicia e fecha tag xmlfile
		tagHeadline.getChild("xmlfile").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				headLineMinicurso.setXmlfile(body);
			}
		});
		
		//inicia e fecha tag icon
		tagHeadline.getChild("icon").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				headLineMinicurso.setIcon(body);
			}
		});
		//inicia tag authors
		Element tagPanelists = tagHeadline.getChild("authors");
		tagPanelists.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				arrayAuthors = new ArrayList<String>();
			}
		});
		
		//inicia e fecha tag author 
		Element tagPanelist = tagPanelists.getChild("author");
		tagPanelist.setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				arrayAuthors.add(body);
			}
		});
		//fecha tag author
		tagPanelists.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				headLineMinicurso.setAuthors(arrayAuthors);
			}
		});
		
		//fecha tag headline
		tagHeadline.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				arrayOfHeadLinesMinicurso.add(headLineMinicurso);
			}
		});
		
		//fecha tag headlines
		tagHeadlines.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				scheduleOfMinicursos.setArrayMinicursos(arrayOfHeadLinesMinicurso);
			}
		});
		
		//fecha tag schedule
		tagSchedule.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				arraySchedulesOfMinicursos.add(scheduleOfMinicursos);
			}
		});
		
		//fecha tag schedules
		tagSchedules.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				dayOfMinicurso.setArraySchedules(arraySchedulesOfMinicursos);			
			}
		});
		
		//fecha tag day
		tagDay.setEndElementListener(new EndElementListener(){
			@Override
			public void end() {
				// TODO Auto-generated method stub
				arrayDaysOfMinicursos.add(dayOfMinicurso);
			}
		});
		
		//fecha tag days
		tagDays.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				minicursoProgram.setArrayDaysMinicurso(arrayDaysOfMinicursos);
			}
		});
		
		Xml.parse(inputStream, Xml.Encoding.UTF_8, root.getContentHandler());
			
		return minicursoProgram;
	}
	
}