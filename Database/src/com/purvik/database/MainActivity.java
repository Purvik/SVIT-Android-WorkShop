package com.purvik.database;

import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	EditText edt_name, edt_phn_no;
	TextView tv_List;

	
	DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	db = new DBHandler(this);
    	
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    
    public void addContact(View v) {
    	
    	edt_name = (EditText)findViewById(R.id.edt_Name);
    	edt_phn_no = (EditText)findViewById(R.id.edt_Phone_No);
    	
    	String name = edt_name.getText().toString();
    	String phn_no = edt_phn_no.getText().toString();
    	boolean check = validFields(name, phn_no);
    	
    	if(!check){
    		
    		Toast.makeText(getApplicationContext(), "Provide Appropriate Fields", Toast.LENGTH_SHORT).show();
    		
    	}else{
    		
    		db.addContact(new Contact(name, phn_no));
    		Toast.makeText(getApplicationContext(), "Contact Addes", Toast.LENGTH_LONG).show();
    			
    	}
	}
    
    
    public void showList(View v) {
		
    	tv_List = (TextView) findViewById(R.id.tvList);
    //	List<Contact> contacts = 
    	
    	
	}
    

    private boolean validFields(String name2, String phn_no2) {
		// TODO Auto-generated method stub
		
    	if(name2 != "" && (phn_no2.length() >= 10)){
    		
    		return true;
    		
    	}
    	else{
    		
    		return false;
    	}
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
