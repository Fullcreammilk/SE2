package datahelper;

public class Comment {
	private String hotelname,detials;
	
	public Comment(String hotelname,String detials){
		this.hotelname=hotelname;
		this.detials=detials;
	}
	
	public String getHotelName(){
		return this.hotelname;
	}
	
	public String getDetials(){
		return this.detials;
	}
}