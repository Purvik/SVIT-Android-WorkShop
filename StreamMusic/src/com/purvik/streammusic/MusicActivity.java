package com.purvik.streammusic;

import java.io.IOException;

import android.support.v7.app.ActionBarActivity;
import android.app.ProgressDialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;

public class MusicActivity extends ActionBarActivity implements OnClickListener, OnPreparedListener, OnErrorListener, OnCompletionListener{

	MediaPlayer mp = new MediaPlayer();
	ProgressDialog pd;
	Button btnPlay;
	Integer fTime = 0;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.music_home);
		
		btnPlay = (Button)findViewById(R.id.btn_Play);
		final Button btnStop = (Button)findViewById(R.id.btn_Stop);
		btnPlay.setOnClickListener(this);
		btnStop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if(mp.isPlaying())
				{
					mp.stop();	Log.i("STOP", "MP - STOP");
					
					fTime = 0;
					btnPlay.setText("Play");
					mp.reset(); Log.i("RELEASE", "MP - RESET");
				}
				else{
					Toast.makeText(getApplicationContext(), "Play First", Toast.LENGTH_SHORT).show();
				}
				
				
				/*if((btnStop.getText()).equals("Pause"))
				{
					mp.pause();
					btnStop.setText("Resume");
				}
				else if((btnStop.getText()).equals("Resume"))
				{
					mp.start();
					btnStop.setText("Pause");
				}
				else
				{
					Toast.makeText(getApplicationContext(), "Nothing Shown", Toast.LENGTH_SHORT).show();
					
				}
			*/
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

	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub
		pd.dismiss();
		Toast.makeText(getApplicationContext(), "Completed", Toast.LENGTH_LONG).show();
		
	}

	@Override
	public boolean onError(MediaPlayer mp, int what, int extra) {
		// TODO Auto-generated method stub
		pd.dismiss();
		return false;
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		// TODO Auto-generated method stub
		pd.setMessage("Playing...");
		Log.i("START", " MP - Start");
		mp.start();
		
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if((btnPlay.getText()).equals("Play") || (btnPlay.getText()).equals("Resume"))
		{
			if(fTime == 0)
			{
				Log.i("Play", "MP - Play");
				fTime = 1;
				try {
					
					pd = new ProgressDialog(this);
					pd.setMessage("Buffering...");
					pd.show();
//					mp = new MediaPlayer();
					mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
					mp.setOnPreparedListener(this);
					mp.setOnErrorListener(this);
					
					mp.setDataSource("http://media.djmazadownload.com/music/indian_movies/Hamari%20Adhuri%20Kahani%20(2015)/01%20-%20HAK%20-%20Hamari%20Adhuri%20Kahani%20[DJMaza.Info].mp3");
					
					mp.prepareAsync();
					mp.setOnCompletionListener(this);
				} catch (IllegalArgumentException | SecurityException
						| IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else{
				Log.i("Resume", "MP - Resume");
				mp.start();
			}
			
			btnPlay.setText("Pause");
		}
		else{
			if(fTime == 0)
			{
				Toast.makeText(getApplicationContext(), "Play First", Toast.LENGTH_SHORT).show();
				
			}
			else{
				Log.i("PAUSE", "MP - Pause");
				mp.pause();
			}
			
			btnPlay.setText("Resume");
		}
			
		
	}
}
