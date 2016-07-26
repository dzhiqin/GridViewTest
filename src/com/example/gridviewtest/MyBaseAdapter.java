package com.example.gridviewtest;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyBaseAdapter extends BaseAdapter{

	private Context context;
	private int[] images=new int[]{R.drawable.alligator,R.drawable.bat,R.drawable.lion,R.drawable.monkey,R.drawable.moose,
			R.drawable.tiger,R.drawable.toucan,R.drawable.turkey,R.drawable.turtle,R.drawable.wolf};
	public MyBaseAdapter(Context c){
		context=c;
	}

	@Override
	public int getCount() {
		// ��ȡͼƬ�ĸ���
		return images.length;
	}

	@Override
	public Object getItem(int position) {
		// ��ȡͼƬ��λ��
		return position;
	}

	@Override
	public long getItemId(int position) {
		// ��ȡͼƬid
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO �Զ����ɵķ������
		ImageView imageView;
		if(convertView==null){
			/**
			 * û��Ϊ�б����һ��XML�����ļ�����Ϊ����ֻ����һ��imageview��Ҳ������grid_item������
			 * ��ImageView������Դ
			 */
			imageView=new ImageView(context);
			//���ò���ͼƬ120*120��ʾ
			imageView.setLayoutParams(new GridView.LayoutParams(120,120));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
			
		}else{
			imageView=(ImageView)convertView;
		}
		imageView.setImageResource(images[position]);
		return imageView;
	}

}
