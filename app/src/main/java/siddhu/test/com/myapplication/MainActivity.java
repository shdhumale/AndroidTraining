package siddhu.test.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import siddhu.test.com.myapplication.objects.NewsObjects;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.activity_main_newstems);
        progressBar = (ProgressBar) findViewById(R.id.activity_main_progress);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NewAdapter newAdapter = new NewAdapter(NewsObjects.getObjNewsObjects());
        recyclerView.setAdapter(newAdapter);


    }
}
