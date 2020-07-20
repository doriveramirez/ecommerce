package net.doriv.onlineshop.dao;

import net.doriv.onlineshop.dto.User;
import net.doriv.onlineshop.dto.Cart;

public interface UserDAO {
	boolean addUser(User user);
	User getByEmail(String email);
	boolean updateCart(Cart cart);
}
