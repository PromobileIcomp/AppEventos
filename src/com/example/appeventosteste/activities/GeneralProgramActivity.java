package com.example.appeventosteste.activities;

import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.SAXException;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.appeventosteste.R;
import com.example.appeventosteste.adapters.ListViewAdapter;
import com.example.appeventosteste.beans.Day;
import com.example.appeventosteste.beans.GeneralProgramWorkshop;
import com.example.appeventosteste.beans.Item;
import com.example.appeventosteste.beans.Schedule;
import com.example.appeventosteste.parses.ParseWSPGeneralProgram;

public class GeneralProgramActivity extends ActionBarActivity implements ActionBar.TabListener {

	private static GeneralProgramWorkshop pg;
	private static Context context;
	private static ArrayList<ArrayList<Item>>arrayMasterDeItens;
	private static FragmentManager fm;
	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a {@link FragmentPagerAdapter}
	 * derivative, which will keep every loaded fragment in memory. If this
	 * becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	private static SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	private static ViewPager mViewPager;
	private static ActionBar actionBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_general_program);

		context = this;
		fm = getSupportFragmentManager();
		// Set up the action bar.
		actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(fm);//modificado

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		//mViewPager.setAdapter(mSectionsPagerAdapter);
		

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		
		
//		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
//					@Override
//					public void onPageSelected(int position) {
//						actionBar.setSelectedNavigationItem(position);
//					}
//				});

//		// For each of the sections in the app, add a tab to the action bar.
//		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
//			// Create a tab with text corresponding to the page title defined by
//			// the adapter. Also specify this Activity object, which implements
//			// the TabListener interface, as the callback (listener) for when
//			// this tab is selected.
//			actionBar.addTab(actionBar.newTab().setText(mSectionsPagerAdapter.getPageTitle(i)).setTabListener(this));
//		}
		
		ParseGeneralProgram();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.general_program, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {
		
		private  ArrayList<ArrayList<Item>> arrayMasterOfItens;
		
		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		public ArrayList<ArrayList<Item>> getArrayMasterOfItens() {
			return arrayMasterOfItens;
		}

		public void setArrayMasterOfItens(ArrayList<ArrayList<Item>> arrayMasterOfItens) {
			this.arrayMasterOfItens = arrayMasterOfItens;
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a PlaceholderFragment (defined as a static inner class
			// below).
			return PlaceholderFragment.newInstance(arrayMasterOfItens.get(position));
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return arrayMasterOfItens.size();//null pointer aqui
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return arrayMasterOfItens.get(position).get(0).getTitle();//null pointer aui
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		
		
		private ArrayList<Item> arrayItens;
		private ListView lv;
		private ListViewAdapter myAdapter;
		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(ArrayList <Item> arrayListItem) {
			PlaceholderFragment fragment = new PlaceholderFragment(arrayListItem);
			return fragment;
		}
		
		public PlaceholderFragment(){}

		public PlaceholderFragment(ArrayList<Item> arrayItens) {
			this.arrayItens = arrayItens;
//			this.myAdapter = new ListViewAdapter(context,arrayItens);
			
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_general_program,container, false);
//			TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//			textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
			//setRetainInstance(true);
			return rootView;
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			setRetainInstance(true);
			lv = (ListView)getView().findViewById(R.id.idListViewGeneralProgram);
			myAdapter = new ListViewAdapter(context,arrayItens);
			lv.setAdapter(myAdapter);
			//myAdapter.notifyDataSetChanged();
			lv.setOnItemClickListener(new OnItemClickListener(){
				@Override
				public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
					// TODO Auto-generated method stub
					Item item = (Item)parent.getAdapter().getItem(position);
					item.starctActivity(context);
				}
			});
			
//			myAdapter.notifyDataSetChanged();
		}
	}
	
	public static ArrayList<ArrayList<Item>> myArrayOfItemsEachDay(){
		ArrayList<ArrayList<Item>> arrayMasterOfItens = new ArrayList<ArrayList<Item>>();
		for(Day dia : pg.getArrayDeDias()){
			ArrayList<Item> arrayItens = new ArrayList<Item>(); 
			arrayItens.add(dia);
			for(Schedule schedule: dia.getArrayDeHorarios()){
				arrayItens.add(schedule);
				for(Item item: schedule.getArrayDeEventos()){
					item.setDateAndSchedule(dia.getData().trim(), schedule.getStart().trim()+"-"+schedule.getEnd().trim());	
					arrayItens.add(item);
				}
			}
			arrayMasterOfItens.add(arrayItens);	
		}
				
		return arrayMasterOfItens;
	}

	
	
	public static void ParseGeneralProgram (){
		new AsyncTask<Void, Void, Void>() {
		
			@Override
			protected void onPostExecute(Void result) {
				super.onPostExecute(result);
				
				arrayMasterDeItens = myArrayOfItemsEachDay();
				mSectionsPagerAdapter.setArrayMasterOfItens(arrayMasterDeItens);;
				mViewPager.setAdapter(mSectionsPagerAdapter);//null pointer aqui
				
				// For each of the sections in the app, add a tab to the action bar.
				for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
					// Create a tab with text corresponding to the page title defined by
					// the adapter. Also specify this Activity object, which implements
					// the TabListener interface, as the callback (listener) for when
					// this tab is selected.
					actionBar.addTab(actionBar.newTab().setText(mSectionsPagerAdapter.getPageTitle(i)).setTabListener((TabListener) context));
				}
				
				mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});
				//myAdapter = new ListViewAdapter(context, myArrayOfItemsEachDay());
				//lv.setAdapter(myAdapter);
				
			}
			
			@Override
			protected Void doInBackground(Void... arg) {
				try {
					pg = ParseWSPGeneralProgram.parse(context,"programacao.xml" );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return null;
			}
		}.execute();
	}
	

}
