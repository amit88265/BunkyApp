package com.example.amit.pamm;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by AMIT on 29-Jan-17.
 */

public class DetailActivity extends AppCompatActivity implements Communicator{
int fragmentID;
    Fragment fragment;
    DetailFragment detailFragment;
    CompleteDataFragment dataFragment;
    GuideFragment guideFragment;
    AboutFragment aboutFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        FragmentManager fragmentManager= getFragmentManager();
        fragmentID=getIntent().getIntExtra("fragment_id",0);

        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
switch(fragmentID){
    case 1:
        if((fragment=fragmentManager.findFragmentByTag("detail_fragment"))==null){
             detailFragment = new DetailFragment();
            fragmentTransaction.add(R.id.fragmentContainerDetail,detailFragment,"detail_fragment");
            fragmentTransaction.commit();
        }
        else {
            detailFragment= (DetailFragment) fragment;
        }
    break;
    case 2:
        if((fragment=fragmentManager.findFragmentByTag("complete_data_fragment"))==null) {
            dataFragment = new CompleteDataFragment();
            fragmentTransaction.add(R.id.fragmentContainerDetail, dataFragment, "complete_data_fragment");
            fragmentTransaction.commit();
        }
        else {
            dataFragment= (CompleteDataFragment) fragment;
        }
        break;
    case 3:
        if((fragment=fragmentManager.findFragmentByTag("guide_fragment"))==null) {
            guideFragment = new GuideFragment();
            fragmentTransaction.add(R.id.fragmentContainerDetail, guideFragment, "guide_fragment");
            fragmentTransaction.commit();
        }
        else {
            guideFragment= (GuideFragment) fragment;
        }
        break;
    case 4:
        if((fragment=fragmentManager.findFragmentByTag("about_fragment"))==null) {
            aboutFragment=new AboutFragment();
            fragmentTransaction.add(R.id.fragmentContainerDetail, aboutFragment, "about_fragment");
            fragmentTransaction.commit();
        }
        else {
            aboutFragment= (AboutFragment) fragment;
        }
        break;
}



    }

    @Override
    public void respond(String subjectName) {
        //nothing use here
    }

    @Override
    public void respondToDate(String string) {
        FragmentManager f= getFragmentManager();
       DetailFragment detailFragment= (DetailFragment) f.findFragmentByTag("detail_fragment");
        detailFragment.changeDate(string);


    }


}
