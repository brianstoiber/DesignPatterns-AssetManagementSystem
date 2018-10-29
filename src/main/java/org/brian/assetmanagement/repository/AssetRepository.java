package org.brian.assetmanagement.repository;

import org.brian.assetmanagement.bean.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
	Asset findBySerial(String serial);
}