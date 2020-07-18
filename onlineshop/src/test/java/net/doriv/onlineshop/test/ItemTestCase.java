package net.doriv.onlineshop.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.doriv.onlineshop.dao.ItemDAO;
import net.doriv.onlineshop.dto.Item;

public class ItemTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ItemDAO itemDAO;
	private Item item;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.doriv.onlineshop");
		context.refresh();
		itemDAO = (ItemDAO)context.getBean("itemDAO");
	}
	
//	@Test
//	public void testAddItem() {
//		item = new Item();
//		item.setName("Super Mario Odyssey");
//		item.setImage("super_mario_odyssey.png");ç
//		item.setPrice(60);
//		item.setActive(true);
//		item.setId_catalog(3);
//		item.setStock(5);
//		assertEquals("Error when try to add the item.",true,itemDAO.add(item));
//	}
	
//	@Test
//	public void testGetItem() {
//		item = itemDAO.get(2);
//		assertEquals("Error when try to fetch.","Super Mario Odyssey",item.getName());
//	}
	
//	@Test
//	public void testUpdateItem() {
//		item = itemDAO.get(4);
//		item.setName("Mario Odyssey");
//		assertEquals("Error when try to update.",true,itemDAO.update(item));
//	}
	
//	@Test
//	public void testDeleteItem() {
//		item = itemDAO.get(4);
//		assertEquals("Error when try to delete.",true,itemDAO.delete(item));
//	}
	
//	@Test
//	public void testListItem() {
//		assertEquals("Error when try to fetch a list of item.",3,itemDAO.List().size());
//	}
	
//	@Test
//	public void testListActiveItems() {
//		assertEquals("Error when try to fetch a list of item that are active.",5,itemDAO.listActiveItems().size());
//	}
	
//	@Test
//	public void testListActiveItemsByCategory() {
//		assertEquals("Error when try to fetch a list of item that are active.",1,itemDAO.listActiveItemsByCatalog(3).size());
//	}
	
	@Test
	public void testGetLatestActiveItem() {
		assertEquals("Error when try to get the latest active item.",2,itemDAO.getLatestActiveItems(2).size());
	}
}
