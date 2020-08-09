package application;


import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.ResourceBundle;

import model.GameConfiguration;
import model.Player;
import javafx.animation.PauseTransition;
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
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;


// Grass: https://graphicriver.img.customer.envatousercontent.com/files/121477694/grass_0020_background_AM_IPr.jpg?auto=compress%2Cformat&fit=crop&crop=top&w=590&h=590&s=f8259506302be4a30a682963b6a72d71
// Snake : https://w7.pngwing.com/pngs/461/577/png-transparent-rattlesnake-a-silver-ring-snake-png-material-ring-animals.png
// Ladder : https://img.favpng.com/21/0/14/tangyuan-ladder-png-favpng-vYBUNXKvN2rEgxSFipAxSNNyN.jpg

public class GameboardController {
	private static final int MAX_PLAYERS = 4;
	private int numOfHumanPlayers = 0;
	private int numOfComputerPlayers = 0;
	private int currentPlayer = 0;
	private int TURN = 0;						// keeps track whose turn it is
	private  int totalPlayers;
	private String nameEntered;					// string of player name entered
	private String[] numOfPlayers = {"1","2","3","4"};
	private String[] playerNameList = new String[MAX_PLAYERS];
	private String[] messages = {"Enter first players name", 
			"Enter second players name", "Enter third players name", 
			"Enter fourth players name"};
	private String[] computerNames = {"CP1", "CP2", "CP3", "CP4"};
	private int [] columns = {0,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,0,		// indices of columns in gridpane
							  0,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,0,
							  0,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,0,
							  0,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,0,
							  0,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,0};
	private int [] rows = {9,9,9,9,9,9,9,9,9,9,8,8,8,8,8,8,8,8,8,8,			// indices of rows in gridpane
						   7,7,7,7,7,7,7,7,7,7,6,6,6,6,6,6,6,6,6,6,
						   5,5,5,5,5,5,5,5,5,5,4,4,4,4,4,4,4,4,4,4,
						   3,3,3,3,3,3,3,3,3,3,2,2,2,2,2,2,2,2,2,2,
						   1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0};
	private ArrayList<Circle> tokens = new ArrayList<Circle>();				// holds game tokens
	private GameConfiguration gc = new GameConfiguration("GUIBased");		// initializes the GUI

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
    private ChoiceBox<String> numOfComp;

    @FXML
    private Label currentTurnLabel;

    @FXML
    private TextField playerNameTextField;
    
    @FXML
    private GridPane gameGridTop;
    
    @FXML
    private Pane pane;
  
    @FXML
    private Label currentplayerText;
    
    @FXML
    private Label yourRoll;
    
