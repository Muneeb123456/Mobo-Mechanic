package com.example.muneeb.mobomechanics;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView start_btn,dont_start_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_dont_start);

        start_btn=(TextView)findViewById(R.id.start);
        dont_start_btn=(TextView)findViewById(R.id.dont_start);

        start_btn.setOnClickListener(this);
        dont_start_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.start:
                start_btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.light_blue_color_rectangle));
                dont_start_btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.square_shape));
                Intent intent=new Intent(this, StartActivity.class);
                startActivity(intent);
                break;
            case R.id.dont_start:
                start_btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.square_shape));
                dont_start_btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.light_blue_color_rectangle));
                Intent Intent=new Intent(this, DontStartActivity.class);
                startActivity(Intent);
                break;
        }
    }
}
