package ch.hsr.mge.gadgeothek;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import ch.hsr.mge.gadgeothek.domain.Gadget;
import ch.hsr.mge.gadgeothek.service.Callback;
import ch.hsr.mge.gadgeothek.service.LibraryService;


public class GadgetFragment extends android.support.v4.app.Fragment {


    public GadgetFragment() {
        // Required empty public constructor
        Log.d("GadgetFragment","konstruktor");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gadget, container, false);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.gadget_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        LibraryService.getGadgets(new Callback<List<Gadget>>() {
            @Override
            public void onCompletion(List<Gadget> input) {
                GadgetAdapter gadgetAdapter = new GadgetAdapter(input);
                recyclerView.setAdapter(gadgetAdapter);
                Log.d("GadgetFragment","setAdapter");


            }

            @Override
            public void onError(String message) {
                Toast.makeText(getActivity(), "Request failed", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }



}
