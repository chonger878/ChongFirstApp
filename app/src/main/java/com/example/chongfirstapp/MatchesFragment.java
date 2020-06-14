package com.example.chongfirstapp;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MatchesFragment extends Fragment {

    public MatchesFragment(){
        //STUB
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                        R.layout.recycler_view, container, false);

        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView profilePic;
        public TextView profileName;
        public TextView profileInfo;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.item_card,parent,false));
            profilePic = itemView.findViewById(R.id.profilePic);
            profileName = itemView.findViewById(R.id.card_title);
            profileInfo = itemView.findViewById((R.id.info_here));
            final ImageButton likePic = itemView.findViewById(R.id.like_button);
            likePic.setOnClickListener(v -> Toast.makeText(profileName.getContext(),
                    "You Liked " + profileName.getText(),Toast.LENGTH_SHORT).show());



        }
    }

    public class ContentAdapter extends RecyclerView.Adapter<ViewHolder>{

        private static final int LENGTH = 6;
        private  String[] name;
        private String[] image;
        private final String[] mDesc;
        private final Drawable[] mPics;
        private FirebaseMatchViewModel matchVM;
        ArrayList<MatchItem> matchItems = new ArrayList<>();

        public ContentAdapter(Context context){
            matchVM = new FirebaseMatchViewModel();
            matchVM.getMatches((match) -> {
                matchItems = match;
                name = new String[matchItems.size()];
                image = new String[matchItems.size()];
                for(int i = 0; i < matchItems.size(); i++){
                    name[i] = matchItems.get(i).getMatchesName();
                    image[i] = matchItems.get(i).getImageUrl();
                }
                notifyDataSetChanged();
            });
            Resources resources = context.getResources();
            //mMatches = resources.getStringArray(R.array.matches);
            mDesc = resources.getStringArray(R.array.matchDesc);
            TypedArray picProfile = resources.obtainTypedArray(R.array.matches_pic);
            mPics = new Drawable[picProfile.length()];
            for(int i =0; i < mPics.length; i++){
                mPics[i] = picProfile.getDrawable(i);
            }
            picProfile.recycle();



        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position)
        {
            Picasso.get().load(image[position % image.length]).into(holder.profilePic);
            holder.profileName.setText(name[position % name.length]);
            //holder.profileInfo.setText(mDesc[position % mDesc.length]);
        }

        public int getItemCount(){
            return matchItems.size();
        }


    }

















}
