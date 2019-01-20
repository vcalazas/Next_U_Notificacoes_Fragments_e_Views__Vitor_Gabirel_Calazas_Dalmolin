package com.vcalazas.muno.fragments;


import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.vcalazas.muno.R;
import com.vcalazas.muno.interfaces.OnListener;
import com.vcalazas.muno.models.Instruments;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    private OnListener mListener;
    private TextView tvDescription, tvInstrumentName1, tvInstrumentName2;
    private ImageButton imageButton1, imageButton2, imageButton3, imageButton4;
    private ImageView imageView1, imageView2;
    private List<Instruments> instrumentsList;
    private String[] classI;
    private LinearLayout llInsDefault;
    private ScrollView sVInsSelected;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        Bundle bundle = getArguments();

        DetailsFragment.this.tvDescription     = view.findViewById(R.id.tvDescription);
        DetailsFragment.this.tvInstrumentName1 = view.findViewById(R.id.tvInstrumentName1);
        DetailsFragment.this.tvInstrumentName2 = view.findViewById(R.id.tvInstrumentName2);
        DetailsFragment.this.imageButton1      = view.findViewById(R.id.imageButton1);
        DetailsFragment.this.imageButton2      = view.findViewById(R.id.imageButton2);
        DetailsFragment.this.imageButton3      = view.findViewById(R.id.imageButton3);
        DetailsFragment.this.imageButton4      = view.findViewById(R.id.imageButton4);
        DetailsFragment.this.imageView1        = view.findViewById(R.id.imageView1);
        DetailsFragment.this.imageView2        = view.findViewById(R.id.imageView2);
        DetailsFragment.this.llInsDefault      = view.findViewById(R.id.LLInsDefault);
        DetailsFragment.this.sVInsSelected     = view.findViewById(R.id.SVInsSelected);

        if (bundle == null){
            DetailsFragment.this.sVInsSelected.setVisibility(View.GONE);
            DetailsFragment.this.llInsDefault.setVisibility(View.VISIBLE);
        } else {
            DetailsFragment.this.llInsDefault.setVisibility(View.GONE);
            DetailsFragment.this.sVInsSelected.setVisibility(View.VISIBLE);
            int idClass = bundle.getInt("id");
            String[] classDescription   = getResources().getStringArray(R.array.classDescription);
            DetailsFragment.this.classI = getResources().getStringArray(R.array.classI);
            DetailsFragment.this.setInstrumentsList();
            final List<Instruments> il = DetailsFragment.this.gertInstrumentsByClass(DetailsFragment.this.classI[idClass]);

            getActivity().setTitle(classI[idClass]);

            DetailsFragment.this.tvDescription.setText(classDescription[idClass]);

            /* Imagens dos instrumentos */
            DetailsFragment.this.imageView1.setImageBitmap(BitmapFactory.decodeResource(getResources(),il.get(0).getImage()));
            DetailsFragment.this.imageView2.setImageBitmap(BitmapFactory.decodeResource(getResources(),il.get(1).getImage()));

            /* Nome dos instrumentos */
            DetailsFragment.this.tvInstrumentName1.setText(il.get(0).getName());
            DetailsFragment.this.tvInstrumentName2.setText(il.get(1).getName());


            /* Favoritos */
            DetailsFragment.this.imageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), il.get(0).getName()+" Adicionado aos seus favoritos.", Toast.LENGTH_SHORT).show();
                }
            });
            DetailsFragment.this.imageButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), il.get(1).getName()+" Adicionado aos seus favoritos.", Toast.LENGTH_SHORT).show();
                }
            });

            /* Toques */
            DetailsFragment.this.imageButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Este é o som do(a) "+il.get(0).getName(), Toast.LENGTH_SHORT).show();
                }
            });
            DetailsFragment.this.imageButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Este é o som do(a) "+il.get(1).getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        return view;
    }

    public void setmListener(OnListener mListener) {
        DetailsFragment.this.mListener = mListener;
    }

    private List<Instruments> gertInstrumentsByClass(String classI){
        try {
            List<Instruments> il = new ArrayList<Instruments>();
            for (Instruments i : DetailsFragment.this.instrumentsList){
                if( i.getClassI().equals(classI) ){
                    il.add(i);
                }
            }
            return il;
        } catch (Exception e){
            return new ArrayList<Instruments>();
        }
    }

    private void setInstrumentsList() {
        DetailsFragment.this.instrumentsList = new ArrayList<Instruments>();

        DetailsFragment.this.instrumentsList.add(new Instruments(1,  DetailsFragment.this.classI[0], "Violão",   false, R.drawable.violao));
        DetailsFragment.this.instrumentsList.add(new Instruments(2,  DetailsFragment.this.classI[0], "Violino",  false, R.drawable.violino));
        DetailsFragment.this.instrumentsList.add(new Instruments(3,  DetailsFragment.this.classI[1], "Bateria",  false, R.drawable.bateria));
        DetailsFragment.this.instrumentsList.add(new Instruments(4,  DetailsFragment.this.classI[1], "Pandeiro", false, R.drawable.pandeiro));
        DetailsFragment.this.instrumentsList.add(new Instruments(5,  DetailsFragment.this.classI[2], "Flauta",   false, R.drawable.flauta));
        DetailsFragment.this.instrumentsList.add(new Instruments(6,  DetailsFragment.this.classI[2], "Clarinete",false, R.drawable.clarinete));
        DetailsFragment.this.instrumentsList.add(new Instruments(7,  DetailsFragment.this.classI[3], "Teclado",  false, R.drawable.teclado));
        DetailsFragment.this.instrumentsList.add(new Instruments(8,  DetailsFragment.this.classI[3], "Guitarra", false, R.drawable.guitarra));
    }
}
