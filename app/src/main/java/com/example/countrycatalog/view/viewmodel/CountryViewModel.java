package com.example.countrycatalog.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.countrycatalog.model.country.CountriesItem;
import com.example.countrycatalog.model.country.CountryResponse;
import com.example.countrycatalog.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<CountriesItem>> listCountry = new MutableLiveData<>();

    public void setCountryDiscover() {
        if(this.apiMain==null){
            apiMain = new ApiMain();
        }

        apiMain.getApiCountry().getCountry().enqueue(new Callback<CountryResponse>() {
            @Override
            public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response) {
                CountryResponse responseDiscover = response.body();
                if(responseDiscover != null && responseDiscover.getCountries() != null){
                    ArrayList<CountriesItem> countriesItems = responseDiscover.getCountries();
                    listCountry.postValue(countriesItems);
                }
            }

            @Override
            public void onFailure(Call<CountryResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<CountriesItem>> getCountryDiscover(){
        return listCountry;
    }
}
