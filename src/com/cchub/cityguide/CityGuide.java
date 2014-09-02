/**
 * 
 */
package com.cchub.cityguide;


import com.parse.Parse;
import com.parse.ParseFacebookUtils;

import android.app.Application;


/**
 * @author Bernard
 *
 */
public class CityGuide extends Application {
	
	static final String TAG = "City Guide";

	@Override
	public void onCreate() {
		super.onCreate();

		Parse.initialize(this, "uAdfYL9uIbLg38eCDsFsQLQ3cbImk6dtD3Fmb3XJ",
				"7fdLoZqPr7wnlEg8pISHg3hDsu3KyIqwfXaO5EPH");

		// Set your Facebook App Id in strings.xml
		ParseFacebookUtils.initialize(getString(R.string.app_id));

	}	
}
