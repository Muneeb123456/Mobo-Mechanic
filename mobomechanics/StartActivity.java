package com.example.muneeb.mobomechanics;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView engine,ignition,electrical,general,engineTick,ignitionTick,electricalTick,generalTick;
    TextView move, dont_move;
    int check=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        engine=(ImageView)findViewById(R.id.engine);
        ignition=(ImageView)findViewById(R.id.ignition);
        electrical=(ImageView)findViewById(R.id.electrical);
        general= (ImageView) findViewById(R.id.general);
        engineTick=(ImageView)findViewById(R.id.engine_tick);
        ignitionTick=(ImageView)findViewById(R.id.ignition_tick);
        electricalTick=(ImageView)findViewById(R.id.electrical_tick);
        generalTick=(ImageView)findViewById(R.id.general_tick);
        move=(TextView)findViewById(R.id.move);
        dont_move=(TextView)findViewById(R.id.dontmove);

        engine.setOnClickListener(this);
        ignition.setOnClickListener(this);
        electrical.setOnClickListener(this);
        general.setOnClickListener(this);
        move.setOnClickListener(this);
        dont_move.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.engine:
                check=1;
                engineTick.setVisibility(View.VISIBLE);
                ignitionTick.setVisibility(View.INVISIBLE);
                electricalTick.setVisibility(View.INVISIBLE);
                generalTick.setVisibility(View.INVISIBLE);
                Intent i=new Intent(this,EngineActivity.class);
                startActivity(i);
                break;
            case R.id.ignition:
                check=2;
                ignitionTick.setVisibility(View.VISIBLE);
                engineTick.setVisibility(View.INVISIBLE);
                electricalTick.setVisibility(View.INVISIBLE);
                generalTick.setVisibility(View.INVISIBLE);
                break;
            case R.id.electrical:
                check=3;
                electricalTick.setVisibility(View.VISIBLE);
                ignitionTick.setVisibility(View.INVISIBLE);
                engineTick.setVisibility(View.INVISIBLE);
                generalTick.setVisibility(View.INVISIBLE);
                break;
            case R.id.general:
                check=4;
                generalTick.setVisibility(View.VISIBLE);
                ignitionTick.setVisibility(View.INVISIBLE);
                electricalTick.setVisibility(View.INVISIBLE);
                engineTick.setVisibility(View.INVISIBLE);
                break;
            case R.id.move:
                move.setBackgroundDrawable(getResources().getDrawable(R.drawable.light_blue_color_rectangle));
                dont_move.setBackgroundDrawable(getResources().getDrawable(R.drawable.square_shape));
                Check_Alert();
                if(check==4) {
                    Intent intent = new Intent(this, GeneralActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.dontmove:
                dont_move.setBackgroundDrawable(getResources().getDrawable(R.drawable.light_blue_color_rectangle));
                move.setBackgroundDrawable(getResources().getDrawable(R.drawable.square_shape));
                Check_Alert();
                if(check==4){
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this).setTitle("Refer Mechanic")
                    .setMessage("Broken Axle" + "\n" + "Bad Clutch Plates")
                            .setPositiveButton("Find Mechanic", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                    alertDialog.create();
                    alertDialog.show();
                }
                break;
        }
    }

    public void Check_Alert()
    {
        if(check==0){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this).setTitle("Alert")
                    .setMessage("Please select any option")
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
            alertDialog.create();
            alertDialog.show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == android.R.id.home){
            finish();
        }
        return true;
    }
}
