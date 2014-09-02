package com.cchub.cityguide;

import org.json.JSONException;
import org.json.JSONObject;

import com.codecamp.libs.RestClient;
import com.codecamp.libs.RestClient.RequestMethod;

public class BusinessModel {
	private String address, businessname, city, email, services, phone,
			mondaystart, mondayend, tuesdaystart, tuesdayend, wednesdaystart,
			wednesdayend, thursdaystart, thursdayend, fridaystart, fridayend,
			saturdaystart, saturdayend, sundaystart, sundayend,longitude, latitude,product,website,description;
	int rating;

	public BusinessModel(JSONObject data) {
		try {
			this.address = data.getString("Address");
		
		this.businessname = data.getString("BusinessName");
		this.city = data.getString("CityName");
		this.email = data.getString("EmailAddress");
		this.services = data.getString("Services");
		this.phone = data.getString("PhoneNumber");
		this.rating = data.getInt("Rating");
		this.latitude = data.getString("Lattitude");
		this.longitude = data.getString("Longitude");
		this.mondaystart = data.getString("MondayStart");
		this.mondayend = data.getString("MondayEnd");
		this.tuesdaystart = data.getString("TuesdayStart");
		this.tuesdayend = data.getString("TuesdayEnd");
		this.wednesdaystart = data.getString("WednesdayStart");
		this.wednesdayend = data.getString("WednesdayEnd");
		this.thursdaystart = data.getString("ThursdayStart");
		this.thursdayend = data.getString("ThursdayEnd");
		this.fridaystart = data.getString("FridayStart");
		this.fridayend = data.getString("FridayEnd");
		this.saturdaystart = data.getString("SaturdayStart");
		this.saturdayend = data.getString("SaturdayEnd");
		this.sundaystart = data.getString("SundayStart");
		this.sundayend = data.getString("SundayEnd");
		this.description = data.getString("ShortDescription");
		this.website = data.getString("WebAddress");
		this.product = data.getString("Product");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getAddress() {
		return address;
	}

	public String getBusinessname() {
		return businessname;
	}

	public String getCity() {
		return city;
	}

	public String getEmail() {
		return email;
	}

	public String getServices() {
		return services;
	}

	public String getPhone() {
		return phone;
	}

	public String getMonday() {
		if (IsClosed(mondaystart)==0){
		return mondaystart;}
		else if(IsClosed(mondaystart)==1){
			return "unavailable";
		}
		else{
			
			return Stringtotime(mondaystart)+" to "+Stringtotime(mondayend);
		}
		}
	

	

	public String getTuesday() {
		if (IsClosed(tuesdaystart)==0){
			return tuesdaystart;}
		else if(IsClosed(tuesdaystart)==1){
			return "unavailable";
		}
			else{
				
				return Stringtotime(tuesdaystart)+" to "+Stringtotime(tuesdayend);
			}
	}

	

	public String getWednesday() {
		if (IsClosed(wednesdaystart)==0){
			return wednesdaystart;}
		else if(IsClosed(wednesdaystart)==1){
			return "unavailable";
		}
			else{
				
				return Stringtotime(wednesdaystart)+" to "+Stringtotime(wednesdayend);
			}
	}

	

	public String getThursday() {
		if (IsClosed(thursdaystart)==0){
			return thursdaystart;}
		else if(IsClosed(thursdaystart)==1){
			return "unavailable";
		}
			else{
				
				return Stringtotime(thursdaystart)+" to "+Stringtotime(thursdayend);
			}
	}

	

	public String getFriday() {
		if (IsClosed(fridaystart)==0){
			return fridaystart;}
		else if(IsClosed(fridaystart)==1){
			return "unavailable";
		}
			else{
				
				return Stringtotime(fridaystart)+" to "+Stringtotime(fridayend);
			}
	}

	
	public String getSaturday() {
		if (IsClosed(saturdaystart)==0){
			return saturdaystart;}
		else if(IsClosed(saturdaystart)==1){
			return "unavailable";
		}
			else{
				
				return Stringtotime(saturdaystart)+" to "+Stringtotime(saturdayend);
			}
	}

	
	public String getSunday() {
		if (IsClosed(sundaystart)==0){
			return sundaystart;}
		else if(IsClosed(sundaystart)==1){
			return "unavailable";
		}
			else{
				
				return Stringtotime(sundaystart)+" to "+Stringtotime(sundayend);
			}
	}

	

	public Double getLongitude() {
		return Double.parseDouble(longitude);
	}

	public Double getLatitude() {
		return Double.parseDouble(latitude);
	}

	public String getProduct() {
		return product;
	}

	public String getWebsite() {
		return website;
	}

	public String getDescription() {
		return description;
	}

	public int getRating() {
		return rating;
	}
	
	private int IsClosed(String Day){
		if(Day.equalsIgnoreCase("Closed")){
			return 0;
		}
			else if(Day.equals("null")){
				return 1;
			}
		else{
			return 2;
		}
	}
		private String Stringtotime(String time){
		Double dtime	= Double.parseDouble(time);
		if(dtime < 1){
			return 12+" AM";
		}
		else if(dtime <= 12){
		return time+" AM";
		}
		else{
			dtime -= 12;
			return dtime+"0 PM";
		}
	}
	
	}
		
		