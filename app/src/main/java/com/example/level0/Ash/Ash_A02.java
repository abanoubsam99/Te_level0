package com.example.level0.Ash;


import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.level0.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


/**
 * A simple {@link Fragment} subclass.
 */
public class Ash_A02 extends Fragment {

    private AdView mAdView;


    public Ash_A02() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ash__a02, container, false);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        MobileAds.initialize(getContext(), "ca-app-pub-9066719717930706~6805817120");

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "Avva_Shenouda.ttf");
        TextView textView = view.findViewById(R.id.COPTIC_ash02);
        textView.setTypeface(typeface);



        final TextView Ta = view.findViewById(R.id.ARAB_ash02);
        final TextView TC = view.findViewById(R.id.COPTIC_ash02);
        final TextView TCA = view.findViewById(R.id.Ca_ash02);
        Spinner spinner = view.findViewById(R.id.spinner_ash02);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (view != null) {


                    if (i == 0) {
                        Ta.setText(R.string.mazmor126_ash02);
                        TC.setText("");
                        TCA.setText("");



                    } else if (i == 1) {
                        Ta.setText(R.string.mazmor99_ash02);
                        TC.setText("");
                        TCA.setText("");


                    } else {
                        Ta.setText(R.string.mazmor69_ash02);
                        TC.setText("");
                        TCA.setText("");


                    }


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }


}