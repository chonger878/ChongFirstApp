package com.example.chongfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private TextView getName;
    private TextView getAge;
    private TextView getOccupation;
    private TextView getDescription;
    private Bundle bundle;

    public ProfileFragment(Bundle bundle){
        this.bundle = bundle;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){


        View getProfile =  inflater.inflate(R.layout.profiles_view,
                null);

        getName = getProfile.findViewById(R.id.name);
        getAge = getProfile.findViewById(R.id.age);
        getOccupation = getProfile.findViewById(R.id.occupation);
        getDescription = getProfile.findViewById(R.id.description);

        if(bundle != null) {
            getName.setText(this.bundle.getString((Constants.KEY_NAME)));
            getAge.setText(this.bundle.getString((Constants.KEY_AGE)));
            getOccupation.setText(this.bundle.getString((Constants.KEY_OCCUPATION)));
            getDescription.setText(this.bundle.getString((Constants.KEY_DESC)));
        }


        return getProfile;




    }

}
