package com.purvik.recording;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	private MediaRecorder mRecorder;
	private MediaPlayer mPLayer;
	
	private String outPath = null;
	Button btnRecord, btnPlay;
	TextView tvMsg, playMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
      //Creating View Objects
      		tvMsg = (TextView)findViewById(R.id.tvMessage);
      		playMessage = (TextView)findViewById(R.id.tvMsgPlay);
      		btnRecord = (Button) findViewById(R.id.btn_Record);
      		btnPlay = (Button) findViewById(R.id.btn_Play);      		
      		
      		//Setting File Path
      		outPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/recording.mp3";
      	
      		//Creating MediaRecorder Objects and Sources as well as Output Formats For Recording
      		mRecorder = new MediaRecorder();
      		mPLayer = new MediaPlayer();
      		
      		//set Audio Source
      		mRecorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT);
      		
      		//set Output Format
      		mRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
      		
      		//Set Audio Recorder
      		mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
      		
      		//Set Output File 
      		mRecorder.setOutputFile(outPath);
      		
      		//Button OnTouch Events - For Recording
      		btnRecord.setOnTouchListener(new View.OnTouchListener() {
      			
      			@Override
      			public boolean onTouch(View v, MotionEvent event) {
      				// TODO Auto-generated method stub
      				switch (event.getAction()) {
      				case MotionEvent.ACTION_DOWN:
      					
      					Log.i("RECORD", "Btn Pressed");
      					tvMsg.setText("Release To Stop Recording");
      					btnRecord.setText("RELAEASE");
      					
      					try {
      							//Prepare MediaRecorder
      							mRecorder.prepare();
      							
      							//Start MediaRecorder
      							mRecorder.start();
      						
      					} catch (IllegalStateException | IOException e) {
      						// TODO Auto-generated catch block
      						e.printStackTrace();
      					}
      					
      					
      					break;
      					
      				case MotionEvent.ACTION_UP:
      					
      					Log.i("RECORD", "Btn Up");
      					tvMsg.setText("Recording End");
      					
      					if (mRecorder != null) {
      						
      						//Stop Media Recorder
      						mRecorder.stop();
      						
      						//Release MediaRecorder
      						mRecorder.release();
      						
      						//mRecorder = null;
      						
      					}
      					
      					
      					
      					break;
      					
      				/*case MotionEvent.ACTION_MOVE:
      					
      					Log.i("RECORD", "Btn MMoving");
      					tvMsg.setText("Button Action Moving");
      					break;*/

      				default:
      					break;
      				}
      				
      				/*Thread th = new Thread();
      				try {
      					
      					th.sleep(3000);
      					tvMsg.setText("Press To Record");

      					
      				} catch (InterruptedException e) {
      					// TODO Auto-generated catch block
      					e.printStackTrace();
      				}*/
      				return true;
      			}
      		});
      		
      		
      		//Button OnTouch Events - For Playing
      				btnPlay.setOnTouchListener(new View.OnTouchListener() {
      					
      					@Override
      					public boolean onTouch(View v, MotionEvent event) {
      						// TODO Auto-generated method stub
      						switch (event.getAction()) {
      						case MotionEvent.ACTION_DOWN:
      							
      							Log.i("PLAY", "Btn Pressed");
      							tvMsg.setText("Release TO Stop");
      							btnPlay.setText("RELAEASE");
      							
      							try {
      								
      								mPLayer.setDataSource(outPath);
      								mPLayer.prepare();
      								mPLayer.start();
      								
      							} catch (IllegalStateException | IOException e) {
      								// TODO Auto-generated catch block
      								e.printStackTrace();
      							}
      							
      							
      							break;
      							
      						case MotionEvent.ACTION_UP:
      							
      							Log.i("PLAY", "Btn Up");
      							tvMsg.setText("Recording Stop");
      							
      							if (mPLayer != null) {
      								
      								mPLayer.stop();
      								mPLayer.release();
      								
      								//mPLayer = null;
      								
      							}
      							
      							
      							break;
      							
      						/*case MotionEvent.ACTION_MOVE:
      							
      							Log.i("RECORD", "Btn MMoving");
      							tvMsg.setText("Button Action Moving");
      							break;*/

      						default:
      							break;
      						}
      						/*try {
      							Thread th = new Thread();
      							th.sleep(3000);
      							tvMsg.setText("Press To Play");

      						} catch (InterruptedException e) {
      							// TODO Auto-generated catch block
      							e.printStackTrace();
      						}*/
      						return true;
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
}
