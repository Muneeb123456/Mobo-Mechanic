package com.example.muneeb.mobomechanics;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CheckPlugCurrent extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_check_plug_current,container,false);
        TextView txt=(TextView)rootView.findViewById(R.id.info);
        txt.setText(getArguments().getString("msg"));
        return rootView;
    }
    public static CheckPlugCurrent newInstance(String text) {

        CheckPlugCurrent f = new CheckPlugCurrent();
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }
}
