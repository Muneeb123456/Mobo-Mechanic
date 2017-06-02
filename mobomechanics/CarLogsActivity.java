package com.example.muneeb.mobomechanics;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static android.support.design.widget.Snackbar.LENGTH_SHORT;

public class CarLogsActivity extends AppCompatActivity implements View.OnClickListener {

    Button submit;
    EditText make, model, mileage, avgmile, oilchange;
    ArrayList<String> logsInfo;
    int mileag, avgmil;
    Date oilchang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_logs);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        logsInfo = new ArrayList<>();
        make = (EditText) findViewById(R.id.make);
        model = (EditText) findViewById(R.id.model);
        mileage = (EditText) findViewById(R.id.mileage);
        avgmile = (EditText) findViewById(R.id.avgmile);

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit:

                logsInfo.add(make.getText().toString());
                logsInfo.add(model.getText().toString());
                mileag = Integer.parseInt(mileage.getText().toString());
                avgmil = Integer.parseInt(avgmile.getText().toString());

                String currentDateString = DateFormat.getDateInstance().format(new Date());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar c = Calendar.getInstance();
                try {
                    c.setTime(sdf.parse(currentDateString));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                c.add(Calendar.MONTH, 1);  // number of days to add
                currentDateString = sdf.format(c.getTime());  // dt is now the new date

                AlarmManager alarms = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

                NotificationReciever receiver = new NotificationReciever();
                IntentFilter filter = new IntentFilter("ALARM_ACTION");
                registerReceiver(receiver, filter);

                Intent intent = new Intent("ALARM_ACTION");
                intent.putExtra("param", "My scheduled action");
                PendingIntent operation = PendingIntent.getBroadcast(this, 0, intent, 0);
                // I choose 3s after the launch of my application
                alarms.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), operation);

                Toast.makeText(this, "Car logs activated for " + currentDateString, Toast.LENGTH_LONG).show();
                break;
        }
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.home) {
            finish();
        }
        return true;
    }
}
