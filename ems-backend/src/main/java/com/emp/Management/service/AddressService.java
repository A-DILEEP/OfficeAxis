package com.emp.Management.service;

import java.util.List;

import com.emp.Management.entity.Address;

public interface AddressService {
	Address createAddress(Address address);
	void deleteAddress(Long id);
	Address updateAddress(Long id,Address address);
	Address getAddressById(Long id);
	List<Address>getAllAddress();
}
