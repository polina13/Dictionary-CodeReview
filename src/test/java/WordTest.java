import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void getWord_returnsWord_true() {
    Word testWord = new Word("home");
    assertEquals("home", testWord.getWord());
  }
}
