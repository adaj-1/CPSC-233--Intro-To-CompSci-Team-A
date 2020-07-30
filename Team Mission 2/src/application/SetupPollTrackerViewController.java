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

        String[] factoryNames = getFactory().getPartyNames(); //{"1","2","3","4","5","6","7","8"};
        
        String[] partyNames = new String[party];
        
        for (int i = 0; i < party; i++) {
        	partyNames[i] = factoryNames[i];
        }

        getFactory().setPartyNames(partyNames);
        
        PollList list = getFactory().createRandomPollList(10);
        setPollList(list);

    }

    /**
     * This method handles the event when the clear button
     * is clicked. It clears all input from all text areas.
     * @param event
     */

    @FXML
    public void clearButton(ActionEvent event) {

        poll.clear();
        seats.clear();
        parties.clear();

    }

    @Override
    public void refresh() {

    }
}
