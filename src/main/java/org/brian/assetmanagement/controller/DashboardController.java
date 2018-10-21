package org.brian.assetmanagement.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import org.brian.assetmanagement.config.FXMLSceneManager;
import org.brian.assetmanagement.view.ViewResolver;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class DashboardController extends AbstractTemplateController {

	private static final Logger LOG = getLogger(DashboardController.class);

	@Autowired
	@Lazy
	private FXMLSceneManager sceneManager;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		LOG.info("Inside DashboardController::initialize");
	}

	@FXML
	public void handleHyperLinkForward(ActionEvent event) throws IOException {
		/**
		 * facade pattern implemented here. dashboard is the facade or interface which
		 * provides interraction with multiple controllers. once the scene is switched,
		 * the corresponding controller takes over the control from dashboard.
		 */
		Hyperlink currentLink = (Hyperlink) event.getSource();
		LOG.info("inside handleHyperLinkForward. Event trigerred from: " + currentLink.getText());
		delegateToFacade(currentLink.getText());
	}

	private void delegateToFacade(String sourceName) {
		switch (sourceName) {
		case "View Assets":
			sceneManager.switchScene(ViewResolver.ASSETS);
			break;
		case "Add New Asset":
			// will add corresponding file once completed.
			sceneManager.switchScene(ViewResolver.DASHBOARD);
			break;
		case "View Employees":
			sceneManager.switchScene(ViewResolver.EMPLOYEES);
			break;
		case "Add New Employee":
			// will add corresponding file once completed.
			sceneManager.switchScene(ViewResolver.DASHBOARD);
			break;
		case "View Vendors":
			sceneManager.switchScene(ViewResolver.VENDORS);
			break;
		case "Add New Vendor":
			// will add corresponding file once completed.
			sceneManager.switchScene(ViewResolver.DASHBOARD);
			break;
		}
	}
}