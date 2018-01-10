package com.svit.broadcastreceiver;

import com.example.broadcastreceiver.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class MainAct extends Activity {
	
	ToggleButton toggleWifiState;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Object Reference
        toggleWifiState =  (ToggleButton)findViewById(R.id.toggleWifiState);
        
        //set OnClick Listener
        toggleWifiState.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				//When Checked
				if(toggleWifiState.isChecked()){
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

}
