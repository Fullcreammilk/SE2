package strategy_bl_serv;

import PO.WebStrategyPO;

public interface WebStrategyBlServ {
	public WebStrategyPO[] getStrategy(String hotelName);
	public boolean addStrategy(WebStrategyPO strategy);
	public boolean modifyStrategy(WebStrategyPO strategy);
	public boolean delStrategy(WebStrategyPO strategy);
}
