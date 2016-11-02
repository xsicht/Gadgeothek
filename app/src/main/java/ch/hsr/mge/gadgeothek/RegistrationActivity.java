package ch.hsr.mge.gadgeothek;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ch.hsr.mge.gadgeothek.service.Callback;
import ch.hsr.mge.gadgeothek.service.LibraryService;


public class RegistrationActivity extends AppCompatActivity {

    Button btnSignup;
    TextView linkLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btnSignup = (Button)findViewById(R.id.btn_signup);
        linkLogin = (TextView)findViewById(R.id.link_login);

        final EditText email = (EditText)findViewById(R.id.input_email);
        final EditText name = (EditText)findViewById(R.id.input_name);
        final EditText pass = (EditText)findViewById(R.id.input_password);
        final EditText studId = (EditText)findViewById(R.id.input_id);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btnSignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                LibraryService.register(email.getText().toString(), name.getText().toString(), pass.getText().toString(), studId.getText().toString(), new Callback<Boolean>() {
                    @Override
                    public void onCompletion(Boolean success) {
                        if(success) {
                            Toast.makeText(RegistrationActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                        }
                    }

                    @Override
                    public void onError(String message) {
                        Toast.makeText(RegistrationActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        linkLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
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
