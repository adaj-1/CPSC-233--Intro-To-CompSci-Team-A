/**
 * This class controls the FXML file that creates the GUI and pulls all other classes together.
 * All images used are cited below:
 * Grass: https://graphicriver.img.customer.envatousercontent.com/files/121477694/grass_0020_background_AM_IPr.jpg?auto=compress%2Cformat&fit=crop&crop=top&w=590&h=590&s=f8259506302be4a30a682963b6a72d71
 * Snake : https://w7.pngwing.com/pngs/461/577/png-transparent-rattlesnake-a-silver-ring-snake-png-material-ring-animals.png
 * Ladder : https://img.favpng.com/21/0/14/tangyuan-ladder-png-favpng-vYBUNXKvN2rEgxSFipAxSNNyN.jpg
 * 6 Sided Die: https://www.dreamstime.com/stock-image-faces-set-dice-image3177911 / https://thumbs.dreamstime.com/b/faces-set-dice-3177911.jpg
 * Die: https://www.clipartkey.com/mpngs/m/21-215814_six-sided-dice-6-sided-die-png.png
 * @version 3.0 11 August 2020
 * @author Jada Li, Nathan Jung, Luke Couture, and Arlina Dey
 *
 */

package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import model.BlankPlayer;
import model.Computer;
import model.GameConfiguration;
import model.Human;
import model.SnakesAndLadders;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
/**
 *
 * 
 * 
 * 
*/
public class GameboardController {
	private static final int MAX_PLAYERS = 4;					// max # of players for this game
	private static final int FINISHING_SPACE = 100;				// winning tile
	private int numOfHumanPlayers = 0;							// # of human players based on user input
	private int numOfComputerPlayers = 0;						// # of computer players based on user input
	private int currentPlayer = 0;								// keeps track of who the current player is
	private int currentPlayerTurn = 0;							// keeps track whose turn it is
	private  int totalPlayers;									// total # of players based on user input
	private int oldPosition;									// keeps track of the players old position
	private int newPosition;									// keeps track of players new position
	private int roll;											// holds the dice roll value
	private int totalMove;										// used to check how far a player has moved
	private String nameEntered;									// string of player name entered
	private String name;										// holds player name
	private String[] numOfPlayers = {"1","2","3","4"};			// used for show number of players in the choice box
	private String[] playerNameList = new String[MAX_PLAYERS];	// creates String[] of player names
	private String[] messages = {"Enter first players name", 	// String[] to prompt user for name inputs
								 "Enter second players name", 
								 "Enter third players name", 
								 "Enter fourth players name"};
	private String[] computerNames = {"CP1", "CP2", "CP3", "CP4"};			// String[] of computer player names
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
	private GameConfiguration gc;											// initializes the GUI
	Boolean[] toggleDiceDisable;											// disables and enables dice
	Color[] playerTokenColors = {Color.BLUE, Color.RED, Color.GREEN, Color.PURPLE}; 	// used to colour text based on player colour
	private SnakesAndLadders snl;
	
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
    private ImageView grass;
    
    @FXML
    private ImageView dieImage;
    
    @FXML
    private ImageView ladder4;

    @FXML
    private ImageView ladder55;
    
    @FXML
    private ImageView ladder62;

    @FXML
    private ImageView ladder51;

    @FXML
    private ImageView ladder30;
    
    @FXML
    private ImageView ladder18;
    
    @FXML
    private ImageView ladder37;

    @FXML
    private ImageView ladder41;
    
    @FXML
    private ImageView ladder87;

    @FXML
    private ImageView ladder14;

    @FXML
    private ImageView ladder58;
    
    @FXML
    private ImageView ladder73;
    
    @FXML
    private ImageView snake83;
    
    @FXML
    private ImageView snake57;
    
    @FXML
    private ImageView snake46;

    @FXML
    private ImageView snake26; 

    @FXML
    private ImageView snake93;
    
    @FXML
    private ImageView snake52;
    
    @FXML
    private ImageView snake96;
   
    @FXML
    private ImageView snake21;
    
    @FXML
    private ImageView snake80;
    
    @FXML
    private ImageView snake34;

    @FXML
    private ImageView snake16; 

    @FXML
    private ImageView snake97;
   
    /**
     * takes user input for # of human players and # of computer players for GUI setup
     * @param event is when the submit button is pressed with a mouse
     */
    @FXML
    void submitButton(MouseEvent event) {
      	playerNameText.setText(messages[getCurrentPlayerTurn()]);	// sets text to show whose turn
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
      	/**
      	 * the below section of code disables choice boxes after 
      	 * taking user input and enables player name input
      	 */ 
        setPlayers.setDisable(true);
        numOfHumans.setDisable(true);
        numOfComp.setDisable(true);
        playerNameTextField.setDisable(false);
        /* the below section of code sets player names */
        playerNameTextField.setOnKeyPressed(new 
        		EventHandler<KeyEvent>() {
        		@Override
        		public void handle(KeyEvent event) {
        			if (event.getCode().equals(KeyCode.ENTER)) {
        				submitPlayerName(null);
        			}
        		}
        		}
        );
    }
    
