package com.example.muneeb.mobomechanics;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class More_about_plug extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_more_about_plug,container,false);
        TextView txt=(TextView)rootView.findViewById(R.id.info);
        txt.setText(getArguments().getString("msg"));

        return rootView;

    }
    public static More_about_plug newInstance(String text) {

        More_about_plug f = new More_about_plug();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);
        return f;
    }


}
