package com.example.todolist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadTasksFragment extends Fragment {

    private TextView TxtInfo;


    public ReadTasksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_read_tasks, container, false);

        TxtInfo = v.findViewById(R.id.txt_display_info);

        List<LIst> tasks = MainActivity.database.DataObject().getTasks();

        String info = "";
        for (LIst tsk : tasks) {

            int id = tsk.getId();
            String name = tsk.getName();
            String description = tsk.getDescription();
            String category = tsk.getCategory();
            int duration = tsk.getDuration();
        info = info + "\n\n"+ "Id :"+id+"\n Name :"+name+"\n"+"Description :"+description+"\n Category :"+category+"\n Duration :"+duration;

        }
            TxtInfo.setText(info);
            return v;

        }


    }

