package com.shpak.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shpak.persistence.model.Row;
import com.shpak.persistence.service.RowService;
import com.shpak.utils.InputValidator;

@Controller
public class EditController {
	
	@Autowired
	private RowService rowService;
	
	@Autowired
	private InputValidator inputValidator;
	
	@RequestMapping(value="/editRow/{idValue}", method = RequestMethod.GET)
	public String editRowGet(@PathVariable String idValue, Model model){
		
		if(idValue.equals("null")){											//Create new row and show button "Add"
		Row editedRow = new Row();
		model.addAttribute("editedRow", editedRow);
		return "editRow";
		} 
		
		Row editedRow = rowService.getRowById(Long.parseLong(idValue)); 	//Edit existing row and show button "Save"
		model.addAttribute("editedRow", editedRow);
		return "editRow";
	}
	
	@RequestMapping(value="/editRow/**", method = RequestMethod.POST)
	public String editRowPost(@ModelAttribute("editedRow") Row editedRow, Model model,
			@RequestParam(required=false, value="save") String save,
            @RequestParam(required=false, value="add") String add,
            @RequestParam(required=false, value="cancel") String cancel,
            RedirectAttributes redirectAttributes) {
		
		
		String errorMessage = inputValidator.validateEditedRow(editedRow);
		if(errorMessage != null){
			redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
			return "redirect:/editRow/"+editedRow.getId();
		}
			
		
		if (save!=null){											//Button "save" is pressed
		rowService.updateRowById(editedRow);
		
		} else if (add!=null){										//Button "add" is pressed
		rowService.addRow(editedRow);
		
		} if (cancel!=null){										//Button "cancel" is pressed
		return "redirect:/";	
		}
		
		return "redirect:/";
	}
}
