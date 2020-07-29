/**
 * This controller class allows the user to change the name
 * for each of the parties in the election. 
 *  
 * @version 1.0 28 July 2020
 * @author Jada Li
 */
package application;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class SetupPartiesViewController extends PollTrackerController{

    @FXML
    private ChoiceBox<String> partyDropDown;

    @FXML
    private TextField PartyNameTextBox;

    @FXML
    void clear(ActionEvent event) {
    	refresh();
    }

    @FXML
    void PartyInfo(ActionEvent event) {
    	System.out.println("setPartyInfo");
    	int index = partyDropDown.getSelectionModel().getSelectedIndex();
    	partyDropDown.getItems().set(index, PartyNameTextBox.getText());
    	PartyNameTextBox.clear();
    }

    @FXML
    void SubmitPartyInfo(ActionEvent event) {
    	System.out.println("SubmitPartyInfo");
    	ArrayList<String> newPartyNamesList = new ArrayList<String>(partyDropDown.getItems());
    	String[] newPartyNames = new String[newPartyNamesList.size()];
    	
    	for (int i = 0; i < newPartyNamesList.size(); i++) {
    		newPartyNames[i] = newPartyNamesList.get(i);
    	}   	
    	getFactory().setPartyNames(newPartyNames);
    }   
    
    @FXML
    void initialize() {     
        assert partyDropDown != null : "fx:id=\"partyDropDown\" was not injected: check your FXML file 'SetupPartiesView.fxml'.";    
        assert PartyNameTextBox != null : "fx:id=\"PartyNameTextBox\" was not injected: check your FXML file 'SetupPartiesView.fxml'.";       
    }
    
	@Override
	public void refresh() {		
		String[] partyNames = getFactory().getPartyNames();
		partyDropDown.setItems(FXCollections.observableArrayList(partyNames));	
	}
}
