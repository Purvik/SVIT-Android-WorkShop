package com.purvik.persistantstoragefiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	EditText edtMsg;
	TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        edtMsg = (EditText) findViewById(R.id.edtMessage);
        tvMsg = (TextView) findViewById(R.id.tvMessage);
    }
    
    
    public void storeToFiles(View v) {
    	//Store Message To Files
    	String msg = edtMsg.getText().toString();
    	
    	try {
    		
    		//---SD Card Storage---
    		File sdCard = Environment.getExternalStorageDirectory();
    		
    		//Directory Instance
    		File directory = new File (sdCard.getAbsolutePath() +"/MyFiles");
    		
    		//Fire the Call
    		directory.mkdirs();
    		
    		//File Instance
    		File file = new File(directory, "textfile.txt");
    		
    		FileOutputStream fout = new FileOutputStream(file);
    		
    		
    		//---Internal Storage---
//			FileOutputStream fout = openFileOutput("message.txt", MODE_WORLD_READABLE);
    		
			// GET OS
			OutputStreamWriter osw = new OutputStreamWriter(fout);
			
			
			osw.write(msg);	// Write a Message
			osw.flush(); 	// Confirm Message Written
			osw.close();	// Close the Stream
			
			Toast.makeText(getApplicationContext(), "Message Stored", Toast.LENGTH_SHORT).show();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void loadMessage(View v) {
		
    	//Load the Message
    	try {
    		
    		//Get Input Stream
			FileInputStream fin = openFileInput("message.txt");
			InputStreamReader isr = new InputStreamReader(fin);
			
			// Buffer to Store Data
			char[] inBuffer = new char[100];
			String s = "";
			
			
			// Read the Characters
			int charRead;
			while ((charRead = isr.read(inBuffer))> 0)
			{
				//---convert the chars to a String---
				String readString = String.copyValueOf(inBuffer, 0,charRead);
				s += readString;
				inBuffer = new char[100];
			}
			
			// Set Data to TextView
			tvMsg.setText(s);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
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
