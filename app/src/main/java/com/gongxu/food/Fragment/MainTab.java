package com.gongxu.food.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.gongxu.food.R;
import com.gongxu.food.activity.SearchResultActivity;
import com.gongxu.food.util.WebServiceUtil;

import java.util.List;

public class MainTab extends Fragment{
	//搜索框实例
	private SearchView searchView;
	private TextView txtShow;
    // List<ShopType> list;
    List<String>  shopTypeList;
    private WebServiceUtil myWebServiceUtil;
    private Spinner spinnerShopType;
	//创建视图载入器实例
		LayoutInflater myInflater;
		@Override
		@Nullable
		public View onCreateView(LayoutInflater inflater,
				@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
			myInflater = inflater;
            myWebServiceUtil = new WebServiceUtil();
            //myContext = getActivity().getApplicationContext();
            View v = null;
            v = init();
            return v;
		}
		
		//初始化视图
		private View init()  {
            //载入布局
            View v = myInflater.inflate(R.layout.layout_seacher, null);

            //获取控件
            txtShow = (TextView) v.findViewById(R.id.txt_show);
            spinnerShopType = (Spinner) v.findViewById(R.id.spinner_shop_type);



            //list= getShopTypeList();
            shopTypeList = myWebServiceUtil.getShopTypeList();

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,shopTypeList);
            spinnerShopType.setAdapter(adapter);
			//创建搜索结果List



			//管理搜索框控件
			searchView = (SearchView) v.findViewById(R.id.seacher_shop);
			//取消默认缩小为图标
			searchView.setIconifiedByDefault(false);
			//取消显示搜索提交按钮
			searchView.setSubmitButtonEnabled(false);
			
			//设置搜索框监听器
			searchView.setOnQueryTextListener(new OnQueryTextListener() {
				
				@Override
				public boolean onQueryTextSubmit(String query) {
					Toast.makeText(getActivity(), "点击了搜索！", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(getActivity(), SearchResultActivity.class);
					intent.putExtra("keywords",query);
					intent.putExtra("type","");
					startActivity(intent);


					return false;
				}
				
				@Override
				public boolean onQueryTextChange(String newText) {
					// TODO Auto-generated method stub
				//	Toast.makeText(getActivity(),"搜索内容变化了！",Toast.LENGTH_SHORT).show();
					return false;
				}
			});
			//--------搜索监听End


			return v;
		}

}
