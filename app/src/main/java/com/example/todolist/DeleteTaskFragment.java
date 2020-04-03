package com.example.todolist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DeleteTaskFragment extends Fragment {

    private EditText TxtTaskId;
    private Button DeleteButton;

    public DeleteTaskFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_delete_task, container, false);
        TxtTaskId = v.findViewById(R.id.txt_delete);
        DeleteButton = v.findViewById(R.id.btn_delete2);

        DeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(TxtTaskId.getText().toString());
                LIst tasks = new LIst();
                tasks.setId(id);
                MainActivity.database.DataObject().deleteTask(tasks);


                Toast.makeText(getActivity(),"Task successfully deleted", Toast.LENGTH_SHORT).show();
                TxtTaskId.setText("");
            }
        });
            return v;
    }
}
