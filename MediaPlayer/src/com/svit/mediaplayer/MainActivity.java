package com.svit.mediaplayer;


import java.io.IOException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	//--------------1111----------------declare Parameters
	
	MediaPlayer mPlayer;
	Button btnPlay, btnStop;
	TextView mPlayerStateView;
	
	private int mPlayerState;
	private final int mPlayerStateIdle = 0;
	private final int mPlayerStatePlay = 1;
	private final int mPlayerStatePause = 2;
	private final int mPlayerStateError = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //--------2222------------fetch the Objects
        
        btnPlay = (Button)findViewById(R.id.btnPlay);
        btnStop= (Button)findViewById(R.id.btnStop);
        mPlayerStateView = (TextView) findViewById(R.id.tv_mPlayer_state);
        
        initMediaPlayer();
        
        
        
        //------4444--------------set OnClick Listener
        //set onClick Listener for Play/Pause/Quit
        btnPlay.setOnClickListener(btnPlayPauseClickListener);
        btnStop.setOnClickListener(btnStopClickListener);
        
        
    }
    
    
    //-------3333--------------Initiate Media PLayer
    private void initMediaPlayer() {
		
    	
    	
    	//-------while reading from the RAW folder
//    	mPlayer = MediaPlayer.create(MainActivity.this, R.raw.music);
    	
    	//While Reading from the External Storage ---need USES_Permission - READ_EXTERNAL_STORAGE
	    	String PATH = "/sdcard/music.mp3";
	    	mPlayer = new MediaPlayer();
    	
	    try {
    		
    		mPlayer.setDataSource(PATH);			
    		mPlayer.prepare();
    		
    		mPlayerState = mPlayerStateIdle;
	    	mPlayerStateView.setText("--IDLE--");
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mPlayerState = mPlayerStateError;
			mPlayerStateView.setText("--ERROR-IllegalArgumentException-");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mPlayerState = mPlayerStateError;
			mPlayerStateView.setText("--ERROR-SecurityException-");
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mPlayerState = mPlayerStateError;
			mPlayerStateView.setText("--ERROR-IllegalStateException-");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mPlayerState = mPlayerStateError;
			mPlayerStateView.setText("--ERROR-IOException-");
		}
    	
    
		
	}
    
    //---------5555---------------Play/Pause Btn Listener
    Button.OnClickListener btnPlayPauseClickListener = new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			
			switch (mPlayerState) {
			
			case mPlayerStateError:
				break;
				
			case mPlayerStateIdle:
				
				//When IDLE Start mPlayer
				mPlayer.start();
				btnPlay.setText("PAUSE");
				mPlayerStateView.setText("--PLAYING--");
				mPlayerState = mPlayerStatePlay;
				
				break;
				
			case mPlayerStatePlay:
				
				//When Playing - Pause IT
				mPlayer.pause();
				btnPlay.setText("PLAY");
				mPlayerStateView.setText("--PAUSED--");
				mPlayerState = mPlayerStatePause;
				
				
				break;
				
			case mPlayerStatePause:
				
				//When Paused - Again Play it
				mPlayer.start();
				btnPlay.setText("PAUSE");
				mPlayerStateView.setText("--PLAYING--");
				mPlayerState = mPlayerStatePlay;
				
				
				break;
			}
			
		}
    };
    
    
    //------6666---------------Stop Btn Listener
    Button.OnClickListener btnStopClickListener = new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			mPlayer.stop();
			mPlayer.release();
			btnPlay.setText("PLAY");
			finish();
			
		}
    	
    	
    	
    };




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
