package ch.hsr.mge.gadgeothek;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        reservationViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
                    builder1.setMessage("Do you want cancle the reservation?");
                    builder1.setCancelable(true);
                    final View finalView = v;
                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int id) {
                                    //show();

                                    LibraryService.deleteReservation(reservations.get(index), new Callback<Boolean>() {
                                        @Override
                                        public void onCompletion(Boolean input) {
                                            Snackbar.make(finalView, "Reservation cancled", Snackbar.LENGTH_LONG).show();
                                        }

                                        @Override
                                        public void onError(String message) {
                                            Snackbar.make(finalView, "Reservation Error", Snackbar.LENGTH_LONG).show();
                                        }
                                    });

                                    dialog.cancel();

                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                    Log.d("cradview","cardview");
                }
            });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {

        super.onAttachedToRecyclerView(recyclerView);
    }
}
