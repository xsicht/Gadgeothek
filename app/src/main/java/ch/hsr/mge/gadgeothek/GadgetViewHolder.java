package ch.hsr.mge.gadgeothek;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


import ch.hsr.mge.gadgeothek.service.Callback;
import ch.hsr.mge.gadgeothek.service.LibraryService;

public class GadgetViewHolder extends RecyclerView.ViewHolder {

    RecyclerView recyclerView;
    TextView gadgetName;
    TextView gadgetManufacturer;
    TextView gadgetPrice;
    TextView gadgetCondition;
    RadioButton gadgetButton;

    GadgetViewHolder(View itemView) {
        super(itemView);
        gadgetButton = (RadioButton) itemView.findViewById(R.id.gadget_name);
        recyclerView = (RecyclerView)itemView.findViewById(R.id.gadget_recyclerView);
        gadgetName = (TextView)itemView.findViewById(R.id.gadget_name);
        gadgetManufacturer = (TextView)itemView.findViewById(R.id.gadget_manufacturer);
        gadgetPrice = (TextView)itemView.findViewById(R.id.gadget_price);
        gadgetCondition = (TextView)itemView.findViewById(R.id.gadget_condition);

    }
}
