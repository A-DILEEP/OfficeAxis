package com.emp.Management.service.imp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.Management.entity.Address;
import com.emp.Management.exception.ResourceNotFoundException;
import com.emp.Management.repository.AddressRepository;
import com.emp.Management.service.AddressService;

@Service
public class AddressServiceImp implements AddressService {
	
	private AddressRepository addressRepository;
	public AddressServiceImp(AddressRepository addressRepository) {
		this.addressRepository=addressRepository;
	}
	@Override
	public Address createAddress(Address address) {
		Address SavedAddress=addressRepository.save(address);
		return SavedAddress;
	}
	@Override
	public void deleteAddress(Long id) {
		Address deleteAddress=addressRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Address Not found with id:"+id));
		addressRepository.delete(deleteAddress);
		
	}
	@Override
	public Address updateAddress(Long id,Address updatedAddress) {
		Address address=addressRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Address not found with id:"+id));
		address.setCity(updatedAddress.getCity());
		address.setState(updatedAddress.getState());
		address.setEmployee(updatedAddress.getEmployee());
		return address;
	}
	
	@Override
	public Address getAddressById(Long id) {
		Address address=addressRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Address not found with id:"+id));
		return address;
	}
	@Override
	public List<Address> getAllAddress() {
		List<Address> allAddress=addressRepository.findAll();
		return allAddress;
	}
	
}
