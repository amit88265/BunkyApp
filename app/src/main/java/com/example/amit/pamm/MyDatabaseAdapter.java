package com.example.amit.pamm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by AMIT on 05-Feb-17.
 */

public class MyDatabaseAdapter  {

MyHelper myHelper;


    MyDatabaseAdapter(Context context){
        myHelper=new MyHelper(context);
    }

    public void insertDateData(String date,int positionOfColumn){

        String[] colTwo={MyHelper.COLUMN_DATE};
        SQLiteDatabase database=myHelper.getWritableDatabase();
        Cursor c;

        ContentValues contentValues= new ContentValues();
        contentValues.put(MyHelper.COLUMN_DATE,date);
        switch (positionOfColumn+1){
            case 1:
                c=database.query(MyHelper.TABLE_DATE_ONE,colTwo,null,null,null,null,null);
            long   id= database.insert(MyHelper.TABLE_DATE_ONE,null,contentValues);

                Log.d("vivz"," "+id);
                Log.d("vivz",c.getColumnName(0)+" "+c.getColumnCount());
                while(c.moveToNext()){
                    Log.d("vivz",c.getString(0));
                }
                break;
            case 2:
                id= database.insert(MyHelper.TABLE_DATE_TWO,null,contentValues);

                c=database.query(MyHelper.TABLE_DATE_TWO,colTwo,null,null,null,null,null);
                Log.d("vivz"," "+id);
                Log.d("vivz"," "+c.getColumnName(0)+" "+c.getColumnCount());
                while(c.moveToNext()){
                    Log.d("vivz",c.getString(0));
                }
                break;
            case 3:
                id=database.insert(MyHelper.TABLE_DATE_THREE,null,contentValues);
                c=database.query(MyHelper.TABLE_DATE_THREE,colTwo,null,null,null,null,null);
                Log.d("vivz"," "+id);
                Log.d("vivz"," "+c.getColumnName(0)+" "+c.getColumnCount());
                while(c.moveToNext()){
                    Log.d("vivz",c.getString(0));
                }
                break;
            case 4:
                id=database.insert(MyHelper.TABLE_DATE_FOUR,null,contentValues);
                c=database.query(MyHelper.TABLE_DATE_FOUR,colTwo,null,null,null,null,null);
                Log.d("vivz"," "+id);
                Log.d("vivz"," "+c.getColumnName(0)+" "+c.getColumnCount());
                while(c.moveToNext()){
                    Log.d("vivz",c.getString(0));
                }
                break;
            case 5:
                id=database.insert(MyHelper.TABLE_DATE_FIVE,null,contentValues);
                c=database.query(MyHelper.TABLE_DATE_FIVE,colTwo,null,null,null,null,null);
                Log.d("vivz"," "+id);
                Log.d("vivz"," "+c.getColumnName(0)+" "+c.getColumnCount());
                while(c.moveToNext()){
                    Log.d("vivz",c.getString(0));
                }
                break;
            case 6:
                id=database.insert(MyHelper.TABLE_DATE_SIX,null,contentValues);
                c=database.query(MyHelper.TABLE_DATE_SIX,colTwo,null,null,null,null,null);
                Log.d("vivz"," "+id);
                Log.d("vivz"," "+c.getColumnName(0)+" "+c.getColumnCount());
                while(c.moveToNext()){
                    Log.d("vivz",c.getString(0));
                }
                break;
            case 7:
                id=database.insert(MyHelper.TABLE_DATE_SEVEN,null,contentValues);
                c=database.query(MyHelper.TABLE_DATE_SEVEN,colTwo,null,null,null,null,null);
                Log.d("vivz"," "+id);
                Log.d("vivz"," "+c.getColumnName(0)+" "+c.getColumnCount());
                while(c.moveToNext()){
                    Log.d("vivz",c.getString(0));
                }
                break;
            case 8:
                id=database.insert(MyHelper.TABLE_DATE_EIGHT,null,contentValues);
                c=database.query(MyHelper.TABLE_DATE_EIGHT,colTwo,null,null,null,null,null);
                Log.d("vivz"," "+id);
                Log.d("vivz"," "+c.getColumnName(0)+" "+c.getColumnCount());
                while(c.moveToNext()){
                    Log.d("vivz",c.getString(0));
                }
                break;
            case 9:
                id=database.insert(MyHelper.TABLE_DATE_NINE,null,contentValues);
                c=database.query(MyHelper.TABLE_DATE_NINE,colTwo,null,null,null,null,null);
                Log.d("vivz"," "+id);
                Log.d("vivz"," "+c.getColumnName(0)+" "+c.getColumnCount());
                while(c.moveToNext()){
                    Log.d("vivz",c.getString(0));
                }
                break;
            case 10:
                id=database.insert(MyHelper.TABLE_DATE_TEN,null,contentValues);
                c=database.query(MyHelper.TABLE_DATE_TEN,colTwo,null,null,null,null,null);
                Log.d("vivz"," "+id);
                Log.d("vivz"," "+c.getColumnName(0)+" "+c.getColumnCount());
                while(c.moveToNext()){
                    Log.d("vivz",c.getString(0));
                }
                break;
            case 11:
               id= database.insert(MyHelper.TABLE_DATE_ELEVEN,null,contentValues);
                c=database.query(MyHelper.TABLE_DATE_ELEVEN,colTwo,null,null,null,null,null);
                Log.d("vivz"," "+id);
                Log.d("vivz"," "+c.getColumnName(0)+" "+c.getColumnCount());
                while(c.moveToNext()){
                    Log.d("vivz",c.getString(0));
                }
                break;
            case 12:
               id= database.insert(MyHelper.TABLE_DATE_TWELVE,null,contentValues);
                c=database.query(MyHelper.TABLE_DATE_TWELVE,colTwo,null,null,null,null,null);
                Log.d("vivz"," "+id);
                Log.d("vivz"," "+c.getColumnName(0)+" "+c.getColumnCount());
                while(c.moveToNext()){
                    Log.d("vivz",c.getString(0));
                }
                break;
        }



    }

public void insertColorData(int color,int positionOfColumn){
    String[] colOne={MyHelper.COLUMN_COLOR};

    SQLiteDatabase database=myHelper.getWritableDatabase();
    Cursor c;
    ContentValues contentValues= new ContentValues();
    contentValues.put(MyHelper.COLUMN_COLOR,color);
    switch (positionOfColumn+1){
        case 1:
           c= database.query(MyHelper.TABLE_COLOR_ONE,colOne,null,null,null,null,null);
         long id=  database.insert(MyHelper.TABLE_COLOR_ONE,null,contentValues);
            Log.d("vivz"," "+id);
            Log.d("vivz","Color inserted at  "+c.getColumnCount()+""+c.getColumnName(0));
            while (c.moveToNext()){
                Log.d("vivz"," "+c.getInt(0));
            }
            break;

        case 2:
            c= database.query(MyHelper.TABLE_COLOR_TWO,colOne,null,null,null,null,null);
         id=  database.insert(MyHelper.TABLE_COLOR_TWO,null,contentValues);
            Log.d("vivz","Color inserted at  "+c.getColumnCount());
            while (c.moveToNext()){
                Log.d("vivz"," "+c.getInt(0)+" "+id);
            }
            break;
        case 3:
            c= database.query(MyHelper.TABLE_COLOR_THREE,colOne,null,null,null,null,null);
            id=database.insert(MyHelper.TABLE_COLOR_THREE,null,contentValues);
            Log.d("vivz","Color inserted at  "+c.getColumnCount());
            while (c.moveToNext()){
                Log.d("vivz"," "+c.getInt(0)+" "+id);
            }
            break;
        case 4:
            c= database.query(MyHelper.TABLE_COLOR_FOUR,colOne,null,null,null,null,null);
            id=database.insert(MyHelper.TABLE_COLOR_FOUR,null,contentValues);
            Log.d("vivz","Color inserted at  "+c.getColumnCount());
            while (c.moveToNext()){
                Log.d("vivz"," "+c.getInt(0)+ " "+id);
            }
            break;
        case 5:
            c= database.query(MyHelper.TABLE_COLOR_FIVE,colOne,null,null,null,null,null);
            id=database.insert(MyHelper.TABLE_COLOR_FIVE,null,contentValues);
            while (c.moveToNext()){
                Log.d("vivz"," "+c.getInt(0)+" "+id);
            }
            break;
        case 6:
            c= database.query(MyHelper.TABLE_COLOR_SIX,colOne,null,null,null,null,null);
           id= database.insert(MyHelper.TABLE_COLOR_SIX,null,contentValues);
            while (c.moveToNext()){
                Log.d("vivz"," "+c.getInt(0)+" "+id);
            }
            break;
        case 7:
            c= database.query(MyHelper.TABLE_COLOR_SEVEN,colOne,null,null,null,null,null);
           id= database.insert(MyHelper.TABLE_COLOR_SEVEN,null,contentValues);
            while (c.moveToNext()){
                Log.d("vivz"," "+c.getInt(0)+" "+id);
            }
            break;
        case 8:
            c= database.query(MyHelper.TABLE_COLOR_EIGHT,colOne,null,null,null,null,null);
          id=  database.insert(MyHelper.TABLE_COLOR_EIGHT,null,contentValues);
            while (c.moveToNext()){
                Log.d("vivz"," "+c.getInt(0)+" "+id);
            }
            break;
        case 9:
            c= database.query(MyHelper.TABLE_COLOR_NINE,colOne,null,null,null,null,null);
          id=  database.insert(MyHelper.TABLE_COLOR_NINE,null,contentValues);
            while (c.moveToNext()){
                Log.d("vivz"," "+c.getInt(0)+" "+id);
            }
            break;
        case 10:
            c= database.query(MyHelper.TABLE_COLOR_TEN,colOne,null,null,null,null,null);
            id=database.insert(MyHelper.TABLE_COLOR_TEN,null,contentValues);
            while (c.moveToNext()){
                Log.d("vivz"," "+c.getInt(0)+" "+id);
            }
            break;
        case 11:
            c= database.query(MyHelper.TABLE_COLOR_ELEVEN,colOne,null,null,null,null,null);
         id=   database.insert(MyHelper.TABLE_COLOR_ELEVEN,null,contentValues);
            while (c.moveToNext()){
                Log.d("vivz"," "+c.getInt(0)+" "+id);
            }
            break;
        case 12:
            c= database.query(MyHelper.TABLE_COLOR_TWELVE,colOne,null,null,null,null,null);
           id= database.insert(MyHelper.TABLE_COLOR_TWELVE,null,contentValues);
            while (c.moveToNext()){
                Log.d("vivz"," "+c.getInt(0)+" "+id);
            }
            break;



    }




}


