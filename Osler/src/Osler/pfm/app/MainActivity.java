package Osler.pfm.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	
    Button btnLogin;
 /** Called when the activity is first created. */
 @Override
 public void onCreate(Bundle savedInstanceState) {
  		super.onCreate(savedInstanceState);
  		setContentView(R.layout.mainactivity);
  		
  		TextView home = (TextView) findViewById(R.id.link_to_Osler);
  		home.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					Intent i = new Intent(getApplicationContext(), OslarHome.class);
					startActivity(i);
				}
			});
	        
  			initActivityComponents();
  		   
  		//setDummyCredentials();
 }
 protected void initActivityComponents() {
 		 
 	
  /*
 	btnLogin = (Button) findViewById(R.id.btnLogin);
 	btnLogin.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
						Intent myIntent = new Intent(v.getContext(), AndroidDashboardDesignActivity.class);
                     startActivityForResult(myIntent, 0);
				    */
									
				/*
					// Log.i(getClass().getSimpleName(), "send  task - start");
			        HttpParams httpParams = new BasicHttpParams();
			        //HttpConnectionParams.setConnectionTimeout(httpParams,
			        //        TIMEOUT_MILLISEC);
			        //HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
			        //
			        HttpParams p = new BasicHttpParams();
			        // p.setParameter("name", pvo.getName());
			        p.setParameter("user", "1");

			        // Instantiate an HttpClient
			        HttpClient httpclient = new DefaultHttpClient(p);
			        String url = "http://toh7.site.uottawa.ca/palis/Patients/SetEsasScore.aspx?"+ Text;
			        HttpPost httppost = new HttpPost(url);
			        
			        // Instantiate a GET HTTP method
			        try {
			        	
			            Log.i(getClass().getSimpleName(), "send  task - start");
			            //
			            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
			                    2);
			            nameValuePairs.add(new BasicNameValuePair("user", "1"));
			            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			            ResponseHandler<String> responseHandler = new BasicResponseHandler();
			            String responseBody = httpclient.execute(httppost,
			                    responseHandler);
			            // Parse
			            //Toast.makeText(Login.this, "Calling service", Toast.LENGTH_LONG).show();
						
			            JSONObject json = new JSONObject(responseBody);
			            JSONArray jArray = json.getJSONArray("PatientDetails");
			            ArrayList<HashMap<String, String>> mylist = 
			                   new ArrayList<HashMap<String, String>>();
			           
			            for (int i = 0; i < jArray.length(); i++) {
			                HashMap<String, String> map = new HashMap<String, String>();
			                JSONObject e = jArray.getJSONObject(i);
			                String Error = e.getString("Error");
			                String FirstName = e.getString("FirstName");
			                String LastName = e.getString("LastName");
	                        String DOB = e.getString("DOB");
	                        String PatientId = e.getString("PatientId");
	                        String FullName = e.getString("FullName");
	                        String Zero = "0";
	                        
	                        String Pain = e.getString("Pain");
	                        String Nausea = e.getString("Nausea");
	                        String Tireness = e.getString("Tireness");
	                        String Depression = e.getString("Depression");
	                        String Anxiety = e.getString("Anxiety");
	                        String Appetite = e.getString("Appetite");
	                        String Drowsiness = e.getString("Drowsiness");
	                        String Wellbeing = e.getString("Wellbeing");
	                        String ShortnessOfBreath = e.getString("ShortnessOfBreath");
	                        
	                        String PainThreshold = e.getString("PainThreshold");
	                        String NauseaThreshold = e.getString("NauseaThreshold");
	                        String TirenessThreshold = e.getString("TirenessThreshold");
	                        String DepressionThreshold = e.getString("DepressionThreshold");
	                        String AnxietyThreshold = e.getString("AnxietyThreshold");
	                        String AppetiteThreshold = e.getString("AppetiteThreshold");
	                        String DrowsinessThreshold = e.getString("DrowsinessThreshold");
	                        String WellbeingThreshold = e.getString("WellbeingThreshold");
	                        String ShortnessOfBreathThreshold = e.getString("ShortnessOfBreathThreshold");
	                                               
	                        
			            }
			            //Toast.makeText(PalisfinalActivity.this, responseBody, Toast.LENGTH_LONG).show();
			            //Toast.makeText(this, responseBody, Toast.LENGTH_LONG).show();

			        } catch (ClientProtocolException e) {
			            // TODO Auto-generated catch block
			            e.printStackTrace();
			        } catch (IOException e) {
			            // TODO Auto-generated catch block
			            e.printStackTrace();
			        }
			        // Log.i(getClass().getSimpleName(), "send  task - end");
			      //"Request failed: " + t.toString()
			    } catch (Throwable t) {
			       //Toast.makeText(Login.this, "Login UnSuccessful!!!" ,
			      // Toast.LENGTH_LONG).show();
			    }*/


}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
