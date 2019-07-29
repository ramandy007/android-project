package com.example.fraglifecycle;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragcom2 extends Fragment {


    public fragcom2() {
        // Required empty public constructor
    }

    TextView txt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragcom2, container, false);
    }

    public void changedata(String i) {
        txt = (TextView) getActivity().findViewById(R.id.tv);
        txt.setText(i);
    }


}
