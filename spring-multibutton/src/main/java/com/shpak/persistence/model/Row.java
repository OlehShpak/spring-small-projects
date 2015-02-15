package com.shpak.persistence.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="datagrid")
public class Row implements Comparable<Row> {
	
	@Id  
	@GeneratedValue 
	private Long id; 
	
	@Column(name = "iam_char")
	private String iAmLikeChar;
	
	@Column(name = "iam_string")
	private String iAmString;
	
	@Column(name = "iam_date")
	private Date iAmDate;
	
	@Column(name = "iam_bigdecimal", precision = 18, scale = 4)
	private BigDecimal iAmBigDecimal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getiAmLikeChar() {
		return iAmLikeChar;
	}

	public void setiAmLikeChar(String iAmLikeChar) {
		this.iAmLikeChar = iAmLikeChar;
	}

	public String getiAmString() {
		return iAmString;
	}

	public void setiAmString(String iAmString) {
		this.iAmString = iAmString;
	}

	public Date getiAmDate() {
		return iAmDate;
	}

	public void setiAmDate(Date iAmDate) {
		this.iAmDate = iAmDate;
	}

	public BigDecimal getiAmBigDecimal() {
		return iAmBigDecimal;
	}

	public void setiAmBigDecimal(BigDecimal iAmBigDecimal) {
		this.iAmBigDecimal = iAmBigDecimal;
	}

	@Override
	public int compareTo(Row o) {
		
		if(this.id-o.id>0){
			return 1;
		} else {
		return -1;
		}
	}
	
	@Override
	public String toString() {
		return "Row [id=" + id + ", iAmChar=" + iAmLikeChar + ", iAmString="
				+ iAmString + ", iAmDate=" + iAmDate + ", iAmBigDecimal="
				+ iAmBigDecimal + "]";
	}

	public Row(){}
	
	public Row(Long id, String iAmLikeChar, String iAmString, Date iAmDate,
			BigDecimal iAmBigDecimal) {
		super();
		this.id = id;
		this.iAmLikeChar = iAmLikeChar;
		this.iAmString = iAmString;
		this.iAmDate = iAmDate;
		this.iAmBigDecimal = iAmBigDecimal;
	}

}
