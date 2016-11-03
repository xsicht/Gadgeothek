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

import ch.hsr.mge.gadgeothek.domain.Gadget;
import ch.hsr.mge.gadgeothek.service.Callback;
import ch.hsr.mge.gadgeothek.service.LibraryService;

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
    public void onBindViewHolder(final GadgetViewHolder gadgetViewHolder, final int index) {
        Log.d("gadgetadpater","onBindViewHolder");
        gadgetViewHolder.gadgetName.setText(gadgets.get(index).getName());
        gadgetViewHolder.gadgetManufacturer.setText(gadgets.get(index).getManufacturer());
        gadgetViewHolder.gadgetCondition.setText(gadgets.get(index).getCondition().toString());
        gadgetViewHolder.gadgetPrice.setText("" + gadgets.get(index).getPrice());
        gadgetViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
                builder1.setMessage("Do you want reserve "  + gadgetViewHolder.gadgetName.getText());
                builder1.setCancelable(true);
                //Snackbar.make(v, "Do you want reserve this gadget?", Snackbar.LENGTH_LONG).show();
                final View finalView = v;
                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //show();

                                LibraryService.reserveGadget(gadgets.get(index), new Callback<Boolean>() {
                                    @Override
                                    public void onCompletion(Boolean input) {
                                        Log.d("test","test");
                                        Snackbar.make(finalView, "You have reserved " + gadgetViewHolder.gadgetName.getText(), Snackbar.LENGTH_LONG).show();
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

    @Override
    public int getItemCount() {
        return gadgets.size();
    }

}
