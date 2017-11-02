package com.example.amit.pamm;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by AMIT on 04-Feb-17.
 */

public class AboutFragment extends Fragment {
    TextView mAbout;
    @Override
    //hello
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v=inflater.inflate(R.layout.about_layout,container,false);
                mAbout= (TextView) v.findViewById(R.id.textView_about);
          mAbout.setText(R.string.about_string);
        return v;
    }
}