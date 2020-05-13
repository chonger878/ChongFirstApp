package com.example.chongfirstapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText getName;
    private EditText getAge;
    private EditText getDescription;
    private EditText getOccupation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buildprofilea3_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabs =  findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("Profile"));
        tabs.addTab(tabs.newTab().setText("Matches"));
        tabs.addTab(tabs.newTab().setText("Settings"));


        Button submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(this);

        getName = findViewById(R.id.nameEditText);
        getAge = findViewById(R.id.age);
        getDescription= findViewById(R.id.description);
        getOccupation= findViewById(R.id.occupation);


        ViewPager viewPager = findViewById(R.id.viewpager);
            setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);



    }
    

    private void setupViewPager(ViewPager viewPager)
    {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new ProfileFragment(),"Profile");
        adapter.addFragment(new MatchesFragment(),"Matches");
        adapter.addFragment(new SettingsFragment(),"Settings");
        viewPager.setAdapter(adapter);
    }





    static class Adapter extends FragmentPagerAdapter{
            private final List<Fragment> mFragmentList = new ArrayList<>();
            private final List<String> mFragmentTitleList = new ArrayList<>();
        public Adapter(FragmentManager manager)
        {
            super(manager);
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
        dataBundle.putString(Constants.KEY_NAME, getName.getText().toString());
        dataBundle.putString(Constants.KEY_AGE, getAge.getText().toString());
        dataBundle.putString(Constants.KEY_DESC, getDescription.getText().toString());
        dataBundle.putString(Constants.KEY_OCCUPATION, getOccupation.getText().toString());
        intent.putExtras(dataBundle);
        startActivity(intent);

    }


    @Override
    public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);

    }
}

