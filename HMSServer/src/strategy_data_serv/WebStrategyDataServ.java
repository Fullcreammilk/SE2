package strategy_data_serv;

import java.rmi.Remote;
import java.rmi.RemoteException;

import PO.WebStrategyPO;

public interface WebStrategyDataServ extends Remote{
	
	public void insertWebStrategy(WebStrategyPO strategyPO) throws RemoteException;
	
	public WebStrategyPO[] getWebStrategyList () throws RemoteException;
	
	public void deleteWebStrategy(String id) throws RemoteException;
	
	public void modifiedWebStrategy(WebStrategyPO strategy) throws RemoteException;
	
	public void init() throws RemoteException;
	
	public void finish() throws RemoteException;
}
