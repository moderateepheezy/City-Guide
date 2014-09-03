package com.cchub.cityguide;

public class ImageItem {
	public String address;
	public String companyName;
	public int image;
	public int businessID;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}
	

	public int getBusinessID() {
		return businessID;
	}

	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}

	public ImageItem(String address, String companyName, int image, int businessID) {
		this.address = address;
		this.companyName = companyName;
		this.image = image;
		this.businessID = businessID;
	}
	
	
}
