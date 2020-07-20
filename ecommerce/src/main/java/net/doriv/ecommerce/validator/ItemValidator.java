package net.doriv.ecommerce.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.doriv.onlineshop.dto.Item;

public class ItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Item item = (Item) target;
		if(item.getFile() == null || item.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "You must select an image file.");
			return;
		}
		if(!(item.getFile().getContentType().equals("image/jpeg")) || (item.getFile().getContentType().equals("image/png")) || (item.getFile().getContentType().equals("image/gif"))){
			errors.rejectValue("file", null, "The format must be jpg/jpeg, png or gif.");
			return;
		}
	}

}
