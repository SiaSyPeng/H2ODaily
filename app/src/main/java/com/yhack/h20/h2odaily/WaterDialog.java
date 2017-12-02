package com.yhack.h20.h2odaily;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;
import android.view.LayoutInflater;
import android.app.Activity;

/**
 * Created by sosa on 12/2/17.
 */

public class WaterDialog extends android.support.v4.app.DialogFragment implements DialogInterface, Bundle {

    public String inputvalue;

    LayoutInflater inflater = LayoutInflater.from(this);
    final View textenter = inflater.inflate(R.layout.dialog_add, null)
    final EditText userinput = (EditText) textenter.findViewById(R.id.item_added);
    final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("How much water did you drink?")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            inputvalue =  userinput.getText().toString();

                            // This is where we should update the amount of water drank

                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            if (dialog != null && dialog.isShowing()) {
                                dialog.dismiss();
                            }// User cancelled the dialog
                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }

}
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:orientation="vertical"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">

<EditText
       android:id="@+id/item_added"
               android:inputType="text"
               android:layout_width="match_parent"
               android:layout_height="wrap_content"
               android:layout_marginTop="16dp"
               android:layout_marginLeft="4dp"
               android:layout_marginRight="4dp"
               android:layout_marginBottom="4dp"
               android:hint="@string/hint_add_item" />

</LinearLayout>