    /**
     * allows users to input custom player name
     * @param event is when the submit player button is pressed with a mouse
     */
    @FXML
    void submitPlayerName(MouseEvent event) {
    	if (currentPlayer < numOfHumanPlayers) {			// runs code for however many human players
	    	playerNameList[currentPlayer] = nameEntered;	// adds user input player name
	      	playerNameTextField.clear();					// clears text field
	      	currentPlayer++;
	       	if (currentPlayer == numOfHumanPlayers) {		// all human player names are entered
	       		/* the below section of code disables player name and enables start button */
	       		playerNameTextField.setDisable(true);		
	       		startButton.setDisable(false);
	       		submitPlayerNameButton.setDisable(true);
	       		playerNameText.setText("Press the start game button");
	       	} else {
	       		playerNameText.setText(messages[currentPlayer]);	
	       	}
    	} 		
    }
    
    /**
     * gets player name from text field 
     * @param event is when player name is typed into text field
     */
    @FXML
    void playerNameKeyTyped(KeyEvent event) {
    	if (currentPlayer < numOfHumanPlayers) {
	    	nameEntered = playerNameTextField.getText();	// sets player name to user input
	    	submitPlayerNameButton.setDisable(false);
	    }
    }
    
    /**
     * starts the GUI game by creating # of human players and # of computer players inputed
     * @param event is when the start button is pressed with a mouse
     */
    @FXML
    void startButtonClicked(MouseEvent event) {
    	gc = new GameConfiguration("GUIBased");			// initializes GameConfiguration;
    	toggleDiceDisable = new Boolean[totalPlayers];	// initializes toggleDiceDisable
    	
    	if (!(numOfComputerPlayers >= 0)) {
    		numOfComputerPlayers = 0;
    	}
    	playerNameText.setText("Game has started!");	// lets player know the game has started
    	/* the below section of code creates the necessary amount of human players */
    	for (currentPlayer = 0; currentPlayer < numOfHumanPlayers; currentPlayer++) {
    		gc.addPlayer(new Human(playerNameList[currentPlayer]), currentPlayer);
    		toggleDiceDisable[currentPlayer] = false;
    	}
    	/* the below section of code creates the necessary amount of computer players*/
    	for (; currentPlayer < (totalPlayers); currentPlayer++) {
    		gc.addPlayer(new Computer("C" + (currentPlayer)), currentPlayer);
    		toggleDiceDisable[currentPlayer] = true;
    	}
    	/* the below section of code creates the necessary amount of blank players */
    	for (; currentPlayer < MAX_PLAYERS; currentPlayer++) {
    		gc.addPlayer(new BlankPlayer(), currentPlayer);
    	}
    	/* the below section of code fills the playerNameList with computer names */
    	if (numOfHumanPlayers < totalPlayers) {
    		int index = numOfHumanPlayers;
    		for (int i = 0;index < totalPlayers; i++) {
    			playerNameList[index] = computerNames[i];
    			index++;
    		} 
    	}   
    	
    	currentplayerText.setText(playerNameList[getCurrentPlayerTurn()]);	// indicates whose turn it is
    	currentplayerText.setTextFill(Color.BLUE);							// sets text to player token colour
    	rollDice.setDisable(false);											// enables dice
    	startButton.setDisable(true);									
    	snl = new SnakesAndLadders();										// initializes snakes and ladders
    	setSnakesAndLadders();												// sets snakes and ladders on GUI
    }
    
