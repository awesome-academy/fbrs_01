package app.dao.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import app.dao.FollowDAO;
import app.dao.GenericDAO;
import app.model.Follow;

public class FollowDAOImpl extends GenericDAO<Integer, Follow> implements FollowDAO {
	private static final Logger logger = Logger.getLogger(FollowDAOImpl.class);

	public FollowDAOImpl() {
		super(Follow.class);
	}

	public FollowDAOImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public Follow getFollow(int follower_id, int followed_id) {
		logger.info("get Follow");
		Criteria criteria = getSession().createCriteria(Follow.class);
		criteria.add(Restrictions.eq("follower.id", follower_id));
		criteria.add(Restrictions.eq("followed.id", followed_id));
		return (Follow) criteria.uniqueResult();
	}

	@Override
	public Follow findByIdLock(int id, boolean lock) {
		if (lock) {
			return getSession().load(Follow.class, id, LockMode.PESSIMISTIC_WRITE);
		}
		return getSession().load(Follow.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Follow> getFollowsByFollowed(int followed_id) {
		@SuppressWarnings("deprecation")
		Criteria criteria = getSession().createCriteria(Follow.class);
		criteria.add(Restrictions.eq("followed.id", followed_id));
		return criteria.list();

	}

}
