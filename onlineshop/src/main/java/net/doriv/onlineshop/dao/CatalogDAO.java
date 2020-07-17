package net.doriv.onlineshop.dao;

import java.util.List;
import net.doriv.onlineshop.dto.Catalog;

public interface CatalogDAO {
	
	
	
	List<Catalog> List();
	Catalog get(int id);
	
}
