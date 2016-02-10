import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class RockPaperScissorsIntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Rock");
  }
  @Test
  public void playerOneWins() {
    goTo("http://localhost:4567/");
    click("#p1Rock");
    click("#p2Scissors");
    submit("#submitButton");
    assertThat(pageSource()).contains("Player One");
  }
  @Test
  public void playerOneRandom() {
    goTo("http://localhost:4567/");
    click("#p1Random");
    click("#p2Scissors");
    submit("#submitButton");
    assertThat(pageSource()).contains("picked");
  }
}
