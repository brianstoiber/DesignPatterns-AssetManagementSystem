package org.brian.assetmanagement.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.brian.assetmanagement.bean.Vendor;
import org.brian.assetmanagement.config.FXMLSceneManager;
import org.brian.assetmanagement.service.VendorService;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class VendorController extends AbstractTemplateController {
	private static final Logger LOG = getLogger(VendorController.class);

	@Autowired
	private VendorService vendorService;

	@FXML
	private TableView<Vendor> vendorTable;

	@FXML
	private TableColumn<Vendor, Long> colVendorId;

	@FXML
	private TableColumn<Vendor, String> colName;

	@FXML
	private TableColumn<Vendor, String> colPhoneNum;

	@FXML
	private TableColumn<Vendor, String> colEmail;

	@FXML
	private TableColumn<Vendor, String> colVendorRep;

	@Autowired
	@Lazy
	private FXMLSceneManager sceneManager;

	private ObservableList<Vendor> vendorList = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		LOG.info("Inside EmployeeController::initialize");
		vendorTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		setTableColumnProperties();
		populateVendors();
	}

	@FXML
	private void exit(ActionEvent event) {
		Platform.exit();
	}

	private void setTableColumnProperties() {
		colVendorId.setCellValueFactory(new PropertyValueFactory<>("vendorID"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colPhoneNum.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
		colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		colVendorRep.setCellValueFactory(new PropertyValueFactory<>("vendorRep"));
	}

	private void populateVendors() {
		vendorList.clear();
		createDummyVendors();
		vendorList.addAll(vendorService.getAll());
		vendorTable.setItems(vendorList);
	}

	private void createDummyVendors() {
		Vendor vendor = new Vendor();
		vendor.setVendorID(1L);
		vendor.setName("Acme");
		vendor.setPhoneNumber("555-555-5555");
		vendor.setEmail("johnsmith@email.com");
		vendor.setVendorRep("John Smith");
		vendorService.save(vendor);
		vendor = new Vendor();
		vendor.setVendorID(2L);
		vendor.setName("ABC Cleaning");
		vendor.setPhoneNumber("123-456-7890");
		vendor.setEmail("frankjones@email.com");
		vendor.setVendorRep("Frank Jones");
		vendorService.save(vendor);

	}

}