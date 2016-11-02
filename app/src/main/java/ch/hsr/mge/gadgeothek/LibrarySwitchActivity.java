package ch.hsr.mge.gadgeothek;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LibrarySwitchActivity extends AppCompatActivity{

    Button switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libraryswitch);

        switchButton = (Button)findViewById(R.id.switchbutton);

        final EditText newServer = (EditText)findViewById(R.id.serverInput);

        switchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               // MainActivity.serverAddress = newServer.getText().toString();
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