    /**
     * checks to see if the game has not been won yet and will roll the dice to move
     * @param event is when the dice button is pressed with a mouse
     */
    @FXML
    void onDiceClick(MouseEvent event){
 
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
    	/* below section of code enables and disables certain functions prior to user input*/
    	dieImage.setImage(new Image("images/die.png"));
    	rollDice.setDisable(true);
    	startButton.setDisable(true);
    	submitPlayerNameButton.setDisable(true);
    	playerNameTextField.setDisable(true);
    	setPlayers.setDisable(true);
    	numOfHumans.setItems(FXCollections.observableArrayList(numOfPlayers));	// fills the choice box
    	numOfHumans.getSelectionModel().selectedIndexProperty().addListener(
    			/* the below section of code takes the user input for hum players and sets choice box for comp players*/
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
     * @param numOfHum is the user input of how many hum players
     */
    public void setComps(int numOfHum) {
    	String[] numOfComputer = new String[MAX_PLAYERS - numOfHum];	// creates a String[] for the correct amount of comp players
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
     * this method keeps track of player turns 
     */
    public void turnCounter() { 
    	if (getCurrentPlayerTurn() == (totalPlayers - 1)) {		// resets turn counter once last player has gone
			this.currentPlayerTurn = 0;
		} else {
			this.currentPlayerTurn++;
		}
    	rollDice.setDisable(toggleDiceDisable[getCurrentPlayerTurn()]);		// disables die when a player is rolling
    	setPlayerTurnColor();												// sets to players corresponding colour
    	currentplayerText.setText(playerNameList[getCurrentPlayerTurn()]);	// sets text to current players name
	}
	
    /**
     * getter method for keeping track of player turn
     * @return int of currentPlayerTurn
     */
	public int getCurrentPlayerTurn() {
		return currentPlayerTurn;
	}
	
	/**
	 *  Checks to see if any players have won
	 * @return true if a player has won, false if not
	 */
	public boolean checkWin() {	
		/* the below section of code checks if any player has landed on space 100*/
	   for (int i = 0; i < totalPlayers; i++) {
		   if (gc.getPlayer().get(i).getPosition() == FINISHING_SPACE) {
			   rollDice.setDisable(true);
			   yourRoll.setText(gc.getPlayer().get(i).getName() + " has won!");		// print statement for winner
			   return true;
		   }
	   }
	   return false;
   }
	
	/**
	 * this method is used to run computer player turns
	 */
   	public void refresh()  {
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
    		name = gc.getPlayer().get(getCurrentPlayerTurn()).getName();
    		gc.getPlayer().get(getCurrentPlayerTurn()).MovePlayerGUI();
    		roll = gc.getPlayer().get(getCurrentPlayerTurn()).getDiceRoll();
    		newPosition = gc.getPlayer().get(getCurrentPlayerTurn()).getPosition();
    		totalMove = newPosition - oldPosition;
    		/* below three lines of code move the player token to new position on the GUI */
    		gameGridTop.getChildren().remove(tokens.get(getCurrentPlayerTurn()));
           	gameGridTop.add(tokens.get(getCurrentPlayerTurn()),
           					columns[newPosition - 1], rows[newPosition - 1]);
    		
           	setPlayerRollColor();
           	/* below section of code displays player roll and if they went up or down a ladder or snake*/
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
  
    /**
     *  this methods sets current player colour on their roll
     */
    public void setPlayerRollColor() {
       	for (int i = 0; i < totalPlayers; i++) {
       		yourRoll.setTextFill(playerTokenColors[getCurrentPlayerTurn()]);
       	}
    }
    
    /**
     *  this method sets current player text to their corresponding colour
     */
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
    	/* the below section of code loads in the corresponding image for each dice roll */
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
     * This creates an animation timer roller called spinningDice that is used to animate our die
     */
    private Roller spinningDice;
    
    private class Roller extends AnimationTimer{

    	private long FPS= 50L;						    	// # of times the image will change
    	private long INTERVAL=100000000L/FPS;				// # of times it will occur per seconds
    	private int MAX_ROLLS = 20;							// # of flashes that will happen each button press
    	private long last=0;								
    	private int count = 0;
  
		@Override
		public void handle(long now) {
			if(now-last>INTERVAL) {
				int r = 2 + (int)(Math.random() * 5);		// randomly generates an int
				setDiceImage(r);							// randomly sets the dice image
				last=now;
				count++;
				rollDice.setDisable(true);
				if(count > MAX_ROLLS) {						// stops animation once max rolls is reached
					spinningDice.stop();
					count=0;
					setDiceImage(roll);
					rollDice.setDisable(false);
				}
			}
		}
    }
    
    /**
     * the below method sets the opacity of the snakes and ladders on the GUI to 1 according to the
     * randomly generate snake and ladder array created
     */
    public void setSnakesAndLadders() {
    	/* the below section of code determines which snake and which ladder to display */
    	if (snl.getLaddersStart()[0] == 4) {
			ladder4.setOpacity(1);
		} else {
			ladder37.setOpacity(1);
		}
		if (snl.getLaddersStart()[1] == 18) {
			ladder18.setOpacity(1);
		} else {
			ladder41.setOpacity(1);
		}
		if (snl.getLaddersStart()[2] == 30) {
			ladder30.setOpacity(1);
		} else {
			ladder87.setOpacity(1);
		}
		if (snl.getLaddersStart()[3] == 51) {
			ladder51.setOpacity(1);
		} else {
			ladder14.setOpacity(1);
		}
		if (snl.getLaddersStart()[4] == 55) {
			ladder55.setOpacity(1);
		} else {
			ladder58.setOpacity(1);
		}
		if (snl.getLaddersStart()[5] == 62) {
			ladder62.setOpacity(1);				
		} else {
			ladder73.setOpacity(1);
		}
		
		if (snl.getSnakesStart()[0] == 93) {
			snake93.setOpacity(1);
		} else {
			snake97.setOpacity(1);
		}
		if (snl.getSnakesStart()[1] == 83) {
			snake83.setOpacity(1);
		} else {
			snake96.setOpacity(1);
		}
		if (snl.getSnakesStart()[2] == 57) {
			snake57.setOpacity(1);
		} else {
			snake21.setOpacity(1);
		}
		if (snl.getSnakesStart()[3] == 52) {
			snake52.setOpacity(1);
		} else {
			snake80.setOpacity(1);
		}
		if (snl.getSnakesStart()[4] == 46) {
			snake46.setOpacity(1);
		} else {
			snake34.setOpacity(1);
		}
		if (snl.getSnakesStart()[5] == 26) {
			snake26.setOpacity(1);				
		} else {
			snake16.setOpacity(1);
		}
    }
}