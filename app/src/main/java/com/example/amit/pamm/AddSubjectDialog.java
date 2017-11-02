package com.example.amit.pamm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by AMIT on 29-Jan-17.
 */

public class AddSubjectDialog extends DialogFragment {

    EditText subjectText;
    Communicator communicator;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v=getActivity().getLayoutInflater().inflate(R.layout.subject_dialog_layout,null);
        subjectText= (EditText) v.findViewById(R.id.input_subjectName_editText);
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.Enter_subject)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        communicator.respond(subjectText.getText().toString());


                    }
                })
                .create();

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        communicator= (Communicator) getActivity();


    }
}