package net.doriv.onlineshop.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.doriv.onlineshop.dao.UserDAO;
import net.doriv.onlineshop.dto.Cart;
import net.doriv.onlineshop.dto.User;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.doriv.onlineshop");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void testAdd() {
		user = new User();
		user.setName("test");
		user.setEmail("test@gmail.com");
		user.setAdmin(false);
		user.setPassword("test");
		assertEquals("Error", true, userDAO.addUser(user));

		if (!user.isAdmin()) {
			cart = new Cart();
			cart.setUser(user);
			assertEquals("Error", true, userDAO.updateCart(cart));
		}
	}

	@Test
	public void testUpdateCart() {
		user = userDAO.getByEmail("Rodolfo@gmail.com");
		cart = user.getCart();
		cart.setPrice(5000);
		cart.setTotalPrice(6000);
		assertEquals("Failed to update the cart.", true, userDAO.updateCart(cart));
	}
}
