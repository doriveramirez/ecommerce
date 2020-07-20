package net.doriv.onlineshop.dao;

import java.util.List;
import net.doriv.onlineshop.dto.Item;

public interface ItemDAO {
	
	Item get(int id);
	List<Item> list();
	boolean add(Item item);
	boolean update(Item item);
	boolean delete(Item item);
	
	List<Item> listActiveItems();
	List<Item> listActiveItemsByCatalog(int id_catalog);
	List<Item> getLatestActiveItems(int count);
}

