package com.example.countrycatalog.service;

import com.example.countrycatalog.model.country.CountryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryRepository {
    @GET("countries?pretty&key=7546e31d-faa8-4a6f-9360-db3d574606a8")
    Call<CountryResponse> getCountry();
}
