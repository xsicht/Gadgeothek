package ch.hsr.mge.gadgeothek;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ReservationViewHolder extends RecyclerView.ViewHolder {
    RecyclerView recyclerView;
    TextView reservationName;
    TextView reservationManufacturer;
    TextView waiting_position;
    TextView available;
    CardView cardView;

    ReservationViewHolder(final View itemView) {
        super(itemView);
        recyclerView = (RecyclerView)itemView.findViewById(R.id.reservation_recyclerView);
        reservationName = (TextView)itemView.findViewById(R.id.reservation_name);
        reservationManufacturer = (TextView)itemView.findViewById(R.id.reservation_manufacturer);
        waiting_position = (TextView)itemView.findViewById(R.id.reservation_waiting_position);
        cardView = (CardView) itemView.findViewById(R.id.reservation_card_view);

    }
}
