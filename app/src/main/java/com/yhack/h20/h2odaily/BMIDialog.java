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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BMIDialog extends DialogFragment {

    // global members to use in both onStart and onCreate
    private AlertDialog dialog;
//    private Button submitButton;

    // public memebers to pass to host
//    public Integer checkcups() { return cups; }
    public Integer height;
    //= Integer.parseInt( SplashActivity.sh.getString("height", "0"));;
    public Integer weight;
    //= Integer.parseInt(SplashActivity.sh.getString("weight", "0"));


    /* The activity that creates an instance of this dialog fragment must
    * implement this interface in order to receive event callbacks.
    * Each method passes the DialogFragment in case the host needs to query it. */
//    public interface DialogListener {
//        public void onDialogPositiveClick(DialogFragment dialog);
//    }


    //   DialogListener mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // inflate dialog view
        final View dialog_view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_bmi, null);
        // build dialog
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

        dialog = alertDialogBuilder.show();
        // set basic view for alertDialog
        alertDialogBuilder.setView(dialog_view)
                .setTitle("BMI UPDATE")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d("BMI DIALOG", "positive clicked");
                        SplashActivity.editor.putInt("height", height);
                        SplashActivity.editor.putInt("weight", weight);
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

        final EditText height_now = dialog_view.findViewById(R.id.height_now);
        final EditText weight_now = dialog_view.findViewById(R.id.weight_now);

        String height_string =height_now.getText().toString();
        if (height_string != null && !height_string.isEmpty()) {
            height = Integer.parseInt(height_string);
        }

        String weight_string =weight_now.getText().toString();
        if (weight_string != null && !weight_string.isEmpty()) {
            weight = Integer.parseInt(weight_string);
        }

        dialog = alertDialogBuilder.create();
        return dialog;
    }

    // disable save button at the beginning
    @Override
    public void onStart(){
        super.onStart();

    }
}