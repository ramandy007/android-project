package com.example.assignment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class frag2 extends Fragment {

    TextView t1,t2,t3;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag2, container, false);
    }


    public void changeData(ArrayList<String>  i){
        t1=getActivity().findViewById(R.id.name);
        t2=getActivity().findViewById(R.id.fav_movie);
        t3=getActivity().findViewById(R.id.fav_color);

        t1.setText(i.get(0));
        t2.setText(i.get(1));
        t3.setText(i.get(2));


    }

}
