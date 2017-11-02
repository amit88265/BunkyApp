package com.example.amit.pamm;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity implements Communicator {
    FragmentManager fragmentManager;
    MainFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        Fragment f;
        if ((f=fragmentManager.findFragmentByTag("main_fragment"))==null) {
             fragment = new MainFragment();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.fragmentContainer, fragment, "main_fragment");
            transaction.commit();
        }
        else{
            fragment= (MainFragment) f;
        }

    }

    @Override
    public void respond(String subjectName) {
       MainFragment f= (MainFragment) fragmentManager.findFragmentByTag("main_fragment");
        f.sendData(subjectName);

    }

    @Override
    public void respondToDate(String s) {
        //nothing use here
    }


}
