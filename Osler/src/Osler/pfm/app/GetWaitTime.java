package Osler.pfm.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class GetWaitTime extends Activity {
	WebView mWebView;
	// url to make request
	//private static String url = "http://osler.eecs.uottawa.ca/PFM/arrival/hourlyArrival";
	
	// JSON Node names
	private static final String TAG_PATIENTID = "patientId";
	private static final String TAG_State = "state";
	private static final String TAG_Duration = "duration";
	int max;
	
	// contacts JSONArray
	JSONArray hourlyArrivalArray = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);
        
        String Duration="";
        
     // getting intent data
        Intent oneIntent = getIntent();
        int counter = 0;
        // Get JSON values from previous intent
        String patientId = oneIntent.getStringExtra(TAG_PATIENTID);
       
       
        try {
            URL osler = new URL(
                    "http://osler.eecs.uottawa.ca/PFM/patient/getWaitTime/"+patientId);
            
            //File sdcard = Environment.getExternalStorageDirectory();
            //File file = new File(sdcard,"/data/averageDuration.txt");
            URLConnection tc = osler.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    tc.getInputStream()));
            //BufferedReader br = new BufferedReader(new FileReader(file));
 
            String line;
            
            while ((line = in.readLine()) != null) {
                JSONArray ja = new JSONArray(line);
 
                for (int i = 0; i < ja.length(); i++) {
                	counter ++;
                	
                }
            }

            int[] y = new int [counter];
            String[] StateArray = new String[counter];

             URL osler1 = new URL(
                    "http://osler.eecs.uottawa.ca/PFM/patient/getWaitTime/"+patientId);
                URLConnection tc1 = osler1.openConnection();
            BufferedReader in1 = new BufferedReader(new InputStreamReader(
                    tc1.getInputStream()));
            //BufferedReader br = new BufferedReader(new FileReader(file));
 
            String line1;
            
            while ((line1 = in1.readLine()) != null) {
                JSONArray ja1 = new JSONArray(line1);
 
                for (int i = 0; i < ja1.length(); i++) {                	
             
               JSONObject jo1 = (JSONObject) ja1.get(i);
                    
                    String Duration1 = jo1.getString(TAG_Duration);
    				String State = jo1.getString(TAG_State);
    				
    				  int aInt = Integer.parseInt(Duration1);
    				  y[i] = aInt;
    				  StateArray[i] = State;
                      }
            }

			
            
            //Set the Height based on max value
            max = y[0];
            for(int i = 0; i<y.length;i++)
            {

				  if(max < y[i])
						  {
					  max = y[i];
						  }
            }

            for(int m=0;m<y.length;m++)
            {
            	Duration += y[m] + ",";
            	
            }
            Duration = Duration.substring(0, Duration.length() - 1);
            System.out.println(Duration);
            String Statessave="";
            for(int l=StateArray.length-1;l>=0;l--)
            {
            	
            	Statessave += StateArray[l] + "|";
            }
            Statessave = Statessave.substring(0, Statessave.length() - 1);
            System.out.println(Statessave);

     		  mWebView = (WebView) findViewById(R.id.webView1);
     		  String url = "http://chart.googleapis.com/chart?chxr=0,0,"+max+"&chxt=x,y&chbh=6,5&chs=520x360&cht=bhs&chco=0000FF&chds=0,"+max+"&chd=t:"+Duration+"&chxl=1:|"+Statessave+"&chdl=Minutes";
     		  mWebView.loadUrl(url);
     		  
     		  
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
												        
		}
		
        
    }
    
    
