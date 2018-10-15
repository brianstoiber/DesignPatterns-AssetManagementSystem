package org.brian.assetmanagement.config;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import org.brian.assetmanagement.service.AssetService;
import org.brian.assetmanagement.service.impl.AssetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * used to define the application configuration. spring boot loads repositories
 * services, controller and beans based on definition here.
 */

@Configuration
@ComponentScan(basePackages = { "org.brian.assetmanagement.repository", "org.brian.assetmanagement.service" })
@EnableJpaRepositories("org.brian.assetmanagement.repository")
public class AppConfig {

	@Autowired
	JavaFXLoaderUtil springFXMLLoader;

	/**
	 * added to ensure that the service is available before controller invokes fxml
	 * stage setup
	 */
	@Bean
	public AssetService assetService() {
		return new AssetServiceImpl();
	}

	@Bean
	public ResourceBundle resourceBundle() {
		return ResourceBundle.getBundle("Bundle");
	}

	/**
	 * deal with FXML loads only after services, repositories, controllers and beans
	 * are loaded during Spring Boot startup. Otherwise one or more Spring
	 * components will remain missing.
	 */
	@Bean
	@Lazy(value = true)
	public FXMLSceneManager stageManager(Stage stage) throws IOException {
		return new FXMLSceneManager(springFXMLLoader, stage);
	}

}
