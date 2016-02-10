import java.util.HashMap;
import java.util.Random;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class RockPaperScissors {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    get("/", (request, response) -> {
      HashMap model = new HashMap();

      model.put("template", "templates/play-game.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/result", (request, response) -> {
      HashMap model = new HashMap();
      String playerOne = request.queryParams("playerOne");
      String playerTwo = request.queryParams("playerTwo");
      String random = playerOne;
      String result = gameStatus(playerOne, playerTwo);

      model.put("gameResult", result);
      model.put("playerOne", playerOne);
      model.put("playerTwo", playerTwo);

      model.put("template", "templates/results.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
  public static Boolean checkWinner(String playerOneChoice, String playerTwoChoice) {
    if (playerOneChoice.equals("Rock") && playerTwoChoice.equals("Scissors")) {
      return true;
    }
    if (playerOneChoice.equals("Scissors") && playerTwoChoice.equals("Paper")) {
      return true;
    }
    if (playerOneChoice.equals("Paper") && playerTwoChoice.equals("Rock")) {
      return true;
    }
    return false;
  }

  public static String gameStatus(String playerOneChoice, String playerTwoChoice) {
    String randomChoice = "";
    if(playerOneChoice.equals("random")) {
      playerOneChoice = randomChoice();
    }
    if(playerTwoChoice.equals("random")) {
      playerTwoChoice = randomChoice();
    }
    if(playerOneChoice.equals(playerTwoChoice)){
      return "Everyone is a Winner!";
    }
    if (checkWinner(playerOneChoice, playerTwoChoice)) {
      return "Player One Wins!";
    }
    return "Player Two Wins!";
  }

  public static String randomChoice() {
    Random randomNumberGenerator = new Random();
    Integer randomNumber = randomNumberGenerator.nextInt(3);
    String playerChoice = "";
    if(randomNumber == 0) {
      playerChoice = "Rock";
    }
    if(randomNumber == 1) {
      playerChoice = "Paper";
    }
    if(randomNumber == 2) {
      playerChoice = "Scissors";
    }
    return playerChoice;
  }


}
