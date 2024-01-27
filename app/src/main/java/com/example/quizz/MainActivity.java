package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase database;
    boolean isRunning;
    Cursor cursor;
    BottomSheetDialogFragment bottomSheetFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        MainFragment mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mainFragment)
                .commit();
//        AppCompatButton start = findViewById(R.id.start);
//        AppCompatButton record = findViewById(R.id.record);
//        AppCompatButton exit = findViewById(R.id.exit);
//        database = getBaseContext().openOrCreateDatabase("database", MODE_PRIVATE, null);
//        database.execSQL("CREATE TABLE IF NOT EXISTS users (name TEXT, first TEXT, second TEXT, third TEXT, fourth TEXT, UNIQUE(name))");
//        database.execSQL("CREATE TABLE IF NOT EXISTS users2 (result TEXT, UNIQUE(result))");
//        database.execSQL("INSERT OR IGNORE INTO users2 VALUES ('0');");
//        database.execSQL("INSERT OR IGNORE INTO users VALUES ('1342+443', '1785', '939', '23992', '23932'), ('123+329', '844', '445', '452', '233'), ('6665+46', '9888', '6712', '6711', '569'), " +
//                "('366+366', '732', '99', '678', '889'), ('1000+1', '1000', '1004', '999', '1001'), ('865+42', '900', '907', '768', '543'), ('55+76', '131', '130', '129', '120'), " +
//                "('3535+353', '2999', '353', '350', '3888'), ('771+771', '1542', '1400', '1555', '1589'), ('86+965', '1434', '1533', '1049', '1051')");
//        cursor = database.rawQuery("SELECT * FROM users;", null);
//        cursor.close();
//        database.close();
//        start.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bottomSheetFragment = new FragmentQuizz(true, cursor, database);
////        bottomSheetFragment.changeView(position, "Monday");
//                bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
//            }
//        });
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}