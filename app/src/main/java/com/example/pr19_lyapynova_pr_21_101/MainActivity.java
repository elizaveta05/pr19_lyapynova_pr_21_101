package com.example.pr19_lyapynova_pr_21_101;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.chrono.MinguoChronology;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv1;
    Button btnTime, btnDate, btn3;
    Calendar dateAndTime = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.tv1);
        btnDate=findViewById(R.id.btnDate);
        btnDate.setOnClickListener(this);

        btnTime=findViewById(R.id.btnTime);
        btnTime.setOnClickListener(this);

        btn3=findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


        setInitialDataTime();
    }

    private void setInitialDataTime() {
        tv1.setText(DateUtils.formatDateTime(this, dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE|
                        DateUtils.FORMAT_SHOW_YEAR|
                        DateUtils.FORMAT_SHOW_TIME));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnDate:
                new DatePickerDialog(MainActivity.this, d,
                        dateAndTime.get(Calendar.YEAR),
                        dateAndTime.get(Calendar.MONTH),
                        dateAndTime.get(Calendar.DAY_OF_MONTH))
                        .show();
                break;

            case R.id.btnTime:
                new TimePickerDialog(MainActivity.this, t,
                        dateAndTime.get(Calendar.HOUR_OF_DAY),
                        dateAndTime.get(Calendar.MINUTE),true)
                        .show();
                break;

        }
    }
    TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY,hourOfDay);
            dateAndTime.set(Calendar.MINUTE,minute);
            setInitialDataTime();
        }
    };
    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR,year);
            dateAndTime.set(Calendar.MONTH,monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            setInitialDataTime();
        }
    };


}