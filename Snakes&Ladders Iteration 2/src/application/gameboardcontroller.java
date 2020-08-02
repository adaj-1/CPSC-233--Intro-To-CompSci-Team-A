package application;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import model.GameConfiguration;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class GameboardController {
	
	private static final int MAX_PLAYERS = 4;
	
	private String[] numOfPlayers = {"1","2","3","4"};
	
	private int numOfHumansPlayers = 0;
	
	private int numOfComputerPlayers = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label playerNameText;

    @FXML
    private ChoiceBox<String> numOfHumans;

    @FXML
    private ImageView diceIndicatorImage;

    @FXML
    private Button rollDice;

    @FXML
    private ChoiceBox<String> numOfComp;

    @FXML
    private Label currentTurnLabel;

    @FXML
    private TextField PlayerNameTextField;
    
    @FXML
    private Button submit;

    @FXML
    private GridPane gameGrid;
  
    @FXML
    void submitButton(MouseEvent event) {
    	GameConfiguration gc = new GameConfiguration();
    	gc.GUIGameSetup(numOfHumansPlayers,numOfComputerPlayers);
    	
    	// fill PlayerNameTextField
    }
    
    @FXML
    void PlayerNameEntered(KeyEvent event) {

    }
    
    @FXML
    void onDiceClick(MouseEvent event) {

    }
    
    @FXML
    void submitPlayerName(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert playerNameText != null : "fx:id=\"playerNameText\" was not injected: check your FXML file 'Gameboard.fxml'.";
        assert numOfHumans != null : "fx:id=\"numOfHumans\" was not injected: check your FXML file 'Gameboard.fxml'.";
        assert diceIndicatorImage != null : "fx:id=\"diceIndicatorImage\" was not injected: check your FXML file 'Gameboard.fxml'.";
        assert rollDice != null : "fx:id=\"rollDice\" was not injected: check your FXML file 'Gameboard.fxml'.";
        assert numOfComp != null : "fx:id=\"numOfComp\" was not injected: check your FXML file 'Gameboard.fxml'.";
        assert currentTurnLabel != null : "fx:id=\"currentTurnLabel\" was not injected: check your FXML file 'Gameboard.fxml'.";
        assert PlayerNameTextField != null : "fx:id=\"PlayerNameEntered\" was not injected: check your FXML file 'Gameboard.fxml'.";
        assert gameGrid != null : "fx:id=\"gameGrid\" was not injected: check your FXML file 'Gameboard.fxml'.";

        numOfHumans.setItems(FXCollections.observableArrayList(numOfPlayers));
    	numOfHumans.getSelectionModel().selectedIndexProperty().addListener(
    			new	ChangeListener<Number>() {
    				@Override
    				public void changed(ObservableValue observable, Number oldValue, 
        					Number newValue) {
        				int index = newValue.intValue();
        				if (index >= 0) {
        					numOfHumansPlayers = index + 1;
        					setComps(numOfHumansPlayers);
        					}
        				}
    				}
    			);
    }
    
    public void setComps(int numOfHum) {
    	String[] numOfComputer = new String[MAX_PLAYERS - numOfHum];
    	for (int i = 0; i < (MAX_PLAYERS - numOfHum); i++) {
    		numOfComputer[i] = numOfPlayers[i];
    	}
    	numOfComp.setItems(FXCollections.observableArrayList(numOfComputer));
    	numOfComp.getSelectionModel().selectedIndexProperty().addListener(
    		new	ChangeListener<Number>() {
    			@Override
    			public void changed(ObservableValue observable, Number oldValue,
    					Number newValue) {
    				int index = newValue.intValue();
    				if (index >= 0) {
    					numOfComputerPlayers = index + 1;
    				}
    			}
    		}
    	);
    }
    
    public void refresh() {
    	
    }
    
}

