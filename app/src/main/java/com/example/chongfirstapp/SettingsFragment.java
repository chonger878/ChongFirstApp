package com.example.chongfirstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.w3c.dom.Text;

import java.util.List;

public class SettingsFragment extends Fragment {

    private SettingsViewModel settingsViewModel;
    private TextView getReminderTime;
    private TextView getMaxDistanceSearch;
    private TextView getGender;
    private TextView getAcctType;
    private TextView getAgeRange;
    private String getEmail;
    private Button updateAcctBtn;
    Bundle getMain;

    public SettingsFragment(){
        //STUB
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){


        View view= inflater.inflate(R.layout.settings_view,
                container, false);

        getReminderTime =  view.findViewById(R.id.daily_matches_reminder_time);
        getMaxDistanceSearch = view.findViewById(R.id.maximum_distance_search);
        getGender = view.findViewById(R.id.gender);
        getAcctType = view.findViewById(R.id.account_type);
        getAgeRange = view.findViewById(R.id.interested_age_range);

        settingsViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);

        final Observer<List<Settings>> getSettingsObserver = newSettings -> {
            if(newSettings == null || newSettings.size() <= 0){
                return;
            }
            Settings settings = newSettings.get(0);
            if(newSettings == null){
                return;
            }

            getReminderTime.setText(settings.getDailyMatchesReminderTime());
            getMaxDistanceSearch.setText(settings.getMaximumDistanceResearch());
            getGender.setText(settings.getGender());
            getAcctType.setText(settings.getAccountType());
            getAgeRange.setText(settings.getInterestedAgeRange());
        };


        getMain = getArguments();
        if(getMain != null){

            if(getMain.containsKey(Constants.KEY_EMAIL)){
                getEmail = getMain.getString(Constants.KEY_EMAIL);
            }
        }

        String[] getSettingIds = {getEmail};
        settingsViewModel.loadByAllIds(this.getContext(), getSettingIds);
        updateAcctBtn = view.findViewById(R.id.updateBtn);
        updateAcctBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getEmail != null){
                    updateDatabase(v);
                }
            }
        });

        return view;
    }

    public void updateDatabase(View v){
        String getEmail = getMain.getString(Constants.KEY_EMAIL);
        Settings newSettings = new Settings();

        if(getEmail != null){
            newSettings.setSettingId(getEmail);
            newSettings.setDailyMatchesReminderTime(getReminderTime.toString());
            newSettings.setMaximumDistanceResearch(getMaxDistanceSearch.toString());
            newSettings.setGender(getGender.toString());
            newSettings.setAccountType(getAcctType.toString());
            newSettings.setInterestedAgeRange(getAgeRange.toString());

            settingsViewModel.insertAll(v.getContext(), newSettings);

            getReminderTime.setText(newSettings.getDailyMatchesReminderTime());
            getMaxDistanceSearch.setText(newSettings.getMaximumDistanceResearch());
            getGender.setText(newSettings.getGender());
            getAcctType.setText(newSettings.getAccountType());
            getAgeRange.setText(newSettings.getInterestedAgeRange());
        }
    }



}
