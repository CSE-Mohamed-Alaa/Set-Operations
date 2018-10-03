package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SetSubsetsController {

	@FXML
	private TextField subSetTextField;

	@FXML
	private ChoiceBox<String> setNameChoiseBox;

	@FXML
	private Label errorLabel;

	private Set[] sets;

	// like a constructor for information
	public void passInfo(Set[] sets) {
		this.sets = sets;
		setChoiseBox(sets.length);
	}

	public void setChoiseBox(int numOfSets) {
		char x = 'A';
		for (int i = 0; i < numOfSets; i++) {
			setNameChoiseBox.getItems().add(Character.toString(x));
			x++;
		}
		setNameChoiseBox.getSelectionModel().select(0);
	}

	@FXML
	void addSet(ActionEvent event) {
		int idx = setNameChoiseBox.getSelectionModel().getSelectedIndex();
		String setName = setNameChoiseBox.getSelectionModel().getSelectedItem();
		sets[idx] = new Set();
		boolean error = !sets[idx].setSet(subSetTextField.getText());
		
		if (!subSetTextField.getText().matches("(\\s*\\w+\\s*)*(,\\s*\\w+\\s*)*")) {
			errorLabel.setTextFill(Color.RED);
			errorLabel.setText("Error, Can't enter " + setName + " Set!!");		
		} else if (error) {
			errorLabel.setTextFill(Color.RED);
			errorLabel.setText(setName + " has elements not existing in Universe set!!");
		} else {

			errorLabel.setTextFill(Color.GREEN);
			errorLabel.setText(setName + " has been set successfully");
		}
	}

	@FXML
	void back(ActionEvent event) throws Exception {
		sets = null;
		backScene(errorLabel, "Sets Input Scene.fxml");
	}

	@FXML
	void next(ActionEvent event) throws Exception {
		for (int i = 0; i < sets.length; i++) {
			if (sets[i] == null) {
				sets[i] = new Set();
			}
		}
		nextScene(errorLabel, "Operation Scene.fxml");
	}

	private void backScene(Node ref, String fxmlFilePass) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFilePass));
		Parent root = loader.load();
		Stage primaryStage = (Stage) ref.getScene().getWindow();
		primaryStage.setScene(new Scene(root, 700, 500));

	}
	private void nextScene(Node ref, String fxmlFilePass) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFilePass));
		Parent root = loader.load();
		OperationController x = loader.getController();
		x.setSets(sets);
		Stage primaryStage = (Stage) ref.getScene().getWindow();
		primaryStage.setScene(new Scene(root, 700, 500));

	}

}
