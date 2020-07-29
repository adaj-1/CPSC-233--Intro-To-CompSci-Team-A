/**
 * This class handles all of the data related to displaying a list
 * of party data (ie. amount of seats and votes) as well as calculations
 * to edit specific party data in a poll. 
 * 
 * This class also displays an aggregate of all party data which is
 * updated when the user makes changes to individual parties and polls 
 * 
 * @version 1.0 28 July 2020
 * @author Luke Couture
 */
package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import model.Party;
import java.lang.Math;

public class EditPollViewController extends PollTrackerController {
	private Float seatInput;
	private Float voteInput;
	private String currentParty;
	private int currentPoll;
	String[] parties;
	String[] polls;
	
	/**
	 * totalSeats displays the amount of total seats available in the
	 * given election
	 */
	@FXML
	private Label totalSeats;
	
	/**
	 * updatePartyButton updates the selected party data in the
	 * selected poll with the data that has been entered
	 */
    @FXML
    private Button updatePartyButton;

    /**
     * clearButton clears all of the fields in the window
     */
    @FXML
    private Button clearButton;
    
    /**
     * This is the text field where the user can specify the amount of
     * votes they would like to set for the selected party and poll
     */
    @FXML
    private TextField projectedPercentOfVotes;
    
    /**
     * This is the text field where the user can specify the amount of
     * seats they would like to set for the selected party and poll
     */
    @FXML
    private TextField projectedNumOfSeats;
    
    /**
     * This choice box contains the list of polls that the user can edit
     */
    @FXML
    private ChoiceBox<String> pollToEdit;
    
    /**
     * This choice box contains the list of parties that the user can edit
     */
    @FXML
    private ChoiceBox<String> partyToUpdate;

    /**
     * This is the method that handles the event when the clear button is
     * clicked by clearing all fields in the window.
     * 
     * This method resets:
     * poll list choice box
     * party list choice box
     * party seats text field
     * party votes text field
     * 
     * @param event
     */
    @FXML
    void clearButtonClicked(ActionEvent event) {
       	pollToEdit.getItems().clear();
    	refresh();
    }
    
    /**
     * This method handles the event when the update party button is
     * clicked by updating the selected party within the selected poll.
     * 
     * If no party is selected when the update button is clicked, the
     * method will do nothing.
     * 
     * The method also clears any information stored from either text
     * fields after it is run.
     * 
     * @param event
     */
    @FXML
    void updatePartyButtonClicked(ActionEvent event) {
	    if (currentParty != null) {
	    	
	    	Party oldPartyData = getPollTrackerApp().getPolls().getPolls()[currentPoll].
			getParty(currentParty);
	    	
	    	if (seatInput == null) {
	    		seatInput = oldPartyData.getProjectedNumberOfSeats();
	    	} if (voteInput == null) {
	    		voteInput = oldPartyData.getProjectedPercentageOfVotes();
	    	}
	    	
	    	Party aParty = new Party(currentParty, seatInput, voteInput);
	    	getPollList().getPolls()[currentPoll].addParty(aParty);
	    	
	    	seatInput = null;
	    	voteInput = null;
	    }
    }


    /**
     * This method handles the event when information is typed into
     * the text field for editing number of seats.
     * 
     * @param event
     */
    @FXML
    void numberOfSeatsKeyTyped(KeyEvent event) {
    	seatInput = Float.parseFloat(projectedNumOfSeats.getText());
    }
    

    /**
     * This method handles the event when information is typed into
     * the text field for editing percentage of votes.
     * 
     * @param event
     */
    @FXML
    void percentageOfVoteKeyTyped(KeyEvent event) {
    	voteInput = Float.parseFloat(projectedPercentOfVotes.getText()) / 100;
    }
    
    /**
     * After a poll is selected in the poll list choice box, this method
     * takes that poll as an argument and displays data for all of the parties 
     * in that poll in the party list choice box.
     * 
     * Information displayed is:
     * amount of projected seats
     * amount of projected votes
     * 
     * @param currentPoll
     */
    public void setParties(int currentPoll) {
    	String[] parties = getPollTrackerApp().getFactory().getPartyNames();
    	String[] partyDisplayList = new String[parties.length];
    	
    	for (int i = 0; i < parties.length; i++) {
    		Party partyData = getPollTrackerApp().getPolls().
    				getPolls()[currentPoll].getParty(getPollTrackerApp().getFactory().
    						getPartyNames()[i]);
    		
    		partyDisplayList[i] = parties[i] + " (" + 
    		Math.round(partyData.getProjectedPercentageOfVotes() * 100) + "% of votes, " + 
    				Math.round(partyData.getProjectedNumberOfSeats()) + " seats)";
    	}

    	partyToUpdate.setItems(FXCollections.observableArrayList(partyDisplayList));
    	partyToUpdate.getSelectionModel().selectedIndexProperty().addListener(
    		new	ChangeListener<Number>() {
    			@Override
    			public void changed(ObservableValue observable, Number oldValue,
    					Number newValue) {
    				int index = newValue.intValue();
    				if (index >= 0) {
    					currentParty = parties[index];
    				}
    			}
    		}
    	);
    }
    
    /**
     * This method resets the data in the text fields and choice
     * boxes in the window.
     * 
     * This method resets:
     * party list choice box
     * party seats text field
     * party votes text field
     * 
     */
    public void resetFields() {
    	seatInput = null;
    	voteInput = null;
    	partyToUpdate.getItems().clear();
    	projectedPercentOfVotes.setText("");
    	projectedNumOfSeats.setText("");
    }
    
    /**
     * This method gathers a list of all of the polls and adds them to
     * the poll list choice box.
     * 
     * Once a poll is selected, this method also calls setParties in order
     * to fill the party list choice box as well
     */
	@Override
	public void refresh() {
		totalSeats.setText("/" + Integer.toString(getPollTrackerApp().getPolls().
				getNumOfSeats()));
    	int pollLength = getPollList().getPolls().length;

    	
		String[] polls = new String[pollLength];
    	int i = 0;
		for (; i < pollLength; i++) {
    		polls[i] = "Poll" + i;
    	}
		
		pollToEdit.setItems(FXCollections.observableArrayList(polls));
    	pollToEdit.getSelectionModel().selectedIndexProperty().addListener(
    		new	ChangeListener<Number>() {
    			@Override
    			public void changed(ObservableValue observable, Number oldValue, 
    					Number newValue) {
    				int index = newValue.intValue();
    				if (index >= 0) {
    					currentPoll = index;
    					setParties(index);
    				}
    			}
    		}
    	);
    	resetFields();
	}


}
