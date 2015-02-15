package com.shpak.persistence.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shpak.config.PersistenceConfig;
import com.shpak.persistence.model.Row;

@ContextConfiguration(classes = PersistenceConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RowServiceTests {

	@Autowired
	protected RowService rowService;
	
	@Test
	public void deleteById(){
		
		rowService.deleteById(2L);
		
		Row row = rowService.getRowById(2L);
		assertNull(row);
		
	}
	
	@Test
	public void getRowById(){
		
		Row row = rowService.getRowById(1L);
		assertTrue(row.getId().equals(1L));
		
	}
	@Test
	public void updateRow(){
		
		Row row = new Row(5L, "z","Updated string",java.sql.Date.valueOf( "2010-01-19" ),new BigDecimal(14454.323));
		rowService.updateRowById(row);
		
		assertEquals("z", rowService.getRowById(5L).getiAmLikeChar());
		assertEquals("Updated string", rowService.getRowById(5L).getiAmString());
		assertEquals(java.sql.Date.valueOf( "2010-01-19" ), rowService.getRowById(5L).getiAmDate());
		assertEquals(new BigDecimal(14454.323).setScale(4, BigDecimal.ROUND_HALF_UP), rowService.getRowById(5L).getiAmBigDecimal());
	}
	

	@Test
	public void getAllRows(){
		
		List<Row> rowList = rowService.getAllRows();
		assertEquals(9, rowList.size());
		
	}
	
	
}
