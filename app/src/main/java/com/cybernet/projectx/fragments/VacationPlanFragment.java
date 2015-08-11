package com.cybernet.projectx.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cybernet.projectx.R;
import com.cybernet.projectx.adapters.QuestionsListAdapter;
import com.cybernet.projectx.adapters.SpotsListAdapter;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;

public class VacationPlanFragment extends Fragment {
    private MapView mapView;
    //private GoogleMap map;

    private RecyclerView questionsList;
    private RecyclerView.Adapter questionsAdapter;
    private RecyclerView.LayoutManager questionsListLayoutManager;

    public static VacationPlanFragment newInstance() {
        VacationPlanFragment fragment = new VacationPlanFragment();
        return fragment;
    }

    public VacationPlanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_vacation_plan, container, false);

        // Gets the MapView from the XML layout and creates it
        mapView = (MapView) v.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);

        // Gets to GoogleMap from the MapView and does initialization stuff
        //map = mapView.getMap();
        // map.getUiSettings().setMyLocationButtonEnabled(false);
        //map.setMyLocationEnabled(true);


        MapsInitializer.initialize(this.getActivity());


        // Updates the location and zoom of the MapView
        //CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(37.7833, -122.4167), 10);
        //map.animateCamera(cameraUpdate);

        questionsList = (RecyclerView) v.findViewById(R.id.questions_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        questionsList.setHasFixedSize(true);

        // use a linear layout manager
        questionsListLayoutManager = new LinearLayoutManager(this.getActivity());
        questionsList.setLayoutManager(questionsListLayoutManager);

        // specify an adapter (see also next example)
        questionsAdapter = new SpotsListAdapter(new String[30]);
        questionsList.setAdapter(questionsAdapter);

        return v;
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
