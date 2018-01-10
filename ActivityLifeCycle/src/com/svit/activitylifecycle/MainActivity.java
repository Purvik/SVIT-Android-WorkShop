package com.svit.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getBaseContext(), "Activity Created", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
    }
    
    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	
    	Toast.makeText(getBaseContext(), "Activity Started", Toast.LENGTH_SHORT).show();
    	super.onStart();
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	Toast.makeText(getBaseContext(), "Activity Resume", Toast.LENGTH_SHORT).show();
    	super.onResume();
    }
    
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	Toast.makeText(getBaseContext(), "Activity Paused ", Toast.LENGTH_SHORT).show();
    	super.onPause();
    }
    
    @Override
    protected void onStop() {
    	// TODO Auto-generated method stub
    	Toast.makeText(getBaseContext(), "Activity Stopped", Toast.LENGTH_SHORT).show();
    	super.onStop();
    }
    
    @Override
    protected void onRestart() {
    	// TODO Auto-generated method stub
    	Toast.makeText(getBaseContext(), "Activity Re-Started", Toast.LENGTH_SHORT).show();
    	super.onRestart();
    }
    
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	Toast.makeText(getBaseContext(), "Activity Destroyed", Toast.LENGTH_SHORT).show();
    	super.onDestroy();
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
