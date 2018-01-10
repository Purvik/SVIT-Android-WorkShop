package com.svit.intents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void goGoogle(View v) {
    	
    	Intent i = new Intent(android.content.Intent.ACTION_VIEW,
    			Uri.parse("http://www.google.co.in"));
    	startActivity(i);
		
	}

    public void makeCall(View v) {
    	Intent i = new Intent(android.content.Intent.ACTION_CALL,
    			Uri.parse("tel:+919998970653"));
    	startActivity(i);
   	}
    
    public void pickContact(View v) {
		
    	Intent i = new Intent(android.content.Intent.ACTION_PICK);
    		//	Uri.parse("vnd.android.cursor.dir/contact"));
    			i.setType(ContactsContract.Contacts.CONTENT_TYPE);    			
    		startActivity(i);
   	}
    
 public void call2(View v) {
		
    	Intent i = new Intent(MainActivity.this,SecondAct.class);
    	startActivity(i);
   	}
 
 public void call3(View v) {
		
 	Intent i = new Intent(MainActivity.this,ThirdActivity.class);
 	startActivity(i);
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
