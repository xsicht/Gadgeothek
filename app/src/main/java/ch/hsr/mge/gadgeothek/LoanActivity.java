package ch.hsr.mge.gadgeothek;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import ch.hsr.mge.gadgeothek.domain.Loan;
import ch.hsr.mge.gadgeothek.service.Callback;
import ch.hsr.mge.gadgeothek.service.LibraryService;

public class LoanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.loan_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        LibraryService.getLoansForCustomer(new Callback<List<Loan>>() {
            @Override
            public void onCompletion(List<Loan> input) {
                LoanAdapter loanAdapter = new LoanAdapter(input);
                recyclerView.setAdapter(loanAdapter);
            }

            @Override
            public void onError(String message) {
                Toast.makeText(LoanActivity.this, "Request failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
