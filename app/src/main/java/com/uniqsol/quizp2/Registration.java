package com.uniqsol.quizp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.List;

public class Registration extends AppCompatActivity {
    int uid;
    EditText username,password,name,email;
    List<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
    }
    public void regnSave(View v)
    {
        if(username.getText().toString().equalsIgnoreCase("")||name.getText().toString().equalsIgnoreCase("")||password.getText().toString().equalsIgnoreCase("")||email.getText().toString().equalsIgnoreCase(""))
        {
            Toast.makeText(getApplicationContext(),"You cannot leave any field blank",Toast.LENGTH_SHORT).show();
        }
        else {
            User user = new User();


            //Code for correct working of uid
            users=MainActivity.AppDB.userDao().getAll();
            uid=1;
            for(User usr:users)
            {
                uid++;
            }






            user.setUid(uid);
            user.setUsername(username.getText().toString());
            user.setPassword(password.getText().toString());
            user.setName(name.getText().toString());
            user.setEmail(email.getText().toString());
            MainActivity.AppDB.userDao().insertUser(user);
            Toast.makeText(getApplicationContext(), user.getName() + " was successfully registered", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(getApplicationContext(), Login.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));

        }
    }
}
