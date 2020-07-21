package net.doriv.onlineshop.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

public class Cart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "Cart [user=" + user + ", id_cart=" + id_cart + ", units=" + units + ", price=" + price + ", totalPrice="
				+ totalPrice + "]";
	}
	public int getId_cart() {
		return id_cart;
	}
	public void setId_cart(int id_cart) {
		this.id_cart = id_cart;
	}
	@OneToOne
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cart;
	private int units;
	@Min(value=0, message="Price can't be negative.")
	private double price;
	@Min(value=0, message="Price can't be negative.")
	private double totalPrice;
}
