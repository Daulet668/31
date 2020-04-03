package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static Database database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        database = Room.databaseBuilder(getApplicationContext(),Database.class, "taskdb").allowMainThreadQueries().build();


        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState!=null){
                return;

            }


            fragmentManager.beginTransaction().add(R.id.fragment_container,new HomeFragment()).commit();


        }

    }
}
