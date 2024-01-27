package com.example.quizz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class QuizzFragment extends Fragment {
    MainActivity parent;
    RegisterFragment registerFragment;
    boolean first;
    int place = 0;
    int count = 0;
    boolean isRunning;
    Handler handler;
    View rootView;
    boolean done;
    SQLiteDatabase database;
    Cursor cursor;
    boolean start;
    public QuizzFragment(MainActivity parent, boolean start, Cursor cursor, SQLiteDatabase database) {
        this.start = start;
        if (start) {
            first = true;
        }
        this.cursor = cursor;
        this.database = database;
        this.parent = parent;
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
        return inflater.inflate(R.layout.fragment_quizz, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView)view.findViewById(R.id.textView);
        AppCompatButton firstButton = view.findViewById(R.id.firstButton);
        AppCompatButton secondButton = view.findViewById(R.id.secondButton);
        AppCompatButton thirdButton = view.findViewById(R.id.thirdButton);
        AppCompatButton fourthButton = view.findViewById(R.id.fourthButton);
        cursor.moveToNext();
        handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (place < 10) {
                    textView.setText(cursor.getString(0).toString());
                    firstButton.setText(cursor.getString(1).toString());
                    secondButton.setText(cursor.getString(2).toString());
                    thirdButton.setText(cursor.getString(3).toString());
                    fourthButton.setText(cursor.getString(4).toString());
                    if (done) {
                        cursor.moveToNext();
                        done = false;
                    }
                } else {
                    handler.removeMessages(0);
                    back();
                }
                if (place < 10) {
                    handler.postDelayed(this, 50);
                }
            }

        });

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = cursor.getString(0).toString();
                int temp = solve(result);
                result = String.valueOf(temp);
                if (result.equals(cursor.getString(1))) {
                    count++;
                }
                done = true;
                place++;
            }
        });
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = cursor.getString(0).toString();
                int temp = solve(result);
                result = String.valueOf(temp);
                if (result.equals(cursor.getString(2))) {
                    count++;
                }
                done = true;
                place++;
            }
        });
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = cursor.getString(0).toString();
                int temp = solve(result);
                result = String.valueOf(temp);
                if (result.equals(cursor.getString(3))) {
                    count++;
                }
                done = true;
                place++;
            }
        });
        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = cursor.getString(0).toString();
                int temp = solve(result);
                result = String.valueOf(temp);
                if (result.equals(cursor.getString(4))) {
                    count++;
                }
                done = true;
                place++;
            }
        });
    }

    public int solve (String str) {
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        boolean znak = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+') {
                znak = true;
                i++;
            }
            if (!znak) {
                stringBuilder1.append(str.charAt(i));
            }
            if (znak) {
                stringBuilder2.append(str.charAt(i));
            }
        }
        Integer one = Integer.valueOf(stringBuilder1.toString());
        Integer two = Integer.valueOf(stringBuilder2.toString());
        return one + two;
    }

    public void back() {
        if (place == 10) {
            registerFragment = new RegisterFragment(count, database, parent);
            parent.replaceFragment(registerFragment);
        }
    }
}