package com.example.countrycatalog.model.country;

import com.google.gson.annotations.SerializedName;

public class Requests{

	@SerializedName("available")
	private int available;

	@SerializedName("resets")
	private String resets;

	@SerializedName("used")
	private int used;

	public void setAvailable(int available){
		this.available = available;
	}

	public int getAvailable(){
		return available;
	}

	public void setResets(String resets){
		this.resets = resets;
	}

	public String getResets(){
		return resets;
	}

	public void setUsed(int used){
		this.used = used;
	}

	public int getUsed(){
		return used;
	}

	@Override
 	public String toString(){
		return 
			"Requests{" + 
			"available = '" + available + '\'' + 
			",resets = '" + resets + '\'' + 
			",used = '" + used + '\'' + 
			"}";
		}
}