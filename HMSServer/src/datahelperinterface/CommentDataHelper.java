package datahelperinterface;

import java.util.ArrayList;

import datahelper.Comment;

public interface CommentDataHelper {
	public ArrayList<Comment> getAll();
	
	public int insert(Comment c);
	
	public int delete(Comment c);
}
