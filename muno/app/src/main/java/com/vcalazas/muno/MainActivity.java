package com.vcalazas.muno;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.transitionseverywhere.Rotate;
import com.transitionseverywhere.TransitionManager;

import com.vcalazas.muno.fragments.DetailsFragment;
import com.vcalazas.muno.fragments.ListFragment;
import com.vcalazas.muno.interfaces.OnListener;

public class MainActivity extends AppCompatActivity {

    private int deviceOrientation;
    private OnListener mListener;

    private LinearLayout mainActMainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActMainLayout = findViewById(R.id.MainActMainLayout);

        MainActivity.this.deviceOrientation = MainActivity.this.getResources().getConfiguration().orientation;

        MainActivity.this.startListener();

        if (MainActivity.this.deviceOrientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            MainActivity.this.navigator(R.id.fragment_content, "list", null);
        } else /* landscape */ {

            MainActivity.this.goList(R.id.fragment, null);
            MainActivity.this.goDetais(R.id.fragment2, null);

        }

    }

    private void startListener() {
        MainActivity.this.mListener = new OnListener() {

            @Override
            public <T> void saveSession(Context context, String field, T data) {
//                try {
//                    session.save(context, field, data);
//                } catch (Exception e) {
//                    Logger.write("HomeActivity.startListener // new OnListener().saveSession - ", Constants.Verbose.ERROR);
//                }
            }

            @Override
            public void onCall(int frameLayout, String option,Bundle arguments) {
                try {
                    MainActivity.this.navigator(frameLayout ,option, arguments);
                } catch (Exception e) {
//                    Logger.write("HomeActivity.startListener // new OnListener().onCall - ", Constants.Verbose.ERROR);
                }
            }
        };
    }

    private void navigator(int frameLayout , String way, Bundle arguments){
        try {

            switch (way) {
                case "list":
                    MainActivity.this.goList(frameLayout, arguments);
                    break;

                case "details":
                    MainActivity.this.goDetais(frameLayout, arguments);
                    break;
            }
        } catch (Exception e){

        }
    }

    private void navigationFragment(int frameLayout, Fragment fragment, String title) {
        try {
            //setTitle(title);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(frameLayout, fragment);
            fragmentTransaction.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.commit();
        } catch (Exception e) {
//            Logger.write("HomeActivity.navigationFragment - ", Constants.Verbose.ERROR);
        }
    }

    private void goDetais(int frameLayout, Bundle arguments){
        try {
            DetailsFragment detailsFragment = new DetailsFragment();
            detailsFragment.setmListener(MainActivity.this.mListener);
            if( arguments != null ){
                detailsFragment.setArguments(arguments);
            }
            MainActivity.this.navigationFragment(frameLayout ,detailsFragment, "Detalhes");
            TransitionManager.beginDelayedTransition(mainActMainLayout, new Rotate());
        } catch (Exception e){

        }
    }

    private void goList(int frameLayout, Bundle arguments){
        try {
            ListFragment listFragment = new ListFragment();
            listFragment.setmListener(MainActivity.this.mListener);
            if( arguments != null ){
                listFragment.setArguments(arguments);
            }
            MainActivity.this.navigationFragment(frameLayout, listFragment, "Lista");
            TransitionManager.beginDelayedTransition(mainActMainLayout, new Rotate());
        } catch (Exception e){

        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (MainActivity.this.deviceOrientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            MainActivity.this.navigator(R.id.fragment_content, "list", null);
        }
    }
}
