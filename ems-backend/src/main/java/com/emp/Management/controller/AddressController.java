package com.emp.Management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.Management.entity.Address;
import com.emp.Management.service.AddressService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	private AddressService addressService;
	public AddressController(AddressService addressService) {
		this.addressService=addressService;
	}
	
	@GetMapping
	public ResponseEntity<List<Address>>getAddress(){
		List<Address>myList=addressService.getAllAddress();
		
		return ResponseEntity.ok(myList);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Address>getAddressById(@PathVariable Long id){
		Address address=addressService.getAddressById(id);
		return ResponseEntity.ok(address);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Address>updateAddress(@PathVariable Long id,@RequestBody Address updatedAddress){
		Address address=addressService.updateAddress(id, updatedAddress);
		return ResponseEntity.ok(address);
	}
	
	@PostMapping
	public ResponseEntity<Address>CreateAddress(@RequestBody Address newAddress){
		Address address=addressService.createAddress(newAddress);
		
		return ResponseEntity.ok(address);
	}
	@DeleteMapping("/{id}")
	public void deleteAddress(@PathVariable Long id){
		addressService.deleteAddress(id);
	}
}

