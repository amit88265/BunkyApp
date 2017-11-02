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

public class GuideFragment extends Fragment {
    TextView mGuide;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v=inflater.inflate(R.layout.guide_layout,container,false);
        mGuide= (TextView) v.findViewById(R.id.textView_guide);
        mGuide.setText(getString(R.string.guide_string));

        return v;
    }
}
