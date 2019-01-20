package com.vcalazas.muno.fragments;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.vcalazas.muno.MainActivity;
import com.vcalazas.muno.R;
import com.vcalazas.muno.interfaces.OnListener;

public class ListFragment extends Fragment {

    private OnListener mListener;
    private int deviceOrientation;
    private int idLayoutDescription;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        getActivity().setTitle("Instrumentos músicais");

        ListFragment.this.idLayoutDescription = ( ListFragment.this.getResources().getConfiguration().orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT ? R.id.fragment_content : R.id.fragment2 );

        String[] classI = getResources().getStringArray(R.array.classI);

        ListView select_dialog_listview = view.findViewById(R.id.select_dialog_listview);

        ArrayAdapter<String> ad = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, classI);
        select_dialog_listview.setAdapter(ad);

        //list.setItemChecked(0, true);
        select_dialog_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("id", position);
                mListener.onCall(ListFragment.this.idLayoutDescription, "details", bundle);            }
        });

        return view;
    }

    public void setmListener(OnListener mListener) {
        this.mListener = mListener;
    }
}
