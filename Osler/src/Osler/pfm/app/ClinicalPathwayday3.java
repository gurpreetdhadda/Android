package Osler.pfm.app;


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class ClinicalPathwayday3 extends Activity  {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);
        WebView mWebView;
        mWebView = (WebView) findViewById(R.id.webView1);
        String url = "http://osler.eecs.uottawa.ca/PFM/html/ClinicalPathwayDay3.html";
        mWebView.loadUrl(url); 
    }

}