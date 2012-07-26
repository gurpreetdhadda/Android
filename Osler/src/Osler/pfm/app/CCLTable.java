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
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;


public class CCLTable extends ListActivity {
	
	// JSON Node names
	private static final String TAG_PATIENTID = "patientId";
	private static final String TAG_STATE = "state";
	private static final String TAG_DURATION = "duration";
	
	
	ArrayList<HashMap<String, String>> eventList = new ArrayList<HashMap<String, String>>();
	
	//JSONArray
	JSONArray mapArray = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String url = "http://osler.eecs.uottawa.ca/PFM/unit/getUnitPerformance/CCL";
        
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
                    String patientid = jo.getString(TAG_PATIENTID);
                    String state = jo.getString(TAG_STATE);
    				String duration = jo.getString(TAG_DURATION);
    				HashMap<String, String> map = new HashMap<String, String>();
    				
    				// adding each child node to HashMap key => value
    				map.put(TAG_PATIENTID, patientid);
    				map.put(TAG_STATE, state);
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
				R.layout.cueddlayout,
				new String[] {TAG_PATIENTID, TAG_STATE, TAG_DURATION }, new int[] {
						R.id.patientid, R.id.waitstate,R.id.duration});

        setListAdapter(adapter);
											        
		}
		
        
    }