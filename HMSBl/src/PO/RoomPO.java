package PO;

public class RoomPO {
	private String hotelname,type;
	private int[] number;
	private int totel;
	private double price;
	
	public RoomPO(String hn,String t,int[] num,int totel,double price){
		super();
		this.hotelname=hn;
		this.type=t;
		this.number=num;
		this.totel=totel;
		this.price=price;
	}
	
	public String getHn(){
		return hotelname;
	}
	
	
	public String getType(){
		return type;
	}
	
	public void setType(String t){
		this.type=t;
	}
	
	public void setTotel(int i){
		this.totel=i;
	}
	
	public int getTotel(){
		return this.totel;
	}
	
	public void setPrice(double d){
		this.price=d;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public int[] getNum(){
		return number;
	}
	
	public void setNum(int num[]){
		this.number=num;
	}
}