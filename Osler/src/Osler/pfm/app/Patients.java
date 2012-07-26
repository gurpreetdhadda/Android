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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Patients extends ListActivity {
	
	// JSON Node names
	private static final String TAG_PATIENTID = "patientId";
	private static final String TAG_ROOMID = "roomId";
	
	ArrayList<HashMap<String, String>> contactList = new ArrayList<HashMap<String, String>>();
	
	// contacts JSONArray
	JSONArray mapArray = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            URL osler = new URL(
                    "http://osler.eecs.uottawa.ca/PFM/patient/getPatientRoomMapping");
            URLConnection tc = osler.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    tc.getInputStream()));
 
            String line;
            while ((line = in.readLine()) != null) {
                JSONArray ja = new JSONArray(line);
 
                for (int i = 0; i < ja.length(); i++) {
                    JSONObject jo = (JSONObject) ja.get(i);
                    
                    String PatientId = jo.getString(TAG_PATIENTID);
    				String RoomId = jo.getString(TAG_ROOMID);
    				HashMap<String, String> map = new HashMap<String, String>();
    				
    				// adding each child node to HashMap key => value
    				map.put(TAG_PATIENTID, PatientId);
    				map.put(TAG_ROOMID, RoomId);
    				
    				// adding HashList to ArrayList
    				contactList.add(map);
    				
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
        
        ListAdapter adapter = new SimpleAdapter(this, contactList,
				R.layout.patientlistview,
				new String[] { TAG_PATIENTID, TAG_ROOMID}, new int[] {
						R.id.PatiendId, R.id.RoomNo });

        setListAdapter(adapter);

		// selecting single ListView item
		ListView lv = getListView();
		
		// Launching new screen on Selecting Single ListItem
				lv.setOnItemClickListener(new OnItemClickListener() {

					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// getting values from selected ListItem
						String PatientId = ((TextView) view.findViewById(R.id.PatiendId)).getText().toString();
						String Roomno = ((TextView) view.findViewById(R.id.RoomNo)).getText().toString();
							
						// Starting new intent
						Intent in = new Intent(getApplicationContext(), PatientStateEventTab.class);
						in.putExtra(TAG_PATIENTID, PatientId);
						in.putExtra(TAG_ROOMID, Roomno);
						startActivity(in);

					}
				});
				
        											        
		}
		
        
    }