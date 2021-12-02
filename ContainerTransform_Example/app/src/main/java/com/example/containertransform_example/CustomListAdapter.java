package com.example.containertransform_example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomListAdapter extends ArrayAdapter<ContactInfoHolder> {
    private int resource;
    private Context mContext;

    public CustomListAdapter(@NonNull Context context, int resource, @NonNull List<ContactInfoHolder> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.resource=resource;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if(view==null){
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            view = layoutInflater.inflate(resource,null);
        }
        ContactInfoHolder contactInfoHolder = getItem(position);
        if(contactInfoHolder!=null){

            TextView email = view.findViewById(R.id.txt_email_row);
            TextView name = view.findViewById(R.id.txt_name_row);
            TextView phone = view.findViewById(R.id.txt_phone_row);

            email.setText(contactInfoHolder.getEmail());
            name.setText(contactInfoHolder.getName());
            phone.setText(contactInfoHolder.getPhone());

        }

        return view;
    }

}