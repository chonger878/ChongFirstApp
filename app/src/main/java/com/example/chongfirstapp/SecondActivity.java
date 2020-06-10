package com.example.chongfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity{

    public TextView getName;
    public TextView getAge;
    public TextView getOccupation;
    public TextView getDescription;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Second", "In Second Activity");
        setContentView(R.layout.second_activitya3);


        Intent intent = getIntent();
        Bundle db = intent.getExtras();



        getName = findViewById(R.id.name);
        getAge = findViewById(R.id.age);
        getOccupation = findViewById(R.id.occupation);
       getDescription = findViewById(R.id.description);

        if(db != null) {
            getName.setText(db.getString(Constants.KEY_NAME));
            getAge.setText(db.getString(Constants.KEY_AGE));
            getOccupation.setText(db.getString(Constants.KEY_OCCUPATION));
            getDescription.setText(db.getString(Constants.KEY_DESC));
        }

        ProfileFragment showProfile = new ProfileFragment();
        showProfile.setArguments(db);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ViewPager viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("Profile"));
        tabs.addTab(tabs.newTab().setText("Matches"));
        tabs.addTab(tabs.newTab().setText("Settings"));
        tabs.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager)
    {
        SecondActivity.Adapter adapter = new SecondActivity.Adapter(getSupportFragmentManager());
        adapter.addFragment(new ProfileFragment(),"Profile");
        adapter.addFragment(new MatchesFragment(),"Matches");
        adapter.addFragment(new SettingsFragment(),"Settings");
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState.containsKey(Constants.KEY_NAME)){
            getName.setText((String)savedInstanceState.get(Constants.KEY_NAME));
            getAge.setText((String)savedInstanceState.get(Constants.KEY_AGE));
            getOccupation.setText((String)savedInstanceState.get(Constants.KEY_OCCUPATION));
            getDescription.setText((String)savedInstanceState.get(Constants.KEY_DESC));
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Constants.KEY_NAME, getName.getText().toString());
        outState.putString(Constants.KEY_AGE, getAge.getText().toString());
        outState.putString(Constants.KEY_OCCUPATION, getOccupation.getText().toString());
        outState.putString(Constants.KEY_DESC, getDescription.getText().toString());

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


}





