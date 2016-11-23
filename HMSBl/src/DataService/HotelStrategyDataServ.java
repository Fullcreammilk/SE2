package DataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import PO.HotelStrategyPO;

public interface HotelStrategyDataServ extends Remote{
	
	public void insertHotelStrategy(HotelStrategyPO strategyPO) throws RemoteException;
	
	public HotelStrategyPO[] getHotelStrategyList () throws RemoteException;
	
	public void deleteHotelStrategy(String id) throws RemoteException;
	
	public void modifiedHotelStrategy(HotelStrategyPO strategy) throws RemoteException;
	
	public void init() throws RemoteException;
	
	public void finish() throws RemoteException;
	
}
