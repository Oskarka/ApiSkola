package com.example.oskar.apiskola;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Oskar on 2017-02-27.
 */

public class Network {

    public static String networkConnection(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        try{
            InputStream in = httpURLConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");
            boolean hasinput = scanner.hasNext();

            if (hasinput) return scanner.next();
            else return null;

        }
        finally {
            httpURLConnection.disconnect();
        }
    }


    public static URL buildUrl(String searchstring){
        URL url = null;
        try {
            url = new URL(searchstring);
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        return url;
    }
}
