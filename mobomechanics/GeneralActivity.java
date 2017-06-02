package com.example.muneeb.mobomechanics;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class GeneralActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout linear;
    ArrayList<String> CheckedList, symptoms;
    SymptomDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSymptoms();
        symptoms = db.getAllSymptom();

        Button next = (Button) findViewById(R.id.next);
        LinearLayout myRoot = (LinearLayout) findViewById(R.id.container);
        LinearLayout a = new LinearLayout(this);
        a.setOrientation(LinearLayout.VERTICAL);
        a.setGravity(LinearLayout.TEXT_ALIGNMENT_CENTER);
        for (int i = 0; i < symptoms.size(); i++) {
            CheckBox chkbox = new CheckBox(this);
            chkbox.setText(symptoms.get(i));
            chkbox.setId(i);
            a.addView(chkbox);
        }
        myRoot.addView(a);
        next.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int totalCB = 0;
        CheckedList = new ArrayList<String>();
        switch (v.getId()) {
            case R.id.next:
                totalCB = symptoms.size();
                for (int i = 0; i < totalCB; i++) {
                    CheckBox cb = (CheckBox) findViewById(i);
                    boolean checked = cb.isChecked();// status of checkbox
                    if (checked) {
                        String st = cb.getText().toString();
                        CheckedList.add(st.replaceAll("\\s+", ""));
                    }
                }
                Log.d("Checked: ", CheckedList.get(0));
                Intent i = new Intent(this, Problem.class);
                startActivity(i);
                break;
        }
    }

    public void setSymptoms() {
        String[] Symptoms = {"Blue Smoke", "White Smoke", "Black Smoke", "OverHeating engine", "jerking",
                "Burning Smell", "Hard Start", "Engine missfire", "High fuel consumption", "Lack of acceleration",
                "Squeaky belt noise"};
        db = new SymptomDbHelper(this);

        for (int i = 0; i < Symptoms.length; i++) {
            db.insertSymptom(Symptoms[i]);
            Log.d(db.numberOfRows()+"", "Rows number: ");
        }
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == android.R.id.home){
            finish();
        }
        return true;
    }

}