package hotel_data_servlmpl;

import java.rmi.RemoteException;

import PO.HotelPO;
import hotel_data_serv.HotalDataServ;

public class HotelDataServlmpl implements HotalDataServ{
	

	@Override
	public void insertHotel(HotelPO hotel) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HotelPO getHotel(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteHotel(String name) throws RemoteException {
		return false;	
	}

	@Override
	public boolean modifiedHotel(HotelPO hotel) throws RemoteException {
		return false;
	}

	@Override
	public HotelPO[] getHotelList(String businesscircle) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
