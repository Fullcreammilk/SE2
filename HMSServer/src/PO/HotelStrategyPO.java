package PO;
enum HotelStrategyType{BIRTHDAY,COMPANY,BEYOND,DATE}
public class HotelStrategyPO {
	private String hotelname,strategyname,specialInfo;
	double discount;
	HotelStrategyType type;
	
	public HotelStrategyPO(String hotelname,String strategyname,String specialInfo,double discount,
			HotelStrategyType t){
		this.hotelname=hotelname;
		this.strategyname=strategyname;
		this.specialInfo=specialInfo;
		this.discount=discount;
		this.type=t;
	}
	
	public String getHotelName(){
		return this.hotelname;
	}
	
	public String getStrategyName(){
		return this.strategyname;
	}
	
	public String getSpecialInof(){
		return this.specialInfo;
	}
	
	public double getDiscount(){
		return this.discount;
	}
	
	public HotelStrategyType getType(){
		return this.type;
	}
}
