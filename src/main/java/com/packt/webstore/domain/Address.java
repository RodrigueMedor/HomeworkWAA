package com.packt.webstore.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Address {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

 	private String street;
	private String city;
	
 	private String state;

  	private String zipCode;

	@OneToOne(mappedBy = "address")
  	private Employee employee;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
