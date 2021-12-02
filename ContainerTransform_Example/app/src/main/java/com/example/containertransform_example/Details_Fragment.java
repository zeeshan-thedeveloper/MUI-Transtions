package com.example.containertransform_example;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.transition.platform.MaterialContainerTransform;

public class Details_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Details_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

//        MaterialContainerTransform materialContainerTransform = new MaterialContainerTransform();
//        materialContainerTransform.setDuration(3000);
//        materialContainerTransform.setFadeMode(MaterialContainerTransform.FADE_MODE_OUT);
//        setSharedElementEnterTransition(materialContainerTransform);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details_, container, false);
        view.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                        .addSharedElement(v,v.getTransitionName())
                        .replace(R.id.fragment_holder,new List_Fragment(),List_Fragment.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}