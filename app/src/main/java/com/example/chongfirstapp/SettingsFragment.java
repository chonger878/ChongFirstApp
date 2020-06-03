package com.example.chongfirstapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class SettingsFragment extends Fragment {
    private List<Settings> sItemList;
    private SettingListAdapter sDB;
    private SettingsViewModel sViewModel;

    public void setSettingsList(List<Settings> getSettingsList){
        if(sItemList == null){
            sItemList = new ArrayList<>();
        }
        sItemList.clear();
        sItemList.addAll(getSettingsList);

        if(sDB != null){
            sDB.setSettingItem(getSettingsList);
        }

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){


        View view=  inflater.inflate(R.layout.settings_view,
                container, false);

        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        if(sItemList != null){
            sDB.setSettingItem(sItemList);
        }
        recyclerView.setAdapter(sDB);
        return view;
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        sViewModel= new ViewModelProvider(this).get(SettingsViewModel.class);
        sViewModel.getAllSettings().observe(getViewLifecycleOwner(), new Observer<List<Settings>>() {
            @Override
            public void onChanged(List<Settings> settings) {
                if(settings != null){
                    setSettingsList(settings);
                }
            }
        });
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.settings_view,parent,false));
        }
    }
    public static class ContentAdapter extends RecyclerView.Adapter<SettingsFragment.ViewHolder> {

        private static int LENGTH = 18;

        public ContentAdapter() {

        }

        @Override
        public SettingsFragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SettingsFragment.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(SettingsFragment.ViewHolder holder, int position) {

        }

        public int getItemCount() {
            return LENGTH;
        }
    }

}
