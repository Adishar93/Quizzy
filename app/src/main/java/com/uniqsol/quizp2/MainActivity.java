package com.uniqsol.quizp2;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static AppDatabase AppDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDB=Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"user-database").allowMainThreadQueries().build();

    }

    public void openLogin(View v)
    {
        startActivity(new Intent(MainActivity.this,Login.class));
    }
}
