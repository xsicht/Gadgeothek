package ch.hsr.mge.gadgeothek;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import ch.hsr.mge.gadgeothek.service.Callback;
import ch.hsr.mge.gadgeothek.service.LibraryService;

public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LibraryService.logout(new Callback<Boolean>() {
            @Override
            public void onCompletion(Boolean success) {
                if(success) {
                    Toast.makeText(LogoutActivity.this, "Logout successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LogoutActivity.this, LoginActivity.class));
                }
            }

            @Override
            public void onError(String message) {
                Toast.makeText(LogoutActivity.this, "Logout failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
