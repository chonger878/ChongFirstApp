package com.example.chongfirstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MatchesFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view,
                                    container, false);

        ContentAdapter adapter = new ContentAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView profilePic;
        public TextView profileInfo;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.matches_view,parent,false));
            profilePic = itemView.findViewById(R.id.profilePic);
            profileInfo = itemView.findViewById((R.id.info_here));
            final ImageButton likePic = itemView.findViewById(R.id.like_button);
            likePic.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(), "You Liked", Toast.LENGTH_LONG).show();
        }
    }

    public class ContentAdapter extends RecyclerView.Adapter<ViewHolder>{

        private int LENGTH = 18;

        public ContentAdapter(){

        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position)
        {

        }

        public int getItemCount(){
            return LENGTH;
        }


    }
}
