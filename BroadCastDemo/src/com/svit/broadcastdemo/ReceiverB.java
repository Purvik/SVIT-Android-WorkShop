package com.svit.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class ReceiverB extends BroadcastReceiver {
	
	
	WifiManager wManager;

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		wManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);

		
		if(intent.getAction().equalsIgnoreCase("com.purvik.SEND_BROADCAST_1")){
			
			
			if (!wManager.isWifiEnabled()) {
				
				wManager.setWifiEnabled(true);
				
			}
			
			Toast.makeText(context, "BroadCast_1 -- Wifi ON--", Toast.LENGTH_LONG).show();
			
			
		}
		else if(intent.getAction().equalsIgnoreCase("com.purvik.SEND_BROADCAST_2")){
			
				if (wManager.isWifiEnabled()) {
				
				wManager.setWifiEnabled(false);
				
			}
			
			Toast.makeText(context, "BroadCast_2-- Wifi Off --", Toast.LENGTH_LONG).show();
			
		}else if(intent.getAction().equalsIgnoreCase("android.provider.Telephony.SMS_RECEIVED")){
			
			Toast.makeText(context, "Message Received", Toast.LENGTH_SHORT).show();
		}

	}

}
