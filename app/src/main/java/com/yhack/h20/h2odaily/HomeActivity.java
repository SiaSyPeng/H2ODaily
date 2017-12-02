package com.yhack.h20.h2odaily;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    public WaterDialog mwaterdialog;
    public BMIDialog mbmiDialog;
    //public Integer cupsConsumed;

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
        mwaterdialog = new WaterDialog();
        mwaterdialog.show(getFragmentManager(), "dialogShow");

    }

    public void checkClick(View view) {

    }

    public void exerciseClick(View view) {

    }

    public void weightClick(View v) {
        mbmiDialog = new BMIDialog();
        mbmiDialog.show(getFragmentManager(), "dialogShow");

    }

}
