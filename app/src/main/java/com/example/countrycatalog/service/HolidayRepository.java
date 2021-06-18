package com.example.countrycatalog.service;

import com.example.countrycatalog.model.holiday.HolidayResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HolidayRepository {

    @GET("holidays?pretty&key=7546e31d-faa8-4a6f-9360-db3d574606a8&country=ID&year=2020")
    Call<HolidayResponse> getHoliday();

}