    class MyHelper extends SQLiteOpenHelper{
        private static final String DATABASE_NAME="myDatabase";
        private static final int VERSION_NO=1;
        public static final String TABLE_DATE_ONE="dateDataOne";
        public static final String TABLE_DATE_THREE="dateDataTwo";
        public static final String TABLE_DATE_TWO="dateDataThree";
        public static final String TABLE_DATE_FOUR="dateDataFour";
        public static final String TABLE_DATE_FIVE="dateDataFive";
        public static final String TABLE_DATE_SIX="dateDataSix";
        public static final String TABLE_DATE_SEVEN="dateDataSeven";
        public static final String TABLE_DATE_EIGHT="dateDataEight";
        public static final String TABLE_DATE_NINE="dateDataNine";
        public static final String TABLE_DATE_TEN="dateDataTen";
        public static final String TABLE_DATE_ELEVEN="dateDataEleven";
        public static final String TABLE_DATE_TWELVE="dateDataTwelve";

        public static final String TABLE_COLOR_ONE="colorDataOne";
        public static final String TABLE_COLOR_TWO="colorDataTwo";
        public static final String TABLE_COLOR_THREE="colorDataThree";
        public static final String TABLE_COLOR_FOUR="colorDataFour";
        public static final String TABLE_COLOR_FIVE="colorDataFive";
        public static final String TABLE_COLOR_SIX="colorDataSix";
        public static final String TABLE_COLOR_SEVEN="colorDataSeven";
        public static final String TABLE_COLOR_EIGHT="colorDataEight";
        public static final String TABLE_COLOR_NINE="colorDataNine";
        public static final String TABLE_COLOR_TEN="colorDataTen";
        public static final String TABLE_COLOR_ELEVEN="colorDataEleven";
        public static final String TABLE_COLOR_TWELVE="colorDataTwelve";

