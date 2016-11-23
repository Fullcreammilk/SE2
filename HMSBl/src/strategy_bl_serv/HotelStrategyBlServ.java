package strategy_bl_serv;

import PO.HotelStrategyPO;

public interface HotelStrategyBlServ {
	public HotelStrategyPO[] getStrategy(String hotelName);
	public boolean addStrategy(HotelStrategyPO strategy);
	public boolean modifyStrategy(HotelStrategyPO strategy);
	public boolean delStrategy(HotelStrategyPO strategy);
}
