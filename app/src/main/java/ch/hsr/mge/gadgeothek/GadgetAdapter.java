package ch.hsr.mge.gadgeothek;

import java.util.List;
import ch.hsr.mge.gadgeothek.domain.Gadget;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import ch.hsr.mge.gadgeothek.domain.Gadget;

public class GadgetAdapter extends RecyclerView.Adapter<GadgetViewHolder> {

    List<Gadget> gadgets;

    GadgetAdapter(List<Gadget> gadgets) {
        this.gadgets = gadgets;
    }

    @Override
    public GadgetViewHolder onCreateViewHolder(ViewGroup viewGroup, int index) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gadget_row, viewGroup, false);
        return new GadgetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GadgetViewHolder gadgetViewHolder, int index) {
        gadgetViewHolder.gadgetName.setText(gadgets.get(index).getName());
        gadgetViewHolder.gadgetManufacturer.setText(gadgets.get(index).getManufacturer());
        gadgetViewHolder.gadgetCondition.setText(gadgets.get(index).getCondition().toString());
        gadgetViewHolder.gadgetPrice.setText("" + gadgets.get(index).getPrice());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return gadgets.size();
    }
}
