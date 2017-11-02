package com.example.amit.pamm;

/**
 * Created by AMIT on 10-Feb-17.
 */

public class DateAndColorLoader {
    String loadDate;
    int loadColor;

    DateAndColorLoader(){

    }
    DateAndColorLoader(String s,int j){
        this.loadColor=j;
        this.loadDate=s;
    }

    public String getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(String loadDate) {
        this.loadDate = loadDate;
    }

    public int getLoadColor() {
        return loadColor;
    }

    public void setLoadColor(int loadColor) {
        this.loadColor = loadColor;
    }
}
