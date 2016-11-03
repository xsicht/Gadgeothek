package ch.hsr.mge.gadgeothek;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GadgetViewHolder extends RecyclerView.ViewHolder {

    RecyclerView recyclerView;
    TextView gadgetName;
    TextView gadgetManufacturer;
    TextView gadgetPrice;
    TextView gadgetCondition;
    Button gadgetBtnReserve;
    CardView cardView;


    GadgetViewHolder(View itemView) {
        super(itemView);
        Log.d("GadgetViewHolder","konstruktor");
        recyclerView = (RecyclerView)itemView.findViewById(R.id.gadget_recyclerView);
        gadgetName = (TextView)itemView.findViewById(R.id.gadget_name);
        gadgetManufacturer = (TextView)itemView.findViewById(R.id.gadget_manufacturer);
        gadgetPrice = (TextView)itemView.findViewById(R.id.gadget_price);
        gadgetCondition = (TextView)itemView.findViewById(R.id.gadget_condition);
        cardView = (CardView) itemView.findViewById(R.id.gadget_card_view);
        //gadgetBtnReserve = (Button) itemView.findViewById(R.id.gadget_button);
    }

}
