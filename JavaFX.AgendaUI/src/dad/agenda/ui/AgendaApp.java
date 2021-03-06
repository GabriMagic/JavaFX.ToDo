package dad.agenda.ui;

import dad.agenda.services.jpa.utils.JPAUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AgendaApp extends Application {
	BorderPane view;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
		loader.setController(this);
		view = loader.load();
		
		primaryStage.setScene(new Scene(view));
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception {
		super.stop();
		System.out.println("Deteniendo la aplicación JavaFX");
		JPAUtil.closeEntityManagerFactory();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
