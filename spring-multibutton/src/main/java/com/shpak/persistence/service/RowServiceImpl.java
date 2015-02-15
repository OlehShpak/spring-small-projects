package com.shpak.persistence.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shpak.persistence.model.Row;
import com.shpak.persistence.repository.RowRepository;

@Service
public class RowServiceImpl implements RowService {

	@Autowired
	private RowRepository rowRepository;
	
	@Override
	public void addRow(Row row) {
		rowRepository.saveAndFlush(row);
	}

	@Override
	public void deleteById(Long id) {
		rowRepository.deleteById(id);
		
	}

	@Override
	public List<Row> getAllRows() {
		List<Row> list = rowRepository.findAll();
		Collections.sort(list);
		return list;
	}

	@Override
	public Row getRowById(Long id) {
		return rowRepository.findOne(id);
	}

	@Override
	public void updateRowById(Row row) {
		rowRepository.updateRowById(row.getId(),row.getiAmLikeChar(),row.getiAmString(),row.getiAmDate(),row.getiAmBigDecimal());
		
	}

}
