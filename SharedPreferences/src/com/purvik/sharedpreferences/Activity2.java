package com.purvik.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends Activity implements OnClickListener{
	
	EditText edtName, edtClass, edtEnrollNo;
	Button btnSave, btnDisplay;
	TextView tvDisplay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_activity);
		
		findViewById();
		
		
		
	}

	private void findViewById() {
	
		edtName = (EditText) findViewById(R.id.edtName);
		edtClass = (EditText) findViewById(R.id.edtClass);
		edtEnrollNo = (EditText) findViewById(R.id.edtEnrollNo);
		
		btnSave = (Button) findViewById(R.id.btnSave);
		btnSave.setOnClickListener(Activity2.this);
		
		btnDisplay = (Button) findViewById(R.id.btnDisplay);
		btnDisplay.setOnClickListener(this);
		
		tvDisplay = (TextView) findViewById(R.id.tvDisplay);
	}

	@Override
	public void onClick(View v) {
		
		SharedPreferences sf;
		Editor editor;
		
		switch (v.getId()) {
		case R.id.btnSave:
			//get the data and stored it to the SharedPreferences
			
			String Name = edtName.getText().toString();
			String Class = edtClass.getText().toString();
			String EnrollNo = edtEnrollNo.getText().toString();
			
			sf = getSharedPreferences("appPreference", MODE_PRIVATE);
			editor = sf.edit();
			editor.putString("NAME", Name);
			editor.putString("CLASS", Class);
			editor.putString("ENROLL_NO", EnrollNo);
			editor.commit();
			
			Toast.makeText(Activity2.this, "Data Saved Successfully", Toast.LENGTH_LONG).show();
			break;
			
		case R.id.btnDisplay:
			//get data from SharedPreferences and Display in the TextView
			sf = getSharedPreferences("appPreference", MODE_PRIVATE);
			String displayString = "Name:\t"+sf.getString("NAME", "Not Stored") +
								"\nClass :\t" + sf.getString("CLASS","Not Stored") +
								"\n Enroll No:\t"+ sf.getString("ENROLL_NO", "Not Stored");
			
			tvDisplay.setText(displayString);
			
			break;

		default:
			
			break;
		}
		
		
	}

}
