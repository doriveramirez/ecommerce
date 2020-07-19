package net.doriv.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.doriv.onlineshop.dao.CatalogDAO;
import net.doriv.onlineshop.dao.ItemDAO;
import net.doriv.onlineshop.dto.Catalog;
import net.doriv.onlineshop.dto.Item;

@Controller
public class PageController {
	
	@Autowired
	private CatalogDAO catalogDAO;
	@Autowired
	private ItemDAO itemDAO;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("page");
//		mav.addObject("StartMessage","Welcome to the MHP Shop!");
		mav.addObject("title","Home");
		mav.addObject("catalogs", catalogDAO.List());
		mav.addObject("userClickHome",true);
		return mav;
	}
	
	@RequestMapping(value = { "/show/all/items" })
	public ModelAndView showAllItems() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title","All Items");
		mav.addObject("catalogs", catalogDAO.List());
		mav.addObject("userClickAllItems",true);
		return mav;
	}
	
	@RequestMapping(value = { "/show/catalog/{id_catalog}/items" })
	public ModelAndView showCatalog(@PathVariable("id_catalog") int id) {
		ModelAndView mav = new ModelAndView("page");
		Catalog catalog = null;
		catalog = catalogDAO.get(id);
		mav.addObject("title",catalog.getName());
		mav.addObject("catalogs", catalogDAO.List());
		mav.addObject("catalog", catalog);
		mav.addObject("userClickCatalog",true);
		return mav;
	}
	
	@RequestMapping(value = { "/show/{id_item}/item" })
	public ModelAndView showItem(@PathVariable("id_item") int id) {
		ModelAndView mav = new ModelAndView("page");
		Item item = itemDAO.get(id);
		Catalog catalog= catalogDAO.get(item.getId_catalog());
		item.setViews(item.getViews() + 1);
		itemDAO.update(item);
		mav.addObject("title", item.getName());
		mav.addObject("item", item);
		mav.addObject("catalog", catalog);
		mav.addObject("userClickItem",true);
		return mav;
	}
	
	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title","About MHP");
		mav.addObject("userClickAbout",true);
		return mav;
	}
	
	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title","Contact MHP");
		mav.addObject("userClickContact",true);
		return mav;
	}
//	@RequestMapping(value="/test")
//	public ModelAndView test(@RequestParam(value="StartMessage",required=false)String StartMessage) {
//		if(StartMessage == null) {
//			StartMessage = "Hello";
//		}
//		ModelAndView mav = new ModelAndView("page");
//		mav.addObject("StartMessage",StartMessage);
//		return mav;
//	}
//	@RequestMapping(value="/test/{StartMessage}")
//	public ModelAndView test(@PathVariable("StartMessage")String StartMessage) {
//		if(StartMessage == null) {
//			StartMessage = "Hello";
//		}
//		ModelAndView mav = new ModelAndView("page");
//		mav.addObject("StartMessage",StartMessage);
//		return mav;
//	}
}
