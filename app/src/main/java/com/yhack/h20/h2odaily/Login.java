package com.yhack.h20.h2odaily;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener{


    String str_UserName, str_Password, str_getID, str_getPass;

    EditText edt_UName, edt_Password;

    Button login;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        /* fetching the data from shared preference in order to make user login */
        /* data are saved in application through SplashActivity */
        /* only name and password is sufficient to make login */

        str_getID = SplashActivity.sh.getString("name", null);
        str_getPass = SplashActivity.sh.getString("password", null);
        login = (Button) findViewById(R.id.btn_login);
        edt_UName = (EditText) findViewById(R.id.edt_userName);
        edt_Password = (EditText) findViewById(R.id.edt_password);

        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        str_UserName = edt_UName.getText().toString();
        str_Password = edt_Password.getText().toString();

        /* make edittext condition for empty, input etc match */

        if (str_UserName.length() == 0 & str_Password.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "Please enter your login User Name and Password",
                    Toast.LENGTH_LONG).show();
        } else if (str_UserName.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "Please enter your User Name", Toast.LENGTH_LONG).show();
        } else if (str_Password.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "Please enter your Password", Toast.LENGTH_LONG).show();
        }

        else if (str_getID.matches("") && str_getPass.matches("")) {
            Toast.makeText(getApplicationContext(),
                    "Details does not belongs to any account",
                    Toast.LENGTH_LONG).show();
        }

        else if (!(str_UserName.matches(str_getID))) {
            Toast.makeText(getApplicationContext(),
                    "Either login/password is incorrect", Toast.LENGTH_LONG)
                    .show();
        }

        else if (!(str_getPass.matches(str_Password))) {
            Toast.makeText(getApplicationContext(),
                    "Either login/password is incorrect", Toast.LENGTH_LONG)
                    .show();
        }

        else if ((str_getID.matches(str_UserName))
                && (str_getPass.matches(str_Password))) {

            /*
             * dont forget to commit after doing the operation with shared
             * preference
             */
            /* without commit data will not saved to shared preference */
            SplashActivity.editor.putString("loginTest", "true");
            SplashActivity.editor.commit();

            Toast.makeText(getApplicationContext(),
                    "You have successfuly login", Toast.LENGTH_LONG).show();

            Intent sendToLogout = new Intent(getApplicationContext(),
                    HomeActivity.class);

            startActivity(sendToLogout);
        }

    }

    // on back key press exit the application.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(Login.this, SplashActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT", true);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
