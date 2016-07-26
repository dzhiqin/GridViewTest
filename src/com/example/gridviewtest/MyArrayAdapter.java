package com.example.gridviewtest;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyArrayAdapter extends ArrayAdapter<Animal>{

	private int layoutId;
	/**
	 * 自定义的ArrayAdapter
	 * @param context 
	 * @param resourceId 自定义列表项的布局Id
	 * @param objects 用于显示的资源
	 */
	public MyArrayAdapter(Context context,int resourceId,List<Animal> objects){
		super(context,resourceId,objects);
		layoutId=resourceId;
	}
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		View view;
		ViewHolder viewHolder;
		Animal animal=(Animal)getItem(position);
		if(convertView==null){
			view=LayoutInflater.from(getContext()).inflate(layoutId,null);
			viewHolder=new ViewHolder();
			viewHolder.imageView=(ImageView)view.findViewById(R.id.itemImage);
			viewHolder.textView=(TextView)view.findViewById(R.id.itemText);
			view.setTag(viewHolder);
		}else{
			view=convertView;
			viewHolder=(ViewHolder)view.getTag();
		}
		viewHolder.imageView.setImageResource(animal.getId());
		viewHolder.textView.setText(animal.getName());
		return view;
	}

	class ViewHolder{
		ImageView imageView;
		TextView textView;
	}
}
