package com.example.amit.pamm;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
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

public class DetailFragment extends Fragment {
    int i=0;
    private static final String ADD_DETAILS = "details";
    ListView listDetail;
    int position_of_subject;
    private static final String POSITION_OF_SUBJECT= "positionOfSubject";
    detailAdapter adapter;
         DateKeeper mDateKeeper;
    ArrayList<DateKeeper> dateOfSubject = new ArrayList<>();
    int count=0;
    float[] totalAttendance= new float[12];
    float[] totalPresent= new float[12];
    float percentAttendance=0;
    int remain_bunk=0;
    Communicator communicatorForData;
    MyDatabaseAdapter myDatabaseAdapter;
DataOfAttendance attendance;
MyDatabaseAdapter.MyHelper helper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_detail,container,false);
        listDetail= (ListView) v.findViewById(R.id.listView_detail);
        registerForContextMenu(listDetail);
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
               setHasOptionsMenu(true);
        communicatorForData= (Communicator) getActivity();
        myDatabaseAdapter= new MyDatabaseAdapter(getActivity());
        helper=myDatabaseAdapter.new MyHelper(getActivity());
        attendance= new DataOfAttendance(getActivity());
        String title=getActivity().getIntent().getStringExtra("title");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.add_menu_date, menu);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        position_of_subject =getActivity().getIntent().getIntExtra(POSITION_OF_SUBJECT,0);
loading(position_of_subject);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (R.id.add_subject_menuItem) {
            case R.id.add_subject_menuItem:
FragmentManager f= getActivity().getFragmentManager();
                DialogFragment  dialogDate= new DatePickerFragment();
                dialogDate.show(f,ADD_DETAILS);
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater= getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.context_menu_list,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        SharedPreferences s= getActivity().getSharedPreferences(attendance.AttendanceFile, Context.MODE_PRIVATE);
        switch (item.getItemId()) {
            case R.id.present_id:
                info.targetView.setBackgroundColor(getResources().getColor(R.color.green));
                dateOfSubject.get(info.position).setColorTemp(getResources().getColor(R.color.green));
                for(i=0;i<12;i++){
                    if(i==position_of_subject){
                        totalAttendance[i]= s.getFloat("totalAtt"+i, 0);
                        totalPresent[i]= s.getFloat("totalPresent"+i,0);
                        totalAttendance[i]++;
                        totalPresent[i]++;
                        percentAttendance=100*(totalPresent[i]/totalAttendance[i]);
                        remain_bunk = (int) ((1.3333 * totalPresent[i]) - totalAttendance[i]);
                       attendance.saveAttendance(totalAttendance[i],totalPresent[i],percentAttendance,remain_bunk,position_of_subject);
                        myDatabaseAdapter.insertColorData(getResources().getColor(R.color.green),position_of_subject);
                        Log.d("folk"," "+dateOfSubject.get(info.position).getColorTemp());
                                                break;
                    }
                }

                return true;
            case R.id.absent_id:
                info.targetView.setBackgroundColor(getResources().getColor(R.color.red));
                dateOfSubject.get(info.position).setColorTemp(getResources().getColor(R.color.red));
                for(i=0;i<12;i++){
                    if(i==position_of_subject){
                        totalAttendance[i]= s.getFloat("totalAtt"+i, 0);
                        totalPresent[i]= s.getFloat("totalPresent"+i,0);
                        totalAttendance[i]++;
                        percentAttendance=100*(totalPresent[i]/totalAttendance[i]);
                        remain_bunk = (int) ((1.3333 * totalPresent[i]) - totalAttendance[i]);
                        myDatabaseAdapter.insertColorData(getResources().getColor(R.color.red),position_of_subject);
                        attendance.saveAttendance(totalAttendance[i],totalPresent[i],percentAttendance,remain_bunk,position_of_subject);

                        break;
                    }
                }
                return true;
            case R.id.cancel_id:
                info.targetView.setBackgroundColor(getResources().getColor(R.color.slaty));
                dateOfSubject.get(info.position).setColorTemp(getResources().getColor(R.color.slaty));
                for(i=0;i<12;i++){
                if(i==position_of_subject) {
                    myDatabaseAdapter.insertColorData(getResources().getColor(R.color.slaty), position_of_subject);
                    break;
                }
                }
                    return true;

            case R.id.holiday_id:
                info.targetView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                dateOfSubject.get(info.position).setColorTemp(getResources().getColor(R.color.colorPrimary));
                for(i=0;i<12;i++){
                if(i==position_of_subject) {
                    myDatabaseAdapter.insertColorData(getResources().getColor(R.color.colorPrimary), position_of_subject);
                }
                }
                return true;

            case R.id.delete_id:
              //  TextView t= (TextView) info.targetView;
                dateOfSubject.remove(info.position);
                adapter.notifyDataSetChanged();
               // Toast.makeText(getActivity(),""+info.targetView+""+t.getBackground(),Toast.LENGTH_LONG).show();
              //  delete(t.getText().toString(),0,position_of_subject);
                return true;
            default:
                return super.onContextItemSelected(item);

        }
    }



    public void changeDate(String changedDate){
        if(count==0){
            dateOfSubject.add(new DateKeeper(changedDate,0));
            adapter=new detailAdapter(dateOfSubject);
            listDetail.setAdapter(adapter);
            count++;
        }
        else if(count>0){
            dateOfSubject.add(new DateKeeper(changedDate,0));
            adapter.notifyDataSetChanged();
        }
        myDatabaseAdapter.insertDateData(changedDate,position_of_subject);
    }


