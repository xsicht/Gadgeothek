package ch.hsr.mge.gadgeothek;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class LoanViewHolder extends RecyclerView.ViewHolder {

    RecyclerView recyclerView;
    TextView loanName;
    TextView loanManufacturer;
    TextView loanDate;
    TextView returnDate;
    TextView daysLeft;

    LoanViewHolder(View itemView) {
        super(itemView);
        recyclerView = (RecyclerView)itemView.findViewById(R.id.loan_recyclerView);
        loanName = (TextView)itemView.findViewById(R.id.loan_name);
        loanManufacturer = (TextView)itemView.findViewById(R.id.loan_manufacturer);
        loanDate = (TextView)itemView.findViewById(R.id.loan_date);
        returnDate = (TextView)itemView.findViewById(R.id.loan_return_date);
        daysLeft = (TextView)itemView.findViewById(R.id.loan_days_left);
    }

}
