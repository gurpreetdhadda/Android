package Osler.pfm.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class HourlyAdmissionDischargeChart extends Activity {
	WebView mWebView;
	// url to make request
	private static String url = "http://osler.eecs.uottawa.ca/PFM/admission/hourlyAdmissionDischarge";
	int max;
	
	// JSON Node names
	private static final String TAG_HourlyAdmission = "hourlyAdmission";
	private static final String TAG_Admission = "admission";
	private static final String TAG_Hour = "hour";
	
	private static final String TAG_HourlyDischarge = "hourlyDischarge";
	private static final String TAG_Discharge = "discharge";


	// contacts JSONArray
	JSONArray hourlyAdmissionArray = null;
	JSONArray hourlyDischargeArray = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);
        
        String Admissions="";
		String Discharges="";

		// getting JSON string from URL
		JSONObject json = getJSONFromUrl(url);
		// declares an array of integers
		 String[] y = new String [24];
		  for (int j = 0; j <y.length; j++ )
		  y[j] = "0";
		  
			// declares an array of integers
			 String[] x = new String [24];
			  for (int k = 0; k<x.length; k++ )
			  x[k] = "0";
		
		try {
			// Getting Array of Contacts
			hourlyAdmissionArray = json.getJSONArray(TAG_HourlyAdmission);
			
			// looping through All Contacts
			for(int i = 0; i < hourlyAdmissionArray.length(); i++){
				JSONObject c = hourlyAdmissionArray.getJSONObject(i);
				
				// Storing each json item in variable
				String Hour = c.getString(TAG_Hour);
				String Admission = c.getString(TAG_Admission);
				
				  int aInt = Integer.parseInt(Hour);
				  y[aInt] = Admission;
				  	  
			}
			
				             // Getting Array of Contacts
				             hourlyDischargeArray = json.getJSONArray(TAG_HourlyDischarge);
							
							// looping through All Contacts
							for(int i = 0; i < hourlyDischargeArray.length(); i++){
								JSONObject c = hourlyDischargeArray.getJSONObject(i);
								
								// Storing each json item in variable
								String Hour1 = c.getString(TAG_Hour);
								String Discharge = c.getString(TAG_Discharge);
								
								  int aInt1 = Integer.parseInt(Hour1);
								  
								  x[aInt1] = Discharge;
								  

							}
							
							//Set the Height based on max value
				            max = Integer.parseInt(y[0]);
				            for(int i = 0; i<y.length;i++)
				            {
								  if(max < Integer.parseInt(y[i]))
										  {
									  max = Integer.parseInt(y[i]);
										  }
				            }
				            
				            for(int i = 0; i<x.length;i++)
				            {
								  if(max < Integer.parseInt(x[i]))
										  {
									  max = Integer.parseInt(x[i]);
										  }
				            }
							
							Admissions = y[0] + "," + y[1] +"," + y[2] +"," + y[3] + "," + y[4] + ","+
		                     		y[5] + "," + y[6] +"," + y[7] +"," + y[8] + "," + y[9] + ","+
		                     		y[10] + "," + y[11] +"," + y[12] +"," + y[13] + "," + y[14] + ","+
		                     		y[15] + "," + y[16] +"," + y[17] +"," + y[18] + "," + y[19] + ","+
		                     		y[20] + "," + y[21] +"," + y[22] +"," + y[23];
								 
							Discharges = x[0] + "," + x[1] +"," + x[2] +"," + x[3] + "," + x[4] + ","+
                            		x[5] + "," + x[6] +"," + x[7] +"," + x[8] + "," + x[9] + ","+
                            		x[10] + "," + x[11] +"," + x[12] +"," + x[13] + "," + x[14] + ","+
                            		x[15] + "," + x[16] +"," + x[17] +"," + x[18] + "," + x[19] + ","+
                            		x[20] + "," + x[21] +"," + x[22] +"," + x[23];
										 
							
							
							 mWebView = (WebView) findViewById(R.id.webView1);
						     String url = "https://chart.googleapis.com/chart?cht=bvg&chbh=r,.1,1&chd=t:" +Admissions+ "|" + Discharges+ "&chco=0000FF,FF0000&chs=500x350&chxt=x,y&chxr=1,0,23|1,0,"+max+"&chds=0,"+max+",0,"+max+",0,24,0,24&chm=o,000000,2,,10|s,000000,3,,10&chdl=ADMISSION|DISCHARGE";
						        mWebView.loadUrl(url);
												        
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
        
    }
    
    public JSONObject getJSONFromUrl(String url) {
    	 InputStream is = null;
    	 JSONObject jObj = null;
    	 String json = "";


		// Making HTTP request
		try {
			// defaultHttpClient
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);

			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();			

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			
			//File sdcard = Environment.getExternalStorageDirectory();
            //File file = new File(sdcard,"/data/AdmissionVsDischarge.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			//BufferedReader br = new BufferedReader(new FileReader(file));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
		} catch (Exception e) {
			Log.e("Buffer Error", "Error converting result " + e.toString());
		}

		// try parse the string to a JSON object
		try {
			jObj = new JSONObject(json);
		} catch (JSONException e) {
			Log.e("JSON Parser", "Error parsing data " + e.toString());
		}

		// return JSON String
		return jObj;

	}
}