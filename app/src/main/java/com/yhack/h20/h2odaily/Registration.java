package com.yhack.h20.h2odaily;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity implements View.OnClickListener {

    Button register;
    String url;

    String str_Name, str_Password, str_RePassword, str_Height, str_Weight,
            random;

    EditText edt_Name, edt_Password, edt_RePassword, edt_Height, edt_Weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.registration);

        register = (Button) findViewById(R.id.btn_register);
        edt_Name = (EditText) findViewById(R.id.edt_Rname);
        edt_Password = (EditText) findViewById(R.id.edt_Rpassword);
        edt_RePassword = (EditText) findViewById(R.id.edt_RRepassword);
        edt_Height = (EditText) findViewById(R.id.edt_height);
        edt_Weight = (EditText) findViewById(R.id.edt_weight);

        register.setOnClickListener(this);
    }

    public void onClick(View v) {
        // TODO Auto-generated method stub
        str_Name = edt_Name.getText().toString();
        str_Password = edt_Password.getText().toString();
        str_RePassword = edt_RePassword.getText().toString();
        str_Height = edt_Height.getText().toString();
        str_Weight = edt_Weight.getText().toString();

        if (str_Name.length() == 0 & str_Password.length() == 0
                & str_RePassword.length() == 0 & str_Height.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "All fields are mandatory to fill", Toast.LENGTH_LONG)
                    .show();
        } else if (str_Name.length() == 0) {
            Toast.makeText(getApplicationContext(), "Please enter your Name",
                    Toast.LENGTH_LONG).show();
        } else if (str_Password.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "Please enter your Password", Toast.LENGTH_LONG).show();
        } else if (str_RePassword.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "Please Re-enter your Password", Toast.LENGTH_LONG).show();
        } else if (str_Height.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "Please enter your Height", Toast.LENGTH_LONG).show();
        }

        else if (str_Password.contains(str_RePassword) != str_RePassword
                .contains(str_Password)) {
            Toast.makeText(getApplicationContext(),
                    "Confirm Password does not match", Toast.LENGTH_LONG)
                    .show();
        } else if (str_Weight.length() == 0) {

            Toast.makeText(getApplicationContext(),
                    "Please enter your Intake", Toast.LENGTH_LONG)
                    .show();

        }

        else {
            SplashActivity.editor.putString("name", str_Name);
            SplashActivity.editor.putString("password", str_RePassword);
            SplashActivity.editor.putInt("height", Integer.parseInt(str_Height));
            SplashActivity.editor.putInt("weight", Integer.parseInt(str_Weight));

            SplashActivity.editor.commit();

            Intent sendtoLogin = new Intent(getApplicationContext(),
                    LandingActivity.class);

            Toast.makeText(getApplicationContext(),
                    "You have successfully registered", Toast.LENGTH_LONG)
                    .show();

            startActivity(sendtoLogin);

        }

    }

    // on back key press exit the application.

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(Registration.this, SplashActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT", true);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

}
