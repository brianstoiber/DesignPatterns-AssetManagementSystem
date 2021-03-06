package org.brian.assetmanagement.config;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * loads the fxml files on startup and allows JavaFX files to be used in Spring
 * Boot app. the static load function available from javafx.fxml.FXMLLoader
 * interferes with Spring Boot startup because components and services may not
 * be loaded properly
 */
@Component
public class JavaFXLoaderUtil {
	private final ResourceBundle resourceBundle;
	private final ApplicationContext context;

	@Autowired
	public JavaFXLoaderUtil(ApplicationContext context, ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
		this.context = context;
	}

	public Parent load(String fxmlPath) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setControllerFactory(context::getBean);
		loader.setResources(resourceBundle);
		loader.setLocation(getClass().getResource(fxmlPath));
		return loader.load();
	}
}