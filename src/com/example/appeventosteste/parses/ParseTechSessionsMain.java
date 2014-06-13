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

import com.example.appeventosteste.beans.DayTechSession;
import com.example.appeventosteste.beans.HeadLineTSessions;
import com.example.appeventosteste.beans.ProgramacaoTechSessions;
import com.example.appeventosteste.beans.ScheduleTechSession;

public class ParseTechSessionsMain {
	private static ProgramacaoTechSessions programacaoTechSessions;
	private static ArrayList<DayTechSession> arrayDayTechSessions ;
	private static DayTechSession day;
	private static ArrayList<ScheduleTechSession> arraySchedulesTechSession;
	private static ScheduleTechSession schedule;
	private static ArrayList<HeadLineTSessions> arrayHeadLineTSessions;
	private static HeadLineTSessions headLineTSession;
	private static InputStream inputStream;
	
	public static ProgramacaoTechSessions parse(Context context, String xmlFile) throws IOException, SAXException {
		
		final RootElement root = new RootElement("techsessions");
		
		programacaoTechSessions = new ProgramacaoTechSessions();
		
		inputStream = context.getResources().getAssets().open(xmlFile);
		
		//inicia tag days
		Element days = root.getChild("days");
		days.setStartElementListener(new StartElementListener() {	
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				arrayDayTechSessions = new ArrayList<DayTechSession>();
				
			}
		});
		
			//inicia tag day
			Element tagday = days.getChild("day");
			tagday.setStartElementListener(new StartElementListener() {
				@Override
				public void start(Attributes attributes) {
					// TODO Auto-generated method stub
					day = new DayTechSession();
				}
			});
			
				//inicia e fecha tag date
				tagday.getChild("date").setEndTextElementListener(new EndTextElementListener() {
					@Override
					public void end(String date) {
						// TODO Auto-generated method stub
						day.setDate(date);
					}
				});
			
				//inicia e fecha tag weekday
				tagday.getChild("weekDay").setEndTextElementListener(new EndTextElementListener() {
					@Override
					public void end(String weekDay) {
						// TODO Auto-generated method stub
						day.setWeekDay(weekDay);
					}
				});
				
				//inicia e fecha tag url
				tagday.getChild("url").setEndTextElementListener(new EndTextElementListener() {
					@Override
					public void end(String url) {
						// TODO Auto-generated method stub
						day.setUrl(url);
					}
				});
				
				//inicia tag schedules
				Element schedules = tagday.getChild("schedules");
				schedules.setStartElementListener(new StartElementListener() {
					@Override
					public void start(Attributes attributes) {
						// TODO Auto-generated method stub
						arraySchedulesTechSession = new ArrayList<ScheduleTechSession>();
					}
				});
				
					//inicia tag schedule
					Element tagSchedule = schedules.getChild("schedule");
					tagSchedule.setStartElementListener(new StartElementListener() {
						@Override
						public void start(Attributes attributes) {
							// TODO Auto-generated method stub
							schedule = new ScheduleTechSession();
						}
					});
					
						//inicia e fecha tag start
						tagSchedule.getChild("start").setEndTextElementListener(new EndTextElementListener() {
							@Override
							public void end(String start) {
								// TODO Auto-generated method stub
								schedule.setStartTime(start);
							}
						});
						
						//inicia e fecha tag end
						tagSchedule.getChild("end").setEndTextElementListener(new EndTextElementListener() {
							@Override
							public void end(String end) {
								// TODO Auto-generated method stub
								schedule.setEndTime(end);
								
							}
						});
					
					
						//inicia tag headlines
						Element sessions = tagSchedule.getChild("headlines");
						sessions.setStartElementListener(new StartElementListener() {
							@Override
							public void start(Attributes attributes) {
								// TODO Auto-generated method stub
								arrayHeadLineTSessions = new ArrayList<HeadLineTSessions>();
							}
						});
					
							//inicia tag headline
							Element tagSession = sessions.getChild("headline");
							tagSession.setStartElementListener(new StartElementListener() {
								@Override
								public void start(Attributes attributes) {
									// TODO Auto-generated method stub
									headLineTSession = new HeadLineTSessions();
								}
							});
					
								//inicia e fecha tag title
								tagSession.getChild("title").setEndTextElementListener(new EndTextElementListener() {
									@Override
									public void end(String title) {
										// TODO Auto-generated method stub
										headLineTSession.setTitle(title);
									}
								});
							
								//inicia e fecha tag xmlFile
								tagSession.getChild("xmlFile").setEndTextElementListener(new EndTextElementListener() {
									@Override
									public void end(String xmlFile) {
										// TODO Auto-generated method stub
										headLineTSession.setXmlFile(xmlFile);
									}
								});
								
								//inicia e fecha tag icon
								tagSession.getChild("icon").setEndTextElementListener(new EndTextElementListener() {
									@Override
									public void end(String icon) {
										// TODO Auto-generated method stub
										headLineTSession.setIcon(icon);
									}
								});
							
							//fecha tag headline
							tagSession.setEndElementListener(new EndElementListener() {
								@Override
								public void end() {
									// TODO Auto-generated method stub
									arrayHeadLineTSessions.add(headLineTSession);
								}
							});
					
						//fecha tag headlines
						sessions.setEndElementListener(new EndElementListener() {
							@Override
							public void end() {
								// TODO Auto-generated method stub
								schedule.setArrayHeadLineTSessions(arrayHeadLineTSessions);
							}
						});
					
					//fecha tag schedule
					tagSchedule.setEndElementListener(new EndElementListener() {
						@Override
						public void end() {
							// TODO Auto-generated method stub
							arraySchedulesTechSession.add(schedule);
						}
					});
							
						
				//fecha tag schedules
				schedules.setEndElementListener(new EndElementListener() {
					@Override
					public void end() {
						// TODO Auto-generated method stub
						day.setArraySchedulesTechSession(arraySchedulesTechSession);
					}
				});
							
						
			//fecha tag day
			tagday.setEndElementListener(new EndElementListener() {
				@Override
				public void end() {
					// TODO Auto-generated method stub
					arrayDayTechSessions.add(day);
				}
			});
			
		//fecha tag days
		days.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				programacaoTechSessions.setArrayDaysTechSessions(arrayDayTechSessions);
			}
		});
						
					
		Xml.parse(inputStream, Xml.Encoding.UTF_8, root.getContentHandler());
			
		return programacaoTechSessions;
	}
}
