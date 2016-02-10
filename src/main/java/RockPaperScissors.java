import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class RockPaperScissors {
  public static void main(String[] args) {

  }
  public static Boolean checkWinner(String playerOneChoice, String playerTwoChoice) {
    if (playerOneChoice == "Rock" && playerTwoChoice == "Scissors") {
      return true;
    }
    if (playerOneChoice == "Scissors" && playerTwoChoice == "Paper") {
      return true;
    }
    if (playerOneChoice == "Paper" && playerTwoChoice == "Rock") {
      return true;
    }
    return false;
  }

  public static String gameStatus(String playerOneChoice, String playerTwoChoice) {
    if(playerOneChoice == playerTwoChoice){
      return "Everyone is a Winner!";
    }
    if (checkWinner(playerOneChoice, playerTwoChoice)) {
      return "Player One Wins!";
    }
    return "Player Two Wins!";
  }
}
