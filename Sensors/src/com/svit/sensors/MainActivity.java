package com.svit.sensors;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends Activity implements SensorEventListener {
	
	private SensorManager sManager;
	private Sensor sAccelerometer, sProximity;
	TextView x,y,z, nProxim;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        sManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sAccelerometer = sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sProximity = sManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        
        x = (TextView)findViewById(R.id.xText);
        y = (TextView)findViewById(R.id.yText);
        z = (TextView)findViewById(R.id.zText);
        
        nProxim = (TextView)findViewById(R.id.nProxim);
       
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
    protected void onResume() {
    	// TODO Auto-generated method stub
    	
    	sManager.registerListener(this, sAccelerometer,SensorManager.SENSOR_DELAY_NORMAL);
    	sManager.registerListener(this, sProximity,SensorManager.SENSOR_DELAY_NORMAL);
    	super.onResume();
    	
    }
    
    @Override
    protected void onStop() {
    	// TODO Auto-generated method stub
    	sManager.unregisterListener(this);
    	super.onStop();
    }

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		
		x.setText("x: "+event.values[0]);
		y.setText("y: "+event.values[1]);
		z.setText("z: "+event.values[2]);
		
		nProxim.setText("n: "+event.values[0]);
		
		
		
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
}
