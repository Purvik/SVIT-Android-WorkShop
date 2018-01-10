package com.purvik.streammusic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainHome extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_home);
	}
	
	public void playMusic(View v) {
		Log.i("Play Music", "Music CLICKED");
		Intent i = new Intent(this, MusicActivity.class);
		startActivity(i);
	}
	
	public void playMovie(View v) {
		Log.i("Play Movie", "MOVIE CLICKED");
		Intent i = new Intent(this, MovieHome.class);
		startActivity(i);
	}

}
