package com.vcalazas.muno.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vcalazas.muno.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassOfIntruments extends Fragment {


    public ClassOfIntruments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_class_of_intruments, container, false);



        return view;
    }

}
