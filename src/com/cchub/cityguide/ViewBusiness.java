package com.cchub.cityguide;

import org.json.JSONObject;

import com.codecamp.libs.RestClient;
import com.codecamp.libs.RestClient.RequestMethod;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.CameraPosition;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ViewBusiness extends ActionBarActivity {
	private GoogleMap googleMap;
	public double latitude;
	public double longitude;
	private MarkerOptions marker;
	private TextView address, businessname, city, email, services, phone,
			monday, tuesday, wednesday, thursday, friday, saturday, sunday,
			website, products, description;
	private RatingBar ratingbar;
	Intent i ;
	Double currentlong;
	Double currentlat;
	Button direction;
	private String restclient ;
	BusinessModel business;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_business);
		ActionBar actionbar = getActionBar();
		actionbar.setHomeButtonEnabled(true);
		actionbar.setDisplayHomeAsUpEnabled(true);
		// latitude and longitude
		i = getIntent();
		currentlong = i.getDoubleExtra("longitude", 3.4566);
		currentlat = i.getDoubleExtra("lattitude", 6.4433);
		restclient = "http://72.251.246.227/vconnect_restservice_hack_2014/VConnect.svc/GetBusinessDetails?BusinessId="
				+ i.getIntExtra("businessid", 1);
		//Toast.makeText(getApplicationContext(), i.getIntExtra("businessid", 233)+" nn",Toast.LENGTH_LONG).show();
		address = (TextView) findViewById(R.id.address);
		businessname = (TextView) findViewById(R.id.businessname);
		city = (TextView) findViewById(R.id.city);
		email = (TextView) findViewById(R.id.email);
		email.setOnClickListener(new View.OnClickListener() {

			@SuppressLint("ShowToast")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (email.getText().equals("") || email.getText().equals(null)) {
					Toast.makeText(getApplicationContext(),
							"no email available", Toast.LENGTH_SHORT);
				} else {
					Intent intent = new Intent(Intent.ACTION_VIEW);
					String url = "mailto:" + email.getText();
					intent.setData(Uri.parse(url));

					startActivity(intent);
				}

			}
		});
		services = (TextView) findViewById(R.id.services);
		phone = (TextView) findViewById(R.id.phone);
		phone.setOnClickListener(new View.OnClickListener() {

			@SuppressLint("ShowToast")
			@Override
			public void onClick(View v) {
				if (phone.getText().equals("") || phone.getText().equals(null)) {
					Toast.makeText(getApplicationContext(),
							"no nummber available", Toast.LENGTH_SHORT);
				} else {
					Intent intent = new Intent(Intent.ACTION_VIEW);
					String url = "tel:" + phone.getText();
					intent.setData(Uri.parse(url));

					startActivity(intent);
				}

			}
		});
		monday = (TextView) findViewById(R.id.monday);
		tuesday = (TextView) findViewById(R.id.tuesday);
		wednesday = (TextView) findViewById(R.id.wednesday);
		thursday = (TextView) findViewById(R.id.thursday);
		friday = (TextView) findViewById(R.id.friday);
		saturday = (TextView) findViewById(R.id.saturday);
		sunday = (TextView) findViewById(R.id.sunday);
		website = (TextView) findViewById(R.id.website);
		website.setOnClickListener(new View.OnClickListener() {

			@SuppressLint("ShowToast")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (website.getText().equals("")
						|| website.getText().equals(null)) {
					Toast.makeText(getApplicationContext(),
							"no website available", Toast.LENGTH_SHORT);
				} else {
					Intent intent = new Intent(Intent.ACTION_VIEW);
					String url = website.getText().toString();
					intent.setData(Uri.parse(url));

					startActivity(intent);
				}
			}
		});
		products = (TextView) findViewById(R.id.products);
		description = (TextView) findViewById(R.id.description);
		ratingbar = (RatingBar) findViewById(R.id.rating);
		direction = (Button) findViewById(R.id.button1);
		direction.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(android.content.Intent.ACTION_VIEW, 
					    Uri.parse("http://maps.google.com/maps?saddr="+currentlat+","+currentlong+"&daddr="+latitude+","+longitude));
					startActivity(intent);
			}
		});
	new GetJsonTask().execute();

	}

	public class GetJsonTask extends AsyncTask<Void, Void, String[]> {

		private RestClient connect;
		private String text;

		ProgressDialog pDiag;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pDiag = new ProgressDialog(ViewBusiness.this);
			pDiag.setMessage("Loading..");
			pDiag.setCancelable(true);
			pDiag.setCanceledOnTouchOutside(false);
			pDiag.show();

		}

		@Override
		protected String[] doInBackground(Void... params) {
			// TODO Auto-generated method stub

			connect = new RestClient(restclient);

			try {
				connect.Execute(RequestMethod.GET);

				text = connect.getResponse();

				JSONObject json = new JSONObject(text);
				business = new BusinessModel(json);

			} catch (Exception ex) {
				Toast.makeText(getApplicationContext(),
						"Not able to get data because : " + ex,
						Toast.LENGTH_SHORT).show();
			}

			return null;
		}

		@Override
		protected void onPostExecute(String[] result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			// adapter.addAll(dataS);
			address.setText(business.getAddress());
			businessname.setText(business.getBusinessname());
			city.setText(business.getCity());
			email.setText(business.getEmail());
			services.setText(business.getServices());
			phone.setText(business.getPhone());
			ratingbar.setRating(business.getRating());
			website.setText(business.getWebsite());
			products.setText(business.getProduct());
			description.setText(business.getDescription());
			monday.setText(business.getMonday());
			tuesday.setText(business.getTuesday());
			wednesday.setText(business.getWednesday());
			thursday.setText(business.getThursday());
			friday.setText(business.getFriday());
			saturday.setText(business.getSaturday());
			sunday.setText(business.getSunday());
			longitude = business.getLongitude();
			latitude = business.getLatitude();
			try {
				// Loading map
				initilizeMap();

				googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);// /map view
																// type
				// Showing / hiding your current location
				googleMap.setMyLocationEnabled(false);

				// Enable / Disable zooming controls
				googleMap.getUiSettings().setZoomControlsEnabled(true);

				// Enable / Disable my location button
				googleMap.getUiSettings().setMyLocationButtonEnabled(false);

				// Enable / Disable Compass icon
				googleMap.getUiSettings().setCompassEnabled(false);

				// Enable / Disable Rotate gesture
				googleMap.getUiSettings().setRotateGesturesEnabled(false);

				// Enable / Disable zooming functionality
				googleMap.getUiSettings().setZoomGesturesEnabled(false);

				marker = new MarkerOptions().position(
						new LatLng(latitude, longitude)).title(
						business.getBusinessname());

				// adding marker
				googleMap.addMarker(marker);
				CameraPosition cameraPosition = new CameraPosition.Builder()
						.target(new LatLng(latitude, longitude)).zoom(15)
						.build();

				googleMap.animateCamera(CameraUpdateFactory
						.newCameraPosition(cameraPosition));

			} catch (Exception e) {
				e.printStackTrace();
			}

			pDiag.dismiss();

		}
	}

	private void initilizeMap() {
		if (googleMap == null) {
			googleMap = ((MapFragment) getFragmentManager().findFragmentById(
					R.id.map)).getMap();

			// check if map is created successfully or not
			if (googleMap == null) {
				Toast.makeText(getApplicationContext(),
						"Sorry! unable to create maps", Toast.LENGTH_SHORT)
						.show();
			}
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		initilizeMap();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
