package net.doriv.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.doriv.ecommerce.exception.NotFoundException;
import net.doriv.onlineshop.dao.CatalogDAO;
import net.doriv.onlineshop.dao.ItemDAO;
import net.doriv.onlineshop.dto.Catalog;
import net.doriv.onlineshop.dto.Item;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CatalogDAO catalogDAO;
	@Autowired
	private ItemDAO itemDAO;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("page");
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
	public ModelAndView showCatalog(@PathVariable("id_catalog") int id) throws NotFoundException {
		ModelAndView mav = new ModelAndView("page");
		Catalog catalog = null;
		catalog = catalogDAO.get(id);
		if(catalog == null) throw new NotFoundException();
		mav.addObject("title",catalog.getName());
		mav.addObject("catalogs", catalogDAO.List());
		mav.addObject("catalog", catalog);
		mav.addObject("userClickCatalog",true);
		return mav;
	}
	
	@RequestMapping(value = { "/show/{id_item}/item" })
	public ModelAndView showItem(@PathVariable("id_item") int id) throws NotFoundException {
		ModelAndView mav = new ModelAndView("page");
		Item item = itemDAO.get(id);
		if(item == null) throw new NotFoundException();
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
}
