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

import com.example.appeventosteste.beans.DayOfTalks;
import com.example.appeventosteste.beans.HeadLineSpeaker;
import com.example.appeventosteste.beans.ScheduleOfTalks;
import com.example.appeventosteste.beans.TalksProgram;

public class ParseTalks {

	private static TalksProgram talksProgram;
	private static DayOfTalks dayOfTalks;
	private static ScheduleOfTalks scheduleOfTalks;
	private static HeadLineSpeaker headLineSpeaker;
	private static ArrayList<DayOfTalks> arrayDaysOfTalks;
	private static ArrayList<ScheduleOfTalks> arraySchedulesOfTalks;
	private static ArrayList<HeadLineSpeaker> arrayOfHeadLines;
	private static InputStream inputStream;
	
	
	public static TalksProgram parse(Context context, String xmlFile) throws IOException, SAXException {
				
		final RootElement root = new RootElement("talksprogram");
        
		talksProgram = new TalksProgram();
		inputStream = context.getResources().getAssets().open(xmlFile);
		
		//inicia a tag days
		
		Element tagDays = root.getChild("days");
		tagDays.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				arrayDaysOfTalks = new ArrayList<DayOfTalks>();
			}
		});
		
		//inicia tag day
		Element tagDay = tagDays.getChild("day");
		tagDay.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				dayOfTalks = new DayOfTalks();
			}
		});
		
		//tag data
		tagDay.getChild("date").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				dayOfTalks.setDate(body);
			}
		});
		
		//tag url
		tagDay.getChild("url").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				dayOfTalks.setUrl(body);
			}
		});
		
		//inicia tag Schedules
		Element tagSchedules = tagDay.getChild("schedules");
		tagSchedules.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				arraySchedulesOfTalks = new ArrayList<ScheduleOfTalks>();
			}
		});
		
		//inicia tag Schedule
		Element tagSchedule = tagSchedules.getChild("schedule");
		tagSchedule.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				scheduleOfTalks = new ScheduleOfTalks();
			}
		});
		
		//tag start
		tagSchedule.getChild("start").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				scheduleOfTalks.setStart(body);
			}
		});
		//tag end
		tagSchedule.getChild("end").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				scheduleOfTalks.setEnd(body);
			}
		});
		
		
		//inicia tag headlines
		Element tagHeadLines = tagSchedule.getChild("headlines");
		tagHeadLines.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				arrayOfHeadLines = new ArrayList<HeadLineSpeaker>();
			}
		});
		
		//inicia tag headline
		Element tagHeadLine = tagHeadLines.getChild("headline");
		tagHeadLine.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				headLineSpeaker = new HeadLineSpeaker();
			}
		});
		
		//tag photo
		tagHeadLine.getChild("photo").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				headLineSpeaker.setPhoto(body);
			}
		});
		
		//tag title
		tagHeadLine.getChild("title").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				headLineSpeaker.setTitle(body);
			}
		});
		
		//tag xmlfile
		tagHeadLine.getChild("xmlfile").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				headLineSpeaker.setXmlFile(body);
			}
		});
		
		//tag name
		tagHeadLine.getChild("name").setEndTextElementListener(new EndTextElementListener() {
			@Override																																																																								
			public void end(String body) {
				// TODO Auto-generated method stub
				headLineSpeaker.setName(body);
			}
		});
		
		//tag filiation
		tagHeadLine.getChild("filiation").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				// TODO Auto-generated method stub
				headLineSpeaker.setFiliation(body);
			}
		});
		
		//fecha tag headline
		tagHeadLine.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				arrayOfHeadLines.add(headLineSpeaker);
			}
		});
		
		//fecha tag headlines
		tagHeadLines.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				scheduleOfTalks.setArrayHeadLines(arrayOfHeadLines);
			}
		});
		
		
		//fecha tag schedule
		tagSchedule.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				arraySchedulesOfTalks.add(scheduleOfTalks);
			}
		});
		
		//fecha tag schedules
		tagSchedules.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				dayOfTalks.setArrayOfScheduleOfTalks(arraySchedulesOfTalks);
			}
		});	
		
		//fecha tag day
		tagDay.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				arrayDaysOfTalks.add(dayOfTalks);
			}
		});
		
		//fecha tag days
		tagDays.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				talksProgram.setArrayOfDaysOfTalk(arrayDaysOfTalks);
			}
		});
		
		
		Xml.parse(inputStream, Xml.Encoding.UTF_8, root.getContentHandler());
		
		return talksProgram;
	}
}
