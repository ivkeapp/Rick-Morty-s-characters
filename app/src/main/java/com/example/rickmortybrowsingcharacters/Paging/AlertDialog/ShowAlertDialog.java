package com.example.rickmortybrowsingcharacters.Paging.AlertDialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.rickmortybrowsingcharacters.Models.Result;
import com.example.rickmortybrowsingcharacters.R;

public class ShowAlertDialog {

    public ShowAlertDialog() {
    }

    public void showInfoDialog(Context mContext, Result result){
        LayoutInflater inflater = LayoutInflater.from(mContext);
        final android.app.AlertDialog.Builder mBuilder = new android.app.AlertDialog.Builder(mContext);
        View mView = inflater.inflate(R.layout.alert_dialog_character_details,null);
        mBuilder.setView(mView);
        setInfoText(result, mView);
        final android.app.AlertDialog dialog = mBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
        Button closeDialogBtn = mView.findViewById(R.id.close_btn);
        closeDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.hide();
            }
        });
    }

    private void setInfoText(Result result, View view){
        TextView status, specie, type, gender, headl;
        status = view.findViewById(R.id.character_status);
        specie = view.findViewById(R.id.specie_response);
        type = view.findViewById(R.id.type_response);
        gender = view.findViewById(R.id.gender_response);
        headl = view.findViewById(R.id.character_name);
        status.setText(result.getStatus());
        specie.setText(result.getSpecies());
        type.setText(result.getType());
        gender.setText(result.getGender());
        headl.setText(result.getName());
    }

}