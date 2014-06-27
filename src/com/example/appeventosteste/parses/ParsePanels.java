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

import com.example.appeventosteste.beans.DayOfPanel;
import com.example.appeventosteste.beans.HeadLinePanel;
import com.example.appeventosteste.beans.PanelsProgram;
import com.example.appeventosteste.beans.ScheduleOfPanels;

public class ParsePanels {
	
	private static PanelsProgram panelProgram;
	private static DayOfPanel dayOfPanels;
	private static ScheduleOfPanels scheduleOfPanels;
	private static HeadLinePanel headLinePanel;
	private static ArrayList<DayOfPanel> arrayDaysOfPanels;
	private static ArrayList<ScheduleOfPanels> arraySchedulesOfPanels;
	private static ArrayList<HeadLinePanel> arrayOfHeadLinesPanel;
	private static ArrayList<String> arrayPanelists;
	
	private static InputStream inputStream;
	
	
	
		
	public static PanelsProgram parse(Context context, String xmlFile) throws IOException, SAXException {
		
		//inicia root
		final RootElement root = new RootElement("panelprogram");
        
		panelProgram = new PanelsProgram();
		inputStream = context.getResources().getAssets().open(xmlFile);
			
		//inicia tag days
		Element tagDays = root.getChild("days");
		tagDays.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				arrayDaysOfPanels = new ArrayList<DayOfPanel>();
			}
		});
		
		//inicia tag Day
		Element tagDay = tagDays.getChild("day");
		tagDay.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stubs
				dayOfPanels = new DayOfPanel();
			}
		});
		
		//inicia e fecha tag date
		tagDay.getChild("date").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				dayOfPanels.setDate(body);
			}
		});
		
		//inicia e fecha tag url
		tagDay.getChild("url").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				dayOfPanels.setUrl(body);
			}
		});
		
		//inicia tag schedules
		Element tagSchedules = tagDay.getChild("schedules");
		tagSchedules.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				arraySchedulesOfPanels = new ArrayList<ScheduleOfPanels>();
			}
		});
		
		//inicia tag schedule
		Element tagSchedule = tagSchedules.getChild("schedule");
		tagSchedule.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				scheduleOfPanels = new ScheduleOfPanels();
			}
		});
		
		//inicia e fecha tag start
		tagSchedule.getChild("start").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				scheduleOfPanels.setStart(body);
			}
		});
		
		//inicia e fecha tag end
		tagSchedule.getChild("end").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				scheduleOfPanels.setEnd(body);
			}
		});
				
		//inica tag headlilnes
		Element tagHeadlines = tagSchedule.getChild("headlines");
		tagHeadlines.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				arrayOfHeadLinesPanel = new ArrayList<HeadLinePanel>();
			}
		});
		
		//inicia tag headline
		Element tagHeadline = tagHeadlines.getChild("headline");
		tagHeadline.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				headLinePanel = new HeadLinePanel();
			}
		});
		
		//inicia e fecha tag name
		tagHeadline.getChild("name").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				headLinePanel.setName(body);
			}
		});
		
		//inicia e fecha tag title
		tagHeadline.getChild("title").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				headLinePanel.setTitle(body);
			}
		});
		
		//inicia e fecha tag moderator
		tagHeadline.getChild("moderator").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				headLinePanel.setModerator(body);
			}
		});
		
		//inicia e fecha tag xmlfile
		tagHeadline.getChild("xmlfile").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				headLinePanel.setXmlFile(body);
			}
		});
		
		//inicia e fecha tag icon
		tagHeadline.getChild("icon").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				headLinePanel.setIcon(body);
			}
		});
		//inicia tag panelists
		Element tagPanelists = tagHeadline.getChild("panelists");
		tagPanelists.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				arrayPanelists = new ArrayList<String>();
			}
		});
		
		//inicia e fecha tag panelist 
		Element tagPanelist = tagPanelists.getChild("panelist");
		tagPanelist.setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				arrayPanelists.add(body);
			}
		});
		//fecha tag panelists
		tagPanelists.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				headLinePanel.setPanelists(arrayPanelists);
			}
		});
		
		//fecha tag headline
		tagHeadline.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				arrayOfHeadLinesPanel.add(headLinePanel);
			}
		});
		
		//fecha tag headlines
		tagHeadlines.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				scheduleOfPanels.setArrayHeadLinesPanels(arrayOfHeadLinesPanel);
			}
		});
		
		//fecha tag schedule
		tagSchedule.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				arraySchedulesOfPanels.add(scheduleOfPanels);
			}
		});
		
		//fecha tag schedules
		tagSchedules.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				dayOfPanels.setArrayScheduleOfPanels(arraySchedulesOfPanels);			
			}
		});
		
		//fecha tag day
		tagDay.setEndElementListener(new EndElementListener(){
			@Override
			public void end() {
				// TODO Auto-generated method stub
				arrayDaysOfPanels.add(dayOfPanels);
			}
		});
		
		//fecha tag days
		tagDays.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				panelProgram.setArrayDayPanels(arrayDaysOfPanels);
			}
		});
		
		Xml.parse(inputStream, Xml.Encoding.UTF_8, root.getContentHandler());
			
		return panelProgram;
	}
	
}
