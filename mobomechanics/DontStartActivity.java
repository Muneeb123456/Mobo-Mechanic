package com.example.muneeb.mobomechanics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DontStartActivity extends AppCompatActivity implements View.OnClickListener {

    Button check_fuse, check_battery, check_fuel, check_plug;
    TextView success, unsuccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dont_start);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        check_fuse=(Button)findViewById(R.id.checkFuse);
        check_battery=(Button)findViewById(R.id.checkBattery);
        check_fuel=(Button)findViewById(R.id.checkFuel);
        check_plug=(Button)findViewById(R.id.checkPlug);
        success=(TextView)findViewById(R.id.successful);
        unsuccess=(TextView)findViewById(R.id.un_successful);

        check_fuse.setOnClickListener(this);
        check_battery.setOnClickListener(this);
        check_fuel.setOnClickListener(this);
        check_plug.setOnClickListener(this);
        success.setOnClickListener(this);
        unsuccess.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.checkFuse:
                Intent intent=new Intent(this, CheckFuseActivity.class);
                startActivityForResult(intent,1);
                break;
            case R.id.checkBattery:
                Intent Intent=new Intent(this, CheckBattery.class);
                startActivityForResult(Intent,2);
                break;
            case R.id.checkFuel:
                Intent fuelIntent=new Intent(this,CheckFuelActivity.class);
                startActivityForResult(fuelIntent,3);
                break;
            case R.id.checkPlug:
                Intent plugIntent=new Intent(this,CheckPlugActivity.class);
                startActivityForResult(plugIntent,4);
                break;
            case R.id.successful:
                success.setBackgroundDrawable(getResources().getDrawable(R.drawable.light_blue_color_rectangle));
                unsuccess.setBackgroundDrawable(getResources().getDrawable(R.drawable.square_shape));
                finish();
                break;
            case R.id.un_successful:
                success.setBackgroundDrawable(getResources().getDrawable(R.drawable.square_shape));
                unsuccess.setBackgroundDrawable(getResources().getDrawable(R.drawable.light_blue_color_rectangle));
                break;
            case android.R.id.home:
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case 1:
                check_fuse.setBackgroundColor(getResources().getColor(R.color.colorlightGreen));
                break;
            case 2:
                check_battery.setBackgroundColor(getResources().getColor(R.color.colorlightGreen));
                break;
            case 3:
                check_fuel.setBackgroundColor(getResources().getColor(R.color.colorlightGreen));
                break;
            case 4:
                check_plug.setBackgroundColor(getResources().getColor(R.color.colorlightGreen));
                break;
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
