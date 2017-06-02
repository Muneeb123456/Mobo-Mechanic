package com.example.muneeb.mobomechanics;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import static android.R.attr.id;

public class SoundSmellSmokeBehaviour extends AppCompatActivity implements View.OnClickListener {

    TextView showText,showTextt,showTexttt,showTextttt;
    Button next;
    CheckBox soundChk = null,smokeChk=null,smellChk=null,behaviourChk=null;
    ArrayList<String> sound,smoke,smell,behaviour,CheckedList;
    boolean soundd = false, smelll = false, smokee = false, behaviourr = false, check=false;
    int loop=0;

    SymptomDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_smell_smoke_behaviour);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sound=new ArrayList<>();
        sound.add("Squeaky Belt noise");

        smoke=new ArrayList<>();
        smoke.add("Blue Smoke");
        smoke.add("White Smoke");
        smoke.add("Black Smoke");

        smell=new ArrayList<>();
        smell.add("Burning Smell");

        behaviour=new ArrayList<>();
        behaviour.add("Engine missfire");
        behaviour.add("Lack of acceleration");
        behaviour.add("OverHeating engine");

        next= (Button) findViewById(R.id.nexxt);
        next.setOnClickListener(this);

        showText= (TextView) findViewById(R.id.showText);
        showTextt= (TextView) findViewById(R.id.showTextt);
        showTexttt= (TextView) findViewById(R.id.showTexttt);
        showTextttt= (TextView) findViewById(R.id.showTextttt);

        LinearLayout container= (LinearLayout) findViewById(R.id.containerr);
        LinearLayout containerr= (LinearLayout) findViewById(R.id.containerrr);
        LinearLayout containerrr= (LinearLayout) findViewById(R.id.containerrrr);
        LinearLayout containerrrr= (LinearLayout) findViewById(R.id.containerrrrr);


        Intent mIntent = getIntent();

        soundd=mIntent.getBooleanExtra("sound",false);
        smelll=mIntent.getBooleanExtra("smell",false);
        smokee=mIntent.getBooleanExtra("smoke",false);
        behaviourr=mIntent.getBooleanExtra("behaviour",false);

        if(soundd==true)
        {
        //    setSoundSymptoms();
          //  sound = db.getAllSoundSymptom();
            showText.setVisibility(View.VISIBLE);
            showText.setText("Engine Sound");

            for(int i=0; i<sound.size();i++)
            {
                soundChk=new CheckBox(this);
                soundChk.setText(sound.get(i));
                soundChk.setId(loop);
                container.addView(soundChk);
                loop++;
            }
            container.setVisibility(View.VISIBLE);
        }
        if(smelll==true)
        {
            showTextt.setVisibility(View.VISIBLE);
            //setSmellSymptoms();
            //smell = db.getAllSmellSymptom();
            showTextt.setText("Engine Smell");
            for(int i=0; i<smell.size();i++)
            {
                smellChk=new CheckBox(this);
                smellChk.setText(smell.get(i));
                smellChk.setId(loop);
                containerr.addView(smellChk);
                loop++;
            }
            containerr.setVisibility(View.VISIBLE);

        }
        if(smokee==true)
        {
            showTexttt.setVisibility(View.VISIBLE);
            showTexttt.setText("Engine Smoke");
            for(int i=0; i<smoke.size();i++)
            {
                smokeChk=new CheckBox(this);
                smokeChk.setText(smoke.get(i));
                smokeChk.setId(loop);
                containerrr.addView(smokeChk);
                loop++;
            }
            containerrr.setVisibility(View.VISIBLE);

        }
        if(behaviourr==true)
        {
            showTextttt.setVisibility(View.VISIBLE);
            showTextttt.setText("Engine Behaviour");
            for(int i=0; i<behaviour.size();i++)
            {
                behaviourChk=new CheckBox(this);
                behaviourChk.setText(behaviour.get(i));
                behaviourChk.setId(loop);
                containerrrr.addView(behaviourChk);
                loop++;
            }
            containerrrr.setVisibility(View.VISIBLE);
        }
        Log.d("Loop : ", ""+loop);
    }

    @Override
    public void onClick(View v) {
  //      int soundtotalCB=0,smelltotalCB=0,smoketotalCB=0,behaviourtotalCB=0,totalCB=0;
        CheckedList=new ArrayList<String>();
        //CheckedList=null;
        switch (v.getId())
        {
            case R.id.nexxt:
/*                if(soundd==true){
                    soundtotalCB=sound.size();
                    totalCB+=soundtotalCB;
                }
                if(smelll==true) {
                    smelltotalCB = smell.size();
                    totalCB+=smelltotalCB;
                }
                if(smokee==true) {
                    smoketotalCB = smoke.size();
                    totalCB += smoketotalCB;
                }
                if(behaviourr==true) {
                    behaviourtotalCB = behaviour.size();
                    totalCB += behaviourtotalCB;
                }
                Log.d("TotalCB: ", ""+totalCB);*/
                for(int i=0;i<loop;i++){
                    CheckBox cb=(CheckBox)findViewById(i);
                    boolean checked=cb.isChecked();// status of checkbox

                    if(checked){
                        String st=cb.getText().toString();
                        Log.d("Checked: ", st);
                        CheckedList.add(st.replaceAll("\\s+",""));
                        check=true;
                    }
                }
                if(check==false){
                    Toast.makeText(this, "Please Select an Option to proceed", Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.d("Checked: ", CheckedList.get(0));
                    Intent intent=new Intent(this, Problem.class);
                    startActivity(intent);
                }
                break;
        }
    }

    public void setSoundSymptoms() {
        String[] Symptoms = {"Squeaky belt noise"};
        db = new SymptomDbHelper(this);

        for (int i = 0; i < Symptoms.length; i++) {
            db.insertSoundSymptom(Symptoms[i]);
        }
    }
    public void setSmokeSymptoms() {
        String[] Symptoms = {"Blue Smoke","White Smoke","Black Smoke"};
        db = new SymptomDbHelper(this);

        for (int i = 0; i < Symptoms.length; i++) {
            db.insertSmokeSymptom(Symptoms[i]);
        }
    }
    public void setSmellSymptoms() {
        String[] Symptoms = {"Burning smell"};
        db = new SymptomDbHelper(this);

        for (int i = 0; i < Symptoms.length; i++) {
            db.insertSmellSymptom(Symptoms[i]);
        }
    }
    public void setBehaviourSymptoms() {
        String[] Symptoms = {"Engine missfire","Lack of acceleration","OverHeating engine"};
        db = new SymptomDbHelper(this);

        for (int i = 0; i < Symptoms.length; i++) {
            db.insertBehaviourSymptom(Symptoms[i]);
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
