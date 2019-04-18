package com.example.salil.coursebit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webview extends AppCompatActivity {
    WebView webView;
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        Intent intent=getIntent();
        int  tag= (intent.getIntExtra("newsid",-1));
        Log.i("news:",String.valueOf(tag));
         webView=(WebView)findViewById(R.id.web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setInitialScale(1);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setUseWideViewPort(true);

        if(tag==1)
        {
            webView.loadUrl("https://www.udemy.com/android-app-development-with-java/");
        }
        if(tag==2)
        {
            webView.loadUrl("https://www.udemy.com/the-complete-android-oreo-developer-course/");
        }
        if(tag==3)
        {
            webView.loadUrl("https://www.udemy.com/complete-android-developer-course/");
        }
        if(tag==4)
        {
            webView.loadUrl("https://www.udemy.com/master-android-7-nougat-java-app-development-step-by-step/");
        }
        if(tag==5)
        {
            webView.loadUrl(" https://www.udemy.com/complete-android-n-developer-course/");
        }

    }
}
