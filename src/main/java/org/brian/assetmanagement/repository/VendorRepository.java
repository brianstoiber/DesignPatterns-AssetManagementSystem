package org.brian.assetmanagement.repository;

import org.brian.assetmanagement.bean.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
	Vendor getByEmail(String email);
}