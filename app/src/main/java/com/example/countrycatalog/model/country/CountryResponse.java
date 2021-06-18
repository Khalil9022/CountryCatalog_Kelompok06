package com.example.countrycatalog.model.country;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CountryResponse{

	@SerializedName("requests")
	private Requests requests;

	@SerializedName("countries")
	private ArrayList<CountriesItem> countries;

	@SerializedName("status")
	private int status;

	public void setRequests(Requests requests){
		this.requests = requests;
	}

	public Requests getRequests(){
		return requests;
	}

	public void setCountries(ArrayList<CountriesItem> countries){
		this.countries = countries;
	}

	public ArrayList<CountriesItem> getCountries(){
		return countries;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"CountryResponse{" + 
			"requests = '" + requests + '\'' + 
			",countries = '" + countries + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}