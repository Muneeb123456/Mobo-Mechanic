package com.example.muneeb.mobomechanics;

import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Problem extends AppCompatActivity implements ExpandableListView.OnChildClickListener, View.OnClickListener {

    com.example.muneeb.mobomechanics.ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    HashMap<String,Integer> images;
    HashMap<String,String> videos;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problems);
        expListView = (ExpandableListView) findViewById(R.id.problems);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // preparing list data
        prepareListData();
        LoadImages();
        LoadVideos();
        img= (ImageView) findViewById(R.id.solTutorial);
        img.setOnClickListener(this);

        expListView.setOnChildClickListener(this);
        listAdapter = new com.example.muneeb.mobomechanics.ExpandableListAdapter(this, listDataHeader,
                listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Faulty Spark Plug");
        listDataHeader.add("Dirty Fuel injector/ Faulty Spark Plug");
        listDataHeader.add("Faulty Spark Plug");
        listDataHeader.add("Faulty Spark Plug / Fuel injector Problem");
        listDataHeader.add("Loose Belt, Dry  belt");
        listDataHeader.add("Low Engine Oil");

        // Adding child data
        List<String> Solution = new ArrayList<String>();
        Solution.add("Replace plug or clean it if cleanable");
        List<String> Solution1 = new ArrayList<String>();

        Solution1.add("Refer mechanic / replace plug");
        List<String> Solution2 = new ArrayList<String>();

        Solution2.add("Replace plug");
        List<String> Solution3 = new ArrayList<String>();

        Solution3.add("Replace Plug, check mechanic");
        List<String> Solution4 = new ArrayList<String>();
        Solution4.add("Grease car belt, correct alignment");
        List<String> Solution5 = new ArrayList<String>();
        Solution5.add("Engine Oil level to Full mark");

        listDataChild.put(listDataHeader.get(0), Solution); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Solution1); // Header, Child data
        listDataChild.put(listDataHeader.get(2), Solution2); // Header, Child data
        listDataChild.put(listDataHeader.get(3), Solution3); // Header, Child data
        listDataChild.put(listDataHeader.get(4), Solution4); // Header, Child data
        listDataChild.put(listDataHeader.get(5), Solution5); // Header, Child data

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == android.R.id.home){
            finish();
        }
        return true;
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
                                int childPosition, long id)
    {
        String data=listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).toString();
/*
        if(data=="Replace plug")
        {
            ImageView img= (ImageView) findViewById(R.id.solTutorial);
            img.setVisibility(View.VISIBLE);
            img.setBackground(getResources().getDrawable(R.drawable.remove_spark_plug));
        }
*/

        String key=data;
        Integer value=0;
        String val=null;
        boolean flag=false;
        for(String keyy : images.keySet()) {
            if(keyy==key) {
                value = (Integer) images.get(key);
                flag=false;
                //Toast.makeText(this, "Key: " + keyy + " Value: " + value, Toast.LENGTH_LONG).show();
            }
        }
        for(String keyy : videos.keySet()) {
            if(keyy==key) {
                val = (String) videos.get(key);
                flag=true;
                //Toast.makeText(this, "Key: " + keyy + " Value: " + value, Toast.LENGTH_LONG).show();
            }
        }

        if(flag==false) {
            ImageView img = (ImageView) findViewById(R.id.solTutorial);
            img.setVisibility(View.VISIBLE);
            img.setBackground(getResources().getDrawable(value));
        }
        else {
            Intent intent=new Intent(this, YoutubeActivity.class);
            intent.putExtra("id",val);
            startActivity(intent);
        }
        return true;
    }

    public void LoadImages(){
        images=new HashMap<String, Integer>();
        images.put("Replace plug",R.drawable.remove_spark_plug);
        images.put("Replace plug or clean it if Cleanable",R.drawable.remove_spark_plug);
        images.put("charge car Battery",R.drawable.howtojumpstart);
        images.put("Check Air Pressure in Tyres",R.drawable.airguage);
        images.put("Check Engine Oil level",R.drawable.oillevel);
        images.put("Check Transmission Fluid Level",R.drawable.oillevel);
        images.put("Check Air Filter",R.drawable.filter);
        images.put("Insert Coolant",R.drawable.coolant);
        images.put("Schedule a brake inspection asap",R.drawable.brake);
    }

    public void LoadVideos(){
        videos=new HashMap<String,String>();
        videos.put("Change Belt","dCCS1d40WGU");
        videos.put("Change Engine Oil","Yo2hJym2Ihw");
        videos.put("Grease the Belt","dDzVDNdcQiM");
        videos.put("Correct the Alignment of the belt","yKFAmfeaycs");
        videos.put("Check Fan or Refer Mechanic","6VHlzGaFNGo");
        videos.put("Engine Oil level to Full mark","6VHlzGaFNGo");

    }

    @Override
    public void onClick(View v) {
      recreate();
    }
}