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
        int byear = dob.get(Calendar.YEAR);
        int bmonth = dob.get(Calendar.MONTH);
        int bday = dob.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this, byear, bmonth, bday);
    }



    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
    {
        birthDate.setText((new StringBuilder().append(year).append("-").
                append(month+1).append("-").append(dayOfMonth)));
    }
}
