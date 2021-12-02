package com.example.containertransform_example;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.transition.platform.MaterialContainerTransform;

import java.util.ArrayList;
import java.util.List;


public class List_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ListView listView;
    CustomListAdapter customListAdapter;
    List<ContactInfoHolder> contactInfoHolderList;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;

    public List_Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        MaterialContainerTransform materialContainerTransform = new MaterialContainerTransform();
        materialContainerTransform.setDuration(1000);
        materialContainerTransform.setFadeMode(MaterialContainerTransform.FADE_MODE_OUT);
        setSharedElementEnterTransition(materialContainerTransform);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_list_, container, false);

        listView = view.findViewById(R.id.list_of_items);

        //Adding some sample records.
        contactInfoHolderList = new ArrayList<>();
        ContactInfoHolder contactInfoHolder = new ContactInfoHolder("Zeeshan","03053206339","zeeshanahedd0010@gmail.com","0321","Every where");
        contactInfoHolderList.add(contactInfoHolder);
        contactInfoHolder = new ContactInfoHolder("Nadir","03033306339","nadir@gmail.com","03431","Every where");
        contactInfoHolderList.add(contactInfoHolder);
        contactInfoHolder = new ContactInfoHolder("Nigeeta","03111306339","nigeeta@gmail.com","03321","Every where");
        contactInfoHolderList.add(contactInfoHolder);
        contactInfoHolder = new ContactInfoHolder("Rizwan","03324206339","rizwan@gmail.com","03321","Every where");
        contactInfoHolderList.add(contactInfoHolder);
        customListAdapter = new CustomListAdapter(getContext(),R.layout.contact_info_holder,contactInfoHolderList);
        listView.setAdapter(customListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view_internal, int position, long id) {


                getActivity().getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                        .addSharedElement(view_internal,view_internal.getTransitionName())
                        .replace(R.id.fragment_holder,new Details_Fragment(),Details_Fragment.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}