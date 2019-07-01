package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    TextField tv_input;
    @FXML
    Label lb_output;
    @FXML
    Button btn_guess;
    @FXML
    Label lb_num_of_tries;

    private Game game = new Game();



    public void guessClick(ActionEvent actionEvent) {

        if(!game.isWon()) {
            if (tv_input != null && !tv_input.getText().isEmpty()) {
                try {
                    game.setGuess(Integer.valueOf(tv_input.getText()));
                } catch (NumberFormatException e){
                    lb_output.setText("Du skal indtaste et heltal :)");
                    return;
                }
            }

            for (int i = 0; i < game.getGuesses().size(); i++) {
                if(game.getGuess() == game.getGuesses().get(i)){
                    lb_output.setText("Du har allerede gættet på dette tal :)");
                    return;
                }
            }

            if(game.getGuess() <=100 && game.getGuess() >0) {
                game.evaluateGuess();
                lb_num_of_tries.setText("Forsøg: " + String.valueOf(game.getNumOfTries()));
                lb_output.setText(game.getStatus());
            } else if(game.getGuess() <= 0){
                lb_output.setText("Tallet skal være større end 0 :)");
            } else if(game.getGuess() > 100){
                lb_output.setText("Tallet skal være mindre end eller lig 100 :)");
            }


        } else resetClick(actionEvent);


    }


    public void resetClick(ActionEvent actionEvent) {

        game.startNewGame();
        lb_num_of_tries.setText(String.valueOf(game.getNumOfTries()));
        lb_output.setText(game.getStatus());
        tv_input.setText("");

    }
}