class detailAdapter extends ArrayAdapter<DateKeeper>{
    public detailAdapter(ArrayList<DateKeeper> list_of_dates) {
        super(getActivity(),0,list_of_dates);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=getActivity().getLayoutInflater().inflate(R.layout.list_item_date,null);
        }
        mDateKeeper= getItem(position);
        TextView textView = (TextView) convertView.findViewById(R.id.date_list_textView);
        textView.setText(mDateKeeper.getDateList());
        Log.d("folk"," "+position+" "+parent+" "+mDateKeeper.getColorTemp());
        textView.setBackgroundColor(mDateKeeper.getColorTemp());
        return convertView;
    }
}

    int delete(String deleteDate, int deleteColor,int tablePosition){
        SQLiteDatabase db=helper.getReadableDatabase();
        String[] whereArgs={deleteDate};
      int c=  db.delete(helper.TABLE_DATE_ONE,helper.COLUMN_DATE+"=?",whereArgs);
        Log.d("folk1",""+c);
        return c;
    }


    void loading(int p){
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor c1,c2;
        String[] colTwo={helper.COLUMN_DATE};
        String[] colOne={helper.COLUMN_COLOR};
        switch (p+1){

            case 1:
                c1=db.query(MyDatabaseAdapter.MyHelper.TABLE_DATE_ONE,colTwo,null,null,null,null,null);
                c2=db.query(MyDatabaseAdapter.MyHelper.TABLE_COLOR_ONE,colOne,null,null,null,null,null);
                while(c1.moveToNext()&&c2.moveToNext()){
                    dateOfSubject.add(new DateKeeper(c1.getString(0),c2.getInt(0)));
                    Log.d("folk1",""+c1.getString(0));
                }
               adapter=new detailAdapter(dateOfSubject);
                listDetail.setAdapter(adapter);
                count=1;
                break;
            case 2:
                c1=db.query(MyDatabaseAdapter.MyHelper.TABLE_DATE_TWO,colTwo,null,null,null,null,null);
                c2=db.query(MyDatabaseAdapter.MyHelper.TABLE_COLOR_TWO,colOne,null,null,null,null,null);
                while(c1.moveToNext()&&c2.moveToNext()){
                    dateOfSubject.add(new DateKeeper(c1.getString(0),c2.getInt(0)));
                }
                adapter=new detailAdapter(dateOfSubject);
                listDetail.setAdapter(adapter);
                count=1;
                break;
            case 3:
                c1=db.query(MyDatabaseAdapter.MyHelper.TABLE_DATE_THREE,colTwo,null,null,null,null,null);
                c2=db.query(MyDatabaseAdapter.MyHelper.TABLE_COLOR_THREE,colOne,null,null,null,null,null);
                while(c1.moveToNext()&&c2.moveToNext()){
                    dateOfSubject.add(new DateKeeper(c1.getString(0),c2.getInt(0)));
                }
                adapter=new detailAdapter(dateOfSubject);
                listDetail.setAdapter(adapter);
                count=1;
                break;
            case 4:
                c1=db.query(MyDatabaseAdapter.MyHelper.TABLE_DATE_FOUR,colTwo,null,null,null,null,null);
                c2=db.query(MyDatabaseAdapter.MyHelper.TABLE_COLOR_FOUR,colOne,null,null,null,null,null);
                while(c1.moveToNext()&&c2.moveToNext()){
                    dateOfSubject.add(new DateKeeper(c1.getString(0),c2.getInt(0)));
                }
                adapter=new detailAdapter(dateOfSubject);
                listDetail.setAdapter(adapter);
                count=1;
                break;
            case 5:
                c1=db.query(MyDatabaseAdapter.MyHelper.TABLE_DATE_FIVE,colTwo,null,null,null,null,null);
                c2=db.query(MyDatabaseAdapter.MyHelper.TABLE_COLOR_FIVE,colOne,null,null,null,null,null);
                while(c1.moveToNext()&&c2.moveToNext()){
                    dateOfSubject.add(new DateKeeper(c1.getString(0),c2.getInt(0)));
                }
                adapter=new detailAdapter(dateOfSubject);
                listDetail.setAdapter(adapter);
                count=1;
                break;
            case 6:
                c1=db.query(MyDatabaseAdapter.MyHelper.TABLE_DATE_SIX,colTwo,null,null,null,null,null);
                c2=db.query(MyDatabaseAdapter.MyHelper.TABLE_COLOR_SIX,colOne,null,null,null,null,null);
                while(c1.moveToNext()&&c2.moveToNext()){
                    dateOfSubject.add(new DateKeeper(c1.getString(0),c2.getInt(0)));
                }
                adapter=new detailAdapter(dateOfSubject);
                listDetail.setAdapter(adapter);
                count=1;
                break;
            case 7:
                c1=db.query(MyDatabaseAdapter.MyHelper.TABLE_DATE_SEVEN,colTwo,null,null,null,null,null);
                c2=db.query(MyDatabaseAdapter.MyHelper.TABLE_COLOR_SEVEN,colOne,null,null,null,null,null);
                while(c1.moveToNext()&&c2.moveToNext()){
                    dateOfSubject.add(new DateKeeper(c1.getString(0),c2.getInt(0)));
                }
                adapter=new detailAdapter(dateOfSubject);
                listDetail.setAdapter(adapter);
                count=1;
                break;
            case 8:
                c1=db.query(MyDatabaseAdapter.MyHelper.TABLE_DATE_EIGHT,colTwo,null,null,null,null,null);
                c2=db.query(MyDatabaseAdapter.MyHelper.TABLE_COLOR_EIGHT,colOne,null,null,null,null,null);
                while(c1.moveToNext()&&c2.moveToNext()){
                    dateOfSubject.add(new DateKeeper(c1.getString(0),c2.getInt(0)));
                }
                adapter=new detailAdapter(dateOfSubject);
                listDetail.setAdapter(adapter);
                count=1;
                break;
            case 9:
                c1=db.query(MyDatabaseAdapter.MyHelper.TABLE_DATE_NINE,colTwo,null,null,null,null,null);
                c2=db.query(MyDatabaseAdapter.MyHelper.TABLE_COLOR_NINE,colOne,null,null,null,null,null);
                while(c1.moveToNext()&&c2.moveToNext()){
                    dateOfSubject.add(new DateKeeper(c1.getString(0),c2.getInt(0)));
                }
                adapter=new detailAdapter(dateOfSubject);
                listDetail.setAdapter(adapter);
                count=1;
                break;
            case 10:
                c1=db.query(MyDatabaseAdapter.MyHelper.TABLE_DATE_TEN,colTwo,null,null,null,null,null);
                c2=db.query(MyDatabaseAdapter.MyHelper.TABLE_COLOR_TEN,colOne,null,null,null,null,null);
                while(c1.moveToNext()&&c2.moveToNext()){
                    dateOfSubject.add(new DateKeeper(c1.getString(0),c2.getInt(0)));
                }
                adapter=new detailAdapter(dateOfSubject);
                listDetail.setAdapter(adapter);
                count=1;
                break;
            case 11:
                c1=db.query(MyDatabaseAdapter.MyHelper.TABLE_DATE_ELEVEN,colTwo,null,null,null,null,null);
                c2=db.query(MyDatabaseAdapter.MyHelper.TABLE_COLOR_ELEVEN,colOne,null,null,null,null,null);
                while(c1.moveToNext()&&c2.moveToNext()){
                    dateOfSubject.add(new DateKeeper(c1.getString(0),c2.getInt(0)));
                }
                adapter=new detailAdapter(dateOfSubject);
                listDetail.setAdapter(adapter);
                count=1;
                break;
            case 12:
                c1=db.query(MyDatabaseAdapter.MyHelper.TABLE_DATE_TWELVE,colTwo,null,null,null,null,null);
                c2=db.query(MyDatabaseAdapter.MyHelper.TABLE_COLOR_TWELVE,colOne,null,null,null,null,null);
                while(c1.moveToNext()&&c2.moveToNext()){
                    dateOfSubject.add(new DateKeeper(c1.getString(0),c2.getInt(0)));
                }
                adapter=new detailAdapter(dateOfSubject);
                listDetail.setAdapter(adapter);
                count=1;
                break;
        }


    }


}
