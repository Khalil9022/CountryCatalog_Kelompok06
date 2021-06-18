package com.example.countrycatalog.model.country;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CountriesItem{

	@SerializedName("codes")
	private Codes codes;

	@SerializedName("code")
	private String code;

	@SerializedName("flag")
	private String flag;

	@SerializedName("languages")
	private ArrayList<String> languages;

	@SerializedName("name")
	private String name;

	@SerializedName("subdivisions")
	private ArrayList<SubdivisionsItem> subdivisions;

	public void setCodes(Codes codes){
		this.codes = codes;
	}

	public Codes getCodes(){
		return codes;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setFlag(String flag){
		this.flag = flag;
	}

	public String getFlag(){
		return flag;
	}

	public void setLanguages(ArrayList<String> languages){
		this.languages = languages;
	}

	public ArrayList<String> getLanguages(){
		return languages;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSubdivisions(ArrayList<SubdivisionsItem> subdivisions){
		this.subdivisions = subdivisions;
	}

	public ArrayList<SubdivisionsItem> getSubdivisions(){
		return subdivisions;
	}

	@Override
 	public String toString(){
		return 
			"CountriesItem{" + 
			"codes = '" + codes + '\'' + 
			",code = '" + code + '\'' + 
			",flag = '" + flag + '\'' + 
			",languages = '" + languages + '\'' + 
			",name = '" + name + '\'' + 
			",subdivisions = '" + subdivisions + '\'' + 
			"}";
		}
}