package com.svit.broadcastdemo;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ToggleButton;


public class MainActivity extends Activity {
	
	ToggleButton toggleWifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
      //Object Reference
        toggleWifi =  (ToggleButton)findViewById(R.id.toggleWifiState);
        
        //set OnClick Listener
        toggleWifi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if (toggleWifi.isChecked()) {
							
					//Enable Wifi via BroadCast
					
					Intent i = new Intent("com.purvik.SEND_BROADCAST_1");
					sendBroadcast(i);
					
					
				}else{
					
					//When Unchecked
					//Disable Wifi via BroadCast
					Intent i = new Intent("com.purvik.SEND_BROADCAST_2");
					sendBroadcast(i);
					
				}
				
				
				
			}
		});
        
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
