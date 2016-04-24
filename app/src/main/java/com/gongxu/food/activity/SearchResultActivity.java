package com.gongxu.food.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.gongxu.food.R;

public class SearchResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result);

        init();
    }

    public  void init(){
        Intent intent = getIntent();
        String keywords = intent.getStringExtra("keyWords");
        String type = intent.getStringExtra("type");
    }
}
