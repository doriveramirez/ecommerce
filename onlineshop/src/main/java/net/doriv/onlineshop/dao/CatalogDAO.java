package net.doriv.onlineshop.dao;

import java.util.List;
import net.doriv.onlineshop.dto.Catalog;

public interface CatalogDAO {
	
	Catalog get(int id);
	List<Catalog> List();
	boolean add(Catalog catalog);
	boolean update(Catalog catalog);
	boolean delete(Catalog catalog);
}
