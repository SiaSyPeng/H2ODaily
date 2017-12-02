package com.yhack.h20.h2odaily;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void settingClick(View v) {
        Intent sendToSetting = new Intent(getApplicationContext(),
                SettingActivity.class);

        startActivity(sendToSetting);
    }

    public void waterClick(View view) {
    }

    public void weatherClick(View view) {

    }

    public void exerciseClick(View view) {

    }

    private void weightClick(View view) {

    }

}
