package com.android.redowsko.model.report;

import com.google.gson.annotations.SerializedName;

public class ImageItem{

	@SerializedName("src")
	private String src;

	@SerializedName("id")
	private int id;

	public void setSrc(String src){
		this.src = src;
	}

	public String getSrc(){
		return src;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"ImageItem{" + 
			"src = '" + src + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}