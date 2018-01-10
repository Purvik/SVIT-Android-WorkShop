package com.purvik.sharedpreferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	TextView detailsPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
    
    public void loadPreference(View v) {
    	Log.d("TAG", "-- START --");
    	
    	// Start PreferenceActivity
    	startActivity(new Intent(this, AppPreferences.class));
		
    	Log.d("TAG", "-- END --");
	}
    
    
    public void getDisplayPreferences(View v) {
    	
        detailsPreferences = (TextView)findViewById(R.id.detailsPref);
    	
        
        // Get the Instance
    	SharedPreferences sf1 = getSharedPreferences("appPreferences", MODE_PRIVATE); 
    			//PreferenceManager.getDefaultSharedPreferences(this);
    	Toast.makeText(getApplicationContext(), sf1.getBoolean("checkboxPref", false) + "\n" + sf1.getString("edtPref", "")+ "\n" + sf1.getString("ringtonePref", ""),Toast.LENGTH_LONG).show();


// sf1.getString(KEY);		
    	
    	// Set the Text for the Display
    	detailsPreferences.setText(sf1.getBoolean("checkboxPref", false) + "\n" + sf1.getString("edtPref", "")+ "\n" + sf1.getString("ringtonePref", ""));
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
