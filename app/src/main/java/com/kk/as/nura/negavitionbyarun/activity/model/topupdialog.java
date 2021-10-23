package com.kk.as.nura.negavitionbyarun.activity.model;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.kk.as.nura.negavitionbyarun.R;

import static android.content.Context.MODE_PRIVATE;


/**
 * Created by Chan Myae Thu on 8/2/2017.
 */

public class topupdialog extends DialogFragment implements View.OnClickListener {
    private Button buttoncancel,buttontopup;
    private int id;
    private TextInputEditText edittexttopup;
    private String str;
    private int topup1,topup2,topup3;
    private String balance;
    private onCompleteListener mListener;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.dialogfortopup,container,false);
        buttoncancel= (Button) v.findViewById(R.id.buttoncancel);
        edittexttopup= (TextInputEditText) v.findViewById(R.id.edittexttopup);
        buttontopup=(Button) v.findViewById(R.id.buttontopup);
        buttoncancel.setOnClickListener(this);
        buttontopup.setOnClickListener(this);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        topup1=12345678;
        topup2=12345679;
        topup3=12345680;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mListener= (onCompleteListener) activity;
    }

    @Override
    public void onClick(View view) {
        id = view.getId();
        if (id == R.id.buttoncancel) {
            dismiss();
        }
        else if(id==R.id.buttontopup){
            Log.i("arun","button is working");
            str = edittexttopup.getText().toString();
            if(str!=null){
                Log.i("arun","str is not empty");
                int temp = Integer.parseInt(str.trim());
                if (temp == topup1 || temp == topup2 || temp == topup3) {
                    balance =String.valueOf("5000");
                    this.mListener.onComplete(balance);
                    edittexttopup.clearComposingText();
                    dismiss();
                } else {
                    Toast.makeText(view.getContext(), "Enter correct pin", Toast.LENGTH_SHORT).show();
                    Log.d("arun","etbre ocere");
                }
            }
            else if(str==null){
                Log.i("arun","str is empty");
                Toast.makeText(view.getContext(),"pin must not be empty", Toast.LENGTH_SHORT).show();
            }
            else{
                Log.i("arun","wtf else if working");
            }

        }
    }
public static interface onCompleteListener{
    public abstract void onComplete(String balance);
}

}

