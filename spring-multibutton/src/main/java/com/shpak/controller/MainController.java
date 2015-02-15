package com.shpak.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shpak.persistence.model.SelectedRows;
import com.shpak.persistence.model.Row;
import com.shpak.persistence.service.RowService;

@Controller
public class MainController {
	
	@Autowired
	private RowService rowService;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String buildGridGet(Model model){
		
		List<Row> rows=rowService.getAllRows();
		SelectedRows selectedRows = new SelectedRows();
		model.addAttribute("rowList", rows);
		model.addAttribute("selectedRows", selectedRows);
		return "main";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String buildGridPost(@ModelAttribute SelectedRows selectedRows, Model model,
			@RequestParam(required=false, value="refresh") String refresh,
            @RequestParam(required=false, value="delete") String delete,
            @RequestParam(required=false, value="edit") String edit){
		
		if (refresh!=null){									//Button "refresh" is pressed
			
			List<Row> rows=rowService.getAllRows();
			model.addAttribute("rowList", rows);
			return "main";	
			
		} else if (delete!=null){							//Button "delete" is pressed
			
		List<String> idList = selectedRows.getIdHolder();
		if(idList!=null){
		for(String id:idList){
			rowService.deleteById(Long.parseLong(id));	
				}
			}
		
		} else if (edit!=null){								//Button "edit" is pressed
		
			List<String> idList = selectedRows.getIdHolder();

			if (null==idList) {								// No rows selected 
			return "redirect:/editRow/null";
				
			} else if(idList.size()==1){					// Selected 1 row
			return "redirect:/editRow/"+idList.get(0);
				
			} else if(idList.size()>1){						// Selected more than 1 row
			List<Row> rows=rowService.getAllRows();
			model.addAttribute("rowList", rows);
			model.addAttribute("warning", "warning");
			return "main";
				
			} 
		}
		
		List<Row> rows=rowService.getAllRows();
		model.addAttribute("rowList", rows);
		return "main";
	}
	
	
	
}
