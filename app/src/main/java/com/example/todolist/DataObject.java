package com.example.todolist;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataObject {


    @Insert
    public void addTask(LIst task);
    @Query("select * from tasks")
    public List<LIst> getTasks();

    @Delete
    public void deleteTask(LIst tasks);


}
