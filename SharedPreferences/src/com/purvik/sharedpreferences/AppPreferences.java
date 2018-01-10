package com.purvik.sharedpreferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class AppPreferences extends PreferenceActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		@SuppressWarnings("deprecation")
		PreferenceManager preManager = getPreferenceManager();	// get an instance of PreferenceManager	
		preManager.setSharedPreferencesName("appPreferences");	// Give Specific Name to the Preferences Files
		
		
		//Load From Preference File
//		addContentView(getLayoutInflater().inflate(R.xml.my_pref, null), null);
		addPreferencesFromResource(R.xml.my_pref);	// Load the Preferences From Resources
		
	}

}
