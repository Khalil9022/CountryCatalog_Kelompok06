package com.example.countrycatalog.model.holiday;

import com.google.gson.annotations.SerializedName;

public class Weekday{

	@SerializedName("date")
	private Date date;

	@SerializedName("observed")
	private Observed observed;

	public void setDate(Date date){
		this.date = date;
	}

	public Date getDate(){
		return date;
	}

	public void setObserved(Observed observed){
		this.observed = observed;
	}

	public Observed getObserved(){
		return observed;
	}

	@Override
 	public String toString(){
		return 
			"Weekday{" + 
			"date = '" + date + '\'' + 
			",observed = '" + observed + '\'' + 
			"}";
		}
}