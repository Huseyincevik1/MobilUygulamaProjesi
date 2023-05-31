package com.kubrahuseyinzehra.mobilproje.Models;

import java.util.List;

public class IlanlarimPojo{
	private List<IlanlarimPojoItem> ilanlarimPojo;

	public void setIlanlarimPojo(List<IlanlarimPojoItem> ilanlarimPojo){
		this.ilanlarimPojo = ilanlarimPojo;
	}

	public List<IlanlarimPojoItem> getIlanlarimPojo(){
		return ilanlarimPojo;
	}

	@Override
 	public String toString(){
		return 
			"IlanlarimPojo{" + 
			"ilanlarimPojo = '" + ilanlarimPojo + '\'' + 
			"}";
		}
}