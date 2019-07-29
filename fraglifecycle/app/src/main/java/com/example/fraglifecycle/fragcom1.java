package com.example.fraglifecycle;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragcom1 extends Fragment implements View.OnClickListener {


    int count = 0;
    Button bt;
    Communicator comm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragcom1, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bt = (Button) getActivity().findViewById(R.id.btn);
        bt.setOnClickListener(fragcom1.this);
    }


    @Override
    public void onClick(View v) {
        count++;
        if (comm == null)
            comm = (Communicator) getActivity();
        comm.respond("The button is clicked " + count + " times");


    }
}
