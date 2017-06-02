package com.example.muneeb.mobomechanics;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CheckCoilCurrent extends Fragment implements View.OnClickListener {
    TextView tutorial;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_check_coil_current,container,false);
        tutorial=(TextView)rootView.findViewById(R.id.tutorial);
        tutorial.setOnClickListener(this);
        TextView txt=(TextView)rootView.findViewById(R.id.info);
        txt.setText(getArguments().getString("msg"));
        return rootView;
    }
    public static CheckCoilCurrent newInstance(String text) {
        CheckCoilCurrent f = new CheckCoilCurrent();
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this.getContext(), YoutubeActivity.class);
        startActivity(intent);
    }
}
