package com.example.countrycatalog.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.countrycatalog.model.country.CountriesItem;
import com.example.countrycatalog.model.holiday.HolidayResponse;
import com.example.countrycatalog.model.holiday.HolidaysItem;
import com.example.countrycatalog.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HolidayViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<HolidaysItem>> listHoliday = new MutableLiveData<>();

    public void setHolidayDiscover (){
        if(this.apiMain==null){
            apiMain = new ApiMain();
        }

        apiMain.getApiHoliday().getHoliday().enqueue(new Callback<HolidayResponse>() {
            @Override
            public void onResponse(Call<HolidayResponse> call, Response<HolidayResponse> response) {
                HolidayResponse holidayResponse = response.body();
                if(holidayResponse != null && holidayResponse.getHolidays() != null){
                    ArrayList<HolidaysItem> holidayItem = holidayResponse.getHolidays();
                    listHoliday.postValue(holidayItem);
                }
            }

            @Override
            public void onFailure(Call<HolidayResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<HolidaysItem>> getHolidayDiscover(){
        return listHoliday;
    }
}
