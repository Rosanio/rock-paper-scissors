import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class RockPaperScissorsTest {
  @Test
public void checkWinner_rockBeatsScissors_true() {
  RockPaperScissors testRockPaperScissors = new RockPaperScissors();
  assertEquals(true, testRockPaperScissors.checkWinner("Rock", "Scissors"));
  }
}
