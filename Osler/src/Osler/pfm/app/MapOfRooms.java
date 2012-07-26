package Osler.pfm.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.RelativeLayout;

public class MapOfRooms extends Activity {
	// JSON Node names
	String[] rooms = new String[25];

	Bitmap bimage = null;
	Bitmap bimage2;

	RelativeLayout baseLayout = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);
        WebView mWebView;
        mWebView = (WebView) findViewById(R.id.webView1);
        String url = "http://oslerrtls.eecs.uottawa.ca/epe/main/";
        mWebView.loadUrl(url); 
        /*
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.overlay);

		baseLayout = (RelativeLayout) findViewById(R.id.baselayout);

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
					String RoomId = jo.getString(TAG_ROOMID);
					rooms[i] = RoomId;
				}
			}

			//Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();

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

		// leaf = (ImageView) findViewById(R.id.myImageViewoverlay1);

		ImageView leaf1 = (ImageView) findViewById(R.id.myImageView);
		bimage = getBitmapFromURL("http://osler.eecs.uottawa.ca/PFM/images/plan1.png");
		leaf1.setImageBitmap(bimage);

		bimage2 = getBitmapFromURL("http://osler.eecs.uottawa.ca/PFM/images/blue_spot.png");

		// baseLayout.setVisibility(View.GONE);

		Display display = getWindowManager().getDefaultDisplay();
		int width = display.getWidth(); // deprecated
		int height = display.getHeight(); // deprecated

		/*Toast.makeText(
				this,
				"Image Width: " + display.getWidth() + ", Height: "
						+ display.getHeight(), Toast.LENGTH_LONG).show();*/
        //String[] rooms1 = {"ED1","ED2","ED3","ED4","ED5","ED6","ED7","ED8","ED9","ED10","ED11","ED12","CCU1","CCU2","CCU3","CCU4","CCU5","CCU6","CCU7","CCU8","CCU9","CCU10","CCU11","CCU12"}; 
		/*for (String room : rooms) {
			if (room != null) {
				setRoomFlag(room, width, height);
			}
		}*/

	}

	/*
	private void setRoomFlag(String roomNo, int screenWidth, int screnHeight) {

		int fixedWidth = 600;
		int fixedHeight = 1024;

		int marginLeft = 0;      //62, 90, 130, 167, 200, 230  //430, 425, 420, 415, 410, 405
		int marginTop = 0;        //330, 365, 410, 440, 470, 500 //390, 380, 370, 360, 350, 340

		int defaultEDMarginLeft[] = {62, 90, 130, 167, 200, 230, 62, 95, 140, 177, 210, 250 };
		int defaultEDMarginTop[] = {430, 420, 410, 400, 390, 380, 830, 820, 810, 800, 790, 780 };
		
		int defaultCCUMarginLeft[] = {330, 365, 405, 435, 465, 500, 360, 400, 440, 475, 515, 550 };
		int defaultCCUMarginTop[] = {370, 360, 350, 340, 330, 320 , 750, 740,730, 720, 710, 700};
        
		int edPos = -1;
		int ccuPos = -1;
        
		 if (roomNo.contains("ED10")) {
			edPos = 10;
		} else if (roomNo.contains("ED11")) {
			edPos = 11;
		} else if (roomNo.contains("ED12")) {
			edPos = 12;
		}
		else if (roomNo.contains("ED1")) {
			edPos = 1;
		} else if (roomNo.contains("ED2")) {
			edPos = 2;
		} else if (roomNo.contains("ED3")) {
			edPos = 3;
		} else if (roomNo.contains("ED4")) {
			edPos = 4;
		} else if (roomNo.contains("ED5")) {
			edPos = 5;
		} else if (roomNo.contains("ED6")) {
			edPos = 6;
		} else if (roomNo.contains("ED7")) {
			edPos = 7;
		} else if (roomNo.contains("ED8")) {
			edPos = 8;
		} else if (roomNo.contains("ED9")) {
			edPos = 9;
		} 

		 if (roomNo.contains("CCU10")) {
			 ccuPos = 10;
			} else if (roomNo.contains("CCU11")) {
				ccuPos = 11;
			} else if (roomNo.contains("CCU12")) {
				ccuPos = 12;
			}
			else if (roomNo.contains("CCU1")) {
				ccuPos = 1;
			} else if (roomNo.contains("CCU2")) {
				ccuPos = 2;
			} else if (roomNo.contains("CCU3")) {
				ccuPos = 3;
			} else if (roomNo.contains("CCU4")) {
				ccuPos = 4;
			} else if (roomNo.contains("CCU5")) {
				ccuPos = 5;
			} else if (roomNo.contains("CCU6")) {
				ccuPos = 6;
			} else if (roomNo.contains("CCU7")) {
				ccuPos = 7;
			} else if (roomNo.contains("CCU8")) {
				ccuPos = 8;
			} else if (roomNo.contains("CCU9")) {
				ccuPos = 9;
			} 

		 
		 if (edPos >= 0) {
			marginLeft = defaultEDMarginLeft[edPos - 1] * screenWidth
					/ fixedWidth;
			marginTop = defaultEDMarginTop[edPos - 1] * screnHeight
					/ fixedHeight;
			makeImageOverlay(marginLeft, marginTop);
		} else if(ccuPos >= 0) {
			marginLeft = defaultCCUMarginLeft[ccuPos - 1] * screenWidth
					/ fixedWidth;
			marginTop = defaultCCUMarginTop[ccuPos - 1] * screnHeight
					/ fixedHeight;
			makeImageOverlay(marginLeft, marginTop);
		}

	}

	private void makeImageOverlay(int left, int top) {
		ImageView image = new ImageView(this);
		image.setImageBitmap(bimage2);

		RelativeLayout.LayoutParams par = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		par.leftMargin = left;
		par.topMargin = top;

		image.setScaleType(ImageView.ScaleType.CENTER_CROP);

		image.setLayoutParams(par);

		baseLayout.addView(image);

		System.out.println("..................... Adding : " + left + ", "
				+ top);
	}

	

	public static Bitmap getBitmapFromURL(String src) {
		try {
			Log.e("src", src);
			URL url = new URL(src);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoInput(true);
			connection.connect();
			InputStream input = connection.getInputStream();
			Bitmap myBitmap = BitmapFactory.decodeStream(input);
			Log.e("Bitmap", "returned");
			return myBitmap;
		} catch (IOException e) {
			e.printStackTrace();
			Log.e("Exception", e.getMessage());
			return null;
		}
	}

*/
}
