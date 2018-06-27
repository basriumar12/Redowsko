package com.android.redowsko.model.report;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Detail{

	@SerializedName("date")
	private String date;

	@SerializedName("image")
	private List<ImageItem> image;

	@SerializedName("work_material")
	private String workMaterial;

	@SerializedName("time")
	private String time;

	@SerializedName("worker")
	private String worker;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setImage(List<ImageItem> image){
		this.image = image;
	}

	public List<ImageItem> getImage(){
		return image;
	}

	public void setWorkMaterial(String workMaterial){
		this.workMaterial = workMaterial;
	}

	public String getWorkMaterial(){
		return workMaterial;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}

	public void setWorker(String worker){
		this.worker = worker;
	}

	public String getWorker(){
		return worker;
	}

	@Override
 	public String toString(){
		return 
			"Detail{" + 
			"date = '" + date + '\'' + 
			",image = '" + image + '\'' + 
			",work_material = '" + workMaterial + '\'' + 
			",time = '" + time + '\'' + 
			",worker = '" + worker + '\'' + 
			"}";
		}
}