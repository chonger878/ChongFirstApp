package com.example.chongfirstapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity<TabLayout> extends AppCompatActivity implements View.OnClickListener {

    private EditText getName;
    private EditText getAge;
    private EditText getDescription;
    private EditText getOccupation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout

        Button submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(this);

        getName = findViewById(R.id.nameEditText);
        getAge = findViewById(R.id.age);
        getDescription= findViewById(R.id.description);
        getOccupation= findViewById(R.id.occupation);

    }

    private void setupViewPager(ViewPager viewPager)
    {
        Adapter adapter = new Adapter(getSupportFragmentManager());
            adapter.addFragment(new ProfileFragment(), "Profile");
            adapter.addFragment(new SettingsFragment(), "Settings");
            adapter.addFragment(new MatchesFragment(), "Matches");
            viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter{
        public final List<Fragment> mFragmentList= new ArrayList<>();
        public final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 0;
        }

        public void addFragment(Fragment fragment, String title)
        {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
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

