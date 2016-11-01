package ch.hsr.mge.gadgeothek;

import java.util.List;
import ch.hsr.mge.gadgeothek.domain.Gadget;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Toast;

import ch.hsr.mge.gadgeothek.domain.Gadget;
import ch.hsr.mge.gadgeothek.service.Callback;
import ch.hsr.mge.gadgeothek.service.LibraryService;

public class GadgetAdapter extends RecyclerView.Adapter<GadgetViewHolder> {

    static List<Gadget> gadgets;

    GadgetAdapter(List<Gadget> gadgets) { this.gadgets = gadgets; }



    @Override
    public GadgetViewHolder onCreateViewHolder(ViewGroup viewGroup, int index) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gadget_row, viewGroup, false);
        return new GadgetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GadgetViewHolder gadgetViewHolder, final int index) {
        gadgetViewHolder.gadgetName.setText(gadgets.get(index).getName());
        gadgetViewHolder.gadgetManufacturer.setText(gadgets.get(index).getManufacturer());
        gadgetViewHolder.gadgetCondition.setText(gadgets.get(index).getCondition().toString());
        gadgetViewHolder.gadgetPrice.setText("" + gadgets.get(index).getPrice());
        gadgetViewHolder.gadgetBtnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LibraryService.reserveGadget(gadgets.get(index), new Callback<Boolean>() {
                    @Override
                    public void onCompletion(Boolean input) {
                        Log.d("test","test");
                        //mainActivity.switchTo(new ReservationFragment());
                    }

                    @Override
                    public void onError(String message) {
                        //Toast.makeText(mainActivity, "Fehler bei Löschung", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
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
