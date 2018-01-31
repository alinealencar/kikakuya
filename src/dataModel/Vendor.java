package dataModel;

public class Vendor {
	
	private String name, address, website, phoneNo, imageURL;
	private int rating;
	
	public Vendor () {
		
	}
	
	public Vendor(String name, String address, String website, String phoneNo, String imageURL, int rating) {
		this.name = name;
		this.address = address;
		this.website = website;
		this.phoneNo = phoneNo;
		this.imageURL = imageURL;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
	

}
