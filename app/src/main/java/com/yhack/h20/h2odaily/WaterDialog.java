package com.yhack.h20.h2odaily;

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

public class WaterDialog extends DialogFragment {

    // global members to use in both onStart and onCreate
    private AlertDialog dialog;
//    private Button submitButton;

    // public memebers to pass to host
    public Integer checkcups() { return cups; }
    public Integer cups = 0;


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
        final View dialog_view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_water, null);
        // build dialog
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

        dialog = alertDialogBuilder.show();
        // set basic view for alertDialog
        alertDialogBuilder.setView(dialog_view)
                .setTitle("Water Consumption")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d("WATER DIALOG", "positive clicked");
                        SplashActivity.editor.putInt("cupsConsumed", cups);
                        SplashActivity.editor.commit();

                        //mListener.onDialogPositiveClick(WaterDialog.this);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d("WATER DIALOG", "negative clicked");
                        dialog.dismiss();
                    }
                });

        final EditText water_consumed = dialog_view.findViewById(R.id.water_consumed);
        String cupsString =water_consumed.getText().toString();
        if (cupsString != null && !cupsString.isEmpty()) {
            cups = Integer.parseInt(cupsString);
        }


//        /* checks if password or user is valid
//         * and adjust "matched/unmatched" accordingly
//         * enable positive button only when matched*/
//        final EditText water_consumed = dialog_view.findViewById(R.id.water_consumed);
//
//        pass_re.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
//
//            // update hint and enable submit button after password confirm text changed
//            @Override
//            public void afterTextChanged(Editable editable) {
//                // original password
//                final EditText password_origin = getActivity().findViewById(R.id.passwrd);
//                String password_origin_s = password_origin.getText().toString();
//                // password retyped
//                String pass_re_s = pass_re.getText().toString();
//                // checkView to show if it is available
//                final TextView pass_check = dialog_view.findViewById(R.id.Match);
//
//                // check if password retyped match the original password
//                // and update checkView and save button
//                if (password_origin_s.equals(pass_re_s)) {
//                    Log.d("DIALOG", "Password Matches");
//                    pass_check.setText(R.string.pass_match);
//                    ifMatch = true;
//                    if(submitButton!=null){
//                        submitButton.setEnabled(true);
//                    }
//                } else {
//                    pass_check.setText(R.string.pass_unmatch);
//                    ifMatch = false;
//                    if(submitButton!=null){
//                        submitButton.setEnabled(false);
//                    }
//                }
//            }
//        });

        dialog = alertDialogBuilder.create();
        return dialog;
    }

    // disable save button at the beginning
    @Override
    public void onStart(){
        super.onStart();
//        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
//        submitButton = (Button) dialog.getButton(AlertDialog.BUTTON_POSITIVE);
    }

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//
//        Activity activity;
//
//        if (context instanceof Activity){
//            activity= (Activity) context;
//            try {
//                // Instantiate the NoticeDialogListener so we can send events to the host
//                //mListener = (DialogListener) activity;
//            } catch (ClassCastException e) {
//                // The activity doesn't implement the interface, throw exception
//                throw new ClassCastException(activity.toString()
//                        + " must implement WaterDialog");
//            }
//            Log.d("DIALOG", "attached");
//        }
//
//    }
}