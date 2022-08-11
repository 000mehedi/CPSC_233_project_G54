
package application;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class withdrawFundsController {
	
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
	private TextField withdrawField;
	
	@FXML
	private Label myLabel;
	

    @FXML
    public void withdrawButton(ActionEvent event) throws FileNotFoundException, IOException {
    	
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
    	        if(data.equals(""))
    	        {
    	        	data = myReader.nextLine();
        	        data = data.replace("\n", "").replace("\r", "");
    	        }
    	        System.out.println(data);
    	        String[] arrOfCAccount = data.split(":", 5);
    	        for (String a : arrOfCAccount)
    	            System.out.println(a);
    	        // checking if the current row is emplty

    	        	double newCheqTotal = Double.parseDouble(arrOfCAccount[1]) - Double.parseDouble(withdrawField.getText());
    	        	cheq = "Chequing Account:" + Double.toString(newCheqTotal);
    	        	
    	        
      	        	String savAccountline = myReader.nextLine();
      	        	String sav = savAccountline;
    	        	savAccountline = savAccountline.replace("\n", "").replace("\r", "");
        	        String[] arrOfSAccount = savAccountline.split(":", 2);
        	        for (String a : arrOfSAccount)
        	            System.out.println(a);
        	        
    	      
    	      myReader.close();
    	      
	            FileWriter myWriter = new FileWriter("currentAccount.txt");
	            BufferedWriter bw = new BufferedWriter(myWriter);
	            PrintWriter out = new PrintWriter(bw);
	            out.println(name1);
	            out.println(accNo1);
	            out.println(cheq);
	            out.println(sav);
	            
	            out.close();
	            bw.close();
	            myWriter.close();
    	      
    	    } catch (FileNotFoundException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
    	
    	
		  }  	
}
