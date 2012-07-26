package Osler.pfm.app;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OslarHome extends Activity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oslarhome);
        final Button AverageWaitTimeChart = (Button) findViewById(R.id.AverageWaitTime);
        final Button original = (Button) findViewById(R.id.AdmisionDischarge);
        final Button theMissing = (Button) findViewById(R.id.Arrivals);
        //final Button mapofrooms = (Button) findViewById(R.id.mapofrooms);
        final Button units = (Button) findViewById(R.id.Units);
        final Button patientroommapping = (Button) findViewById(R.id.patientroommapping);
        final Button rooms = (Button) findViewById(R.id.Rooms);
        final Button clinicalpathway1 = (Button) findViewById(R.id.clinicalpathway1);
        final Button clinicalpathway2 = (Button) findViewById(R.id.clinicalpathway2);
        final Button clinicalpathway3 = (Button) findViewById(R.id.clinicalpathway3);
        
        
    	// flag for Internet connection status

    	
    	// Connection detector class
    	 final ConnectionDetector cd;
    	
     // creating connection detector class instance
     		cd = new ConnectionDetector(getApplicationContext());
     		
        //final Button testpage = (Button) findViewById(R.id.testpage);
        AverageWaitTimeChart.setOnClickListener(new OnClickListener() {
            public void onClick(final View v) {
            	Boolean isInternetPresent = false;
            	// get Internet status
				isInternetPresent = cd.isConnectingToInternet();

				// check for Internet status
				if (isInternetPresent) {
					// Internet Connection is Present
					// make HTTP requests
	                final Intent myIntent = new Intent(OslarHome.this, AverageWaitTimeChart.class);
	                OslarHome.this.startActivity(myIntent);
				} else {
					// Internet connection is not present
					// Ask user to connect to Internet
					showAlertDialog(OslarHome.this, "No Internet Connection",
							"You don't have internet connection.", false);
				}

            }
        });
        
        
        original.setOnClickListener(new OnClickListener() {
            public void onClick(final View v) {
            	// get Internet status
            	Boolean isInternetPresent = false;
				isInternetPresent = cd.isConnectingToInternet();

				// check for Internet status
				if (isInternetPresent) {
					// Internet Connection is Present
	                final Intent myIntent = new Intent(OslarHome.this, HourlyAdmissionDischargeChart.class);
	                OslarHome.this.startActivity(myIntent);
				} else {
					// Internet connection is not present
					// Ask user to connect to Internet
					showAlertDialog(OslarHome.this, "No Internet Connection",
							"You don't have internet connection.", false);
				}

            }
        });
        theMissing.setOnClickListener(new OnClickListener() {
            public void onClick(final View v) {
            	Boolean isInternetPresent = false;
            	isInternetPresent = cd.isConnectingToInternet();

				// check for Internet status
				if (isInternetPresent) {
					// Internet Connection is Present
	                final Intent myIntent = new Intent(OslarHome.this, ArrivalChart.class);
	                OslarHome.this.startActivity(myIntent);
				} else {
					// Internet connection is not present
					// Ask user to connect to Internet
					showAlertDialog(OslarHome.this, "No Internet Connection",
							"You don't have internet connection.", false);
				}

            }
        });
        rooms.setOnClickListener(new OnClickListener() {
            public void onClick(final View v) {
            	Boolean isInternetPresent = false;
            	isInternetPresent = cd.isConnectingToInternet();

				// check for Internet status
				if (isInternetPresent) {
					// Internet Connection is Present
	                final Intent myIntent = new Intent(OslarHome.this, RoomsTab.class);
	                OslarHome.this.startActivity(myIntent);
				} else {
					// Internet connection is not present
					// Ask user to connect to Internet
					showAlertDialog(OslarHome.this, "No Internet Connection",
							"You don't have internet connection.", false);
				}


            }
        });
        units.setOnClickListener(new OnClickListener() {
            public void onClick(final View v) {
            	Boolean isInternetPresent = false;
            	isInternetPresent = cd.isConnectingToInternet();

				// check for Internet status
				if (isInternetPresent) {
					// Internet Connection is Present
	                final Intent myIntent = new Intent(OslarHome.this, CUEDDTab.class);
	                OslarHome.this.startActivity(myIntent);
				} else {
					// Internet connection is not present
					// Ask user to connect to Internet
					showAlertDialog(OslarHome.this, "No Internet Connection",
							"You don't have internet connection.", false);
				}



            }
        });
        patientroommapping.setOnClickListener(new OnClickListener() {
            public void onClick(final View v) {
            	// check for Internet status
            	Boolean isInternetPresent = false;
            	isInternetPresent = cd.isConnectingToInternet();
				if (isInternetPresent) {
					// Internet Connection is Present
	                final Intent myIntent = new Intent(OslarHome.this, Patients.class);
	                OslarHome.this.startActivity(myIntent);
				} else {
					// Internet connection is not present
					// Ask user to connect to Internet
					showAlertDialog(OslarHome.this, "No Internet Connection",
							"You don't have internet connection.", false);
				}

            }
        });
        clinicalpathway1.setOnClickListener(new OnClickListener() {
            public void onClick(final View v) {
            	Boolean isInternetPresent = false;
            	isInternetPresent = cd.isConnectingToInternet();
            	if (isInternetPresent) {
					// Internet Connection is Present
                    final Intent myIntent = new Intent(OslarHome.this, ClinicalPathway.class);
                    OslarHome.this.startActivity(myIntent);
				} else {
					// Internet connection is not present
					// Ask user to connect to Internet
					showAlertDialog(OslarHome.this, "No Internet Connection",
							"You don't have internet connection.", false);
				}

            }
        });
        clinicalpathway2.setOnClickListener(new OnClickListener() {
            public void onClick(final View v) {
            	Boolean isInternetPresent = false;
            	isInternetPresent = cd.isConnectingToInternet();
            	if (isInternetPresent) {
					// Internet Connection is Present
                    final Intent myIntent = new Intent(OslarHome.this, ClinicalpathwayDay2.class);
                    OslarHome.this.startActivity(myIntent);
				} else {
					// Internet connection is not present
					// Ask user to connect to Internet
					showAlertDialog(OslarHome.this, "No Internet Connection",
							"You don't have internet connection.", false);
				}


            }
        });
        clinicalpathway3.setOnClickListener(new OnClickListener() {
            public void onClick(final View v) {
            	Boolean isInternetPresent = false;
            	isInternetPresent = cd.isConnectingToInternet();
            	if (isInternetPresent) {
					// Internet Connection is Present
                    final Intent myIntent = new Intent(OslarHome.this, ClinicalPathwayday3.class);
                    OslarHome.this.startActivity(myIntent);
				} else {
					// Internet connection is not present
					// Ask user to connect to Internet
					showAlertDialog(OslarHome.this, "No Internet Connection",
							"You don't have internet connection.", false);
				}

            }
        });
        /*testpage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Intent myIntent = new Intent(OslarHome.this, OslerTestPage.class);
                OslarHome.this.startActivity(myIntent);
            }
        });*/
       
    }

public void showAlertDialog(Context context, String title, String message, Boolean status) {
	AlertDialog alertDialog = new AlertDialog.Builder(context).create();

	// Setting Dialog Title
	alertDialog.setTitle(title);

	// Setting Dialog Message
	alertDialog.setMessage(message);
	
	// Setting alert dialog icon
	alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

	// Setting OK Button
	alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
		}
	});

	// Showing Alert Message
	alertDialog.show();
}
}
