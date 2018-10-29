package org.brian.assetmanagement.service;

import java.util.List;
import org.brian.assetmanagement.bean.Vendor;

public interface VendorService {
	public void save(Vendor employee);

	public Vendor getVendor(Long employeeId);

	public void delete(Long employeeId);

	public void delete(Vendor employee);

	public List<Vendor> getAll();

	public void deleteInBatch(List<Vendor> selectedVendors);
}