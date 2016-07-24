package com.example.gridviewtest;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String texts[]=null;
	private int images[]=null;
	private GridView gridView;
	private SimpleAdapter adapter;
	private String selectedItemText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		images=new int[]{R.drawable.alligator,R.drawable.bat,R.drawable.lion,R.drawable.monkey,R.drawable.moose,
				R.drawable.tiger,R.drawable.toucan,R.drawable.turkey,R.drawable.turtle,R.drawable.wolf};
		texts=new String[]{"öùÓã","òùòð","Ê¨×Ó","ºï×Ó","÷çÂ¹","ÀÏ»¢","Ï¬Äñ","»ð¼¦","ÎÚ¹ê","ÀÇ"};
		gridView=(GridView)findViewById(R.id.gridview);
		ArrayList<HashMap<String,Object>> listImageItem=new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<images.length;i++){
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("itemImage",images[i]);
			map.put("itemText", texts[i]);
			listImageItem.add(map);
		}
		
		adapter=new SimpleAdapter(this,
				listImageItem,//
				R.layout.grid_item,//
				new String[]{"itemImage","itemText"},//
				new int[]{R.id.itemImage,R.id.itemText}//
				);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				HashMap<String ,Object> item=(HashMap<String,Object>)parent.getItemAtPosition(position);
				selectedItemText=(String)item.get("itemText");
				Toast.makeText(MainActivity.this, selectedItemText, Toast.LENGTH_SHORT).show();
				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
}
