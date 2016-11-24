package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.CommentPO;
import PO.CreditPO;
import PO.HotelPO;
import PO.HotelStrategyPO;
import PO.OrderPO;
import PO.RoomPO;
import PO.UserPO;
import PO.WebStrategyPO;
import commet_data_serv.CommentDataServ;
import credit_data_serv.CreditDataServ;
import hotel_data_serv.HotalDataServ;
import order_data_serv.OrderDataServ;
import order_data_serv.abnormalOrderDataServ;
import order_data_serv.normalOrderDataServ;
import order_data_serv.revokOrderDataServ;
import room_data_serv.RoomDataServ;
import strategy_data_serv.HotelStrategyDataServ;
import strategy_data_serv.WebStrategyDataServ;
import user_data_serv.UserDataServ;

public class DataRemoteObject extends UnicastRemoteObject implements
	CreditDataServ,HotalDataServ,OrderDataServ,normalOrderDataServ,abnormalOrderDataServ,
	revokOrderDataServ,RoomDataServ,HotelStrategyDataServ,WebStrategyDataServ,UserDataServ,CommentDataServ{

	protected DataRemoteObject() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertUser(UserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserPO getUser(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifiedUser(UserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserPO[] getUserList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertWebStrategy(WebStrategyPO strategyPO) throws RemoteException {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<WebStrategyPO> getWebStrategyList(String strategynaem,String bc) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifiedWebStrategy(WebStrategyPO strategy) throws RemoteException {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean insertHotelStrategy(HotelStrategyPO strategyPO) throws RemoteException {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<HotelStrategyPO> getHotelStrategyList(String hotelname) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteHotelStrategy(HotelStrategyPO strategyPO) throws RemoteException {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean modifiedHotelStrategy(HotelStrategyPO strategy) throws RemoteException {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public RoomPO getRoom(String hotelname, String type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RoomPO> getRoomList(String hotelname) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertRoom(RoomPO room) throws RemoteException {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteRoom(RoomPO room) throws RemoteException {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean modifiedRoom(RoomPO room) throws RemoteException {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderPO[] getOrderList(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderPO[] getOrderList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOrder(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifiedOrder(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderPO getOrder(String OrderID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean modifiedHotel(HotelPO hotel) throws RemoteException {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public HotelPO[] getHotelList(String businesscircle) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<CreditPO> getDetial(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertCredit(CreditPO credit) throws RemoteException {
		return false;
		// TODO Auto-generated method stub
		
	}


	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<CommentPO> getComments(String hotelname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(CommentPO c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(CommentPO c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteWebStrategy(WebStrategyPO w) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	
		
	
}