        public static final String COLUMN_DATE="subjectOne";
        public static final String COLUMN_COLOR="colorOne";




        Context context;

        public MyHelper(Context context) {
            super(context, DATABASE_NAME, null, VERSION_NO);
            this.context=context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL("create table "+ TABLE_COLOR_ONE + " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_COLOR +" integer);");
                db.execSQL("create table "+ TABLE_COLOR_TWO + " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_COLOR +" integer);");
                db.execSQL("create table "+ TABLE_COLOR_THREE + " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_COLOR +" integer);");
                db.execSQL("create table "+ TABLE_COLOR_FOUR + " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_COLOR +" integer);");
                db.execSQL("create table "+ TABLE_COLOR_FIVE + " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_COLOR +" integer);");
                db.execSQL("create table "+ TABLE_COLOR_SIX+ " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_COLOR +" integer);");
                db.execSQL("create table "+ TABLE_COLOR_SEVEN + " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_COLOR +" integer);");
                db.execSQL("create table "+ TABLE_COLOR_EIGHT + " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_COLOR +" integer);");
                db.execSQL("create table "+ TABLE_COLOR_NINE + " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_COLOR +" integer);");
                db.execSQL("create table "+ TABLE_COLOR_TEN+ " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_COLOR +" integer);");
                db.execSQL("create table "+ TABLE_COLOR_ELEVEN + " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_COLOR +" integer);");
                db.execSQL("create table "+ TABLE_COLOR_TWELVE + " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_COLOR +" integer);");


                db.execSQL("create table "+ TABLE_DATE_ONE + " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_DATE +" text);");

                db.execSQL("create table "+ TABLE_DATE_TWO + " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_DATE +" text);");

                db.execSQL("create table "+ TABLE_DATE_THREE + " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_DATE +" text);");

                db.execSQL("create table "+ TABLE_DATE_FOUR+ " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_DATE +" text);");

                db.execSQL("create table "+ TABLE_DATE_FIVE+ " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_DATE +" text);");

                db.execSQL("create table "+ TABLE_DATE_SIX + " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_DATE +" text);");

                db.execSQL("create table "+ TABLE_DATE_SEVEN + " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_DATE +" text);");

                db.execSQL("create table "+ TABLE_DATE_EIGHT+ " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_DATE+" text);");

                db.execSQL("create table "+ TABLE_DATE_NINE+ " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_DATE+" text);");

                db.execSQL("create table "+ TABLE_DATE_TEN+ " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_DATE+" text);");

                db.execSQL("create table "+ TABLE_DATE_ELEVEN + " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_DATE +" text);");

                db.execSQL("create table "+ TABLE_DATE_TWELVE + " ( " + " _id integer primary key autoincrement ,"+
                        COLUMN_DATE +" text);");

                Log.d("vivz","success "+db.getPath());

            }catch (SQLException e){
            Log.e("vivz",""+e);
                Toast.makeText(context,"sql error"+e,Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS");
            Log.d("vivz","upgrade");
            onCreate(db);
        }
    }

}
