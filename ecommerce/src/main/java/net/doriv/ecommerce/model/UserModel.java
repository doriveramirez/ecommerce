package net.doriv.ecommerce.model;

import java.io.Serializable;

import net.doriv.onlineshop.dto.Cart;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", email=" + email + ", admin=" + admin + ", cart=" + cart
				+ "]";
	}
	private int id;
	private String name;
	private String email;
	private boolean admin;
	private Cart cart;


	
	
}
