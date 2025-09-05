package com.emp.Management.dto;

public class AddressDto {
	private Long id;
	private String city;
	private String state;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public AddressDto(Long id, String city, String state) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
	}
	
}
