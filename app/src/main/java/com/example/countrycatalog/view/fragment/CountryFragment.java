package com.example.countrycatalog.view.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.countrycatalog.R;
import com.example.countrycatalog.adapter.CountryAdapter;
import com.example.countrycatalog.model.country.CountriesItem;
import com.example.countrycatalog.view.activity.ProfileActivity;
import com.example.countrycatalog.view.viewmodel.CountryViewModel;

import java.util.ArrayList;
import java.util.Objects;


public class CountryFragment extends Fragment implements View.OnClickListener {

    private CountryAdapter countryAdapter;
    private RecyclerView rvCountry;
    private CountryViewModel countryViewModel;

    ImageView ivProfile;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivProfile = view.findViewById(R.id.fragmentcountry_iv_profile);
        ivProfile.setOnClickListener(this);

        countryAdapter = new CountryAdapter(getContext());
        countryAdapter.notifyDataSetChanged();

        rvCountry = view.findViewById(R.id.rv_main);
        rvCountry.setLayoutManager(new LinearLayoutManager(getContext()));

        countryViewModel = new ViewModelProvider(this).get(CountryViewModel.class);
        countryViewModel.setCountryDiscover();
        countryViewModel.getCountryDiscover().observe(this ,getCountryDiscover);

        rvCountry.setAdapter(countryAdapter);
    }

    private Observer<ArrayList<CountriesItem>> getCountryDiscover = new Observer<ArrayList<CountriesItem>>() {
        @Override
        public void onChanged(ArrayList<CountriesItem> countriesItems) {
            if(countriesItems != null){
                countryAdapter.setData(countriesItems);
            }
        }
    };

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.fragmentcountry_iv_profile:
                intent = new Intent(getContext(), ProfileActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country, container, false);
    }


}