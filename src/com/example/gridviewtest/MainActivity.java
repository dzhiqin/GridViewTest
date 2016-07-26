package com.example.gridviewtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	private Button simpleAdapterBtn;
	private Button baseAdapterBtn;
	private Button arrayAdapterBtn;
	private TextView getResourceTV;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		simpleAdapterBtn=(Button)findViewById(R.id.simpleadapter_btn);
		baseAdapterBtn=(Button)findViewById(R.id.baseadapter_btn);
		arrayAdapterBtn=(Button)findViewById(R.id.arrayadapter_btn);
		getResourceTV=(TextView)findViewById(R.id.get_resource);
		getResourceTV.setText("»ñÈ¡Ô´Âë£ºhttps://github.com/dzhiqin/GridViewTest.git");
		simpleAdapterBtn.setOnClickListener(this);
		baseAdapterBtn.setOnClickListener(this);
		arrayAdapterBtn.setOnClickListener(this);
		intent=new Intent();
	}
	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
		case R.id.simpleadapter_btn:
			intent.setClass(MainActivity.this, ActivitySimpleAdapter.class);
			break;
		case R.id.baseadapter_btn:
			intent.setClass(MainActivity.this, ActivityBaseAdapter.class);
			break;
		case R.id.arrayadapter_btn:
			intent.setClass(MainActivity.this, ActivityArrayAdapter.class);
			break;
        default:
        	break;
		}
		startActivity(intent);
	}

}
