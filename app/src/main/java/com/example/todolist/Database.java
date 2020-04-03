package com.example.todolist;

import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {LIst.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {


    public abstract DataObject DataObject();

}

