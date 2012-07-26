package Osler.pfm.app;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;


public class PatientStateEventTab  extends TabActivity {
	
	private static final String TAG_PATIENTID = "patientId";
	private static final String TAG_ROOMID = "roomId";
	
	 @Override
	    public void onCreate(final Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        final TabHost tabHost = getTabHost();
	        // getting intent data
	        Intent in = getIntent();
	        
	        // Get JSON values from previous intent
	        String patientId = in.getStringExtra(TAG_PATIENTID);
	        String roomno = in.getStringExtra(TAG_ROOMID);
	        
	        final Intent oneIntent = new Intent().setClass(this, Events.class);
	        oneIntent.putExtra(TAG_PATIENTID, patientId);
	        oneIntent.putExtra(TAG_ROOMID, roomno);
	        final TabSpec oneSpec = tabHost.newTabSpec("Events")
	                .setIndicator("Events").setContent(oneIntent);
	        tabHost.addTab(oneSpec);
	        final Intent twoIntent = new Intent().setClass(this, States.class);
	        twoIntent.putExtra(TAG_PATIENTID, patientId);
	        twoIntent.putExtra(TAG_ROOMID, roomno);
	        final TabSpec twoSpec = tabHost.newTabSpec("States").setIndicator("States").setContent(twoIntent);
	        tabHost.addTab(twoSpec);

	        final Intent threeIntent = new Intent().setClass(this, GetWaitTime.class);
	        threeIntent.putExtra(TAG_PATIENTID, patientId);
	        threeIntent.putExtra(TAG_ROOMID, roomno);
	        final TabSpec threespec = tabHost.newTabSpec("Waittime Chart").setIndicator("Waittime Chart").setContent(threeIntent);
	        tabHost.addTab(threespec);
	       /* final Intent threeIntent = new Intent().setClass(this, ActivityThree.class);
	        final TabSpec threeSpec = tabHost.newTabSpec("Edit Scores").setIndicator("Edit Scores").setContent(threeIntent);
	        tabHost.addTab(threeSpec);

	        tabHost.setCurrentTab(2);
	        */
	    }
}