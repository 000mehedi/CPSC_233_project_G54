package application;


import java.io.BufferedReader;
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

import javafx.scene.layout.VBox;

import javafx.stage.Stage;


public class mainController {
	private Stage stage;
	private Scene scene;

	
    @FXML
    public void backToWelcomeScreen(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
		VBox root = loader.load(new FileInputStream("src/screens/mainScreen.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
    	

    }

    @FXML
    void depositFunds(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	VBox root = loader.load(new FileInputStream("src/screens/depositFunds.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();

    }

    @FXML
    void withdrawFunds(ActionEvent event) throws IOException {

    	FXMLLoader loader = new FXMLLoader();
    	VBox root = loader.load(new FileInputStream("src/screens/withdrawButton.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();    	
    }

    @FXML
    void myAccounts(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
    	VBox root = loader.load(new FileInputStream("src/screens/myAccounts.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();    	

    }
    
    @FXML
    void transferFunds (ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
    	VBox root = loader.load(new FileInputStream("src/screens/transferFunds.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();    	

    }

    @FXML
    void quit(ActionEvent event) throws IOException {
    	try {
  	      File myOb = new File("currentAccount.txt");
  	      Scanner myRead = new Scanner(myOb);
  	      System.out.println("Absolute path: " + myOb.getAbsolutePath());

  	        String data1 = myRead.nextLine();
  	        String name1 = data1;
  	        String[] arrOfName1 = data1.split(":", 5);
  	   
  	        data1 = myRead.nextLine();
  	        String accNo1 = data1;
  	        String[] arrOfNumber1 = accNo1.split(":", 2);
  	        
  	        data1= myRead.nextLine();
  	        String cheq = data1;
  	        
  	        data1 = myRead.nextLine();
  	        String sav = data1;
    		
  	      File myObj = new File("accountDatabase.txt");
  	      Scanner myReader = new Scanner(myObj);
  	      System.out.println("Absolute path: " + myObj.getAbsolutePath());
  	      
  	      File myObj1 = new File("temp.txt");
  	      myObj1.createNewFile();
	      FileWriter myWriter = new FileWriter("temp.txt");
	      BufferedWriter bw = new BufferedWriter(myWriter);	
	      PrintWriter out = new PrintWriter(bw);
  	        
  	      while (myReader.hasNextLine()) {
  	        String data = myReader.nextLine();
  	        String name2 = data;
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
  

  	        if(arrOfName[1].equals(arrOfName1[1]))
  	        {
  	        	out.println(name1);
  	        	String accNumberLine = myReader.nextLine();
  	        	String accNo = accNumberLine; 
  	        	accNumberLine = accNumberLine.replace("\n", "").replace("\r", "");
      	        String[] arrOfNumber = accNumberLine.split(":", 2);
      	        for (String a : arrOfNumber)
      	            System.out.println(a);
      	        if(arrOfNumber[1].equals(arrOfNumber1[1]))
      	        {
      	        	
      	        	String tempy1 = myReader.nextLine();
      	        	String tempy2 = myReader.nextLine();
      	        	out.println(accNo);
      	        	out.println(cheq);
      	        	out.println(sav);
      	        	out.println();
      	        	
      	        	
      	        	

      	        	break;
      	        }
      	        else {
      	   
      	        	out.println(accNo);
      	        }
  	        }
  	        else {
  	        	out.println(name2);
  	        }
  	      }
  	      myReader.close();
  	      out.close();
          bw.close();
          myWriter.close();
          
          boolean delete = myObj.delete();
          boolean b = myObj1.renameTo(myObj);
  	    } catch (FileNotFoundException e) {
  	      System.out.println("An error occurred.");
  	      e.printStackTrace();
  	    }
  	
  	
		    
    }



}
