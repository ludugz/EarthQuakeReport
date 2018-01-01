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

public class EarthQuake {

    private String mCity1;
    private String mCity2;
    private String mDate;
    private String mUrl;
    private double mMag;

    public EarthQuake(String mCity1, String mCity2, String mDate, double mMag, String mUrl) {
        this.mCity1 = mCity1;
        this.mCity2 = mCity2;
        this.mDate = mDate;
        this.mMag = mMag;
        this.mUrl = mUrl;
    }
    public String getmCity1() {
        return mCity1;
    }
    public String getmCity2() {
        return mCity2;
    }
    public String getmDate() {
        return mDate;
    }
    public double getmMag() {
        return mMag;
    }
    public String getmUrl() {
        return mUrl;
    }
    @Override
    public String toString() {
        return mMag+"";
    }
}
