package com.blah.project.integr;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MenuFragment extends Fragment  {
    String[] AndroidOS = new String[] { "Cupcake","Donut","Eclair","Froyo","Gingerbread","Honeycomb","Ice Cream SandWich","Jelly Bean","KitKat" };
    String[] Version = new String[]{"1.5","1.6","2.0-2.1","2.2","2.3","3.0-3.2","4.0","4.1-4.3","4.4"};
    @Override

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_menu, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, AndroidOS);
        ListView lv = view.findViewById(R.id.listview);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view,
                                            int position, long id) {
//                        TextFragment txt = (TextFragment)getFragmentManager().findFragmentById(R.id.fragment2);
//                        txt.change(AndroidOS[position],"Version : "+Version[position]);

                        Toast.makeText(getActivity(), "Clicked on OS:Version - "+ AndroidOS[position]+" : "+Version[position],Toast.LENGTH_SHORT).show();

                    }
                }
        );
        return view;

    }


}
