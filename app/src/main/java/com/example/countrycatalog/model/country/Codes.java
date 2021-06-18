package com.example.countrycatalog.model.country;

import com.google.gson.annotations.SerializedName;

public class Codes{

	@SerializedName("alpha-2")
	private String alpha2;

	@SerializedName("alpha-3")
	private String alpha3;

	@SerializedName("numeric")
	private String numeric;

	public void setAlpha2(String alpha2){
		this.alpha2 = alpha2;
	}

	public String getAlpha2(){
		return alpha2;
	}

	public void setAlpha3(String alpha3){
		this.alpha3 = alpha3;
	}

	public String getAlpha3(){
		return alpha3;
	}

	public void setNumeric(String numeric){
		this.numeric = numeric;
	}

	public String getNumeric(){
		return numeric;
	}

	@Override
 	public String toString(){
		return 
			"Codes{" + 
			"alpha-2 = '" + alpha2 + '\'' + 
			",alpha-3 = '" + alpha3 + '\'' + 
			",numeric = '" + numeric + '\'' + 
			"}";
		}
}