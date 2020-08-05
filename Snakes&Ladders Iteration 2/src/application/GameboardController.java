package application;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import java.util.ResourceBundle;



// Snake : https://w7.pngwing.com/pngs/461/577/png-transparent-rattlesnake-a-silver-ring-snake-png-material-ring-animals.png
// Ladder : https://img.favpng.com/21/0/14/tangyuan-ladder-png-favpng-vYBUNXKvN2rEgxSFipAxSNNyN.jpg
public class GameboardController {
	private static final int MAX_PLAYERS = 4;
	private String[] numOfPlayers = {"1","2","3","4"};
	private int numOfHumanPlayers = 0;
	private int numOfComputerPlayers = 0;
	private int currentPlayer = 0;
	private String nameEntered;
	private String[] playerNameList = new String[MAX_PLAYERS];
	private String[] messages = {"Enter first players name", 
			"Enter second players name", "Enter third players name", 
			"Enter fourth players name"};
	private String[] computerNames = {"CP1", "CP2", "CP3", "CP4"};
	private ArrayList<Circle> tokens = new ArrayList<Circle>();
	private int TURN = 0;
	private GameConfiguration gc = new GameConfiguration("GUIBased");
	private int [] columns = {0,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,0,0,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,0,
			0,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,0,0,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,0,
			0,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,0};
	private int [] rows = {9,9,9,9,9,9,9,9,9,9,8,8,8,8,8,8,8,8,8,8,7,7,7,7,7,7,7,7,7,7,6,6,6,6,6,6,6,6,6,6,
			5,5,5,5,5,5,5,5,5,5,4,4,4,4,4,4,4,4,4,4,3,3,3,3,3,3,3,3,3,3,2,2,2,2,2,2,2,2,2,2,
			1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0};
	private  int totalPlayers;
	
	//private final Image SNAKE1 = ResourceLoader.getImage("src/images/SNAKE.png");
	
	@FXML
    private Circle token1;

    @FXML
    private Circle token2;
    
    @FXML
    private Circle token3;

    @FXML
    private Circle token4;

    
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
    private GridPane gameGridTop;
    
    @FXML
    private GridPane gameGridBottom;
  
    @FXML
    private Label currentplayerText;
    
    @FXML
    private Label yourRoll;
    
    @FXML
    private ImageView snake1;
    
    @FXML
    void submitButton(MouseEvent event) {
      	playerNameText.setText(messages[getTURN()]);
      	totalPlayers = numOfHumanPlayers + numOfComputerPlayers;
     
      	if (totalPlayers == 1) {
      		tokens.add(token1);	
      		token1.setOpacity(1);
      	} else if (totalPlayers == 2) {
      		tokens.add(token1);
      		tokens.add(token2);
      		token1.setOpacity(1);
    		token2.setOpacity(1);
      	}else if (totalPlayers == 3) {
      		tokens.add(token1);
      		tokens.add(token2);
      		tokens.add(token3);
      		token1.setOpacity(1);
    		token2.setOpacity(1);
    		token3.setOpacity(1);
      	}else if (totalPlayers == 4){
      		tokens.add(token1);
      		tokens.add(token2);
      		tokens.add(token3);
      		tokens.add(token4);
      		token1.setOpacity(1);
    		token2.setOpacity(1);
    		token3.setOpacity(1);
    		token4.setOpacity(1);
      	} 
    }
    
    public void TurnCounter() {  	
    	if (getTURN() == (totalPlayers - 1)) {
			this.TURN = 0;
		} else {
			this.TURN++;
		}
    	currentplayerText.setText(playerNameList[getTURN()]);
    	
	}
	

	public int getTURN() {
		return TURN;
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
    	for (currentPlayer = 0; currentPlayer < numOfHumanPlayers; currentPlayer++) {
    		gc.addPlayer(new Player("human", playerNameList[currentPlayer]), currentPlayer);
    	}
    	for (; currentPlayer < (totalPlayers); currentPlayer++) {
    		gc.addPlayer(new Player("AI", "C" + (currentPlayer)), currentPlayer);
    	}
    	for (; currentPlayer < MAX_PLAYERS; currentPlayer++) {
    		gc.addPlayer(new Player(), currentPlayer);		
    	}
    	
    	if (numOfHumanPlayers < totalPlayers) {
    		int index = numOfHumanPlayers;
    		for (int i = 0;index < totalPlayers; i++) {
    			playerNameList[index] = computerNames[i];
    			index++;
    		} 
    	}
    	System.out.println("startbutton "+ getTURN());
    	currentplayerText.setText(playerNameList[getTURN()]);
    }
    
    public void MovePlayerGUI(GameConfiguration gc) {
    	if (gc.getPlayer().get(getTURN()).getType() == "human") {
    	gc.MovePlayerGUI(gc.getPlayer().get(getTURN()));
    	int position = gc.getPlayer().get(getTURN()).getPosition() - 1;
    	
    	yourRoll.setText(gc.getPlayer().get(getTURN()).getName() + " you rolled a: " + gc.getPlayer().get(getTURN()).getHoldDiceRoll());
    	gameGridTop.getChildren().remove(tokens.get(getTURN()));
    	gameGridTop.add(tokens.get(getTURN()),columns[position],rows[position]);
    	TurnCounter();
    	System.out.println("Move Player " + getTURN());
    	} 

    }
    
    @FXML
    void onDiceClick(MouseEvent event) {
    	if (gc.getPlayer().get(getTURN()).getType() == "human") {
    		MovePlayerGUI(gc);
    		refresh();
    	} 	
   	
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
        assert gameGridTop != null : "fx:id=\"gameGrid\" was not injected: check your FXML file 'Gameboard.fxml'.";
        assert gameGridBottom != null : "fx:id=\"gameGrid\" was not injected: check your FXML file 'Gameboard.fxml'.";
        
        
        Image snake = new Image("file:src/images/SNAKE.jpg");
        ImageView imageView = new ImageView(snake);
      //  snake1.setImage(i);
        
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
    	  
    	if (gc.getPlayer().get(getTURN()).getType() == "AI")  {
    		gc.MovePlayerGUI(gc.getPlayer().get(getTURN()));
        	int position = gc.getPlayer().get(getTURN()).getPosition() - 1;
        	yourRoll.setText(gc.getPlayer().get(getTURN()).getName() + " you rolled a: " + gc.getPlayer().get(getTURN()).getHoldDiceRoll());
        	gameGridTop.getChildren().remove(tokens.get(getTURN()));
        	gameGridTop.add(tokens.get(getTURN()),columns[position],rows[position]);
        	
        	TurnCounter();
        	System.out.println("Move Player " + getTURN());
        	refresh();
    	}
    }
    
}