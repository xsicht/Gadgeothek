package ch.hsr.mge.gadgeothek;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ch.hsr.mge.gadgeothek.domain.Reservation;

public class MenuActivity extends AppCompatActivity {

    Button gadgetsButton;
    Button loansButton;
    Button reservationsButton;
    Button switchLibraryButton;
    Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        gadgetsButton = (Button)findViewById(R.id.gadgetsbutton);
        loansButton = (Button)findViewById(R.id.loansbutton);
        reservationsButton = (Button)findViewById(R.id.reservationsbutton);
        switchLibraryButton = (Button)findViewById(R.id.switchlibrarybutton);
        logoutButton = (Button)findViewById(R.id.logoutbutton);

        gadgetsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, GadgetActivity.class));
            }
        });

        loansButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, LoanActivity.class));
            }
        });

        reservationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, ReservationActivity.class));
            }
        });

        switchLibraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, LibrarySwitchActivity.class));
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, LogoutActivity.class));
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
