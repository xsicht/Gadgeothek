package ch.hsr.mge.gadgeothek;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ch.hsr.mge.gadgeothek.domain.Loan;

public class LoanAdapter extends RecyclerView.Adapter<LoanViewHolder> {

    List<Loan> loans;

    LoanAdapter(List<Loan> loan){
        this.loans = loan;
    }

    @Override
    public int getItemCount() {
        return loans.size();
    }

    @Override
    public LoanViewHolder onCreateViewHolder(ViewGroup viewGroup, int index) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.loan_row, viewGroup, false);
        return new LoanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LoanViewHolder loanViewHolder, int index) {
        SimpleDateFormat format = new SimpleDateFormat("dd. MMM yyyy");
        loanViewHolder.loanName.setText(loans.get(index).getGadget().getName());
        loanViewHolder.loanManufacturer.setText(loans.get(index).getGadget().getManufacturer());
        String date = format.format(loans.get(index).getPickupDate());
        loanViewHolder.loanDate.setText(date);
        date = format.format(loans.get(index).overDueDate());
        loanViewHolder.returnDate.setText(date);
        loanViewHolder.daysLeft.setText("" + loans.get(index).getDaysToReturn());

        if(!loans.get(index).isOverdue()){
            loanViewHolder.daysLeft.setBackgroundColor(Color.parseColor("#ff0000"));
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
