package com.example.muneeb.mobomechanics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EngineActivity extends AppCompatActivity implements View.OnClickListener {

    TextView sound, smell, smoke, behaviour;
    ImageView soundTick, smellTick, smokeTick, behaviourTick;
    Button done;
    boolean soundd = false, smelll = false, smokee = false, behaviourr = false, soundcheck=false,smelcheck=false,smokecheck=false,behaviourcheck=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engine);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        soundTick = (ImageView) findViewById(R.id.sound_tick);
        smellTick = (ImageView) findViewById(R.id.smell_tick);
        smokeTick = (ImageView) findViewById(R.id.smoke_tick);
        behaviourTick = (ImageView) findViewById(R.id.behaviour_tick);

        sound = (TextView) findViewById(R.id.sound);
        smell = (TextView) findViewById(R.id.smell);
        smoke = (TextView) findViewById(R.id.smoke);
        behaviour = (TextView) findViewById(R.id.behaviour);
        done = (Button) findViewById(R.id.done);

        sound.setOnClickListener(this);
        smell.setOnClickListener(this);
        smoke.setOnClickListener(this);
        behaviour.setOnClickListener(this);
        done.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.sound:
/*
                smokeTick.setVisibility(View.INVISIBLE);
                smellTick.setVisibility(View.INVISIBLE);
*/
                if(soundd==true){
                    soundcheck=false;
                    soundTick.setVisibility(View.INVISIBLE);
                    soundd = false;
                }
                else{
                    soundcheck=true;
                    soundTick.setVisibility(View.VISIBLE);
                    soundd = true;
                }
//                behaviourTick.setVisibility(View.INVISIBLE);
                break;
            case R.id.smell:
                if(smelll==true){
                    smelcheck=false;
                    smellTick.setVisibility(View.INVISIBLE);
                    smelll = false;
                }
                else{
                    smelcheck=true;
                    smellTick.setVisibility(View.VISIBLE);
                    smelll = true;
                }
 /*               smokeTick.setVisibility(View.INVISIBLE);
                soundTick.setVisibility(View.INVISIBLE);
                behaviourTick.setVisibility(View.INVISIBLE);
 */
                break;
            case R.id.smoke:

                if(smokee==true){
                    smokecheck=false;
                smokeTick.setVisibility(View.INVISIBLE);
                smokee = false;
                }
                else{
                    smokecheck=true;
                    smokeTick.setVisibility(View.VISIBLE);
                    smokee = true;
                }
   /*             smellTick.setVisibility(View.INVISIBLE);
                soundTick.setVisibility(View.INVISIBLE);
                behaviourTick.setVisibility(View.INVISIBLE);
   */
                break;
            case R.id.behaviour:
/*
                smokeTick.setVisibility(View.INVISIBLE);
                smellTick.setVisibility(View.INVISIBLE);
                soundTick.setVisibility(View.INVISIBLE);
*/
                if (behaviourr == true) {
                    behaviourcheck=false;
                    behaviourTick.setVisibility(View.INVISIBLE);
                    behaviourr=false;
                }
                else {
                    behaviourcheck=true;
                    behaviourTick.setVisibility(View.VISIBLE);
                    behaviourr = true;
                }

                break;
            case R.id.done:
                if(soundcheck==false && smelcheck==false && smokecheck==false && behaviourcheck==false){
                    Toast.makeText(this, "Please Select an Option to proceed", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(this, SoundSmellSmokeBehaviour.class);
                    intent.putExtra("sound", soundd);
                    intent.putExtra("smell", smelll);
                    intent.putExtra("smoke", smokee);
                    intent.putExtra("behaviour", behaviourr);
                    startActivity(intent);
                    Log.d("Sound etc", "" + soundd + " " + smelll + " " + smokee + " " + behaviourr);
                }
                break;
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            finish();
        }
        return true;
    }
}
