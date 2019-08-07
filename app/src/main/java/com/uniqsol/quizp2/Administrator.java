package com.uniqsol.quizp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.List;
import android.widget.TextView;
import android.view.View;

public class Administrator extends AppCompatActivity {
List<User> users;
TextView tv;
int count=0;
String info="Registered Candidates:\n---------------------";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);
        tv=(TextView)findViewById(R.id.userdata);
        users=MainActivity.AppDB.userDao().getAll();

        for(User usr:users)
        {
            if(!usr.getEmail().equalsIgnoreCase("administrator"))
            {
                count++;
                info = info + "\n\n" + count + ") Name: " + usr.getName() + "\n  Email: " + usr.getEmail();
            }
        }
        tv.setText(info);
    }

    public void openLogin(View view)
    {
        startActivity(new Intent(getApplicationContext(), Login.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}
