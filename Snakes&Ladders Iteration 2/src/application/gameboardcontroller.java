package application;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import model.GameConfiguration;
import model.Player;
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
	private int numOfHumanPlayers = 0;
	private int numOfComputerPlayers = 0;
	private int currentPlayer = 0;
	private String nameEntered;
	private String[] playerNameList = new String[MAX_PLAYERS];
	private String[] messages = {"Enter first players name", 
			"Enter second players name", "Enter Third players name", 
			"Enter fourth players name"};

	
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
    private TextField playerNameTextField;
    
    @FXML
    private GridPane gameGrid;
  
    @FXML
    void submitButton(MouseEvent event) {
      	playerNameText.setText(messages[currentPlayer]);
    }
    
    @FXML
    void submitPlayerName(MouseEvent event) {
    	if (currentPlayer < numOfHumanPlayers) {
	    	playerNameList[currentPlayer] = nameEntered;
	      	playerNameTextField.clear();
	       	currentPlayer++;
	       	if (currentPlayer == numOfHumanPlayers) {
	       		playerNameText.setText("Press the start game button");
	       	} else {
	       		playerNameText.setText(messages[currentPlayer]);
	       	}
    	} 
    }
    
    @FXML
    void playerNameKeyTyped(KeyEvent event) {
    	nameEntered = playerNameTextField.getText();
    }
    
    @FXML
    void startButtonClicked(MouseEvent event) {
    	playerNameText.setText("Game has started!");
    	GameConfiguration gc = new GameConfiguration("GUIBased");
    	for (currentPlayer = 0; currentPlayer < numOfHumanPlayers; currentPlayer++) {
    		gc.addPlayer(new Player("human", playerNameList[currentPlayer]), currentPlayer);
    	}
    	for (; currentPlayer < (numOfHumanPlayers + numOfComputerPlayers); currentPlayer++) {
    		gc.addPlayer(new Player("AI", "C" + (currentPlayer)), currentPlayer);
    	}
    	for (; currentPlayer < MAX_PLAYERS; currentPlayer++) {
    		gc.addPlayer(new Player(), currentPlayer);
    		
    	}
    	gc.GUIrun();
    }
    
    @FXML
    void onDiceClick(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert playerNameText != null : "fx:id=\"playerNameText\" was not injected: check your FXML file 'Gameboard.fxml'.";
        assert numOfHumans != null : "fx:id=\"numOfHumans\" was not injected: check your FXML file 'Gameboard.fxml'.";
        assert diceIndicatorImage != null : "fx:id=\"diceIndicatorImage\" was not injected: check your FXML file 'Gameboard.fxml'.";
        assert rollDice != null : "fx:id=\"rollDice\" was not injected: check your FXML file 'Gameboard.fxml'.";
        assert numOfComp != null : "fx:id=\"numOfComp\" was not injected: check your FXML file 'Gameboard.fxml'.";
        assert currentTurnLabel != null : "fx:id=\"currentTurnLabel\" was not injected: check your FXML file 'Gameboard.fxml'.";
        assert playerNameTextField != null : "fx:id=\"PlayerNameEntered\" was not injected: check your FXML file 'Gameboard.fxml'.";
        assert gameGrid != null : "fx:id=\"gameGrid\" was not injected: check your FXML file 'Gameboard.fxml'.";

        numOfHumans.setItems(FXCollections.observableArrayList(numOfPlayers));
    	numOfHumans.getSelectionModel().selectedIndexProperty().addListener(
    			new	ChangeListener<Number>() {
    				@Override
    				public void changed(ObservableValue observable, Number oldValue, 
        					Number newValue) {
        				int index = newValue.intValue();
        				if (index >= 0) {
        					numOfHumanPlayers = index + 1;
        					setComps(numOfHumanPlayers);
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

