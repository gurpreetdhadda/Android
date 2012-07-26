package Osler.pfm.app;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class RoomsTab  extends TabActivity {
	
	
	 @Override
	    public void onCreate(final Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        final TabHost tabHost = getTabHost();
	        // getting intent data
	        
	        final Intent oneIntent = new Intent().setClass(this, R105Tab.class);
	        final TabSpec oneSpec = tabHost.newTabSpec("R105")
	                .setIndicator("R105").setContent(oneIntent);
	        tabHost.addTab(oneSpec);
	        
	        final Intent twoIntent = new Intent().setClass(this, R106Tab.class);
	        final TabSpec twoSpec = tabHost.newTabSpec("R106").setIndicator("R106").setContent(twoIntent);
	        tabHost.addTab(twoSpec);
	       
	        final Intent threeIntent = new Intent().setClass(this, R107.class);
	        final TabSpec threeSpec = tabHost.newTabSpec("R107").setIndicator("R107").setContent(threeIntent);
	        tabHost.addTab(threeSpec);
	       
	        /*final Intent fourIntent = new Intent().setClass(this, CCLTable.class);
	        final TabSpec fourSpec = tabHost.newTabSpec("Triage").setIndicator("Triage").setContent(fourIntent);
	        tabHost.addTab(fourSpec);
	        
	       /* final Intent threeIntent = new Intent().setClass(this, ActivityThree.class);
	        final TabSpec threeSpec = tabHost.newTabSpec("Edit Scores").setIndicator("Edit Scores").setContent(threeIntent);
	        tabHost.addTab(threeSpec);

	        tabHost.setCurrentTab(2);
	        */
	    }
}