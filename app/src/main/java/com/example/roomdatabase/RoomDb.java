package com.example.roomdatabase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//add database entites
@Database(entities = {MainData.class},version = 1, exportSchema = false)
public abstract class RoomDb  extends RoomDatabase{
   // create database instance

    private static RoomDb database;
    //define database name
    private static  String DATABASE_NAME ="database";

    public synchronized static RoomDb getInstance(Context context){
        //check condition
        if(database == null){
          //when database is null
            //intialsie database
            database = Room.databaseBuilder(context.getApplicationContext(),RoomDb.class,DATABASE_NAME)
                         .allowMainThreadQueries()
                         .fallbackToDestructiveMigration()
                         .build();
        }

      return database;
    }

    //cretae dao
    public abstract MainDao mainData();


    public void mainDao() {
    }
}
