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
    return false;
  }
}
