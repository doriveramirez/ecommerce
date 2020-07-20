package net.doriv.ecommerce.model;

import java.io.Serializable;

import net.doriv.onlineshop.dto.User;

public class RegisterModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private User user;
	
}
