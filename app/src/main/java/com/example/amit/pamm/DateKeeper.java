package com.example.amit.pamm;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by AMIT on 29-Jan-17.
 */

public class DateKeeper extends Object {

String dateList;
    int colorTemp;
    DateKeeper(String s,int c){
        this.dateList=s;
this.colorTemp=c;
    }

    public int getColorTemp() {
        return colorTemp;
    }

    public void setColorTemp(int colorTemp) {
        this.colorTemp = colorTemp;
    }

    public String getDateList() {
        return dateList;
    }

    public void setDateList(String dateList) {
        this.dateList = dateList;
    }
}
