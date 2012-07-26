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
import android.os.Bundle;
import android.webkit.WebView;

public class ArrivalChart extends Activity {
	WebView mWebView;

	// JSON Node names
	private static final String TAG_Arrival = "arrival";
	private static final String TAG_Hour = "hour";
	int max;
	
	//  JSONArray
	JSONArray hourlyArrivalArray = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);
        
        String Arrivals="";
       
        String[] y = new String [24];
		  for (int j = 0; j <y.length; j++ )
		  y[j] = "0";
        
        try {
            URL osler = new URL(
                    "http://osler.eecs.uottawa.ca/PFM/arrival/hourlyArrival");
            URLConnection tc = osler.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    tc.getInputStream()));
 
            String line;
            
            while ((line = in.readLine()) != null) {
                JSONArray ja = new JSONArray(line);
 
                for (int i = 0; i < ja.length(); i++) {
                    JSONObject jo = (JSONObject) ja.get(i);
                    
                    String Hour = jo.getString(TAG_Hour);
    				String Arrival = jo.getString(TAG_Arrival);
    				
    				  int aInt = Integer.parseInt(Hour);
    				  y[aInt] = Arrival;

                }
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

     			Arrivals = y[0] + "," + y[1] +"," + y[2] +"," + y[3] + "," + y[4] + ","+
     		              y[5] + "," + y[6] +"," + y[7] +"," + y[8] + "," + y[9] + ","+
     		              y[10] + "," + y[11] +"," + y[12] +"," + y[13] + "," + y[14] + ","+
     		              y[15] + "," + y[16] +"," + y[17] +"," + y[18] + "," + y[19] + ","+
     		              y[20] + "," + y[21] +"," + y[22] +"," + y[23];
     								 
     			
     			
     			
     		  mWebView = (WebView) findViewById(R.id.webView1);
     		  String url = "https://chart.googleapis.com/chart?cht=bvg&chs=500x350&chbh=6&chd=t:"+ Arrivals + "&chco=0000FF&chxt=x,y&chxr=1,0,23|1,0," + max + "&chds=0,"+ max + ",0,24&chm=o,000000,2,,10|s,000000,3,,10&chdl=Arrivals";
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
    
    
