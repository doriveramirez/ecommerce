package net.doriv.ecommerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.doriv.ecommerce.model.UserModel;
import net.doriv.onlineshop.dao.UserDAO;
import net.doriv.onlineshop.dto.User;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private HttpSession session;

	private UserModel userModel = null;
	private User user = null;

	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		if (session.getAttribute("userModel") == null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!authentication.getPrincipal().equals("anonymousUser")) {
				user = userDAO.getByEmail(authentication.getName());
				if (user != null) {
					userModel = new UserModel();
					userModel.setId(user.getId_user());
					userModel.setEmail(user.getEmail());
					userModel.setName(user.getName());
					userModel.setAdmin(user.isAdmin());
					if (!userModel.isAdmin()) {
						userModel.setCart(user.getCart());
					}
					session.setAttribute("userModel", userModel);
					return userModel;
				}
			}
		}
		return (UserModel) session.getAttribute("userModel");
	}
}
