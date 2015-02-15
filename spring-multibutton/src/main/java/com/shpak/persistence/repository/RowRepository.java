package com.shpak.persistence.repository;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shpak.persistence.model.Row;

@Transactional(readOnly = true)
public interface RowRepository extends JpaRepository<Row, Long> {
	
	@Modifying
	@Transactional
	@Query("delete from Row r where r.id = :id")
	void deleteById(@Param("id") Long id );
	
	@Modifying
	@Transactional
	@Query("update Row r set r.iAmLikeChar=:c, r.iAmString=:s, r.iAmDate=:d, r.iAmBigDecimal=:b where r.id=:id")
	void updateRowById(@Param("id")Long id,@Param("c")String c, @Param("s")String s,@Param("d")Date d, @Param("b")BigDecimal b);
	
}
