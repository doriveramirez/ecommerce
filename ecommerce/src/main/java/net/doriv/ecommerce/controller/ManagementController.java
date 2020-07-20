package net.doriv.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.doriv.ecommerce.util.FileUploadUtility;
import net.doriv.ecommerce.validator.ItemValidator;
import net.doriv.onlineshop.dao.CatalogDAO;
import net.doriv.onlineshop.dao.ItemDAO;
import net.doriv.onlineshop.dto.Catalog;
import net.doriv.onlineshop.dto.Item;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CatalogDAO catalogDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/items",method=RequestMethod.GET)
	public ModelAndView showManageItems(@RequestParam(name="operation", required=false) String operation) {
		ModelAndView mav= new ModelAndView("page");
		mav.addObject("userClickManageItems", true);
		mav.addObject("title","Manage Items");
		Item item = new Item();
		item.setActive(true);
		mav.addObject("item",item);
		if(operation!=null) {
			if(operation.equals("item")) {
				mav.addObject("message", "Item added successfully.");
			} else if (operation.equals("catalog")) {
				mav.addObject("message","Catalog added succesfully.");
			}
		}
		return mav;
	}
	
	@RequestMapping(value="/{id_item}/item", method=RequestMethod.GET)
	public ModelAndView EditProduct(@PathVariable("id_item") int id) {
		ModelAndView mav= new ModelAndView("page");
		mav.addObject("userClickManageItems", true);
		mav.addObject("title","Manage Items");
		Item item = itemDAO.get(id);
		mav.addObject("item",item);
		return mav;
	}
	
	@RequestMapping(value="/items", method=RequestMethod.POST)
	public String handleItemSubmission(@Valid @ModelAttribute("item") Item newItem, BindingResult results, Model model, HttpServletRequest request) {
		if(newItem.getId_item() == 0) {
			new ItemValidator().validate(newItem, results);
		} else {
			if(!newItem.getFile().getOriginalFilename().equals("")) {
				new ItemValidator().validate(newItem, results);
			}
		}
		if(results.hasErrors()) {
			model.addAttribute("userClickManageItems", true);
			model.addAttribute("title", "Manage Items");
			return "page";
		}
		if(newItem.getId_item() == 0) {
			itemDAO.add(newItem);
		} else {
			itemDAO.update(newItem);
		}
		if(!newItem.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, newItem.getFile(), newItem.getCode());
		}
		return "redirect:/manage/items?operation=item";
	}
	
	@RequestMapping(value = "/item/{id_item}/activation/", method=RequestMethod.POST)
	@ResponseBody
	public String handleItemActivation(@PathVariable("id_item") int id) {
		Item item = itemDAO.get(id);
		boolean active = item.isActive();
		item.setActive(!item.isActive());
		itemDAO.update(item);
		return (active)? "Deactivated " + item.getName() + "." : "Activated " + item.getName() + ".";
	}
	
	@RequestMapping(value="/catalog/", method=RequestMethod.POST)
	public String handleCatalogSubmission(@ModelAttribute Catalog catalog) {
		catalogDAO.add(catalog);
		return "redirect:/manage/items?operation=catalog";
	}
	
	@ModelAttribute("catalogs")
	public List<Catalog> getCatalogs(){
		return catalogDAO.List();
	}
	
	@ModelAttribute("catalog")
	public Catalog getCatalog() {
		return new Catalog();
	}
}
