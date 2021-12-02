package com.example.sharedaxis_example;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.transition.MaterialSharedAxis;

public class Fragment_C extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_C() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        @SuppressLint("WrongConstant")
        MaterialSharedAxis materialSharedAxis_exit = new MaterialSharedAxis(0,true);
        materialSharedAxis_exit.setDuration(4000);
        setExitTransition(materialSharedAxis_exit);
        @SuppressLint("WrongConstant")
        MaterialSharedAxis materialSharedAxis_return = new MaterialSharedAxis(0,false);
        materialSharedAxis_exit.setDuration(4000);
        setReturnTransition(materialSharedAxis_return);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__c, container, false);
        view.findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_holder,new Fragment_B())
                        .commit();
            }
        });

        return view;

    }
}