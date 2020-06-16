package com.example.chongfirstapp;


import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import android.provider.Settings;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MatchesFragment extends Fragment {

    LocationManager locationManager;
    Double latitudeNetwork, longitudeNetwork;



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
        private  MatchItem[] name;
        //private String[] image;
        //private final String[] mDesc;
       // private final Drawable[] mPics;
        private FirebaseMatchViewModel matchVM;
        ArrayList<MatchItem> matchItems = new ArrayList<>();

        public ContentAdapter(Context context){

            locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);

            toggleNetworkUpdates();

            //Resources resources = context.getResources();
            //mMatches = resources.getStringArray(R.array.matches);
            //mDesc = resources.getStringArray(R.array.matchDesc);
            //TypedArray picProfile = resources.obtainTypedArray(R.array.matches_pic);
            //mPics = new Drawable[picProfile.length()];
            //for(int i =0; i < mPics.length; i++){
               // mPics[i] = picProfile.getDrawable(i);
           // }
            //picProfile.recycle();



        }

        private Boolean checkLocation(){
            if(!isLocationEnabled()){
                showAlert();
            }

            return isLocationEnabled();
        }

        private Boolean isLocationEnabled(){
                return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        }

        private void showAlert(){
            final AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
            dialog.setTitle(R.string.enable_location)
                    .setMessage(getString(R.string.location_message))
                    .setPositiveButton(R.string.location_settings, (paramDialogInterface, paramInt) ->
                    {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    })
                        .setNegativeButton(R.string.location_cancel, (paramDialogInterface, paramInt) ->
            {});
        }

        public void toggleNetworkUpdates(){
            if(!checkLocation()){
                return;
            }
            if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION ) == PackageManager.PERMISSION_GRANTED){
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60*1000, 10, mLocationListenerNetwork);
            }
        }
        private final LocationListener mLocationListenerNetwork = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                latitudeNetwork = location.getLatitude();
                longitudeNetwork = location.getLongitude();

                matchVM = new FirebaseMatchViewModel();
                matchVM.getMatches((ArrayList<MatchItem> matchItems) ->{
                    ArrayList<MatchItem> getNearestMatches = new ArrayList<>();
                    for(int i = 0; i < matchItems.size(); i++) {
                        double xSq = Math.pow(Double.parseDouble(matchItems.get(i).getLat()) - latitudeNetwork, 2);
                        double ySq = Math.pow(Double.parseDouble(matchItems.get(i).getLongitude()) - longitudeNetwork, 2);
                        double difference = Math.sqrt(xSq + ySq);
                        if (difference < 10) {
                            getNearestMatches.add(matchItems.get(i));
                        }
                    }
                        name = new MatchItem[getNearestMatches.size()];
                        //image = new String[matchItems.size()];
                        for(int i = 0; i < matchItems.size(); i++){
                            name[i] = getNearestMatches.get(i);
                            //image[i] = matchItems.get(i).getImageUrl();
                        }
                        notifyDataSetChanged();
                    }
                );

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position)
        {
            Picasso.get().load(name[position % name.length].getImageUrl()).into(holder.profilePic);
            holder.profileName.setText(name[position % name.length].getMatchesName());
            //holder.profileInfo.setText(mDesc[position % mDesc.length]);
        }

        public int getItemCount(){
            return matchItems.size();
        }


    }

















}
