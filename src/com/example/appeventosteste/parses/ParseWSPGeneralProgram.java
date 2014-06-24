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

import com.example.appeventosteste.beans.Day;
import com.example.appeventosteste.beans.Item;
import com.example.appeventosteste.beans.Label;
import com.example.appeventosteste.beans.GeneralProgramWorkshop;
import com.example.appeventosteste.beans.Schedule;
import com.example.appeventosteste.beans.TSession;
import com.example.appeventosteste.beans.TSessions;
import com.example.appeventosteste.beans.Talk;
import com.example.appeventosteste.beans.Talks;

public class ParseWSPGeneralProgram {
	
	private static GeneralProgramWorkshop programacaoGeral;
	private static Day dia;
	private static Schedule horario;
	private static Label informacao;
	private static Talk palestra;
	private static TSession sessao;
	private static TSessions conjsessoes;
	private static Talks conjpalestras;;
	private static ArrayList<Item> arrayDeItens;
	private static ArrayList<Day> arrayDeDias;
	private static ArrayList<Schedule> arrayDeHorarios;
	private static InputStream inputStream;
	
	public static GeneralProgramWorkshop  parse(Context context, String xmlFile) throws IOException, SAXException {
		
		programacaoGeral = new GeneralProgramWorkshop();
		final RootElement root = new RootElement("scheduleofevents");
        
		
		//Log.e("StringXmlfile",xmlFile);
		inputStream = context.getResources().getAssets().open(xmlFile);
				
		//inicia e fecha tag url
		root.getChild("url").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String url) {
				// TODO Auto-generated method stub
				programacaoGeral.setUrl(url);
			}
		});
		
		//inicia tag days
		Element tagDays = root.getChild("days");
		tagDays.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				// TODO Auto-generated method stub
				arrayDeDias = new ArrayList<Day>();//fata fechar essa tag
			}
		});
		
			//inicia tag day
			Element tagDay = tagDays.getChild("day");
			tagDay.setStartElementListener(new StartElementListener() {
				@Override
				public void start(Attributes attributes) {
					// TODO Auto-generated method stub
					dia = new Day();//falta fechar essa tag
				}
			});
				
				//inicia fecha tag date
				tagDay.getChild("date").setEndTextElementListener(new EndTextElementListener() {
					@Override
					public void end(String date) {
						// TODO Auto-generated method stub
						dia.setData(date);
					}
				});
			
				
				//inicia fecha tag weekday
				tagDay.getChild("weekday").setEndTextElementListener(new EndTextElementListener() {
					@Override
					public void end(String weekday) {
						// TODO Auto-generated method stub
						dia.setDiaDaSemana(weekday);
					}
				});
				//inicia tag schedules
				Element tagSchedules = tagDay.getChild("schedules");
				tagSchedules.setStartElementListener(new StartElementListener() {
					@Override
					public void start(Attributes attributes) {
						// TODO Auto-generated method stub
						arrayDeHorarios = new ArrayList<Schedule>();//fata fechar essa tag
					}
				});
					
					//inicia tag Schedule
					Element tagSchedule = tagSchedules.getChild("schedule");
					
					tagSchedule.setStartElementListener(new StartElementListener() {
						@Override
						public void start(Attributes attributes) {
							// TODO Auto-generated method stub
							horario = new Schedule();
						}
					});
					
					tagSchedule.getChild("start").setEndTextElementListener(new EndTextElementListener() {
						@Override
						public void end(String body) {
							// TODO Auto-generated method stub
							horario.setStart(body);
						}
					});
					
					tagSchedule.getChild("end").setEndTextElementListener(new EndTextElementListener() {
						@Override
						public void end(String body) {
							// TODO Auto-generated method stub
							horario.setEnd(body);
						}
					});
					
						//inicia tag events
						Element tagEvents = tagSchedule.getChild("events");
						tagEvents.setStartElementListener(new StartElementListener() {
							@Override
							public void start(Attributes attributes) {
								// TODO Auto-generated method stub
								//aqui deveria instanciar algum array de algum item?
								arrayDeItens = new ArrayList<Item>();
							}
						});	
							// tag de informacao
							Element tagInformacao = tagEvents.getChild("informacao");
							if(!tagInformacao.equals(null)){
								tagInformacao.setStartElementListener(new StartElementListener() {
									@Override
									public void start(Attributes attributes) {
										// TODO Auto-generated method stub
										informacao = new Label();
									}
								});
								
								tagInformacao.getChild("title").setEndTextElementListener(new EndTextElementListener() {
									@Override
									public void end(String body) {
										// TODO Auto-generated method stub
										informacao.setTitle(body);
									}
								});
								
								tagInformacao.getChild("icon").setEndTextElementListener(new EndTextElementListener() {
									@Override
									public void end(String body) {
										// TODO Auto-generated method stub
										informacao.setIcon(body);
									}
								});
								
								tagInformacao.setEndElementListener(new EndElementListener() {
									@Override
									public void end() {
										// TODO Auto-generated method stub
										arrayDeItens.add(informacao);
									}
								});
							}
							
							// tag de palestra
							Element tagPalestra = tagEvents.getChild("palestra");
							if(!tagPalestra.equals(null)){
								tagPalestra.setStartElementListener(new StartElementListener() {
									@Override
									public void start(Attributes attributes) {
										// TODO Auto-generated method stub
										palestra = new Talk();
									}
								});
								//	
								tagPalestra.getChild("title").setEndTextElementListener(new EndTextElementListener() {
									@Override
									public void end(String body) {
										// TODO Auto-generated method stub
										palestra.setTitle(body);
									}
								});
								
								tagPalestra.getChild("icon").setEndTextElementListener(new EndTextElementListener() {
									@Override
									public void end(String body) {
										// TODO Auto-generated method stub
										palestra.setIcon(body);//tem que ajeitar isso!!!!
									}
								});
								
								tagPalestra.getChild("xmlfile").setEndTextElementListener(new EndTextElementListener() {
									@Override
									public void end(String body) {
										// TODO Auto-generated method stub
										palestra.setXmlFile(body);
									}
								});
								
								tagPalestra.setEndElementListener(new EndElementListener() {
									@Override
									public void end() {
										// TODO Auto-generated method stub
										arrayDeItens.add(palestra);
									}
								});
							}
							// tag de sessao tecnica
							Element tagSessaoTecninca = tagEvents.getChild("sessaotecnica");
							if(!tagSessaoTecninca.equals(null)){
								tagSessaoTecninca.setStartElementListener(new StartElementListener() {
									@Override
									public void start(Attributes attributes) {
										// TODO Auto-generated method stub
										sessao = new TSession();
									}
								});
								
								tagSessaoTecninca.getChild("title").setEndTextElementListener(new EndTextElementListener() {
									@Override
									public void end(String body) {
										// TODO Auto-generated method stub
										sessao.setTitle(body);
									}
								});
								
								tagSessaoTecninca.getChild("icon").setEndTextElementListener(new EndTextElementListener() {
									@Override
									public void end(String body) {
										// TODO Auto-generated method stub
										sessao.setIcon(body);
									}
								});
								
								tagSessaoTecninca.getChild("xmlfile").setEndTextElementListener(new EndTextElementListener() {
									@Override
									public void end(String body) {
										// TODO Auto-generated method stub
										sessao.setXmlFile(body);
									}
								});
								//
								tagSessaoTecninca.setEndElementListener(new EndElementListener() {
									@Override
									public void end() {
										// TODO Auto-generated method stub
										arrayDeItens.add(sessao);
									}
								});
							}
							
							// tag de conjunto de sessoes
							Element tagConjutoDeSessoes = tagEvents.getChild("conjuntodesessoes");
							if(!tagConjutoDeSessoes.equals(null)){
								tagConjutoDeSessoes.setStartElementListener(new StartElementListener() {
									@Override
									public void start(Attributes attributes) {
										// TODO Auto-generated method stub
										conjsessoes = new TSessions();
									}
								});
								
								tagConjutoDeSessoes.getChild("title").setEndTextElementListener(new EndTextElementListener() {
									@Override
									public void end(String body) {
										conjsessoes.setTitle(body);
									}
								});
								
								//inicia e fecha tag end
								tagConjutoDeSessoes.getChild("icon").setEndTextElementListener(new EndTextElementListener() {
									@Override
									public void end(String body) {
										conjsessoes.setIcon(body);
									}
								});
								
								tagConjutoDeSessoes.getChild("xmlfile").setEndTextElementListener(new EndTextElementListener() {
									@Override
									public void end(String body) {
										conjsessoes.setXmlFile(body);
									}
								});
								tagConjutoDeSessoes.setEndElementListener(new EndElementListener() {
									@Override
									public void end() {
										// TODO Auto-generated method stub
										arrayDeItens.add(conjsessoes);
									}
								});
							}
							
							// tag de conjunto de palestras
							Element tagConjutoDePalestras = tagEvents.getChild("conjuntodepalestras");
							if(!tagConjutoDePalestras.equals(null)){
								tagConjutoDePalestras.setStartElementListener(new StartElementListener() {
									@Override
									public void start(Attributes attributes) {
										// TODO Auto-generated method stub
										conjpalestras = new Talks();
									}
								});
								
								tagConjutoDePalestras.getChild("title").setEndTextElementListener(new EndTextElementListener() {
									@Override
									public void end(String body) {
										conjpalestras.setTitle(body);
									}
								});
								
								//inicia e fecha tag end
								tagConjutoDePalestras.getChild("icon").setEndTextElementListener(new EndTextElementListener() {
									@Override
									public void end(String body) {
										conjpalestras.setIcon(body);
									}
								});
								
								tagConjutoDePalestras.getChild("xmlfile").setEndTextElementListener(new EndTextElementListener() {
									@Override
									public void end(String body) {
										conjpalestras.setXmlFile(body);
									}
								});
								tagConjutoDePalestras.setEndElementListener(new EndElementListener() {
									@Override
									public void end() {
										// TODO Auto-generated method stub
										arrayDeItens.add(conjpalestras);
									}
								});
							}
					
						//fecha tag de eventos (events)	
						tagEvents.setEndElementListener(new EndElementListener() {
							@Override
							public void end() {
								// TODO Auto-generated method stub
								horario.setArrayDeEventos(arrayDeItens);
							}
						});
						//fecha tag de horarios (schedule)	
					tagSchedule.setEndElementListener(new EndElementListener() {
						@Override
						public void end() {
							// TODO Auto-generated method stub
							arrayDeHorarios.add(horario);
						}
					});
				//fecha tag de horarios de um dia (schedules)	
				tagSchedules.setEndElementListener(new EndElementListener() {
					@Override
					public void end() {
						// TODO Auto-generated method stub
						dia.setArrayDeHorarios(arrayDeHorarios);
					}
				});
			//fecha tag de um dia (day)	
			tagDay.setEndElementListener(new EndElementListener() {
				@Override
				public void end() {
					// TODO Auto-generated method stub
					arrayDeDias.add(dia);
				}
			});
		//fecha tag do conjunto de dias (days)
		tagDays.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				// TODO Auto-generated method stub
				programacaoGeral.setArrayDeDias(arrayDeDias);
			}
		});
					
		Xml.parse(inputStream, Xml.Encoding.UTF_8, root.getContentHandler());
			
		return programacaoGeral;
	}
}
