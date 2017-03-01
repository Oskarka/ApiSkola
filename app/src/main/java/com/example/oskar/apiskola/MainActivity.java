package com.example.oskar.apiskola;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView mResultView;
    private String searchUrl = "http://swapi.co/api/starships/9/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResultView = (TextView) findViewById(R.id.tv_result);
        URL url = Network.buildUrl(searchUrl);
        new MakeTheSearch().execute(url);


    }

    public class MakeTheSearch extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... params) {
            URL url = params[0];
            String searchresults = null;


            try {
                searchresults = Network.networkConnection(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return searchresults;
        }


        @Override
        protected void onPostExecute(String searchresults) {
            if (searchresults != null && !searchresults.equals("")) {
                mResultView.setText(searchresults);

            }
        }


    }
}
