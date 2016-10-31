package ch.hsr.mge.gadgeothek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ch.hsr.mge.gadgeothek.service.LibraryService;

public class MainActivity extends AppCompatActivity {

    static String serverAddress = "http://mge1.dev.ifs.hsr.ch/public";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LibraryService.setServerAddress(serverAddress);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startActivity(new Intent(this, LoginActivity.class));
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
