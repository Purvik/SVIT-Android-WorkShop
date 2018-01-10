package com.svit.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondAct extends Activity {
	
	Intent i1 ;
	TextView tv;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		tv = (TextView) findViewById(R.id.tvName);
		
		
		i1 = getIntent();
		String str = "";
		str += " " +i1.getStringExtra("uNAME");
		
		str += " " + i1.getStringExtra("uPWD");
		
		tv.setText(str);
		
		
		
	}

}
