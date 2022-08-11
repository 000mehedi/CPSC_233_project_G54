package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class myAccountController {
	
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
	private Label cheqField;
	
	@FXML
	private Label savField;
	
    @FXML
    public void showCurrentBalance(ActionEvent event) throws FileNotFoundException, IOException {
    	
    	try {
    	      File myObj = new File("currentAccount.txt");
    	      Scanner myReader = new Scanner(myObj);
    	      System.out.println("Absolute path: " + myObj.getAbsolutePath());

    	        String data = myReader.nextLine();
    	        String name1 = data;
    	        
    	        data = myReader.nextLine();
    	        String accNo1 = data;
    	        
    	        data = myReader.nextLine();
    	        String cheq = data;
    	        
    	        data = data.replace("\n", "").replace("\r", "");

    	        System.out.println(data);
    	        String[] arrOfCAccount = data.split(":", 5);
    	        for (String a : arrOfCAccount)
    	            System.out.println(a);

    	        	String cheqTotal = arrOfCAccount[1];
    	        	cheqField.setText(cheqTotal);
    	        	
  
      	        	String savAccountline = myReader.nextLine();
      	        	String sav = savAccountline;
    	        	savAccountline = savAccountline.replace("\n", "").replace("\r", "");
        	        String[] arrOfSAccount = savAccountline.split(":", 2);
        	        for (String a : arrOfSAccount)
        	            System.out.println(a);

        	        	String savTotal = arrOfSAccount[1];
        	        	savField.setText(savTotal);
        	        	
        	        

    	        
        	        
    	      
    	      myReader.close();
    	      
    	      
    	    } catch (FileNotFoundException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
    	
    	
		  } 

}
