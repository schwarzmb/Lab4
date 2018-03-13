package com.example.matthewschwarz.lab4;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by matthewschwarz on 3/13/18.
 */

public class MyAsyncTask extends AsyncTask<String, Void, String> {
    private TextView tv;



    public MyAsyncTask(TextView textView){
        tv = textView;

    }

    @Override
    protected void onPostExecute(String string){
        super.onPostExecute(string);
        Log.i("JSON", string);
        tv.setText(string);
    }

    @Override
    protected String doInBackground(String... String){
        URL url = null;
        try {
            url = new URL(String[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection connection = null;
        try {
            connection = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader((connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String l = null;
        try {
            l = bufferedReader.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }

        int i = 0;
        while(i < 20){
            try {
                l += bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
        return l;
    }

}
