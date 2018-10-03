package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OperationController {
	private Set[] sets;
	@FXML
    private ChoiceBox<String> set1;

    @FXML
    private ChoiceBox<String> operation;

    @FXML
    private VBox vboxSet2;

    @FXML
    private ChoiceBox<String> set2;
    @FXML
    private Label answerLabel;
    @FXML
    void back(ActionEvent event) throws Exception {
    	backScene(operation, "Set Subsets Scene.fxml");
    }
    private void backScene(Node ref, String fxmlFilePass) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFilePass));
		Parent root = loader.load();
		Stage primaryStage = (Stage) ref.getScene().getWindow();
		primaryStage.setScene(new Scene(root, 700, 500));

	}
    @FXML
    void calculate(ActionEvent event) {
    	int operationIdx = operation.getSelectionModel().getSelectedIndex();
    	int set1Idx = set1.getSelectionModel().getSelectedIndex();
    	int set2Idx = set2.getSelectionModel().getSelectedIndex();
    	String ans = null;
    	switch (operationIdx) {
		case 0:
			ans = sets[set1Idx].toString(sets[set1Idx].union(sets[set2Idx].getSet()));
			break;
		case 1:
			ans = sets[set1Idx].toString(sets[set1Idx].intersection(sets[set2Idx].getSet()));
			break;
		case 2:
			ans = sets[set1Idx].toString(sets[set1Idx].comp());
			break;
		}
    	answerLabel.setText(ans);
    	
    }
	public void setSets(Set[] sets) {
		this.sets = sets;
		setChoiseBox(sets.length, set1);
		setChoiseBox(sets.length, set2);
		setOperations();
	}
	private void setOperations() {
		operation.getItems().addAll("Union","Intersection","Complement");
		operation.getSelectionModel().select(0);
		operation.getSelectionModel().selectedIndexProperty().addListener((e,oldValue,newValue) -> {
			if(newValue.equals(2)) {
				vboxSet2.setDisable(true);
			}else {
				vboxSet2.setDisable(false);
			}
		});
	} 
	private void setChoiseBox(int numOfSets,ChoiceBox<String> setNameChoiseBox) {
		char x = 'A';
		for (int i = 0; i < numOfSets; i++) {
			setNameChoiseBox.getItems().add(Character.toString(x));
			x++;
		}
		setNameChoiseBox.getSelectionModel().select(0);
	}
	
}
