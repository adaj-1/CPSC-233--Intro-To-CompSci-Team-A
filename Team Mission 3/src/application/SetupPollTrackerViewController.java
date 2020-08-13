/**
 * This controller allows the user to keep a
 * track of polls by specifying the number of
 * seats and parties in the election and by
 * providing the number of polls to track.
 *
 * @author Arlina Dey
 * @version 29.07.2020
 */
package application;

import model.Factory;
import model.InvalidSetupDataException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import model.PollList;

public class SetupPollTrackerViewController extends PollTrackerController{

    /**
     * Clear button clears all fields in the text area.
     * Submit button submits all fields from text area.
     */
    @FXML
    Button clear = new Button("clear");
    @FXML
    Button submit = new Button("submit");

    /**
     * These are the text areas where the user can
     * specify the amount of polls, seats, & parties
     */
    @FXML
    TextArea poll = new TextArea("poll");
    @FXML
    TextArea seats = new TextArea("seats");
    @FXML
    TextArea parties = new TextArea("parties");

    /**
     * This is a method that handles the event
     * when the submit button is clicked.
     * It submits the user input from all 3 text areas.
     * @param event
     */
    @FXML
    public void submitButton(ActionEvent event) {

        int polls = Integer.parseInt(poll.getText());
        int seat = Integer.parseInt(seats.getText());
        int party = Integer.parseInt(parties.getText());

        System.out.println("polls: " + polls);
        System.out.println("seats: "+ seat);
        System.out.println("parties: "+ party);
        
	/**
         * This sets the party names in factory and creates
         * a new poll list showing polls and seats available.
         */
        Factory factory = new Factory(seat);  
        setFactory(factory);
        
        String[] factoryNames = getFactory().getPartyNames();
        String[] partyNames = new String[party];
        
	/* This takes in the number of parties from the user*/
        PollList list = null;
        for (int i = 0; i < party; i++) {
        	partyNames[i] = factoryNames[i];
        }

        getFactory().setPartyNames(partyNames);        
		try {
			list = getFactory().promptForPollList(polls);
		} catch (InvalidSetupDataException e) {
			//handle error here
		}
		if (list != null) {
			setPollList(list); 
		}
    }

    /**
     * This method handles the event when the clear button
     * is clicked. It clears all input from all text areas.
     * @param event
     */

    @FXML
    public void clearButton(ActionEvent event) {
    	refresh();
    }
    
    /**
     * This method clears all information in this view
     * and brings it back to default view.
     */	
    @Override
    public void refresh() {
        poll.clear();
        seats.clear();
        parties.clear();
    }
    
}
