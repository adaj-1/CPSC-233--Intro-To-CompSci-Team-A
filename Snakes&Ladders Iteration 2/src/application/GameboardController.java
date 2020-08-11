package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import model.Player;
import model.BlankPlayer;
import model.Computer;
import model.GameConfiguration;
import model.Human;
import javafx.animation.AnimationTimer;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

// Grass: https://graphicriver.img.customer.envatousercontent.com/files/121477694/grass_0020_background_AM_IPr.jpg?auto=compress%2Cformat&fit=crop&crop=top&w=590&h=590&s=f8259506302be4a30a682963b6a72d71
// Snake : https://w7.pngwing.com/pngs/461/577/png-transparent-rattlesnake-a-silver-ring-snake-png-material-ring-animals.png
// Ladder : https://img.favpng.com/21/0/14/tangyuan-ladder-png-favpng-vYBUNXKvN2rEgxSFipAxSNNyN.jpg

public class GameboardController {
	private static final int MAX_PLAYERS = 4;
	private static final int FINISHING_SPACE = 100;
	private int numOfHumanPlayers = 0;
	private int numOfComputerPlayers = 0;
	private int currentPlayer = 0;
	private int currentPlayerTurn = 0;						// keeps track whose turn it is
	private  int totalPlayers;
	private int oldPosition;
	private int newPosition;
	private int roll;
	private int totalMove;
	private String nameEntered;					// string of player name entered
	private String[] numOfPlayers = {"1","2","3","4"};
	private String[] playerNameList = new String[MAX_PLAYERS];
	private String[] messages = {"Enter first players name", 
								 "Enter second players name", 
								 "Enter third players name", 
								 "Enter fourth players name"};
	private String[] computerNames = {"CP1", "CP2", "CP3", "CP4"};
	private int[] columns = {0,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,0,		// indices of columns in gridpane
							 0,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,0,
							 0,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,0,
							 0,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,0,
							 0,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,0};
	private int[] rows = {9,9,9,9,9,9,9,9,9,9,8,8,8,8,8,8,8,8,8,8,			// indices of rows in gridpane
						  7,7,7,7,7,7,7,7,7,7,6,6,6,6,6,6,6,6,6,6,
						  5,5,5,5,5,5,5,5,5,5,4,4,4,4,4,4,4,4,4,4,
						  3,3,3,3,3,3,3,3,3,3,2,2,2,2,2,2,2,2,2,2,
						  1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0};
	private ArrayList<Circle> tokens = new ArrayList<Circle>();				// holds game tokens
	private GameConfiguration gc;		// initializes the GUI
	Boolean[] toggleDiceDisable;
	Color[] playerTokenColors = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW}; 
	
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
    private Button rollDice;

    @FXML
    private Button startButton;
    
    @FXML
    private Button setPlayers;
    
    @FXML
    private Button submitPlayerNameButton;
    
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
    private ImageView snake47;
    
    @FXML
    private ImageView grass;
    
    @FXML
    private ImageView dieImage;
   
    /**
     * takes user input for # of human players and # of computer players for GUI setup
     * @param event
     */
    @FXML
    void submitButton(MouseEvent event) {
      	playerNameText.setText(messages[getCurrentPlayerTurn()]);				// sets text to show whose turn
      	totalPlayers = numOfHumanPlayers + numOfComputerPlayers;	// total players based on user input
     /* the below section creates the player tokens based on total number of players inputed */
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
        setPlayers.setDisable(true);
        numOfHumans.setDisable(true);
        numOfComp.setDisable(true);
        playerNameTextField.setDisable(false);
    }
    
    /**
     *  allows users to input custom player name
     * @param event
     */
    @FXML
    void submitPlayerName(MouseEvent event) {
    	if (currentPlayer < numOfHumanPlayers) {
	    	playerNameList[currentPlayer] = nameEntered;	// adds user input player name
	      	playerNameTextField.clear();
	      	currentPlayer++;
	       	if (currentPlayer == numOfHumanPlayers) {
	       		playerNameTextField.setDisable(true);
	       		startButton.setDisable(false);
	       		playerNameText.setText("Press the start game button");
	       	} else {
	       		playerNameText.setText(messages[currentPlayer]);
	       	}
    	} 	
    	submitPlayerNameButton.setDisable(true);
    }
    
    /**
     * gets player name from textfield 
     * @param event
     */
    @FXML
    void playerNameKeyTyped(KeyEvent event) {
    	nameEntered = playerNameTextField.getText();
    	submitPlayerNameButton.setDisable(false);
    }
    
    /**
     * creates GUI game by creating # of human players and # of computer players inputed
     * @param event
     */
    @FXML
    void startButtonClicked(MouseEvent event) {
    	gc = new GameConfiguration("GUIBased");
    	toggleDiceDisable = new Boolean[totalPlayers];
    	
    	if (!(numOfComputerPlayers >= 0)) {
    		numOfComputerPlayers = 0;
    	}
    	playerNameText.setText("Game has started!");	// lets player know the game has started
    	/* The below section of code creates the necessary amount of human/computer players */
    	for (currentPlayer = 0; currentPlayer < numOfHumanPlayers; currentPlayer++) {
    		gc.addPlayer(new Human(playerNameList[currentPlayer]), currentPlayer);
    		toggleDiceDisable[currentPlayer] = false;
    	}
    	
    	for (; currentPlayer < (totalPlayers); currentPlayer++) {
    		gc.addPlayer(new Computer("C" + (currentPlayer)), currentPlayer);
    		toggleDiceDisable[currentPlayer] = true;
    	}
    	
    	for (; currentPlayer < MAX_PLAYERS; currentPlayer++) {
    		gc.addPlayer(new BlankPlayer(), currentPlayer);
    	}
    	
    	if (numOfHumanPlayers < totalPlayers) {
    		int index = numOfHumanPlayers;
    		for (int i = 0;index < totalPlayers; i++) {
    			playerNameList[index] = computerNames[i];
    			index++;
    		} 
    	}    	
    	currentplayerText.setText(playerNameList[getCurrentPlayerTurn()]);
    	currentplayerText.setTextFill(Color.BLUE);
    	rollDice.setDisable(false);
    	startButton.setDisable(true);
    }
    
    /**
     * checks to see if the game has not been won yet and will roll the dice to move
     * @param event
     */
    @FXML
    void onDiceClick(MouseEvent event) {
    	checkWin();
    	if (!checkWin()) {
	    	rollDice.setDisable(true);
	    	move();
	    	spinningDice = new Roller();
	    	spinningDice.start();
			turnCounter();
			refresh();
    	}
    }
    
    /**
     * asks for user input on how many human and computer players
     */
    @FXML
    void initialize() {
    	dieImage.setImage(new Image("images/die.png"));
    	rollDice.setDisable(true);
    	startButton.setDisable(true);
    	submitPlayerNameButton.setDisable(true);
    	playerNameTextField.setDisable(true);
    	setPlayers.setDisable(true);
    	numOfHumans.setItems(FXCollections.observableArrayList(numOfPlayers));
    	numOfHumans.getSelectionModel().selectedIndexProperty().addListener(
    			new	ChangeListener<Number>() {
    				@Override
    				public void changed(ObservableValue observable, Number oldValue, 
        					Number newValue) {
        				int index = newValue.intValue();
        				if (index >= 0) {
        					numOfHumanPlayers = index + 1;
        					setPlayers.setDisable(false);
        					setComps(numOfHumanPlayers);
        				}
        			}
    			}
    	);    	
    }
    
    /**
     * sets up computer players based on user input
     * @param numOfHum
     */
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
    
    /**
     * keeps track of player turns 
     */
    public void turnCounter() { 
    	if (getCurrentPlayerTurn() == (totalPlayers - 1)) {
			this.currentPlayerTurn = 0;
		} else {
			this.currentPlayerTurn++;
		}
    	rollDice.setDisable(toggleDiceDisable[getCurrentPlayerTurn()]);
    	setPlayerTurnColor();
    	currentplayerText.setText(playerNameList[getCurrentPlayerTurn()]);
	}
	
    /**
     * getter method for keeping track of player turn
     * @return
     */
	public int getCurrentPlayerTurn() {
		return currentPlayerTurn;
	}
	
	/**
	 *  Checks to see if any players have won
	 * @return true if a player has won, false if not
	 */
	public boolean checkWin() {	   
	   for (int i = 0; i < totalPlayers; i++) {
		   if (gc.getPlayer().get(i).getPosition() == FINISHING_SPACE) {
			   rollDice.setDisable(true);
			   yourRoll.setText(gc.getPlayer().get(i).getName() + " has won!");
			   return true;
		   }
	   }
	   return false;
   }
   
   	public void refresh(){
   		if (toggleDiceDisable[getCurrentPlayerTurn()]) {
   			move();
	   		turnCounter();
	  		refresh();
   		} 
   	}
   
    /**
     * moves players on GUI and checks whether they have landed on a snake or ladder
     */
    public void move() {
    	if (!checkWin()) {  		
    		
    		oldPosition = gc.getPlayer().get(getCurrentPlayerTurn()).getPosition();	
    		String name = gc.getPlayer().get(getCurrentPlayerTurn()).getName();
    		gc.getPlayer().get(getCurrentPlayerTurn()).MovePlayerGUI();
    		roll = gc.getPlayer().get(getCurrentPlayerTurn()).getDiceRoll();
    		newPosition = gc.getPlayer().get(getCurrentPlayerTurn()).getPosition();
    		totalMove = newPosition - oldPosition;
    		
    		gameGridTop.getChildren().remove(tokens.get(getCurrentPlayerTurn()));
           	gameGridTop.add(tokens.get(getCurrentPlayerTurn()),
           					columns[newPosition - 1], rows[newPosition - 1]);
    		
           	setPlayerRollColor();
           	
    		if (totalMove > 0 && totalMove <= 6) {
        		yourRoll.setText(name + " rolled a " + roll + " and landed on " + newPosition);
        	} else if (totalMove < 0){
        		yourRoll.setText(name + " rolled a " + roll + " and went down a snake!" + 
        						 " Landing on " + newPosition);
        	} else if (totalMove > 6) {
        		yourRoll.setText(name + " rolled a " + roll + " and went up a ladder!" + 
        						 " Landing on " + newPosition);
       		} else if (totalMove == 0) {
       			yourRoll.setText(name + " rolled over 100! Try again.");
       		}
        	} 
    	checkWin();
    }   
  
    public void setPlayerRollColor() {
       	for (int i = 0; i < totalPlayers; i++) {
       		yourRoll.setTextFill(playerTokenColors[getCurrentPlayerTurn()]);
       	}
    }
    
    public void setPlayerTurnColor() {
       	for (int i = 0; i < totalPlayers; i++) {
       		currentplayerText.setTextFill(playerTokenColors[getCurrentPlayerTurn()]);
       	}
    }
 /**
  * This method is for setting the dice image.
  * @param diceRoll This int is passed in to tell the method which image to display based on the
  * "roll" that occured.
  */
    public void setDiceImage(int diceRoll) {
    	if(diceRoll==1) {
    		dieImage.setImage(new Image("images/One.jpg"));
    	}
    	if(diceRoll==2) {
    		dieImage.setImage(new Image("images/Two.jpg"));
    	}
    	if(diceRoll==3) {
    		dieImage.setImage(new Image("images/Three.jpg"));
    	}
    	if(diceRoll==4) {
    		dieImage.setImage(new Image("images/Four.jpg"));
    	}
    	if(diceRoll==5) {
    		dieImage.setImage(new Image("images/Five.jpg"));
    	}
    	if(diceRoll==6) {
    		dieImage.setImage(new Image("images/Six.jpg"));
    	}
    }
    
 
/**
 * This creates a roller called spinningDice
 */
    private Roller spinningDice;
   
    private class Roller extends AnimationTimer{

    	private long FPS= 50L;
    	private long INTERVAL=100000000L/FPS;
    	private int MAX_ROLLS = 20;
    	private long last=0;
    
    	private int count = 0;
  
		@Override
		public void handle(long now) {
			if(now-last>INTERVAL) {
				int r = 2 + (int)(Math.random() * 5);
				setDiceImage(r);
				last=now;
				count++;
				rollDice.setDisable(true);
				if(count > MAX_ROLLS) {
					spinningDice.stop();
					count=0;
					setDiceImage(roll);
					rollDice.setDisable(false);
				}
			}
		}
    }
    
    /**
     * the below method is for iteration 3
     */
//  public void waitfor() {
//  	if (gc.getPlayer().get(getTURN()).getType() == "AI")  {
//  		try
//  		{
//  		    Thread.sleep(3000);
//  		}
//  		catch(InterruptedException ex)
//  		{
//  		    Thread.currentThread().interrupt();
//  		}	
//  	 }	
//  }
 
}