package com.example.muneeb.mobomechanics;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CheckDistributor extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_check_distributor,container,false);
        TextView txt=(TextView)rootView.findViewById(R.id.info);
        txt.setText(getArguments().getString("msg"));
        return rootView;
    }
    public static CheckDistributor newInstance(String text) {
        CheckDistributor f = new CheckDistributor();
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }
}
