/**
 *This class will handle naming each of the poll that the application tracks.
 *
 *@version 1.0 28 July 2020
 *@author Nathan Jung
 */

package application;

import model.Poll;
import model.PollList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

import javafx.collections.FXCollections;




public class AddPollController extends PollTrackerController{
	
    @FXML
    private Label pollPlacement;

    @FXML
    private Button addPoll;

    @FXML
    private Label PollName;

    @FXML
    private Button clearUserFields;

    @FXML
    private ChoiceBox<String> pollDropDown;

    @FXML
    private TextField userInput;
    	

    @FXML
    void clear(ActionEvent event) {
    		userInput.clear();
    		pollDropDown.getSelectionModel().clearSelection();
    
    }
    
   

    @FXML
    void addPoll(ActionEvent event) {
    	Poll RandomPoll=getFactory().createRandomPoll(userInput.getText());
    	Poll[] poll=getPollList().getPolls();
    	
    	int indexNum=pollDropDown.getSelectionModel().getSelectedIndex();
    	poll[indexNum]=RandomPoll;
    	
    	PollList newList=new PollList(poll.length,getPollList().getNumOfSeats());
    	for(int i=0;i<poll.length;i++) {
    		newList.addPoll(poll[i]);
    	}
    	setPollList(newList);
    }

    @FXML
    void userInputType(ActionEvent event) {
    	
    }

	@Override
	public void refresh() {
		Poll[] poll=getPollList().getPolls();
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<poll.length;i++) {
			list.add(poll[i].getPollName());
		}
			pollDropDown.setItems(FXCollections.observableArrayList(list));
			System.out.println("Refreshing");
		
		
	}
}