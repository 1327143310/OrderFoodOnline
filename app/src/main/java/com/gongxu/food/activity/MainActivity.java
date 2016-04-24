package com.gongxu.food.activity;

import com.gongxu.food.Fragment.PersonalCenter;
import com.gongxu.food.Fragment.MainTab;
import com.gongxu.food.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;



public class MainActivity extends FragmentActivity {
	
	//定义FragmentTabHost
	private FragmentTabHost fragmentTabHost;
	
	//定义一个布局
	private LayoutInflater layoutInflater;
	
	//定义数组来存放Fragment页面
	private Class fragmentArray[] = {MainTab.class,PersonalCenter.class};
	
	//定义数组来存放按钮图片
	private int imageViewArray[] = {R.drawable.tab_home_btn,R.drawable.tab_message_btn};
	
	//定义tab选项卡的文字
	private String tab_labels[] = {"找美食","个人中心"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main_tab);
		
		initView();
	}
	
	//初始化视图
	private void initView() {
		//初始化layoutInflater
		layoutInflater = LayoutInflater.from(this);
		
		//实例化TabHost对象
		fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		fragmentTabHost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);
		
		//获取Fragment的个数
		int count = fragmentArray.length;
		
		//为每个选项卡设置图标  文字等
		for (int i = 0; i < count; i++) {
			//为每一个选项卡设置图标 、文字、 内容等
			TabSpec tabSpec = fragmentTabHost.newTabSpec(tab_labels[i]).setIndicator(getItemView(i));
			//将tab按钮添加进tab选项卡中
			fragmentTabHost.addTab(tabSpec,fragmentArray[i],null);
			//设置该选项卡按钮的背景
			fragmentTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
		}
	}
	
	
	//设置单个选项卡的图标、文字
	private View getItemView(int index) {
		View view = layoutInflater.inflate(R.layout.tab_item_view, null);
		
		//设置图标
		ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
		imageView.setImageResource(imageViewArray[index]);
		
		//设置文字标签
		TextView textView = (TextView) view.findViewById(R.id.txt_lable);
		textView.setText(tab_labels[index]);
		
		return view;
		
	}

	

}
