package com.example.chongfirstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class SettingsFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view,
                container, false);

        SettingsFragment.ContentAdapter adapter = new SettingsFragment.ContentAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        return recyclerView;
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
