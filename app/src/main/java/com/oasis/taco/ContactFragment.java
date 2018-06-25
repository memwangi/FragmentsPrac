package com.oasis.taco;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ContactFragment extends Fragment{

    View view;
    private RecyclerView myRecyclerView;
    private List<Contact> lstContact;

    public ContactFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


       view = inflater.inflate(R.layout.contact_fragment,container,false);
       myRecyclerView = (RecyclerView) view.findViewById(R.id.contact_recyclerview);
       RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(),lstContact);
       myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
       myRecyclerView.setAdapter(recyclerAdapter);
       return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstContact = new ArrayList<>();

        lstContact.add(new Contact("Joseph Mugo", "0724916179",R.drawable.loah_profile));
        lstContact.add(new Contact("Joseph Mugo", "0724916179",R.drawable.loah_profile));
        lstContact.add(new Contact("Joseph Mugo", "0724916179",R.drawable.loah_profile));
        lstContact.add(new Contact("Joseph Mugo", "0724916179",R.drawable.loah_profile));
        lstContact.add(new Contact("Joseph Mugo", "0724916179",R.drawable.loah_profile));
        lstContact.add(new Contact("Joseph Mugo", "0724916179",R.drawable.loah_profile));
        lstContact.add(new Contact("Joseph Mugo", "0724916179",R.drawable.loah_profile));
        lstContact.add(new Contact("Joseph Mugo", "0724916179",R.drawable.loah_profile));






    }
}
