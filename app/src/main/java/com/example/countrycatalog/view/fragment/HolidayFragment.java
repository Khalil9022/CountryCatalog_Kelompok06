package com.example.countrycatalog.view.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
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

import com.example.countrycatalog.R;
import com.example.countrycatalog.adapter.CountryAdapter;
import com.example.countrycatalog.adapter.HolidayAdapter;
import com.example.countrycatalog.model.country.CountriesItem;
import com.example.countrycatalog.model.holiday.HolidaysItem;
import com.example.countrycatalog.view.activity.ProfileActivity;
import com.example.countrycatalog.view.viewmodel.CountryViewModel;
import com.example.countrycatalog.view.viewmodel.HolidayViewModel;

import java.util.ArrayList;


public class HolidayFragment extends Fragment implements View.OnClickListener {

    private HolidayAdapter holidayAdapter;
    private RecyclerView rvHoliday;
    private HolidayViewModel holidayViewModel;

    ImageView ivProfile;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivProfile = view.findViewById(R.id.fragmentholiday_iv_profile);
        ivProfile.setOnClickListener(this);

        holidayAdapter = new HolidayAdapter(getContext());
        holidayAdapter.notifyDataSetChanged();

        rvHoliday = view.findViewById(R.id.holiday_rv_main);
        rvHoliday.setLayoutManager(new LinearLayoutManager(getContext()));

        holidayViewModel = new ViewModelProvider(this).get(HolidayViewModel.class);
        holidayViewModel.setHolidayDiscover();
        holidayViewModel.getHolidayDiscover().observe(this ,getHolidayDiscover);

        rvHoliday.setAdapter(holidayAdapter);
    }

    private Observer<ArrayList<HolidaysItem>> getHolidayDiscover = new Observer<ArrayList<HolidaysItem>>() {
        @Override
        public void onChanged(ArrayList<HolidaysItem> holidaysItems) {
            if(holidaysItems != null){
                holidayAdapter.setData(holidaysItems);
            }
        }
    };

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.fragmentholiday_iv_profile:
                intent = new Intent(getContext(), ProfileActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_holiday, container, false);
    }


}