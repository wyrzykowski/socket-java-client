package com.company.models;

import java.util.ArrayList;
import java.util.List;

public class Weather {
    private double temperature;
    private  double wind;
    private double humidity;
    private long time;
    private List<String> moreInfo = new ArrayList<String>();


    public void setWind(double wind) {
        this.wind = wind;
    }

    public double getWind() {
        return wind;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }


    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }


    public List<String> getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(List<String> moreInfo) {
        this.moreInfo = moreInfo;
    }

}
