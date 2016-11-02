package ch.hsr.mge.gadgeothek;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ch.hsr.mge.gadgeothek.domain.Gadget;

public class GadgetAdapter extends RecyclerView.Adapter<GadgetViewHolder> {

    static List<Gadget> gadgets;

    GadgetAdapter(List<Gadget> gadgets) {
        this.gadgets = gadgets;
        Log.d("gadgetadpater","konstruktor");
    }



    @Override
    public GadgetViewHolder onCreateViewHolder(ViewGroup viewGroup, int index) {
        Log.d("gadgetadpater","onCreateViewHolder");
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gadget_row, viewGroup, false);
        return new GadgetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GadgetViewHolder gadgetViewHolder, final int index) {
        Log.d("gadgetadpater","onBindViewHolder");
        gadgetViewHolder.gadgetName.setText(gadgets.get(index).getName());
        gadgetViewHolder.gadgetManufacturer.setText(gadgets.get(index).getManufacturer());
        gadgetViewHolder.gadgetCondition.setText(gadgets.get(index).getCondition().toString());
        gadgetViewHolder.gadgetPrice.setText("" + gadgets.get(index).getPrice());
/*        gadgetViewHolder.gadgetBtnReserve.setOnClickListener(new View.OnClickListener() {
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
        });*/
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
