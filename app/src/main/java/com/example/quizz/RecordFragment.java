package com.example.quizz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class RecordFragment extends Fragment {

    ArrayList<Model> models = new ArrayList<>();
    SQLiteDatabase database;
    public RecordFragment(SQLiteDatabase database) {
        // Required empty public constructor
        this.database = database;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_record, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recycleView = view.findViewById(R.id.myRecycleView);
        RecycleViewAdapter adapter = new RecycleViewAdapter(getContext(), models);
        recycleView.setAdapter(adapter);
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        setup();
    }

    public void setup() {
        Cursor cursor = database.rawQuery("SELECT * FROM users2;", null);
        while (cursor.moveToNext()) {
            models.add(new Model("5"));
        }
    }
}