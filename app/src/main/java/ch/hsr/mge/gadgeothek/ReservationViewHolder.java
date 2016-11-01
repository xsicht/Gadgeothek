package ch.hsr.mge.gadgeothek;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import ch.hsr.mge.gadgeothek.domain.Gadget;
import ch.hsr.mge.gadgeothek.domain.Reservation;

public class ReservationViewHolder extends RecyclerView.ViewHolder {
    RecyclerView recyclerView;
    TextView reservationName;
    TextView reservationManufacturer;
    TextView waiting_position;
    TextView available;
    Button delete;

    ReservationViewHolder(final View itemView) {
        super(itemView);
        recyclerView = (RecyclerView)itemView.findViewById(R.id.reservation_recyclerView);
        reservationManufacturer = (TextView)itemView.findViewById(R.id.reservation_name);
        reservationManufacturer = (TextView)itemView.findViewById(R.id.reservation_manufacturer);
        waiting_position = (TextView)itemView.findViewById(R.id.reservation_waiting_position);
        delete = (Button)itemView.findViewById(R.id.reservation_delete);

    }
}
