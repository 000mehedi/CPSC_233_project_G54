package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
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

public class loginController {
	private Stage stage;
	private Scene scene;

	
	@FXML
	private TextField nameField;
	
	@FXML
	private TextField accNumberField;
	

    
    @FXML
    public void logIn(ActionEvent event) throws FileNotFoundException, IOException {
    	
    	try {
    	      File myObj = new File("accountDatabase.txt");
    	      Scanner myReader = new Scanner(myObj);
    	      System.out.println("Absolute path: " + myObj.getAbsolutePath());
    	      while (myReader.hasNextLine()) {
    	        String data = myReader.nextLine();
    	        data = data.replace("\n", "").replace("\r", "");
    	        if(data.equals(""))
    	        {
      	        	if(myReader.hasNextLine())
      	        		data = myReader.nextLine();
      	        	else
      	        		break;
        	        data = data.replace("\n", "").replace("\r", "");
    	        }
    	        System.out.println(data);
    	        String[] arrOfName = data.split(":", 5);
    	        for (String a : arrOfName)
    	            System.out.println(a);
    	        // checking if the current row is emplty

    	        if(arrOfName[1].equals(nameField.getText()))
    	        {
    	        	String name1 = arrOfName[0] + ":" + arrOfName[1];
    	        	String accNumberLine = myReader.nextLine();
    	        	String accNo = accNumberLine; 
    	        	accNumberLine = accNumberLine.replace("\n", "").replace("\r", "");
        	        String[] arrOfNumber = accNumberLine.split(":", 2);
        	        for (String a : arrOfNumber)
        	            System.out.println(a);
        	        if(arrOfNumber[1].equals(accNumberField.getText()))
        	        {
        	        	String cheqAcc = myReader.nextLine();
        	        	
        	        	String savAcc = myReader.nextLine();
        	        	// write the details to a new file
        	    	    try {
        	    	        File myObj1 = new File("currentAccount.txt");
        	    	        myObj1.createNewFile();
        	    		            	System.out.println("File created: " + myObj1.getName());
        	    		            	
        	    			            FileWriter myWriter = new FileWriter("currentAccount.txt");
        	    			            BufferedWriter bw = new BufferedWriter(myWriter);
        	    			            PrintWriter out = new PrintWriter(bw);
        	    			            out.println(name1);
        	    			            out.println(accNo);
        	    			            out.println(cheqAcc);
        	    			            out.println(savAcc);
        	    			            
        	    			            out.close();
        	    			            bw.close();
        	    			            myWriter.close();

        	    	              
        	    	        

        	              } catch (IOException e) {
        	                System.out.println("An error occurred.");
        	                e.printStackTrace();
        	    	      } 
        	        	
        	    		FXMLLoader loader = new FXMLLoader();
        	    		VBox root = loader.load(new FileInputStream("src/screens/screen1.fxml"));
        	        	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        	        	scene = new Scene(root);
        	        	stage.setScene(scene);
        	        	stage.show();
        	        	

        	        	break;
        	        }
        	        else {
        	        	System.out.println("Number not present");
        	        }
    	        }
    	        else {
    	        	System.out.println("Name not present");
    	        }
    	      }
    	      myReader.close();
    	    } catch (FileNotFoundException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
    	
    	
		  }  	
		
    }
    



