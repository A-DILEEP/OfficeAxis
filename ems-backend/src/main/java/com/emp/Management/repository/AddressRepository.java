package com.emp.Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.emp.Management.entity.Address;
public interface AddressRepository extends JpaRepository<Address, Long> {

}
