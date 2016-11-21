package PO;

import java.util.ArrayList;


public class UserPO {
	private String id,name,contactInof,specialInfo;
	private int creditTol,vipLev;
	private String password;
	private ArrayList<OrderPO> orders;
	private ArrayList<CreditPO> credits;
	private String type;
	
	public UserPO(String id,String password,String contactInfo,String name,String specialInfo,
			int creditTol,int vipLev,String type){
		super();
		this.id=id;
		this.password=password;
		this.contactInof=contactInfo;
		this.name=name;
		this.creditTol=creditTol;
		this.vipLev=vipLev;
		this.type=type;
		this.specialInfo=specialInfo;
		//to be continue...
	}
	
	
	public String getID(){
		return id;
	}
	
	public void setPassword(String p){
		this.password=p;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setContactInfo(String s){
		this.contactInof=s;
	}
	
	public String getContactInfo(){
		return this.contactInof;
	}
	
	public void setName(String s){
		this.name=s;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setCreditTol(int i){
		this.creditTol=i;
	}
	
	public int getCreditTol(){
		return this.creditTol;
	}
	
	public void setVipLev(int i){
		this.vipLev=i;
	}
	
	public int getVipLev(){
		return this.vipLev;
	}
	
	public String getType(){
		return this.type;
	}
	
	public String getSpecialInfo(){
		return this.specialInfo;
	}
	
	public ArrayList<OrderPO> getOrder(){
		return this.orders;
	}
	
	public ArrayList<CreditPO> getCredit(){
		return this.credits;
	}
}
