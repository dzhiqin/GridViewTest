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
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ActivitySimpleAdapter extends Activity {

	private String texts[]=null;
	private int images[]=null;
	private GridView gridView;
	private SimpleAdapter adapter;
	private String selectedItemText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gridview);
		
		images=new int[]{R.drawable.alligator,R.drawable.bat,R.drawable.lion,R.drawable.monkey,R.drawable.moose,
				R.drawable.tiger,R.drawable.toucan,R.drawable.turkey,R.drawable.turtle,R.drawable.wolf};
		texts=new String[]{"鳄鱼","蝙蝠","狮子","猴子","麋鹿","老虎","犀鸟","火鸡","乌龟","狼"};
		gridView=(GridView)findViewById(R.id.gridview);
		ArrayList<HashMap<String,Object>> listImageItem=new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<images.length;i++){
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("itemImage",images[i]);
			map.put("itemText", texts[i]);
			listImageItem.add(map);
		}
		
		adapter=new SimpleAdapter(this,//SimpleAdapter 关联的运行环境
				listImageItem,//一个Map组成的List，GridView的每个item对应一个Map，每一个map中应该包含所有在from参数中指定的键
				R.layout.grid_item,//一个定义列表项的布局文件ID,包含了在to参数中定义的id
				new String[]{"itemImage","itemText"},//将被添加到map映射上的键名
				new int[]{R.id.itemImage,R.id.itemText}//将绑定数据的视图的Id跟from参数对应
				);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				HashMap<String ,Object> item=(HashMap<String,Object>)parent.getItemAtPosition(position);				
				selectedItemText=(String)item.get("itemText");
				Toast.makeText(ActivitySimpleAdapter.this, selectedItemText, Toast.LENGTH_SHORT).show();
				
			}
			
		});
		gridView.setOnItemLongClickListener(new OnItemLongClickListener(){

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				//另外一种获得item实例的方法是parent.getItemAtPosition(position);	
				HashMap<String,Object> item=(HashMap<String,Object>)parent.getAdapter().getItem(position);				
				Toast.makeText(ActivitySimpleAdapter.this, "LongClick "+item.get("itemText"), Toast.LENGTH_SHORT).show();
				return true;//return false 会取消长按震动
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
