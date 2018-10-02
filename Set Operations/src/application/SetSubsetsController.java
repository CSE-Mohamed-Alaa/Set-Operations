package application;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SetSubsetsController{
	
    @FXML
    private TextField subSetTextField;

    @FXML
    private ChoiceBox<String> setNameChoiseBox;

    @FXML
    private Label errorLabel;
	
	private Set[] sets;
	
	//like a constructor for information
	public void passInfo(Set[] sets){
		this.sets = sets;
	}
	
	public void setChoiseBox(int numOfSets) {
		char x = 'A';
		for (int i = 0; i < numOfSets; i++) {
			setNameChoiseBox.getItems().add(Character.toString(x));
			x++;
		}
		setNameChoiseBox.getSelectionModel().select(0);
	}

}