    @FXML
    private ImageView grass;
    
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
     * @param event
     */
    @FXML
    void submitButton(MouseEvent event) {
      	playerNameText.setText(messages[getTURN()]);				// sets text to show whose turn
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
      	} else if (totalPlayers == 3) {
      		tokens.add(token1);
      		tokens.add(token2);
      		tokens.add(token3);
      		token1.setOpacity(1);
    		token2.setOpacity(1);
    		token3.setOpacity(1);
      	} else if (totalPlayers == 4){
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
	       		playerNameText.setText("Press the start game button");
	       	} else {
	       		playerNameText.setText(messages[currentPlayer]);
	       	}
    	} 	
    }
    
    /**
     * gets player name from textfield 
     * @param event
     */
    @FXML
    void playerNameKeyTyped(KeyEvent event) {
    	nameEntered = playerNameTextField.getText();
    }
    
    /**
     * creates GUI game by creating # of human players and # of computer players inputed
     * @param event
     */
    @FXML
    void startButtonClicked(MouseEvent event) {
    	playerNameText.setText("Game has started!");	// lets player know the game has started
    	/* The below section of code creates the necessary amount of human/computer players */
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
    	currentplayerText.setText(playerNameList[getTURN()]);
    	
    		if (gc.getLaddersStart()[0] == 4) {
    			ladder4.setOpacity(1);
    		} else {
    			ladder37.setOpacity(1);
    		}
    		if (gc.getLaddersStart()[1] == 18) {
				ladder18.setOpacity(1);
			} else {
				ladder41.setOpacity(1);
			}
    		if (gc.getLaddersStart()[2] == 30) {
				ladder30.setOpacity(1);
			} else {
				ladder87.setOpacity(1);
			}
    		if (gc.getLaddersStart()[3] == 51) {
				ladder51.setOpacity(1);
			} else {
				ladder14.setOpacity(1);
			}
    		if (gc.getLaddersStart()[4] == 55) {
				ladder55.setOpacity(1);
			} else {
				ladder58.setOpacity(1);
			}
    		if (gc.getLaddersStart()[5] == 62) {
				ladder62.setOpacity(1);				
			} else {
				ladder73.setOpacity(1);
			}
    		
    		if (gc.getSnakesStart()[0] == 93) {
    			snake93.setOpacity(1);
    		} else {
    			snake97.setOpacity(1);
    		}
    		if (gc.getSnakesStart()[1] == 83) {
				snake83.setOpacity(1);
			} else {
				snake96.setOpacity(1);
			}
    		if (gc.getSnakesStart()[2] == 57) {
				snake57.setOpacity(1);
			} else {
				snake21.setOpacity(1);
			}
    		if (gc.getSnakesStart()[3] == 52) {
				snake52.setOpacity(1);
			} else {
				snake80.setOpacity(1);
			}
    		if (gc.getSnakesStart()[4] == 46) {
				snake46.setOpacity(1);
			} else {
				snake34.setOpacity(1);
			}
    		if (gc.getSnakesStart()[5] == 26) {
				snake26.setOpacity(1);				
			} else {
				snake16.setOpacity(1);
			}
    	
    }
    
    /**
     * checks to see if the game has not been won yet and will roll the dice to move
     * @param event
     */
    @FXML
    void onDiceClick(MouseEvent event) {
    	if (gc.getPlayer().get(0).getPosition() != 100 && gc.getPlayer().get(1).getPosition() != 100
    		&& gc.getPlayer().get(2).getPosition() != 100 && gc.getPlayer().get(3).getPosition() != 100) {  		
    		if (gc.getPlayer().get(getTURN()).getType() == "human") {
        		MovePlayerGUI(gc);
        		moveComputerGUI();
        		
        	} 	
    	} 
    	
    }
    
    /*
     * asks for user input on how many human and computer players
     */
    @FXML
    void initialize() {
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
    	
    	gc.initializeSnakeLadder();
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
    public void TurnCounter() { 
  
    	if (getTURN() == (totalPlayers - 1)) {
			this.TURN = 0;
		} else {
			this.TURN++;
		}
    	currentplayerText.setText(playerNameList[getTURN()]);
	}
	
    /**
     * getter method for keeping track of player turn
     * @return
     */
	public int getTURN() {
		return TURN;
	}
	
	/** 
	 * checks if any players have won
	 */
   public void checkWin() {	   
	   for (int i = 0; i < totalPlayers; i++) {
		   if (gc.getPlayer().get(i).getPosition() == 100) {
			   rollDice.setDisable(true);
			   yourRoll.setText(gc.getPlayer().get(i).getName() + " has won!");
		   }
	   }
    }
   
   /**
    * moves human player
    * @param gc
    */
    public void MovePlayerGUI(GameConfiguration gc) {
    	if (gc.getPlayer().get(getTURN()).getType() == "human") {
    		
    		Move();
    		
    	}    	
    } 
    
    /**
     * moves computer player without user input
     */
    public void moveComputerGUI() {  
    	if (gc.getPlayer().get(getTURN()).getType() == "AI")  {	
    		rollDice.setDisable(true);
    		waitfor();
    		Move();
    		rollDice.setDisable(false);	
    		moveComputerGUI();
    	
    	}
    	
    } 
    
    /**
     * moves players on GUI and checks whether they have landed on a snake or ladder
     */
    public void Move() {
    	int startposition = gc.getPlayer().get(getTURN()).getPosition() - 1;
		gc.MovePlayerGUI(gc.getPlayer().get(getTURN()));
    	int position = gc.getPlayer().get(getTURN()).getPosition() - 1;
    	int snakeLadderCheck = position - startposition;
    	
    	if (snakeLadderCheck > 6) {
    		yourRoll.setText(gc.getPlayer().get(getTURN()).getName() + " went up a ladder and rolled a: " + gc.getPlayer().get(getTURN()).getHoldDiceRoll());
    		
    	} else if (snakeLadderCheck < 0) {
    		yourRoll.setText(gc.getPlayer().get(getTURN()).getName() + " went down a snake and rolled a: " + gc.getPlayer().get(getTURN()).getHoldDiceRoll());
    		
    	} else {
    		yourRoll.setText(gc.getPlayer().get(getTURN()).getName() + " you rolled a: " + gc.getPlayer().get(getTURN()).getHoldDiceRoll()); 
    		
    	}
    	gameGridTop.getChildren().remove(tokens.get(getTURN()));
    	gameGridTop.add(tokens.get(getTURN()),columns[position],rows[position]);
    
    	checkWin();	
    	TurnCounter();	
    }
  
    
    /**
     * the below method is for iteration 3
     */
  public void waitfor() {
  	if (gc.getPlayer().get(getTURN()).getType() == "AI")  {
  		try
  		{
  		    Thread.sleep(1000);
  		}
  		catch(InterruptedException ex)
  		{
  		    Thread.currentThread().interrupt();
  		}	
  	 }	
  }
 
}