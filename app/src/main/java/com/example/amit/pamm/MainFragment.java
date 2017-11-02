package com.example.amit.pamm;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by AMIT on 29-Jan-17.
 */

public class MainFragment extends Fragment implements AdapterView.OnItemClickListener{
    private static final String ADD_SUBJECT = "AddSubject";
    ArrayList<SubjectName> subjectList= new ArrayList<>();
    SubjectAdapter subjectAdapter;
    private  ListView list;
    SubjectName subjectName;
    int counter=0;
     private final static int  stop =12;
    SharedPreferences preferences;
    private static final String TitleFile="fileForSavingTitle";
    int j=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);
        list = (ListView) v.findViewById(R.id.list);
        list.setOnItemClickListener(this);
        loadData();
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.add_subject_menu, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_subject_menuItem:
                FragmentManager fm = getActivity().getFragmentManager();
                AddSubjectDialog dialog = new AddSubjectDialog();
                dialog.show(fm, ADD_SUBJECT);
                return  true;
            case R.id.details:
                Intent intent= new Intent(getActivity(),DetailActivity.class);
                for(j=0;j<subjectList.size();j++){
                    intent.putExtra("subjectTitle"+j,subjectList.get(j).getNameOfSubject());
                }
                intent.putExtra("size",j);
                intent.putExtra("fragment_id",2);
                startActivity(intent);
                return  true;
            case R.id.guide:
                Intent i= new Intent(getActivity(),DetailActivity.class);
                i.putExtra("fragment_id",3);
                startActivity(i);
                return  true;
            case R.id.about:
                Intent intentAbout= new Intent(getActivity(),DetailActivity.class);
                intentAbout.putExtra("fragment_id",4);
                startActivity(intentAbout);
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void sendData(String data){

    for(SubjectName name: subjectList){
        if(data.equals(name.getNameOfSubject())){
            Toast.makeText(getActivity(),"Item already added",Toast.LENGTH_SHORT).show();
            return;
        }
    }

    if(data==null||data.trim().equals("")){
        Toast.makeText(getActivity(), R.string.input_field_empty,Toast.LENGTH_SHORT).show();
    }
    else {

        if(subjectList.size()<stop){
            if(counter==0){
                subjectList.add( new SubjectName(data));
                subjectAdapter= new SubjectAdapter(subjectList);
                list.setAdapter(subjectAdapter);
                counter++;
            }
            else{
                subjectList.add(new SubjectName(data));
                subjectAdapter.notifyDataSetChanged();
            }
        }
        else{
            Toast.makeText(getActivity(), R.string.exceed_length_of_subject,Toast.LENGTH_SHORT).show();
        }

    }




}


    class SubjectAdapter extends ArrayAdapter<SubjectName>{
        public SubjectAdapter(ArrayList<SubjectName> list_of_subject) {
            super(getActivity(),0,list_of_subject);
        }
        TextView title;
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                convertView=getActivity().getLayoutInflater().inflate(R.layout.list_of_subject,null);
            }
            subjectName= getItem(position);

            title= (TextView) convertView.findViewById(R.id.subject_title);

            title.setText(subjectName.getNameOfSubject());


            return convertView;
        }



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView t= (TextView) view;
        Intent intent= new Intent(getActivity(),DetailActivity.class);
        intent.putExtra("title",t.getText());
        intent.putExtra("positionOfSubject",position);
        intent.putExtra("fragment_id",1);
        startActivity(intent);

    }
    public void saveData(){
        preferences=getActivity().getSharedPreferences(TitleFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        int n,i=0;
        n=subjectList.size();
        for(SubjectName s: subjectList){
            editor.putString("positionOfTitle"+i,s.getNameOfSubject());
            i++;
        }
        editor.putInt("sizeOfTitleList",n);
editor.apply();
    }
public void loadData(){
    preferences=getActivity().getSharedPreferences(TitleFile, Context.MODE_PRIVATE);
    int n=preferences.getInt("sizeOfTitleList",0);
    String tempTitle;
    for(int i=0;i<n;i++){
        tempTitle=preferences.getString("positionOfTitle"+i,"NA");
        subjectList.add(new SubjectName(tempTitle));
    }
    subjectAdapter=new SubjectAdapter(subjectList);
    list.setAdapter(subjectAdapter);
}

    @Override
    public void onPause() {
        super.onPause();
        saveData();
    }


}