package com.purvik.streammusic;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class MovieHome extends Activity {
	
	VideoView videoView;
	MediaController vidControl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.movie_home);
		Log.i("On MOVIE Activity", "MOVIE ACTIVITY");
		
		videoView = (VideoView)findViewById(R.id.videoView);
		vidControl = new MediaController(this);
		
	String vidLink = "http://videos.djmazadownload.com/mobile/mobile_videos/Pop/SelenaGomez/Who%20Says%20-%20Selena%20Gomez%20(www.DJMaza.Com).mp4";
	Uri vidUri = Uri.parse(vidLink);
	
	videoView.setVideoURI(vidUri);
	vidControl.setAnchorView(videoView);
	videoView.setMediaController(vidControl);
	
	
	videoView.start();
	}

}
