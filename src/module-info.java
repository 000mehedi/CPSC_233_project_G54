module CPSC_233_project_G54 {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
}
