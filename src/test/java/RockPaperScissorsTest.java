import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;

public class RockPaperScissorsTest {
  @Test
  public void checkWinner_rockBeatsScissors_true() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals(true, testRockPaperScissors.checkWinner("Rock", "Scissors"));
  }

  @Test
  public void checkWinner_scissorsBeatsPaper_true() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals(true, testRockPaperScissors.checkWinner("Scissors", "Paper"));
  }
  @Test
  public void checkWinner_paperBeatsRock_true() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals(true, testRockPaperScissors.checkWinner("Paper", "Rock"));
  }
  @Test
  public void gameStatus_playerOneWins_playerOneWins() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals("Player One Wins!", testRockPaperScissors.gameStatus("Paper", "Rock"));
  }
  @Test
  public void gameStatus_playerOneTiesWithPlayerTwo_itsATie() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals("Everyone is a Winner!", testRockPaperScissors.gameStatus("Paper", "Paper"));
  }
}
