package net.doriv.onlineshop.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.doriv.onlineshop.dao.CatalogDAO;
import net.doriv.onlineshop.dto.Catalog;

@Repository("catalogDAO")
public class CatalogDAOImpl implements CatalogDAO {

	private static List<Catalog> catalogs = new ArrayList<>();
	
	static {
//		Test
		Catalog catalog = new Catalog();
		catalog.setId_catalog(0);
		catalog.setName("Telephones");
		catalog.setImage("Catalog_telephones.png");
		catalogs.add(catalog);
		
		catalog = new Catalog();
		catalog.setId_catalog(1);
		catalog.setName("Videogames");
		catalog.setImage("Catalog_videogames.png");
		catalogs.add(catalog);
		
		catalog = new Catalog();
		catalog.setId_catalog(2);
		catalog.setName("Computers");
		catalog.setImage("Catalog_computers.png");
		catalogs.add(catalog);
	}
	
	@Override
	public java.util.List<Catalog> List() {
		// TODO Auto-generated method stub
		return catalogs;
	}

	@Override
	public Catalog get(int id) {
		for (Catalog catalog: catalogs) {
			if(catalog.getId_catalog() == id) return catalog;
		}
		return null;
	}

}
