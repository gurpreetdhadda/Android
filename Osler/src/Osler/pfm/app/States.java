package Osler.pfm.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;


public class States extends ListActivity {
	
	// JSON Node names
	private static final String TAG_PATIENTID = "patientId";
	private static final String TAG_STATE = "state";
	private static final String TAG_STARTTIME = "startTime";
	private static final String TAG_ENDTIME = "endTime";
	private static final String TAG_DURATION = "duration";
	
	
	ArrayList<HashMap<String, String>> eventList = new ArrayList<HashMap<String, String>>();
	
	//  JSONArray
	JSONArray mapArray = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // getting intent data
        Intent oneIntent = getIntent();
        
        // Get JSON values from previous intent
        String patientId = oneIntent.getStringExtra(TAG_PATIENTID);
        String url = "http://osler.eecs.uottawa.ca/PFM/patient/getStateList/" + patientId;
        try {
            URL osler = new URL(url);
            URLConnection tc = osler.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    tc.getInputStream()));
 
            String line;
            while ((line = in.readLine()) != null) {
                JSONArray ja = new JSONArray(line);
 
                for (int i = 0; i < ja.length(); i++) {
                    JSONObject jo = (JSONObject) ja.get(i);
                    
                    String state = jo.getString(TAG_STATE);
    				String startTime = jo.getString(TAG_STARTTIME);
    				String endTime = jo.getString(TAG_ENDTIME);
    				String duration = jo.getString(TAG_DURATION);
    				HashMap<String, String> map = new HashMap<String, String>();
    				
    				// adding each child node to HashMap key => value
    				map.put(TAG_STATE, state);
    				map.put(TAG_STARTTIME, startTime);
    				map.put(TAG_ENDTIME, endTime);
    				map.put(TAG_DURATION, duration);
    				
    				// adding HashList to ArrayList
    				eventList.add(map);
    				
                }
            }    
			

     		  
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
        
        ListAdapter adapter = new SimpleAdapter(this, eventList,
				R.layout.states,
				new String[] { TAG_STATE, TAG_STARTTIME,TAG_ENDTIME, TAG_DURATION }, new int[] {
						R.id.StateName, R.id.StartTime,R.id.EndTime, R.id.Duration });

        setListAdapter(adapter);
											        
		}
		
        
    }