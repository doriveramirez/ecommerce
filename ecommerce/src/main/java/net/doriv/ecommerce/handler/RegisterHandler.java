package net.doriv.ecommerce.handler;

import net.doriv.ecommerce.model.RegisterModel;
import net.doriv.onlineshop.dto.User;

public class RegisterHandler {
	
	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	
}
