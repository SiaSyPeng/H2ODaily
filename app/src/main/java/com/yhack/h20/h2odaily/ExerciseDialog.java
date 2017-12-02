package com.yhack.h20.h2odaily;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExerciseDialog extends DialogFragment {

    // global members to use in both onStart and onCreate
    private AlertDialog dialog;
    public Integer exerciseHour;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // inflate dialog view
        final View dialog_view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_exercise, null);
        // build dialog
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

        dialog = alertDialogBuilder.show();
        // set basic view for alertDialog
        alertDialogBuilder.setView(dialog_view)
                .setTitle("EXERCISE RECORD")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d("BMI DIALOG", "positive clicked");
                        SplashActivity.editor.putInt("exercise", exerciseHour);
                        SplashActivity.editor.commit();

                        //mListener.onDialogPositiveClick(WaterDialog.this);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d("BMI DIALOG", "negative clicked");
                        dialog.dismiss();
                    }
                });

        final EditText exercise_st = dialog_view.findViewById(R.id.exercise);

        exercise_st.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    // update hint and enable submit button after password confirm text changed
                    @Override
                    public void afterTextChanged(Editable editable) {
                        String exercise_str =exercise_st.getText().toString();
                        if (exercise_str != null && !exercise_str.isEmpty()) {
                            exerciseHour = Integer.parseInt(exercise_str);
                        }}});

        dialog = alertDialogBuilder.create();
        return dialog;
    }
}
