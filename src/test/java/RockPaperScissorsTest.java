import org.junit.*;
import static org.junit.Assert.*;

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
}
