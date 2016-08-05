package siddhu.test.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import siddhu.test.com.myapplication.network.NewsAPI;
import siddhu.test.com.myapplication.objects.Article;
import siddhu.test.com.myapplication.objects.CommonUsage;
import siddhu.test.com.myapplication.objects.NewsApiArticleResponse;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    //List<NewsObjects> newsItems = new ArrayList<NewsObjects>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.activity_main_newstems);
        progressBar = (ProgressBar) findViewById(R.id.activity_main_progress);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Call<NewsApiArticleResponse> responseCall = NewsAPI.getNewsAPI().getArticles("bbcnews", "top");
        responseCall.enqueue(new Callback<NewsApiArticleResponse>() {
            @Override
            public void onResponse(Call<NewsApiArticleResponse> call, Response<NewsApiArticleResponse> response) {
                NewsApiArticleResponse newsApiArticleResponse = response.body();
                List<Article> articles = newsApiArticleResponse.getArticles();
               /* for(int i=0;i<articles.size();i++)
                {
                    //String imageUrl, String title, String date, String description, String detailsUrl
                    NewsObjects newsObjects = new NewsObjects(articles.get(i).getUrlToImage(),articles.get(i).getTitle(),articles.get(i).getPublishedAt(),articles.get(i).getDescription(),articles.get(i).getUrl());
                    newsItems.add(newsObjects);
                }*/
                CommonUsage.setAllNewArticle(articles);

                NewAdapter newAdapter = new NewAdapter(CommonUsage.getAllNewArticle());
                recyclerView.setAdapter(newAdapter);

                Toast.makeText(MainActivity.this, "response received", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<NewsApiArticleResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error received", Toast.LENGTH_SHORT).show();
            }
        });





    }
}
