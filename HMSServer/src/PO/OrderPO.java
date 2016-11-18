package PO;

import java.util.ArrayList;

public class OrderPO {
	public enum Type{
		normal,abnormal,revoke;
	}
	private String id,userid,username,usercontact,hotel;
	private ArrayList<String> room;
	private ArrayList<Integer> num,price,subtotel;
	private double totel;
	private Type type;
	
	public OrderPO(String id,String userid,String hotel,String username,
			String usercontact,Type t){
		super();
		this.id=id;
		this.username=username;
		this.hotel=hotel;
		this.usercontact=usercontact;
		this.userid=userid;
		this.type=t;
	}
	
	public String getID(){
		return id;
	}
	
	public String getUserName(){
		return username;
	}
	
	public String getUserID(){
		return this.userid;
	}
	
	public String getUserContact(){
		return this.usercontact;
	}
	
	public ArrayList<Integer> getPrice(){
		return this.price;
	}
	
	public ArrayList<Integer> getSubtotel(){
		return this.subtotel;
	}
	
	public double getTotel(){
		return this.totel;
	}
	
	public String getHotel(){
		return hotel;
	}
	
	public ArrayList<String> getRoom(){
		return room;
	}
	
	public ArrayList<Integer> getNum(){
		return num;
	}
	
	public Type getType(){
		return type;
	}
	
	public void setType(Type t){
		this.type=t;
	}
}