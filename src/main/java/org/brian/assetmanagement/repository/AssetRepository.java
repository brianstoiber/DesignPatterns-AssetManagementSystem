package org.brian.assetmanagement.repository;

import java.util.List;
import org.brian.assetmanagement.bean.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
	Asset findBySerial(String serial);

	List<Asset> findByAssigned(String assignedTo);
}