package com.kubrahuseyinzehra.mobilproje.Models;

import java.util.List;

public class IlanlarimPojo{
	private List<IlanlarItem> ilanlar;

	public void setIlanlar(List<IlanlarItem> ilanlar){
		this.ilanlar = ilanlar;
	}

	public List<IlanlarItem> getIlanlar(){
		return ilanlar;
	}

	@Override
 	public String toString(){
		return 
			"IlanlarimPojo{" + 
			"ilanlar = '" + ilanlar + '\'' + 
			"}";
		}
}