package app.dao;

import java.util.List;

import app.model.Follow;
import app.model.User;

public interface FollowDAO extends BaseDAO<Integer, Follow>{
	Follow getFollow(int follower_id, int followed_id);
	Follow findByIdLock(int id,boolean lock);
	List<Follow> getFollowsByFollowed(int followed_id);
	
}
