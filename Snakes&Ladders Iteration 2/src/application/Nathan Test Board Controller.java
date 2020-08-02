

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class GameGUI {

    @FXML
    private Button againstComputerBtn;

    @FXML
    private Button rollDice;

    @FXML
    private ImageView diceIndicatorImage;

    @FXML
    private Label currentTurnLabel;

    @FXML
    private Button againstHumanBtn;

    @FXML
    private GridPane gameGrid;



    @FXML
    void onDiceClick(ActionEvent event) {

    }

}
