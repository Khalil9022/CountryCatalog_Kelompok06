package com.example.countrycatalog.model.country;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SubdivisionsItem{

	@SerializedName("code")
	private String code;

	@SerializedName("languages")
	private List<String> languages;

	@SerializedName("name")
	private String name;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setLanguages(List<String> languages){
		this.languages = languages;
	}

	public List<String> getLanguages(){
		return languages;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"SubdivisionsItem{" + 
			"code = '" + code + '\'' + 
			",languages = '" + languages + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}