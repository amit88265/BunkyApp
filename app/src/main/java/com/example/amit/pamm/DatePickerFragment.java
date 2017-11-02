package com.example.amit.pamm;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by AMIT on 29-Jan-17.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

Communicator comm;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar= Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month= calendar.get(Calendar.MONTH);
        int year= calendar.get(Calendar.YEAR);
        DatePickerDialog dialog ;
        dialog= new DatePickerDialog(getActivity(),this,year,month,day);

        return dialog;

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String name_of_month="";
        switch(month+1){
            case 1:name_of_month=getString(R.string.january);
                break;
            case 2:name_of_month=getString(R.string.february);
                break;
            case 3:name_of_month=getString(R.string.march);
                break;
            case 4:name_of_month=getString(R.string.april);
                break;
            case 5:name_of_month=getString(R.string.may);
                break;
            case 6:name_of_month=getString(R.string.june);
                break;
            case 7:name_of_month=getString(R.string.july);
                break;
            case 8:name_of_month=getString(R.string.august);
                break;
            case 9:name_of_month=getString(R.string.september);
                break;
            case 10:name_of_month=getString(R.string.october);
                break;
            case 11:name_of_month=getString(R.string.november);
                break;
            case 12:name_of_month=getString(R.string.december);
                break;
            default:
                name_of_month=getString(R.string.month_name_error);
        }

        String dateString=dayOfMonth + " "+name_of_month+ ","+year;
        comm.respondToDate(dateString);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm= (Communicator) getActivity();
    }
}