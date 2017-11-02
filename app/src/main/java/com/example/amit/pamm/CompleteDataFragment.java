package com.example.amit.pamm;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AMIT on 04-Feb-17.
 */

public class CompleteDataFragment extends Fragment {

    private ListView mCompleteDataList;
    TextView mSubjectTitle,mTotalAttendance,mPerecentAttendance,mAvailableBunk,
            mShowTotalAttendance,mShowPerecentAttendance,mShowAvailableBunk;
    DataOfAttendance dataOfAttendance,getDataOfAttendance;
CompleteDataAdapter completeDataAdapter;
String[] nameOfSubject= new String[12];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataOfAttendance=new DataOfAttendance(getActivity());
        int size=getActivity().getIntent().getIntExtra("size",0);
for(int i=0;i<size;i++){
    nameOfSubject[i]=getActivity().getIntent().getStringExtra("subjectTitle"+i);
}

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v=inflater.inflate(R.layout.fragment_complete_data,container,false);
        mCompleteDataList= (ListView) v.findViewById(R.id.complete_data_listView);
           dataOfAttendance.loadAttendance();
       completeDataAdapter= new CompleteDataAdapter(dataOfAttendance.attendanceArrayList);
        mCompleteDataList.setAdapter(completeDataAdapter);
        return v;
    }


   class CompleteDataAdapter extends ArrayAdapter<DataOfAttendance> {
       public CompleteDataAdapter(ArrayList<DataOfAttendance> dataOfAttendanceArrayList ) {
           super(getActivity(),0,dataOfAttendanceArrayList);
       }
       @Override
       public View getView(int position, View convertView, ViewGroup parent) {
           if(convertView==null){
               convertView=getActivity().getLayoutInflater().inflate(R.layout.complete_data_layout,null);
           }
           getDataOfAttendance=getItem(position);
           mSubjectTitle= (TextView) convertView.findViewById(R.id.title_of_subject);
           mPerecentAttendance= (TextView) convertView.findViewById(R.id.perecent_attendance);
           mTotalAttendance= (TextView) convertView.findViewById(R.id.Total_Attendance);
           mAvailableBunk= (TextView) convertView.findViewById(R.id.bunk_available);
           mShowTotalAttendance= (TextView) convertView.findViewById(R.id.Show_Total_Attendance);
           mShowPerecentAttendance= (TextView) convertView.findViewById(R.id.show_percent_attendance);
           mShowAvailableBunk= (TextView) convertView.findViewById(R.id.show_bunk_available);

           mSubjectTitle.setText(nameOfSubject[position]);
           mTotalAttendance.setText(R.string.total_classes_held);
           mPerecentAttendance.setText(R.string.precent_attendance);
           mAvailableBunk.setText(R.string.remaining_bunk);

           mShowTotalAttendance.setText(String.valueOf(getDataOfAttendance.getTotalAttendance()));
           mShowPerecentAttendance.setText(String.valueOf(getDataOfAttendance.getPre_attendance()));
           mShowAvailableBunk.setText(String.valueOf(getDataOfAttendance.getBunk_remaining()));

           return convertView;
       }
   }
}
