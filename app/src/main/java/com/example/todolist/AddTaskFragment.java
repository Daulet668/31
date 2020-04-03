package com.example.todolist;

import android.app.TaskInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddTaskFragment extends Fragment {

    private EditText TaskId, TaskName, TaskDescription, TaskCategory, TaskDuration;
    private Button BtnSave;

    public AddTaskFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_task, container, false);

        TaskId = v.findViewById(R.id.txt_task_id);
        TaskName = v.findViewById(R.id.txt_task_name);
        TaskDescription = v.findViewById(R.id.txt_description);
        TaskCategory = v.findViewById(R.id.txt_category);
        TaskDuration = v.findViewById(R.id.txt_date);
        BtnSave = v.findViewById(R.id.btn_save_task);

        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int taskid = Integer.parseInt(TaskId.getText().toString());
                String taskname = TaskName.getText().toString();
                String taskdescription = TaskDescription.getText().toString();
                String taskcategory = TaskCategory.getText().toString();
                int taskduration = Integer.parseInt(TaskDuration.getText().toString());


                LIst task = new LIst();
                task.setId(taskid);
                task.setName(taskname);
                task.setDescription(taskdescription);
                task.setCategory(taskcategory);
                task.setDuration(taskduration);

                MainActivity.database.DataObject().addTask(task);
                Toast.makeText(getActivity(), "Task added successfully", Toast.LENGTH_SHORT).show();

                TaskId.setText("");
                TaskName.setText("");
                TaskDescription.setText("");
                TaskCategory.setText("");
                TaskDuration.setText("");



            }
        });
            return v;
    }

}