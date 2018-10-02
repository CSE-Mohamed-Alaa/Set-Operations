package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SetsInputController {
	@FXML
	private TextField universeTextField;
	@FXML
	private TextField numberField;
	
	@FXML private Label errorLabel;

	private Set[] sets;

	@FXML
	private void nextButton() throws Exception {
		boolean universeError = !Set.setUniverse(universeTextField.getText());
		int numOfSets = getSetsNum();
		if (noErrors(universeError, numOfSets)) {
			sets = new Set[numOfSets];
			goNextScene(errorLabel, "Set Subsets Scene.fxml");
		}
	}
	
	private int getSetsNum() {
		try {
			return Integer.parseInt(numberField.getText());
		} catch (NumberFormatException e) {
			return 0;
		}
	}
	
	private boolean noErrors(boolean universeError,int numOfSets) {
		boolean ans = false;
		if(universeError) {
			errorLabel.setText("Error, Can't enter the Universe Set!!");	
		}
		else if (numOfSets == 0) {
			errorLabel.setText("Failed to get the number of Subsets!!");	
		}
		else if (numOfSets > 26) {
			errorLabel.setText("The number of Subsets must be equal or less than 26!!");
		}else {
			ans = true;
		}
		
		return ans;
	}

	private void goNextScene(Node ref, String fxmlFilePass) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFilePass));
        Parent root = loader.load();
        SetSubsetsController setSubsetsController = loader.getController();
        setSubsetsController.setChoiseBox(sets.length);
        setSubsetsController.passInfo(sets);
        Stage primaryStage = (Stage) ref.getScene().getWindow();
        primaryStage.setScene(new Scene(root, 700, 500));
        
	}
}
