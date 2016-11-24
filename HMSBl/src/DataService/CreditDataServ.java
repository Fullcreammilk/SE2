package DataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import PO.CreditPO;

public interface CreditDataServ extends Remote{
	
	
	public CreditPO getDetial(String id) throws RemoteException;
	
	public void insertCredit(CreditPO credit) throws RemoteException;
	
	
}
