package com.uniqsol.quizp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ProgressBar;
public class Result extends AppCompatActivity
{
    int marks;
    TextView tv,tvc;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        marks=getIntent().getIntExtra("Marks",0);
        tv=(TextView)findViewById(R.id.tv);
        pb=(ProgressBar)findViewById(R.id.pb);
        tvc=(TextView)findViewById(R.id.tvComment);

            tv.setText(tv.getText().toString() + "  " + marks + "/10");
            pb.setProgress(marks);

            if(marks==0)
                tvc.setText("Failure!");
            else if(marks<=3)
                tvc.setText("Work harder!");
            else if(marks<=5)
                tvc.setText("Try harder");
            else if(marks<=7)
                    tvc.setText("Average");
            else if(marks<10)
                tvc.setText("Looking good!");
            else
                tvc.setText("Godly!");




    }
}
