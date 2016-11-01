package ch.hsr.mge.gadgeothek;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import ch.hsr.mge.gadgeothek.domain.Reservation;
import ch.hsr.mge.gadgeothek.service.Callback;
import ch.hsr.mge.gadgeothek.service.LibraryService;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationViewHolder>{

    List<Reservation> reservations;

    ReservationAdapter(List<Reservation> reservations){
        this.reservations = reservations;
    }

    @Override
    public int getItemCount() {
        return reservations.size();
    }

    @Override
    public ReservationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reservation_row, viewGroup, false);
        return new ReservationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ReservationViewHolder reservationViewHolder, final int index) {
            reservationViewHolder.reservationName.setText(reservations.get(index).getGadget().getName());
            reservationViewHolder.reservationManufacturer.setText(reservations.get(index).getGadget().getManufacturer());
            if (reservations.get(index).isReady()) {
                reservationViewHolder.waiting_position.setText("Available");
            } else {
                reservationViewHolder.waiting_position.setText((reservations.get(index).getWatingPosition() + 1) + ". queued");
            }
            reservationViewHolder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LibraryService.deleteReservation(reservations.get(index), new Callback<Boolean>() {
                        @Override
                        public void onCompletion(Boolean input) {

                        }

                        @Override
                        public void onError(String message) {
                        }
                    });
                }
            });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
