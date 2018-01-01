/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.ntan.earthquakeversion2;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {
    private static final String LOG_TAG = EarthQuakeAdapter.class.getSimpleName();
    public EarthQuakeAdapter(Activity context, ArrayList<EarthQuake> EarthQuakes) {
        super(context, 0, EarthQuakes);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        EarthQuake currentEarthQuake = getItem(position);

        //Set Information to TextView
        TextView cityTextView1 = (TextView) listItemView.findViewById(R.id.idCity1);
        cityTextView1.setText(currentEarthQuake.getmCity1());
        TextView cityTextView2 = (TextView) listItemView.findViewById(R.id.idCity2);
        cityTextView2.setText(currentEarthQuake.getmCity2());
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.idDate);
        numberTextView.setText(currentEarthQuake.getmDate());
        TextView magView = (TextView) listItemView.findViewById(R.id.idMag);
        magView.setText(currentEarthQuake.toString());

        //SetBackground for each earthquake magnitude.
        GradientDrawable circle = (GradientDrawable) magView.getBackground();
        setBackground(currentEarthQuake,circle);
        
        //return
        return listItemView;
    }
    private void setBackground(EarthQuake currentEarthQuake, GradientDrawable circle){
        double s = currentEarthQuake.getmMag();
        int magnitudeID ;

        //Change colour depends on magnitude
        if (s<=1.0){
            magnitudeID = R.color.magnitude1;
        } else if (s<=2.0){
            magnitudeID = R.color.magnitude2;
        }
        else if (s<=3.0){
            magnitudeID = R.color.magnitude3;
        }
        else if (s<=4.0){
            magnitudeID = R.color.magnitude4;
        }
        else if (s<=5.0){
            magnitudeID = R.color.magnitude5;
        }
        else if (s<=6.0){
            magnitudeID = R.color.magnitude6;
        }
        else if (s<=7.0){
            magnitudeID = R.color.magnitude7;
        }
        else if (s<=8.0){
            magnitudeID = R.color.magnitude8;
        }
        else if (s<=9.0){
            magnitudeID = R.color.magnitude9;
        }
        else {
            magnitudeID = R.color.magnitude10plus;
        }
        circle.setColor(ContextCompat.getColor(getContext(),magnitudeID));

    }

}
