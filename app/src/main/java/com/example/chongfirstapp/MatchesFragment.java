package com.example.chongfirstapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MatchesFragment extends Fragment {
    private FusedLocationProviderClient fusedLocationClient;
    LocationManager locationManager;
    double latitudeOnGPS, longitudeOnGPS;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(getActivity());

        fusedLocationClient.getLastLocation()
                            .addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
                                @Override
                                public void onSuccess(Location location) {
                                    if(location != null){
                                            latitudeOnGPS = location.getLatitude();
                                            longitudeOnGPS= location.getLongitude();
                                    }
                                }
                            });

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

    private boolean checkLocation(){
        if(!isLocationEnabled())
            showAlert();
        return isLocationEnabled();
    }

    private void showAlert(){
        final AlertDialog.Builder getAlertDialog = new AlertDialog.Builder(getActivity());
        getAlertDialog.setTitle("Turn on Location")
                .setMessage("Your Location is turned off.  Please turn enable location")
                .setPositiveButton("Location Settings", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt){
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt){
                    }
                });
        getAlertDialog.show();
    }

    private boolean isLocationEnabled(){
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }
}
