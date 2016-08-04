package siddhu.test.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import siddhu.test.com.myapplication.objects.NewsObjects;

/**
 * Created by admin on 8/4/2016.
 */

public class DetailsActivity extends AppCompatActivity {

    WebView webView;
    ProgressBar progressBar;

    private static final int DEFAULT_POSITION=-1;
    private static final String KEY_POSITION="position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail);
        progressBar = (ProgressBar) findViewById(R.id.news_details_progressbar);
        webView = (WebView) findViewById(R.id.activity_details_webview);
        int position = getIntent().getIntExtra(KEY_POSITION,DEFAULT_POSITION);
        NewsObjects newsObjects = NewsObjects.getObjNewsObjects().get(position);
        getSupportActionBar().setTitle(newsObjects.getTitle());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
        webView.loadUrl(newsObjects.getDetailsUrl());
    }

    public static void start (Context context, int position)
    {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra("position",position);
        context.startActivity(intent);
    }

}
