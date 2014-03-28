package com.hill30.android.angular;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends ActionBarActivity {
    private static final String TAG = "**WEBVIEW**";

    private WebView webView;


    private boolean needUpdateWatch = false;

    protected class UpdateWatchThread extends Thread {

        @Override
        public void run() {
            while(needUpdateWatch){
                try {
                    final String date = new SimpleDateFormat("HH:mm:ss").format(new Date());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            webView.loadUrl("javascript:if (WebApi.NotificationService) WebApi.NotificationService.updateWatch(\'" + date + "\')");
                        }
                    });
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private UpdateWatchThread updateWatchThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);

        // todo: is it really necessary?
        webView.requestFocus();

        webView.getSettings().setJavaScriptEnabled(true);

        // todo: call this method only for API level >= 16
        webView.getSettings().setAllowFileAccessFromFileURLs(true);

        webView.addJavascriptInterface(new MVCControllers(), "WebApi");

    }

    @Override
    protected void onResume() {
        super.onResume();
        webView.loadUrl("file:///android_asset/application/index.html");
        updateWatchThread = new UpdateWatchThread();
        needUpdateWatch = true;
        updateWatchThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        needUpdateWatch = false;
        updateWatchThread = null;
    }
}
