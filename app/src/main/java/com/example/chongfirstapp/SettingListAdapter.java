package com.example.chongfirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SettingListAdapter extends RecyclerView.Adapter<SettingListAdapter.SettingsViewHolder> {
    class SettingsViewHolder extends RecyclerView.ViewHolder{
        private final TextView settingsItemView;
        private SettingsViewHolder(View itemView){
            super(itemView);
            settingsItemView = itemView.findViewById(R.id.addItem);
        }
    }

    private final LayoutInflater sInflater;
    private List<Settings> sItem;

    SettingListAdapter(Context context){sInflater = LayoutInflater.from(context);}

    @Override
    public SettingsViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View sItemView = sInflater.inflate(R.layout.recyclerview_item,parent,false);
        return new SettingsViewHolder(sItemView);
    }

    @Override
    public void onBindViewHolder(SettingsViewHolder holder, int pos){
        if(sItem != null){
            Settings current = sItem.get(pos);
            holder.settingsItemView.setText(current.getWord());
        }else{
            holder.settingsItemView.setText("Null setting item");
        }
    }

    @Override
    public int getItemCount() {
        if(sItem != null)
            return sItem.size();
        else return 0;
    }

    void setSettingItem(List<Settings> setting){
        sItem = setting;
        notifyDataSetChanged();
    }






}
