import javafx.application.Application;
import javafx.stage.Stage;
import view.WorldViewer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * @author Christos Dimopoulos
 * The mainProgramm class was taken from the Javafx examples given in the course website.
 */
public class MainProgram extends Application {

	/**
	 * Start the Application's Interface.
	 */
	public void start(Stage stage) {

		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			String viewerFxml = "/view/WorldViewer.fxml";
			java.net.URL url = this.getClass().getResource(viewerFxml);
			AnchorPane page = (AnchorPane) fxmlLoader.load(url.openStream());
			Scene scene = new Scene(page);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("A Tour to Botanical Gardens!");

			WorldViewer controller = (WorldViewer) fxmlLoader.getController();
			controller.Initialise();
			scene.getStylesheets().add("/view/MyStyle.css");
			stage.show();

		} catch (IOException ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
			System.exit(1);
		}
	}

	/**
	 * Launch the application.
	 * @param args Initial starting argument.
	 */
	public static void main(String args[]) {
		launch(args);
		System.exit(0);
	}
}
