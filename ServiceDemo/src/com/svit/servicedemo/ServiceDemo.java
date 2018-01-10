package com.svit.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

public class ServiceDemo extends Service {
	
	Handler mHandler;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
	Toast.makeText(getBaseContext(), "Service Ceated", Toast.LENGTH_SHORT).show();
	
	mHandler = new Handler();
		super.onCreate();
	}

	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Toast.makeText(getBaseContext(), "Service Destroyed", Toast.LENGTH_SHORT).show();
		super.onDestroy();
	}

}
