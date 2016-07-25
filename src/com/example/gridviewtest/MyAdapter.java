package com.example.gridviewtest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyAdapter extends BaseAdapter{

	private Context context;
	private int[] images=new int[]{R.drawable.alligator,R.drawable.bat,R.drawable.lion,R.drawable.monkey,R.drawable.moose,
			R.drawable.tiger,R.drawable.toucan,R.drawable.turkey,R.drawable.turtle,R.drawable.wolf};
	public MyAdapter(Context c){
		context=c;
	}
	@Override
	public int getCount() {
		// 获取图片的个数
		return images.length;
	}

	@Override
	public Object getItem(int position) {
		// 获取图片的位置
		return position;
	}

	@Override
	public long getItemId(int position) {
		// 获取图片id
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO 自动生成的方法存根
		ImageView imageView;
		if(convertView==null){
			//给ImageView设置资源
			imageView=new ImageView(context);
			//设置布局图片120*120显示
			imageView.setLayoutParams(new GridView.LayoutParams(85,85));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
			
		}else{
			imageView=(ImageView)convertView;
		}
		imageView.setImageResource(images[position]);
		return imageView;
	}

}
