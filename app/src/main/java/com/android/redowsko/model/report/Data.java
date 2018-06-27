package com.android.redowsko.model.report;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("next_page")
	private boolean nextPage;

	@SerializedName("list")
	private List<ListItem> list;

	@SerializedName("current_page")
	private int currentPage;

	public void setNextPage(boolean nextPage){
		this.nextPage = nextPage;
	}

	public boolean isNextPage(){
		return nextPage;
	}

	public void setList(List<ListItem> list){
		this.list = list;
	}

	public List<ListItem> getList(){
		return list;
	}

	public void setCurrentPage(int currentPage){
		this.currentPage = currentPage;
	}

	public int getCurrentPage(){
		return currentPage;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"next_page = '" + nextPage + '\'' + 
			",list = '" + list + '\'' + 
			",current_page = '" + currentPage + '\'' + 
			"}";
		}
}