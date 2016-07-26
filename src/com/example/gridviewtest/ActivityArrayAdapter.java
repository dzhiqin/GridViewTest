package com.example.gridviewtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class ActivityArrayAdapter extends Activity {

	private MyArrayAdapter adapter;
	private GridView gridView;
	private ListView listView;
	private List<Animal> myList;
	private Animal animal;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gridview);
		gridView=(GridView)findViewById(R.id.gridview);
		myList=new ArrayList<Animal>();//myList记得要实例化，否则会出现NPE
		adapter=new MyArrayAdapter(this,R.layout.grid_item,getDatas());
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				animal=(Animal)parent.getItemAtPosition(position);
				Toast.makeText(ActivityArrayAdapter.this, ""+(String)animal.getName(), Toast.LENGTH_SHORT).show();
				
			}
			
		});
		gridView.setOnItemLongClickListener(new OnItemLongClickListener(){

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				animal=(Animal)parent.getItemAtPosition(position);
				Toast.makeText(ActivityArrayAdapter.this, "LongClick "+(String)animal.getName(), Toast.LENGTH_SHORT).show();
				return true;
			}
			
		});
	}
	private List<Animal> getDatas() {
		
		myList.add(new Animal("alligator",R.drawable.alligator));
		myList.add(new Animal("bat",R.drawable.bat));
		myList.add(new Animal("lion",R.drawable.lion));
		myList.add(new Animal("monkey",R.drawable.monkey));
		myList.add(new Animal("moose",R.drawable.moose));
		myList.add(new Animal("tiger",R.drawable.tiger));
		myList.add(new Animal("toucan",R.drawable.toucan));
		myList.add(new Animal("turkey",R.drawable.turkey));
		myList.add(new Animal("turtle",R.drawable.turtle));
		myList.add(new Animal("wolf",R.drawable.wolf));
		return myList;
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
