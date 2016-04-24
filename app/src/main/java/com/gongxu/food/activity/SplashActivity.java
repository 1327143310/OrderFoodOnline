package com.gongxu.food.activity;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.gongxu.food.R;

public class SplashActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_splash);
		init();
		
	}
	
	protected void init()
	{	
		//隐藏ActionBar
		ActionBar actionBar ;
		actionBar = getActionBar();
		actionBar.hide();
		
		LayoutInflater inflater = LayoutInflater.from(this);
		
		TextView txt_version = (TextView) findViewById(R.id.txt_version);
		
		String version;
		version = getVersion();
		txt_version.setText("version "+version);
		
		new Thread()
		{
			public void run() {
				try {
					sleep(4000);
					Intent intent = new Intent(SplashActivity.this,MainActivity.class);
					startActivity(intent);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		}.start();
		
		
	}

	
	//获取版本号
	public String getVersion()
	{
		String version;  //储存版本号
		PackageManager manager = this.getPackageManager();
		PackageInfo info = null;
		try {
			info = manager.getPackageInfo(getPackageName(), 0);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		version = info.versionName;
		return version;
	}
}
