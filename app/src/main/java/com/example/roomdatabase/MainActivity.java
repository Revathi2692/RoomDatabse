package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity<ListLayoutManager> extends AppCompatActivity {

    //Intialize variable
    EditText editText;
    Button btAdd,btReset;
    RecyclerView recyclerView;

    List<MainData> dataList =  new ArrayList<>();
    ListLayoutManager layoutManager;


    RoomDb database;
    MainAdapter  adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //assign varaible
        editText = findViewById(R.id.edit_text);
        btAdd = findViewById(R.id.bt_add);
        btReset= findViewById(R.id.bt_reset);
        recyclerView = findViewById(R.id.recycler_view);

    }
}