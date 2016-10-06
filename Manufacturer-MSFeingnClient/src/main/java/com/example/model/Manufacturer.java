package com.example.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="manufacturers")
public class Manufacturer {

	@Id
	private int id;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-mm-dd")
	private Date startDate;
	
	private String name;

	/*@JsonManagedReference
	private List<Product> products;
	*/
	public Manufacturer() {
		
	}

	public Manufacturer(int id, Date startDate, String name/*, List<Product> products*/) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.name = name;
		//this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}*/
	
	
}
