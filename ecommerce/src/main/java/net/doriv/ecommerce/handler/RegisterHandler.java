package net.doriv.ecommerce.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;

import net.doriv.ecommerce.model.RegisterModel;
import net.doriv.onlineshop.dao.UserDAO;
import net.doriv.onlineshop.dto.Cart;
import net.doriv.onlineshop.dto.User;

public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	
	public String validateUser(User user, MessageContext error) {
		String transitionValue = "success";
		if (userDAO.getByEmail(user.getEmail())!=null) {
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("Email is already used.")
					.build()
					);
			transitionValue = "failure";
		}
		return transitionValue;
	}
	
	public String saveAll(RegisterModel model) {
		String transitionValue = "success";
		User user = model.getUser();
		if(!user.isAdmin()) {
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		userDAO.addUser(user);
		return transitionValue;
	}
	
}
