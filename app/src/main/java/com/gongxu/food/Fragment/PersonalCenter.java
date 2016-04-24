package com.gongxu.food.Fragment;

import com.gongxu.food.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PersonalCenter extends Fragment{

	//创建视图载入器实例
	LayoutInflater inflater;
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.layout_personalcenter, null);
	}



	

}
