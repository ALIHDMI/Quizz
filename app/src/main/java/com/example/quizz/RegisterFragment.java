package com.example.quizz;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterFragment extends Fragment {
    int count = 0;
    TextView result;
    EditText name;
    AppCompatButton saveButton;
    SQLiteDatabase database;
    MainActivity parent;
    public RegisterFragment(int count, SQLiteDatabase database, MainActivity parent) {
        this.count = count;
        this.database = database;
        this.parent = parent;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        result = view.findViewById(R.id.result);
        result.setText(String.valueOf(count));
        saveButton = view.findViewById(R.id.saveButton);
        name = view.findViewById(R.id.editText);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = database.rawQuery("SELECT * FROM users2", null);
                while (cursor.moveToNext()) {
                    if (cursor.getString(0) == null) {
                        break;
                    }
                }
//                String str = "";
//                if (cursor.getPosition() != 0) {
//                    str = "result" + String.valueOf(cursor.getPosition() + 1);
//                } else {
//                    str = "result";
//                }
                ContentValues cv = new ContentValues();
                cv.put("result", String.valueOf(name.getText().toString()));
                cv.put("result2", count);
                database.insert ("users2", "", cv);
                MainFragment mainFragment = new MainFragment();
                parent.replaceFragment(mainFragment);
            }
        });
    }
}