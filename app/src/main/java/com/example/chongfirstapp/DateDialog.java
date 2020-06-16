package com.example.chongfirstapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    private TextView birthDate;

    public DateDialog(TextView birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        final Calendar dob = Calendar.getInstance();
        int bYear = dob.get(Calendar.YEAR);
        int bMonth = dob.get(Calendar.MONTH);
        int bDay = dob.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this, bYear, bMonth, bDay);
    }



    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
    {
       int correctMonth = month + 1;

        birthDate.setText((new StringBuilder().append(year).append("-").
                append(correctMonth).append("-").append(dayOfMonth)));
    }
}
