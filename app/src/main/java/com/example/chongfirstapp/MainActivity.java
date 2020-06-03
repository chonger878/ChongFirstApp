package com.example.chongfirstapp;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String TAG= null;
    private EditText Name;
    private EditText UserName;
    private EditText Email;
    private TextView birthDate;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        final SettingListAdapter adapter = new SettingListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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
        birthDate = findViewById(R.id.getDate);

        FirebaseFirestore getMatchesDB = FirebaseFirestore.getInstance();

        getMatchesDB.collection("matches").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(QueryDocumentSnapshot document: task.getResult()){
                        Log.d(TAG, document.getId()+ " => " + document.getData());
                    }
                }else{
                    Log.d(TAG, "Error: ", task.getException());
                }
            }
        });

    }


    public void showBirthDateDialog(View v){
        DialogFragment newFragment = new DateDialog(birthDate);
        newFragment.show(getSupportFragmentManager(), "datePicker");
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
        dataBundle.putString(Constants.KEY_BIRTH_DATE, birthDate.getText().toString());
        intent.putExtras(dataBundle);
        SimpleDateFormat Formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Date getBirthDate = new Date();
        Date compareDate = new Date();
        try{
            getBirthDate = Formatter.parse(birthDate.getText().toString());
            compareDate = Formatter.parse(Constants.PROHIBIT_BEFORE_DATE);
        }catch(ParseException e){
            e.printStackTrace();
        }
        assert getBirthDate != null;
        if ( getBirthDate.before(compareDate)) {
            startActivity(intent);
        }
    }


}



