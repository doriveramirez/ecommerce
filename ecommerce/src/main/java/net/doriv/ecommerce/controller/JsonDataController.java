package net.doriv.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.doriv.onlineshop.dao.ItemDAO;
import net.doriv.onlineshop.dto.Item;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ItemDAO itemDAO;
	
	@RequestMapping("/all/items")
	@ResponseBody
	public List<Item> getAllItems(){
		return itemDAO.listActiveItems();
	}
	
	@RequestMapping("/admin/all/items")
	@ResponseBody
	public List<Item> getAllItemsForAdmin(){
		return itemDAO.list();
	}
	
	@RequestMapping("/catalog/{id}/items")
	@ResponseBody
	public List<Item> getAllItemsByCatalog(@PathVariable int id){
		return itemDAO.listActiveItemsByCatalog(id);
	}
}
