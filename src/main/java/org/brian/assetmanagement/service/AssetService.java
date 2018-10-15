package org.brian.assetmanagement.service;

import java.util.List;
import org.brian.assetmanagement.bean.Asset;

public interface AssetService {
	public void save(Asset asset);

	public Asset getOneAsset(Long id);

	public void delete(Long id);

	public void delete(Asset asset);

	public List<Asset> getAll();
}