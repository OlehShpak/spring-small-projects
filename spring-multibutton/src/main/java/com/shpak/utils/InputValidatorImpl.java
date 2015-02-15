package com.shpak.utils;

import org.springframework.stereotype.Service;

import com.shpak.persistence.model.Row;

@Service
public class InputValidatorImpl implements InputValidator {

	@Override
	public String validateEditedRow(Row row) {
		
		if(row.getId()==null){
			return "Please fill all fields";
		} else if(row.getiAmBigDecimal()==null){
			return "Please fill the field with BigDecimal";
		} else if(row.getiAmDate()==null){
			return "Please select the Date";
		} else if(row.getiAmLikeChar().equals("")){
			return "Please fill the field with char";
		} else if(row.getiAmLikeChar().length()>1){
			return "Please fill correctly field with char";
		} else if(row.getiAmString().equals("")){
			return "Please fill the field with String";
		} else {
		return null;
		}
	}

}
