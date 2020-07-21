package net.doriv.onlineshop.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import net.doriv.onlineshop.dao.UserDAO;
import net.doriv.onlineshop.dto.Cart;
import net.doriv.onlineshop.dto.User;

@Service("UserDAO")
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().persist(cart);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM Usr where email = :email";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery,User.class).setParameter("email", email).getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
