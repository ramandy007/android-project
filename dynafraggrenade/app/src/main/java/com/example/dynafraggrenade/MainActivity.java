package com.example.dynafraggrenade;



import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button firstFragment, secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = (Button) findViewById(R.id.firstFragment);
        secondFragment = (Button) findViewById(R.id.secondFragment);

        // perform setOnClickListener event on First Button
        firstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // load First Fragment
                loadFragment(new FragmentFirst());
            }
        });
        // perform setOnClickListener event on Second Button
        secondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // load Second Fragment
                loadFragment(new FragmentSecond());
            }
        });
    }
   /*
    Details regarding Fragment Classes:
   android.app.Fragment : The base class for all fragment definitions
   android.app.FragmentManager : The class for interacting with fragment objects inside an activity
   android.app.FragmentTransaction : The class for performing an atomic set of fragment operations

   When using a compatibility package library provided by Google, the following classes are used for implementation.

   android.support.v4.app.FragmentActivity : The base class for all activities using compatibility-based fragment
   (and loader) features
   android.support.v4.app.Fragment
   android.support.v4.app.FragmentManager
   android.support.v4.app.FragmentTransaction
    */

    private void loadFragment(Fragment fragment) {
        // create a FragmentManager
        FragmentManager fm = getFragmentManager();
        // android.support.v4.app.FragmentManager fm=getSupportFragmentManager();

        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction =
                fm.beginTransaction();

        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);

        //fragmentTransaction.add(R.id.firstFragment,fragment);
        fragmentTransaction.commit(); // save the changes
    }
}
