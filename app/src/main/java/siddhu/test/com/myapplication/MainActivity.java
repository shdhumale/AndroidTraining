package siddhu.test.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import siddhu.test.com.myapplication.network.NewsAPI;
import siddhu.test.com.myapplication.objects.NewsApiArticleResponse;
import siddhu.test.com.myapplication.objects.NewsObjects;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<NewsApiArticleResponse> responseCall = NewsAPI.getNewsAPI().getArticles("bbcnews", "top");
        responseCall.enqueue(new Callback<NewsApiArticleResponse>() {
            @Override
            public void onResponse(Call<NewsApiArticleResponse> call, Response<NewsApiArticleResponse> response) {
                NewsApiArticleResponse newsApiArticleResponse = response.body();
                Toast.makeText(MainActivity.this, "response received", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<NewsApiArticleResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error received", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.activity_main_newstems);
        progressBar = (ProgressBar) findViewById(R.id.activity_main_progress);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NewAdapter newAdapter = new NewAdapter(NewsObjects.getObjNewsObjects());
        recyclerView.setAdapter(newAdapter);


    }
}
