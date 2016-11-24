package DataService;

import java.util.ArrayList;

import PO.CommentPO;

public interface CommentDataServ {
	public ArrayList<CommentPO> getComments(String hotelname);
	
	public boolean insert(CommentPO c);
	
	public boolean delete(CommentPO c);
}
