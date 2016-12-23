package dad.agenda.ui;

import dad.agenda.services.jpa.utils.JPAUtil;
import javafx.application.Application;
import javafx.stage.Stage;

public class AgendaApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
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
