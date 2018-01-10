package com.svit.mediaplayer;

import java.io.IOException;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;

public class VideoPlayBack extends Activity implements SurfaceHolder.Callback, OnPreparedListener, MediaPlayerControl {
	
	private MediaPlayer mPlayer;
	private MediaController mController;
	private SurfaceHolder vidHolder;
	private SurfaceView vidSurf;
	String SDCard = Environment.getExternalStorageDirectory().getPath();
	String PATH = SDCard + "/Chris Brown - Turn Up The Music.mp4";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
		
		setContentView(R.layout.activity_video_layout);
		
		vidSurf = (SurfaceView) findViewById(R.id.surfView);
		vidHolder = vidSurf.getHolder();
		vidHolder.addCallback(this);
		
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		mController.show();
		return false;
	}


	@Override
	public void start() {
		// TODO Auto-generated method stub
		mPlayer.start();
	}


	@Override
	public void pause() {
		// TODO Auto-generated method stub
		mPlayer.pause();
	}


	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return mPlayer.getDuration();
	}


	@Override
	public int getCurrentPosition() {
		// TODO Auto-generated method stub
		return getCurrentPosition();
	}


	@Override
	public void seekTo(int pos) {
		// TODO Auto-generated method stub
		mPlayer.seekTo(pos);
	}


	@Override
	public boolean isPlaying() {
		// TODO Auto-generated method stub
		return mPlayer.isPlaying();
	}


	@Override
	public int getBufferPercentage() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean canPause() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean canSeekBackward() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean canSeekForward() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public int getAudioSessionId() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void onPrepared(MediaPlayer mp) {
		
		mController.setMediaPlayer(this);
		mController.setAnchorView(findViewById(R.id.surfView));
		mController.setEnabled(true);
		mController.show();
		
	}


	@Override
	public void surfaceCreated(SurfaceHolder holder) {

		
		try {
			mPlayer = new MediaPlayer();
			mPlayer.setDisplay(vidHolder);
			mPlayer.setDataSource(PATH);
			mPlayer.prepare();
			mPlayer.setScreenOnWhilePlaying(true);
			mPlayer.setOnPreparedListener(this);
			mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			mController = new MediaController(this);
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}


	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

}
