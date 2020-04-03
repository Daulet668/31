package com.example.todolist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button BtnAddTask, BtnSeeTask, BtnDeleteTask;




    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        BtnAddTask = view.findViewById(R.id.btn_add_task);
        BtnAddTask.setOnClickListener(this);

        BtnSeeTask = view.findViewById(R.id.btn_see_task);
        BtnSeeTask.setOnClickListener(this);

        BtnDeleteTask = view.findViewById(R.id.btn_delete);
        BtnDeleteTask.setOnClickListener(this);
            return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_add_task:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddTaskFragment()).addToBackStack(null).commit();

                break;

            case R.id.btn_see_task:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ReadTasksFragment()).addToBackStack(null).commit();

                break;



            case R.id.btn_delete:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteTaskFragment()).addToBackStack(null).commit();

                break;
        }
        }
    }

