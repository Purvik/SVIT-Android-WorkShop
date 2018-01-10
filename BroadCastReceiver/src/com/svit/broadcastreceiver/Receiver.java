package com.svit.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

	WifiManager wManager;
	int i = 0;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		wManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
		
		if (intent.getAction().equals("com.purvik.SEND_BROADCAST_1")) {
			
			Toast.makeText(context, "Receiver Received: BroadCast_1", Toast.LENGTH_SHORT).show();
			
			
			if(!wManager.isWifiEnabled()){
				
				wManager.setWifiEnabled(true);
				Toast.makeText(context, "Wifi Enabled", Toast.LENGTH_SHORT).show();
			}
			
			
		}else if(intent.getAction().equals("com.purvik.SEND_BROADCAST_2")){
			
			//Toast.makeText(context, "Receiver Received: BroadCast_2", Toast.LENGTH_SHORT).show();
			
			if(wManager.isWifiEnabled()){
				wManager.setWifiEnabled(false);
				Toast.makeText(context, "Wifi Disabled", Toast.LENGTH_SHORT).show();
				
			}
		}else if(intent.getAction().equals("android.intent.action.AIRPLANE_MODE")){
			
			Toast.makeText(context, "AirPlane Mode Toast", Toast.LENGTH_SHORT).show();

		}else{
			
			
		}
		

	}

}
