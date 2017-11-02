package com.example.amit.pamm;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by AMIT on 03-Feb-17.
 */

public class DataOfAttendance extends Object {


    float pre_attendance;
    int bunk_remaining;
    float TotalAttendance;
    Context context;
    SharedPreferences sharedPreferences;
    public static final String AttendanceFile="fileForAttendance";
    ArrayList<DataOfAttendance> attendanceArrayList= new ArrayList<>();
    DataOfAttendance(Context context){
        this.context=context;
    }
    DataOfAttendance(float TA,float PA,int RB){
        this.bunk_remaining=RB;
        this.TotalAttendance=TA;
        this.pre_attendance=PA;

    }


    public void saveAttendance(float TA,float TP,float PA,int RB,int subjectPosition){

        sharedPreferences=context.getSharedPreferences(AttendanceFile,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putFloat("totalAtt"+subjectPosition,TA);
        editor.putFloat("totalPresent"+subjectPosition,TP);
            editor.putFloat("perAtt"+subjectPosition,PA);
            editor.putInt("remain_bunk"+subjectPosition,RB);
        editor.apply();
Log.d("folk",""+TA+" "+PA+" "+RB);
    }



    public  void loadAttendance(){
        sharedPreferences=context.getSharedPreferences(AttendanceFile, Context.MODE_PRIVATE);
        float f1=0,f2=0;
        int i=0,j=0;

        while(i<(sharedPreferences.getAll().size()/4)) {
            f1 = sharedPreferences.getFloat("totalAtt"+i, 0);
            f2 = sharedPreferences.getFloat("perAtt"+i, 0);
            j = sharedPreferences.getInt("remain_bunk"+i, 0);
            attendanceArrayList.add(new DataOfAttendance(f1, f2, j));
            Log.d("folk",""+f1+" "+f2+" "+j);
            i++;
        }


    }

    public float getTotalAttendance() {
        return TotalAttendance;
    }

    public void setTotalAttendance(int totalAttendance) {
        TotalAttendance = totalAttendance;
    }

    public float getPre_attendance() {
        return pre_attendance;
    }

    public void setPre_attendance(float pre_attendance) {
        this.pre_attendance = pre_attendance;
    }

    public int getBunk_remaining() {

        return bunk_remaining;
    }

    public void setBunk_remaining(int bunk_remaining) {
        this.bunk_remaining = bunk_remaining;
    }
}
