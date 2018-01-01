package com.example.ntan.earthquakeversion2;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

import static android.content.Intent.ACTION_VIEW;

/**
 * Created by NTan on 7/26/2017.
 */

public class MainActivity extends AppCompatActivity {
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-05-02&minfelt=50&minmagnitude=5";
    ArrayList<EarthQuake> earthQuakes = new ArrayList<EarthQuake>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up AsyncTask
        MyTask myTask = new MyTask();
        myTask.execute(USGS_REQUEST_URL);
    }
    private class MyTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            return GetDataFromUrl.fetchEarthquakeData(strings[0]) ;
        }
        @Override
        protected void onPostExecute(String result) {
            earthQuakes =QueryUtils.extractEarthquakes(result);
            EarthQuakeAdapter earthQuakeAdapter = new EarthQuakeAdapter(MainActivity.this, earthQuakes);
            ListView listView = (ListView) findViewById(R.id.listview_flavor);
            listView.setAdapter(earthQuakeAdapter);
        }
    }
}