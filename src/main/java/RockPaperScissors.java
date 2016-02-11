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

      model.put("template", "templates/players.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/playGame", (request, response) -> {
      HashMap model = new HashMap();

      model.put("template", "templates/play-game.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/computer", (request, response) -> {
      HashMap model = new HashMap();

      model.put("template", "templates/play-computer.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/playerResult", (request, response) -> {
      HashMap model = new HashMap();
      String playerOne = request.queryParams("playerOne");
      String playerTwo = request.queryParams("playerTwo");

      if(playerOne.length() == 0) {
        playerOne = randomChoice();
      }
      if(playerOne.equals("random")) {
        playerOne = randomChoice();
      }
      if(playerTwo.equals("random")) {
        playerTwo = randomChoice();
      }
      System.out.println(playerOne);
      String result = gameStatus(playerOne, playerTwo);
      model.put("gameResult", result);
      model.put("playerOne", playerOne);
      model.put("playerTwo", playerTwo);

      model.put("template", "templates/results.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/computerResult", (request, response) -> {
      HashMap model = new HashMap();
      String playerOne = request.queryParams("playerOne");
      if(playerOne.equals("random")) {
        playerOne = randomChoice();
      }
      String playerTwo = randomChoice();
      String result = gameStatus(playerOne, playerTwo);

      model.put("gameResult", result);
      model.put("playerOne", playerOne);
      model.put("playerTwo", playerTwo);

      model.put("template", "templates/computer-result.vtl");
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
