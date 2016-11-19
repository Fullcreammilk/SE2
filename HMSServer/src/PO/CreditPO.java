package PO;

enum behavior{DONE,INNORMAL,REVOKE,RECHARGE}

public class CreditPO {
	private String id,time,userid;
	private double totel,change;
	private behavior bh;
	
	public CreditPO(String id,String time,String userid,double totel,double change,behavior bh){
		super();
		this.id=id;
		this.userid=userid;
		this.time =time;
		this.totel=totel;
		this.change=change;
		this.bh=bh;
	}
	
	public String getID(){
		return id;
	}
	
	public double getTotel(){
		return totel;
	}
	

	public String getTime(){
		return this.time;
	}
	
	public double getChange(){
		return this.change;
	}
	
	public behavior getBehavior(){
		return this.bh;
	}
	
	public String getUserID(){
		return this.userid;
	}
}