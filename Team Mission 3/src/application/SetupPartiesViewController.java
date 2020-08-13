/**
 * This controller class allows the user to edit the name for each of 
 * the parties in the election. 
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

    /**
     * This choice box contains the list of party names that will be 
     * used in the polls.
     */    	
	@FXML
    private ChoiceBox<String> partyDropDown;

	/**
     * This text field is where the user can input the party names
     * of their choice to replace the current place holder names.
     */ 
    @FXML
    private TextField PartyNameTextBox;

    /**
     * This method is invoked when the Clear button is selected. It will
     * clear all changes made to the party names and then it will pull the
     * list of party names through refresh.
     * 
     * @param event
     */ 
    @FXML
    void clear(ActionEvent event) {
    	refresh();
    }

    /**
     * This method is invoked when the Set Party Info button is selected.
     * It will then take the text from the Text Field and set it as the party name
     * of whichever party was selected from the choice box.
     * @param event
     */ 
    @FXML
    void PartyInfo(ActionEvent event) {
    	/* index stores the index of the selected party name from the choice box */
    	int index = partyDropDown.getSelectionModel().getSelectedIndex();
    	/* sets the party name to user input from text field */
    	partyDropDown.getItems().set(index, PartyNameTextBox.getText()); 
    	PartyNameTextBox.clear(); // clears text field
    }
    
    /**
     * This method is invoked when the Submit Party Info button is selected.
     * It will then take all the choice box party names and set the party names
     * in factory to the users inputs.
     * @param event
     */ 
    @FXML
    void SubmitPartyInfo(ActionEvent event) {
    	/* This block grabs party names from choice box and creates new string[] with its length*/
    	ArrayList<String> newPartyNamesList = new ArrayList<String>(partyDropDown.getItems());
    	String[] newPartyNames = new String[newPartyNamesList.size()];
    	
    	/* This block passes the choice box values into the new string[]*/
    	for (int i = 0; i < newPartyNamesList.size(); i++) {
    		newPartyNames[i] = newPartyNamesList.get(i);
    	}   
    	getFactory().setPartyNames(newPartyNames); // sets party names to user input for application
    }   
    
    /**
     * This method fills the choice box with the party names that are set for the
     * entire application.
     */ 
	@Override
	public void refresh() {		
		String[] partyNames = getFactory().getPartyNames(); // gets party names from application
		partyDropDown.setItems(FXCollections.observableArrayList(partyNames));	// sets choice box to party names from application
	}
}
