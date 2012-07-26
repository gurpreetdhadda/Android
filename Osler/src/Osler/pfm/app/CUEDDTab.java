package Osler.pfm.app;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class CUEDDTab  extends TabActivity {
	
	
	 @Override
	    public void onCreate(final Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        final TabHost tabHost = getTabHost();
	        // getting intent data
	        
	        final Intent oneIntent = new Intent().setClass(this, EDTable.class);
	        final TabSpec oneSpec = tabHost.newTabSpec("ED")
	                .setIndicator("ED").setContent(oneIntent);
	        tabHost.addTab(oneSpec);
	        
	        final Intent twoIntent = new Intent().setClass(this, CCLTable.class);
	        final TabSpec twoSpec = tabHost.newTabSpec("CCL").setIndicator("CCL").setContent(twoIntent);
	        tabHost.addTab(twoSpec);
	       
	        final Intent threeIntent = new Intent().setClass(this, CWTable.class);
	        final TabSpec threeSpec = tabHost.newTabSpec("CW").setIndicator("CW").setContent(threeIntent);
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