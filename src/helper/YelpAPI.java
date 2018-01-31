package helper;

import okhttp3.*;
import okhttp3.Request.Builder;
import org.json.*;

import dataModel.Vendor;

import java.io.IOException;
import java.util.ArrayList;

public class YelpAPI {

	final String API_KEY = "GHXTrEYIoQ5WnF2Unl9YSXs44os7QS0PquAkU1eL2gz_jHsATJGp6X98U257JsN8zLdD2dufzwP1Ls90n8KeFK9FG84F6OfCsTAYw9R6npybodmWilCXZzKesnFwWnYx";
	//final String API_HOST = "https://api.yelp.com";
	//final String SEARCH_PATH = "/v3/businesses/search";
	//final String BUSINESS_PATH = "/v3/businesses/";
	//final int SEARCH_LIMIT = 5;
	
	
	public static JSONArray searchForVendors(String term, String location) throws JSONException, IOException{
		final String API_KEY = "GHXTrEYIoQ5WnF2Unl9YSXs44os7QS0PquAkU1eL2gz_jHsATJGp6X98U257JsN8zLdD2dufzwP1Ls90n8KeFK9FG84F6OfCsTAYw9R6npybodmWilCXZzKesnFwWnYx";
		OkHttpClient client = new OkHttpClient();
		
		Request request = new Builder()
                .url("https://api.yelp.com/v3/businesses/search?term=" + term + "&location=" + location + "&limit=5")
                .get()
                .addHeader("authorization", "Bearer"+" "+API_KEY)
                .build();
		
		Response response = client.newCall(request).execute();

		JSONObject jsonObject = new JSONObject(response.body().string().trim());       // parser
		JSONArray vendors = (JSONArray)jsonObject.get("businesses");

		return vendors;
	}
	
	public static ArrayList<Vendor> createVendorObjects(JSONArray vendors) throws JSONException {
		String name, category, address, website, phoneNo, imageURL;
		int rating;
		ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
		
		for(int i=0; i<vendors.length(); i++){
			name = vendors.getJSONObject(i).getString("name");
			address = vendors.getJSONObject(i).getJSONObject("location").getString("address1") + " "
					+ vendors.getJSONObject(i).getJSONObject("location").getString("city") + " " 
					+ vendors.getJSONObject(i).getJSONObject("location").getString("state") + " "
					+ vendors.getJSONObject(i).getJSONObject("location").getString("zip_code");
			website  = vendors.getJSONObject(i).getString("url");
			phoneNo  = vendors.getJSONObject(i).getString("phone");
			imageURL  = vendors.getJSONObject(i).getString("image_url");
			rating  = vendors.getJSONObject(i).getInt("rating");
			
			Vendor aVendor = new Vendor(name, address, website, phoneNo, imageURL, rating);
			vendorList.add(aVendor);
		}
		
		return vendorList;
	}
}
