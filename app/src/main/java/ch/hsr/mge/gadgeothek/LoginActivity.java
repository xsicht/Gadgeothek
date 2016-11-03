package ch.hsr.mge.gadgeothek;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ch.hsr.mge.gadgeothek.service.Callback;
import ch.hsr.mge.gadgeothek.service.LibraryService;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    TextView linkSignup;
    TextView linkServer;
    String serverAdress;
    SharedPreferences settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        settings = getSharedPreferences("SERVER", MODE_PRIVATE);
        LibraryService.setServerAddress(settings.getString("serverAdress", "http://mge1.dev.ifs.hsr.ch/public"));



        loginButton = (Button)findViewById(R.id.loginbutton);
        linkSignup = (TextView)findViewById(R.id.link_signup);
        linkServer = (TextView)findViewById(R.id.link_server);

        final EditText email = (EditText)findViewById(R.id.input_email);
        final EditText pass = (EditText)findViewById(R.id.input_password);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Log.d("server","adress: " + serverAdress);
                final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                        R.style.AppTheme_Dark_Dialog);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Authenticating...");
                progressDialog.show();
                LibraryService.login(email.getText().toString(), pass.getText().toString(), new Callback<Boolean>() {


                    @Override
                    public void onCompletion(Boolean success) {
                        if(success) {
                            progressDialog.dismiss();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));

                            //startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                        }
                    }

                    @Override
                    public void onError(String message) {
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        linkSignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });


        linkServer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final EditText edittext = new EditText(LoginActivity.this);
                AlertDialog.Builder alert = new AlertDialog.Builder((new ContextThemeWrapper(v.getContext(), R.style.AlertDialogCustom)));
                edittext.setText(settings.getString("serverAdress", "default"));
                alert.setMessage("Enter server adress");
                alert.setView(edittext);
                alert.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        serverAdress = edittext.getText().toString();

                        //SharedPreferences settings = getSharedPreferences("SERVER", MODE_PRIVATE);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("serverAdress", serverAdress);

                        editor.commit();
                        //
                        LibraryService.setServerAddress(settings.getString("serverAdress", "default"));

                        Log.d("server","adress: " + settings.getString("serverAdress", "default"));

                    }
                });

                alert.setNegativeButton("Discard", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // what ever you want to do with No option.
                    }
                });
                alert.show();
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
