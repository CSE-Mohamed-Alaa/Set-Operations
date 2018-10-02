package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SetsInputController {
	@FXML
	private TextField universeTextField;
	@FXML
	private TextField numberField;
	@FXML
	
	private void firstNext(){
		Set.setUniverse(universeTextField.getText());
		
	}
}
