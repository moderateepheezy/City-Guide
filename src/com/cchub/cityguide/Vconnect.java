package com.cchub.cityguide;

import org.json.JSONException;
import org.json.JSONObject;

public class Vconnect {
	public String businessName;
	public String bussinessAddress;
	public String image;
	public String BusinessID;
	public Vconnect(JSONObject json) {
		try {
			this.businessName = json.getString("BusinessName");
			this.bussinessAddress = json.getString("City");
			this.image = json.getString("CompanyLogo");
			this.BusinessID = json.getString("BusinessName");
	}catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
	public String getBusinessID() {
		return BusinessID;
	}

	public void setBusinessID(String businessID) {
		BusinessID = businessID;
	}

	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getBussinessAddress() {
		return bussinessAddress;
	}
	public void setBussinessAddress(String bussinessAddress) {
		this.bussinessAddress = bussinessAddress;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
