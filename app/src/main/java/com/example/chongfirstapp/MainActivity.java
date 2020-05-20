package com.example.chongfirstapp;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText Name;
    private EditText UserName;
    private EditText Email;
    private EditText txtDate;
    private int byear,bmonth, bday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ViewPager viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        TabLayout tabs =  findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("Profile"));
        tabs.addTab(tabs.newTab().setText("Matches"));
        tabs.addTab(tabs.newTab().setText("Settings"));
        tabs.setupWithViewPager(viewPager);

        Name = findViewById(R.id.nameEditText);
        UserName = findViewById(R.id.usernameEditText);
        Email= findViewById(R.id.emailEditText);
        txtDate = findViewById(R.id.getDate);
        final Button getDate = findViewById(R.id.pickbirthdate);
        getDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar dob = Calendar.getInstance();
                byear = dob.get(Calendar.YEAR);
                bmonth =  dob.get(Calendar.MONTH);
                bday = dob.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog getDateDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            txtDate.setText(year + "-" + month+1 + "-" +dayOfMonth);
                    }
                }, byear, bmonth,bday);
                getDateDialog.show();
            }
        });
        Button submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(this);


    }

    private void setupViewPager(ViewPager viewPager)
    {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new ProfileFragment(),"Profile");
        adapter.addFragment(new MatchesFragment(),"Matches");
        adapter.addFragment(new SettingsFragment(),"Settings");
        viewPager.setAdapter(adapter);
    }



    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();


        public Adapter(FragmentManager manager)
        {
            super(manager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        }
        @Override
        public Fragment getItem(int position){
            return mFragmentList.get(position);
        }

        @Override
        public int getCount(){
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String tabName){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(tabName);
        }
        @Override
        public CharSequence getPageTitle(int position){
            return mFragmentTitleList.get(position);
        }
    }
    

    public void getSecondActivity(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        Bundle dataBundle = new Bundle();
        dataBundle.putString(Constants.KEY_NAME, Name.getText().toString());
        dataBundle.putString(Constants.KEY_USERNAME, UserName.getText().toString());
        dataBundle.putString(Constants.KEY_EMAIL, Email.getText().toString());
        intent.putExtras(dataBundle);
        startActivity(intent);

    }

    public void onClick(View v) {
        String getDate = txtDate.getText().toString();
        if(getDate.compareTo(Constants.PROHIBIT_BEFORE_DATE) < 0) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    }

}

