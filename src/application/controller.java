package application;

<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

=======
import javafx.event.ActionEvent;
>>>>>>> mahira-dev
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

<<<<<<< HEAD
public class controller{
	@FXML
	void buttonGetStarted(ActionEvent event) throws IOException{
		VBox root = FXMLLoader.load(getClass().getResource("src/secondScreen/secondScreen.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		
	}
=======
public class controller {

    @FXML
    void createNewAccount(ActionEvent event) {

    }

    @FXML
    void depositFunds(ActionEvent event) {

    }

    @FXML
    void withdrawFunds(ActionEvent event) {

    }

    @FXML
    void myAccounts(ActionEvent event) {

    }

    @FXML
    void quit(ActionEvent event) {

    }

>>>>>>> mahira-dev
}