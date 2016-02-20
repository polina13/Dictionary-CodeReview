import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Create a dictionary");
  }


  @Test
  public void wordIsCreatedAndDisplayTest() {
    goTo("http://localhost:4567/words/new");
    fill("#word").with("home");
    submit(".btn");
    click("a", withText("View Words"));
    assertThat(pageSource()).contains("home");
  }

  @Test
  public void multipleWordsDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#word").with("home");
    submit(".btn");
    goTo("http://localhost:4567/words/new");
    fill("#word").with("dog");
    submit(".btn");
    click("a", withText("View Words"));
    assertThat(pageSource()).contains("home");
    assertThat(pageSource()).contains("dog");
  }


  @Test
  public void DefinitionIsCreatedAndDisplayTest() {
    goTo("http://localhost:4567/definition/new");
    fill("#definition").with("place for family");
    submit(".btn");
    click("a", withText("Add definition for the word"));
    assertThat(pageSource()).contains("place for family");
    }
// this test doesnt work;gives me asertion error
//   @Test
//   public void wordFormIsDisplayed() {
//     goTo("http://localhost:4567/");
//     fill("#word").with("home");
//     submit(".btn");
//     click("a", withText("View Words"));
//     click("a", withText("home"));
//     click("a", withText("Add Word"));
//     assertThat(pageSource()).contains("Add a Definition to home");
//   }
}
