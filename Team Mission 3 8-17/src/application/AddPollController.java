/**
 *This class will handle naming each of the poll that the application tracks.
 *
 * @version 3.0 13 August 2020
 *@author Nathan Jung
 */

package application;

import model.InvalidSetupDataException;
import model.Poll;
import model.PollList;
import model.PollListFullException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

import javafx.collections.FXCollections;

public class AddPollController extends PollTrackerController{
	/**
	 * This label is for the drop down of list of current polls
	 */
    @FXML
    private Label currentPolls;
	/**
	 * This Button is used for naming a poll
	 */
    @FXML
    private Button addPoll;

	/**
	 * This label indicates to enter a name of a poll into a text field
	 */
    @FXML
    private Label PollName;
	/**
	 * This button is used for clearing all inputs.
	 */

    @FXML
    private Button clearUserFields;

	/**
	 * This choice box contains the list of Poll names that will be 
	 * used in a poll list
	 */
    @FXML
    private ChoiceBox<String> pollDropDown;
    
    /**
     * This text field is where the user can input the Poll name into
     * of their choice to replace the current place holder names
     */
    @FXML
    private TextField userInput;

    @FXML
    private Label errorLabel;

    	
   /**
 	* This method handles the event when the clear button is clicked.
 	* It clears all input.
 	* @param event
 	*/
    @FXML
    void clear(ActionEvent event) {
    		userInput.clear();
    		refresh();
    }
    
    /**
     * This method handles the event when the addPoll button is clicked. 
     * It will take the name entered in the text box and then replace the poll name that was selected from the drop down.
     *  
     * @param event
     */
    @FXML
    void addPoll(ActionEvent event) {
    	Poll randomPolls=getFactory().createRandomPoll(userInput.getText());
    	Poll[] poll=getPollList().getPolls();
    	
    	int indexNum=pollDropDown.getSelectionModel().getSelectedIndex();
    	poll[indexNum]=randomPolls;
    	
    	try {
    	PollList newList=new PollList(poll.length,getPollList().getNumOfSeats());
    	for(int i=0;i<poll.length;i++) {
    		try {
				newList.addPoll(poll[i]);
				errorLabel.setText("");
			} catch (PollListFullException e) {
				// TODO Auto-generated catch block
				errorLabel.setText("Error, PollList is Full!");
			}
    	}
    	setPollList(newList);
    	} catch (InvalidSetupDataException isde) {
    		isde.getMessage();
    	}
    }

    /**
     * This method refreshes the list of polls with any changes made from the 
     * text field and the drop down of the desired poll name to change.
     * Outputs a message to indicate a refresh has been made.
     */
	@Override
	public void refresh() {
//		if (getPollList().getPolls() == null) {
///			pollDropDown.isVisible(false);
	//	}
		try {
		ArrayList<String> pollList=new ArrayList<String>();
		Poll[] poll=getPollList().getPolls();
		for(int i=0;i<poll.length;i++) {
			pollList.add(poll[i].getPollName());
		}
			pollDropDown.setItems(FXCollections.observableArrayList(pollList));
			
		
		userInput.clear();
		} catch (NullPointerException npe) {
			
		}
	}
}