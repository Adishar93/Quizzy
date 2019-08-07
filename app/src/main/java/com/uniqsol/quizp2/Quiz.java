package com.uniqsol.quizp2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.app.Notification;

//import android.util.Log;


public class Quiz extends AppCompatActivity {
    int marks = 0, id;
    RadioGroup rgq1, rgq2, rgq3, rgq4, rgq5, rgq6, rgq7, rgq8, rgq9, rgq10;
    RadioButton rb;
    TextView tvTimer;
    final String CHANNEL_ID="new_notification";
    final int START_ACTIVITY=1;
    final int NO_ACTIVITY=0;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        tvTimer = (TextView) findViewById(R.id.tvTimer);
        timer= new CountDownTimer(60000, 1000)
        {
            public void onTick(long milisec)
            {
                tvTimer.setText("Timer: " + milisec / 1000 + " s");
                if(milisec>=30000&&milisec<=31000)
                {
                    createNotification("30 seconds left",NO_ACTIVITY);
                }
                if(milisec>=10000&&milisec<=11000)
                {
                    createNotification("10 seconds left!",NO_ACTIVITY);
                }
            }

            public void onFinish()
            {
                collectAnswers();

                createNotification("Result: "+marks+"/10",START_ACTIVITY);

            }
        };
        timer.start();
    }

    @Override
    protected void onStop(){
        super.onStop();
        timer.cancel();
    }

    public void getMarks(View v) {

        collectAnswers();
        timer.cancel();

        createNotification("Result: "+marks+"/10",START_ACTIVITY);



    }

    public void collectAnswers() {
        rgq1 = (RadioGroup) findViewById(R.id.rgq1);

        id = rgq1.getCheckedRadioButtonId();
        if (id >= 0) {
            rb = (RadioButton) findViewById(id);
            if (rb.getText().toString().equalsIgnoreCase("res/layout")) {
                marks++;
            }

        }
        rgq2 = (RadioGroup) findViewById(R.id.rgq2);
        id = rgq2.getCheckedRadioButtonId();
        if (id >= 0) {
            rb = (RadioButton) findViewById(id);
            if (rb.getText().toString().equalsIgnoreCase("Absolute Layout")) {
                marks++;
            }
        }


        rgq3 = (RadioGroup) findViewById(R.id.rgq3);
         id = rgq3.getCheckedRadioButtonId();
        if (id >= 0) {

            rb = (RadioButton) findViewById(rgq3.getCheckedRadioButtonId());
            if (rb.getText().toString().equalsIgnoreCase("android:orientation")) {
                marks++;
            }
            }

            rgq4 = (RadioGroup) findViewById(R.id.rgq4);

              id = rgq4.getCheckedRadioButtonId();
             if (id >= 0) {
            rb = (RadioButton) findViewById(rgq4.getCheckedRadioButtonId());
            if (rb.getText().toString().equalsIgnoreCase("match_parent")) {
                marks++;
            }
            }


            rgq5 = (RadioGroup) findViewById(R.id.rgq5);

        id = rgq5.getCheckedRadioButtonId();
        if (id >= 0) {
            rb = (RadioButton) findViewById(rgq5.getCheckedRadioButtonId());
            if (rb.getText().toString().equalsIgnoreCase("alignParentUnder")) {
                marks++;
            }
        }


            rgq6 = (RadioGroup) findViewById(R.id.rgq6);

        id = rgq6.getCheckedRadioButtonId();
        if (id >= 0) {
            rb = (RadioButton) findViewById(rgq6.getCheckedRadioButtonId());
            if (rb.getText().toString().equalsIgnoreCase("ImageView")) {
                marks++;
            }
        }

            rgq7 = (RadioGroup) findViewById(R.id.rgq7);
        id = rgq7.getCheckedRadioButtonId();
        if (id >= 0) {

            rb = (RadioButton) findViewById(rgq7.getCheckedRadioButtonId());
            if (rb.getText().toString().equalsIgnoreCase("1")) {
                marks++;
            }
        }

            rgq8 = (RadioGroup) findViewById(R.id.rgq8);

        id = rgq8.getCheckedRadioButtonId();
        if (id >= 0) {
            rb = (RadioButton) findViewById(rgq8.getCheckedRadioButtonId());
            if (rb.getText().toString().equalsIgnoreCase("Dalvik Virtual Machine")) {
                marks++;
            }
        }
            rgq9 = (RadioGroup) findViewById(R.id.rgq9);
        id = rgq9.getCheckedRadioButtonId();
        if (id >= 0) {

            rb = (RadioButton) findViewById(rgq9.getCheckedRadioButtonId());
            if (rb.getText().toString().equalsIgnoreCase("bin")) {
                marks++;
            }
        }

            rgq10 = (RadioGroup) findViewById(R.id.rgq10);
        id = rgq10.getCheckedRadioButtonId();
        if (id >= 0) {
            rb = (RadioButton) findViewById(rgq10.getCheckedRadioButtonId());
            if (rb.getText().toString().equalsIgnoreCase("manifest")) {
                marks++;
            }
        }

            if(marks>10)
            marks=10;

            Intent i = new Intent(getApplicationContext(), Result.class);
            i.putExtra("Marks",marks);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(i);
        }

    public void createNotification(String text,int choice) {
        NotificationManager nm = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notification Example";
            String description = "This is a demo";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            nm.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle("Aptitude Test").setContentText(text).setSmallIcon(R.drawable.ic_stat_name)
                .setDefaults(Notification.DEFAULT_ALL).setPriority(NotificationCompat.PRIORITY_HIGH);
        if(choice==START_ACTIVITY)
        {
        Intent notificationIntent=new Intent(this,Result.class);
        notificationIntent.putExtra("Marks",marks);

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(contentIntent);
        }

        nm.notify(0, builder.build());


    }


    }

