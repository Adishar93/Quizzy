package com.uniqsol.quizp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity {

    EditText username,password;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
    }

    public void openQuiz(View v)
    {
        user=MainActivity.AppDB.userDao().findByUsername(username.getText().toString());
        if(password.getText().toString().equalsIgnoreCase("")||username.getText().toString().equalsIgnoreCase(""))
        {
            Toast.makeText(getApplicationContext(),"You cannot leave the fields blank",Toast.LENGTH_SHORT).show();
        }
        else {
            if (user != null) {

                if (user.getPassword().equalsIgnoreCase(password.getText().toString()))
                {
                    if(user.getEmail().equalsIgnoreCase("administrator"))
                    {
                        startActivity(new Intent(getApplicationContext(), Administrator.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    }
                    else {
                        startActivity(new Intent(getApplicationContext(), Instructions.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Sorry! Wrong Password", Toast.LENGTH_SHORT).show();
                }


            } else {
                Toast.makeText(getApplicationContext(), "Sorry! Wrong Username", Toast.LENGTH_SHORT).show();
            }
        }




    }

    public void openRegistration(View v)
    {
        startActivity(new Intent(getApplicationContext(),Registration.class));
    }
}
