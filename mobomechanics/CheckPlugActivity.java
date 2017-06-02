package com.example.muneeb.mobomechanics;

import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class CheckPlugActivity extends AppCompatActivity implements View.OnClickListener {

    Button done;
    ToggleButton tgb;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plug_check_new);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        done=(Button)findViewById(R.id.done);
        tgb=(ToggleButton)findViewById(R.id.toggleButton2);

        done.setOnClickListener(this);
        tgb.setOnClickListener(this);

        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.toggleButton2:
                if(tgb.isChecked()) {
                    play();
                }
                else
                    stop();
                break;
            case R.id.done:
                finish();
                break;
        }
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {
                case 0: return Check_Plug.newInstance("Please check your plug");
                case 1: return More_about_plug.newInstance("Please check for more information about plugs");
                case 2: return CheckPlugCurrent.newInstance("Please check your plug wires");
                case 3: return CheckDistributor.newInstance("Please check your distributor current");
                case 4: return CheckCoilCurrent.newInstance("Please check your coil current");
                default: return CheckCoilCurrent.newInstance("Please check your coil current");
            }
        }
        @Override
        public int getCount() {
            return 5;
        }
    }

    public void play()
    {
        mediaPlayer = MediaPlayer.create(this, R.raw.sound);
        mediaPlayer.start();
    }
    public void stop()
    {
        mediaPlayer.stop();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == android.R.id.home){
            finish();
        }
        return true;
    }
}