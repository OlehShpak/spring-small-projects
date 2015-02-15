package com.shpak.persistence.service;

import java.util.List;

import com.shpak.persistence.model.Row;

public interface RowService {
	
	void addRow(Row row);
	
	void deleteById(Long id);
	
	List<Row> getAllRows();
	
	Row getRowById(Long id);
	
	void updateRowById(Row row);
}
