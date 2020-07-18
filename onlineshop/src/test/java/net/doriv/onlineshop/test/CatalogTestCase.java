package net.doriv.onlineshop.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.doriv.onlineshop.dao.CatalogDAO;
import net.doriv.onlineshop.dto.Catalog;

public class CatalogTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CatalogDAO catalogDAO;
	private Catalog catalog;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.doriv.onlineshop");
		context.refresh();
		catalogDAO = (CatalogDAO)context.getBean("catalogDAO");
	}
	
//	@Test
//	public void testAddCatalog() {
//		catalog = new Catalog();
//		catalog.setName("Telephones");
//		catalog.setImage("Catalog_telephones.png");
//		assertEquals("Error when try to add the catalog.",true,catalogDAO.add(catalog));
//		catalog = new Catalog();
//		catalog.setName("Videogames");
//		catalog.setImage("Catalog_Videogames.png");
//		assertEquals("Error when try to add the catalog.",true,catalogDAO.add(catalog));
//		catalog = new Catalog();
//		catalog.setName("Computers");
//		catalog.setImage("Catalog_Computers.png");
//		assertEquals("Error when try to add the catalog.",true,catalogDAO.add(catalog));
//	}
	
//	@Test
//	public void testGetCatalog() {
//		catalog = catalogDAO.get(2);
//		assertEquals("Error when try to fetch.","Videogames",catalog.getName());
//	}
	
//	@Test
//	public void testUpdateCatalog() {
//		catalog = catalogDAO.get(2);
//		catalog.setName("Games");
//		assertEquals("Error when try to update.",true,catalogDAO.update(catalog));
//	}
	
//	@Test
//	public void testDeleteCatalog() {
//		catalog = catalogDAO.get(3);
//		assertEquals("Error when try to delete.",true,catalogDAO.delete(catalog));
//	}
	
//	@Test
//	public void testListCatalog() {
//		assertEquals("Error when try to fetch a list of catalog.",3,catalogDAO.List().size());
//	}
}
