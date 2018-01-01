package com.example.ntan.earthquakeversion2;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
* Helper methods related to requesting and receiving earthquake data from USGS.
*/
public final class QueryUtils {
   private QueryUtils() {
   }
   public static ArrayList<EarthQuake> extractEarthquakes(String jsondata2) {
       // Create an empty ArrayList
       ArrayList<EarthQuake> earthquakes = new ArrayList<EarthQuake>();

       try {
            JSONObject jsonObject = new JSONObject(jsondata2);
            JSONArray jsonArrayFeatures = jsonObject.getJSONArray("features");
           for (int i=0;i<=jsonArrayFeatures.length()-1;i++){
               JSONObject jsonObjectInfo = (JSONObject) jsonArrayFeatures.get(i);
               JSONObject jsonProperties = jsonObjectInfo.getJSONObject("properties");
               String place = jsonProperties.getString("place");
               String url = jsonProperties.getString("url");

               // Convert place into 2 different lines
               String place1,place2;
               String[] temp;
               if(place.matches("(.*)of (.*)")){
                   temp = place.split("of ");
                   place1 = temp[0]+"of";
                   place2 = temp[1];
               }else{
                   place1=null;
                   place2 = place;
               }
               double mag =jsonProperties.getDouble("mag");
               Long time = jsonProperties.getLong("time");

               // Convert miliseconds into actual date
               Date dateObject = new Date(time);
               SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM DD,yyyy\nHH:mm:ss");
               String dateToDisplay = dateFormat.format(dateObject);

               // Add elements to earthquakes ArrayList
               earthquakes.add(new EarthQuake(place1,place2,dateToDisplay,mag,url));
           }
       } catch (JSONException e) {
           // catch the exception
           Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
       }
       // Return the list of earthquakes
       return earthquakes;
   }

}