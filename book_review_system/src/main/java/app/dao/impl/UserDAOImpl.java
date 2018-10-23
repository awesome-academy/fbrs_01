package app.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import app.dao.GenericDAO;
import app.dao.UserDAO;
import app.model.User;

public class UserDAOImpl extends GenericDAO<Integer, User> implements UserDAO {
	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

	public UserDAOImpl() {
		super(User.class);
	}

	public UserDAOImpl(SessionFactory sessionfactory) {
		setSessionFactory(sessionfactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> loadUsers(int page) {
		logger.info("load User in DAO");
		return getSession().createQuery("from User").setFirstResult(page).setMaxResults(5).getResultList();
	}

	@Override
	public int loadRowsCount() {
		return getSession().createQuery("from User").getResultList().size();
	}

	@Override
	public User findByIdLock(int id, boolean lock) {
		if (lock) {
			return getSession().get(User.class, id, LockMode.PESSIMISTIC_WRITE);
		}
		return getSession().get(User.class, id);
	}
}