package ch.hsr.mge.gadgeothek;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.List;

import ch.hsr.mge.gadgeothek.domain.Reservation;
import ch.hsr.mge.gadgeothek.service.Callback;
import ch.hsr.mge.gadgeothek.service.LibraryService;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReservationFragment extends android.support.v4.app.Fragment {


    public ReservationFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservation, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.reservation_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        FrameLayout rlayout = (FrameLayout) container.findViewById(R.id.framlayout);

        getReservations();

        return view;
    }

    public void getReservations(){
        LibraryService.getReservationsForCustomer(new Callback<List<Reservation>>() {
            @Override
            public void onCompletion(List<Reservation> input) {
                ReservationAdapter reservationAdapter = new ReservationAdapter(input);
                recyclerView.setAdapter(reservationAdapter);
                Log.d("ReservationFragment","setAdapter");


            }

            @Override
            public void onError(String message) {
                Toast.makeText(getActivity(), "Request failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
