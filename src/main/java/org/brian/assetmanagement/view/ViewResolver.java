package org.brian.assetmanagement.view;

import java.util.ResourceBundle;

/**
 * ViewResolver enum helps in resolving the right fxml file and switching scenes.
 * This is used in FXMLSceneManager.switchScene().
 */
public enum ViewResolver {

	ASSETS {
		@Override
		public String getTitle() {
			return getStringFromResourceBundle("asset.title");
		}

		@Override
		public String getFxmlFile() {
			return "/Assets.fxml";
		}
	},
	ASSET_DETAILS {
		@Override
		public String getTitle() {
			return getStringFromResourceBundle("assetdetails.title");
		}

		@Override
		public String getFxmlFile() {
			return "/AssetDetails.fxml";
		}
	},
	EMPLOYEES {
		@Override
		public String getTitle() {
			return getStringFromResourceBundle("employee.title");
		}

		@Override
		public String getFxmlFile() {
			return "/Employees.fxml";
		}
	};

	public abstract String getTitle();

	public abstract String getFxmlFile();

	String getStringFromResourceBundle(String key) {
		return ResourceBundle.getBundle("Bundle").getString(key);
	}

}