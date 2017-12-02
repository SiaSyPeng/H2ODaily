package com.yhack.h20.h2odaily;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity implements WaterDialog.DialogListener{

    public WaterDialog mwaterdialog;
    public Integer cupsConsumed;

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

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        cupsConsumed = mwaterdialog.checkcups();
    }

    public void weatherClick(View view) {

    }

    public void exerciseClick(View view) {

    }

    public void weightClick(View v) {

    }

}
