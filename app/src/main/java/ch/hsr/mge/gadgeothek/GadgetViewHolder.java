package ch.hsr.mge.gadgeothek;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class GadgetViewHolder extends RecyclerView.ViewHolder {

    RecyclerView recyclerView;
    TextView gadgetName;
    TextView gadgetManufacturer;
    TextView gadgetPrice;
    TextView gadgetCondition;

    GadgetViewHolder(View itemView) {
        super(itemView);
        recyclerView = (RecyclerView)itemView.findViewById(R.id.gadget_recyclerView);
        gadgetName = (TextView)itemView.findViewById(R.id.gadget_name);
        gadgetManufacturer = (TextView)itemView.findViewById(R.id.gadget_manufacturer);
        gadgetPrice = (TextView)itemView.findViewById(R.id.gadget_price);
        gadgetCondition = (TextView)itemView.findViewById(R.id.gadget_condition);
    }
}
