package com.yhack.h20.h2odaily;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    private WaterDialog mwaterdialog;
    private BMIDialog mbmiDialog;
    private ExerciseDialog mexercisedialog;

    private Integer curr_height,  curr_weight , curr_cups, curr_exercise;

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
        curr_height = SplashActivity.sh.getInt("height", 0);
        curr_weight = SplashActivity.sh.getInt("weight", 0);
        curr_cups = SplashActivity.sh.getInt("cupsConsumed", 0);
        curr_exercise = SplashActivity.sh.getInt("exercise", 0);

    }

    public void exerciseClick(View view) {
        mexercisedialog = new ExerciseDialog();
        mexercisedialog.show(getFragmentManager(), "dialogShow");

    }

    public void weightClick(View v) {
        mbmiDialog = new BMIDialog();
        mbmiDialog.show(getFragmentManager(), "dialogShow");

    }

}
