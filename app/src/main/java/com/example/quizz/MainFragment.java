package com.example.quizz;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment {
    MainActivity parent;
    Cursor cursor;
    SQLiteDatabase database;

    public MainFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        parent = ((MainActivity) getActivity());
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        database = getContext().openOrCreateDatabase("database", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS users (name TEXT, first TEXT, second TEXT, third TEXT, fourth TEXT, UNIQUE(name))");
        database.execSQL("CREATE TABLE IF NOT EXISTS users2 (result TEXT, result2 TEXT, UNIQUE(result))");
        database.execSQL("CREATE TABLE IF NOT EXISTS users22 (result TEXT, UNIQUE(result))");
//        database.execSQL("INSERT OR IGNORE INTO users2 VALUES ('0');");
        database.execSQL("INSERT OR IGNORE INTO users VALUES ('1342+443', '1785', '939', '23992', '23932'), ('123+329', '844', '445', '452', '233'), ('6665+46', '9888', '6712', '6711', '569'), " +
                "('366+366', '732', '99', '678', '889'), ('1000+1', '1000', '1004', '999', '1001'), ('865+42', '900', '907', '768', '543'), ('55+76', '131', '130', '129', '120'), " +
                "('3535+353', '2999', '353', '350', '3888'), ('771+771', '1542', '1400', '1555', '1589'), ('86+965', '1434', '1533', '1049', '1051')");
        cursor = database.rawQuery("SELECT * FROM users;", null);
        AppCompatButton buttonStart = view.findViewById(R.id.start);
        AppCompatButton buttonRecord = view.findViewById(R.id.record);

        buttonRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecordFragment recordFragment = new RecordFragment(database);
                parent.replaceFragment(recordFragment);
            }
        });
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizzFragment quizzFragment = new QuizzFragment(parent,true, cursor, database);
                parent.replaceFragment(quizzFragment);
            }
        });
    }
}