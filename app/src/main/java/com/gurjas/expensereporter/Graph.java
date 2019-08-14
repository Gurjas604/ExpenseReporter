package com.gurjas.expensereporter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.JavascriptInterface;

public class Graph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        WebSettings mwebSettings = myWebView.getSettings();
        mwebSettings.setJavaScriptEnabled(true);
        myWebView.setWebChromeClient(new WebChromeClient());

        myWebView.loadUrl("file:///android_asset/index.html");
    }
}
