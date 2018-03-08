package com.example.matthewschwarz.lab4;

import android.os.Debug;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private static final String TAG_PREFIX = "URL";
    private static final boolean DEBUG = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = new WebView();
        setContentView(webView);
    }

    private String getURL(String string) throws java.io.IOException{
        URL url;
        try{
            url = new URL(string);
        }catch (java.net.MalformedURLException e){
            System.out.println("URL Error");
        }
        URLConnection urlConnection = url.openConnection(url);
        InputStreamReader inputStreamReader
        try {
            inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(inputStreamReader);

        String line = br.readLine();
        if(DEBUG)
            Log.i(TAG_PREFIX + "Stock.load()", "line = " + line);

        while (br.readLine() != null){
            ;

        br.close();




        //return string;

    }
}
