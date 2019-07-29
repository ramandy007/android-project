package com.example.fraglifecycle;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class frag3 extends Fragment {

    View view;
    Button thirdbutton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_frag3, container, false);
        thirdbutton = view.findViewById(R.id.thirdButton);
        thirdbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Third Fragment", Toast.LENGTH_LONG).show();
            }
        });
        return view;

    }

}
