package application;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class transferFundsController implements Initializable   {
	
	
	private Stage stage;
	private Scene scene;
	
    @FXML
    public void backToAccountScreen(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
		VBox root = loader.load(new FileInputStream("src/screens/screen1.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
    	

    }

    @FXML
    private ChoiceBox<String> toDropdown;
    
    private String[] accounts = {"Chequing" , "Savings"};

    @FXML
    private ChoiceBox<String> fromDropdown;

	@Override
	public void initialize(URL location, ResourceBundle resources)   {
		toDropdown.getItems().addAll(accounts);
		fromDropdown.getItems().addAll(accounts);
		String from = fromDropdown.getValue();
		
	
		
		}
	
	

		
	}
	
	
	
	


