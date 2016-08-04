package siddhu.test.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import siddhu.test.com.myapplication.objects.NewsObjects;

/**
 * Created by admin on 8/4/2016.
 */

public class DetailsActivity extends AppCompatActivity {

    WebView webView;

    private static final int DEFAULT_POSITION=-1;
    private static final String KEY_POSITION="position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail);
        webView = (WebView) findViewById(R.id.activity_details_webview);
        int position = getIntent().getIntExtra(KEY_POSITION,DEFAULT_POSITION);
        NewsObjects newsObjects = NewsObjects.getObjNewsObjects().get(position);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){});
        webView.loadUrl(newsObjects.getDetailsUrl());
    }

    public static void start (Context context, int position)
    {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra("position",position);
        context.startActivity(intent);
    }

}
