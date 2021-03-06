package org.brian.assetmanagement.view;

import java.util.ResourceBundle;

/**
 * ViewResolver enum helps in resolving the right fxml file and helps with
 * switching scenes. this is used in FXMLSceneManager.switchScene().
 */
public enum ViewResolver {

    DASHBOARD {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("dashboard.title");
        }

        @Override
        public String getFxmlFile() {
            return "/Dashboard.fxml";
        }
    },
    VENDORS {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("vendor.title");
        }

        @Override
        public String getFxmlFile() {
            return "/Vendors.fxml";
        }
    },
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
    EMPLOYEE_DETAILS {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("employeedetails.title");
        }

        @Override
        public String getFxmlFile() {
            return "/EmployeeDetails.fxml";
        }
    },
    VENDOR_DETAILS {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("vendordetails.title");
        }

        @Override
        public String getFxmlFile() {
            return "/VendorDetails.fxml";
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