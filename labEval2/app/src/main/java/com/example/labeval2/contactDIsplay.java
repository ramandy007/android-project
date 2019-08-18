package com.example.labeval2;


import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class contactDIsplay extends Fragment {

    ListView lv;
    public    String phone;


    public contactDIsplay() {
        // Required empty public constructor
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater =getActivity().getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);

     /*menu.setHeaderTitle("Context Menu");
     menu.add(0, v.getId(), 0, "Upload");
     menu.add(0, v.getId(), 0, "Search");
     menu.add(0, v.getId(), 0, "Share");
     menu.add(0, v.getId(), 0, "Bookmark");*/
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_contact_display, container, false);
        lv= view.findViewById(R.id.listview);
        registerForContextMenu(lv);

        ContentResolver cr = getContext().getContentResolver();
        Cursor c = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        List<Map<String, String>> list = new ArrayList<>();
        HashMap<String,String> map ;

        if (c.moveToFirst()) {
            do {
//                numbers.add(c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
//                contacts.add(c.getString((c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))));
                map = new HashMap<String, String>();
                map.put("numbers", c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
                map.put("contacts", c.getString((c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))));
                list.add(map);

            } while (c.moveToNext());
        }
        String [] from = {"contacts", "numbers"};
        int [] to = {android.R.id.text1,
                android.R.id.text2};

        SimpleAdapter ad = new SimpleAdapter(getContext(), list,android.R.layout.simple_list_item_2, from,to);

        lv.setAdapter(ad);

       lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

              phone= view.findViewById(android.R.id.text2).toString();
              Log.i("hehehe",phone);

               return false;
           }
       });





        return  view;
    }

}
