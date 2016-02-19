import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {
  @Test
  public void newDefinition_instatiateCorrectly_true() {
    Definition testDefinition = new Definition("place for family");
    assertEquals(true, testDefinition instanceof Definition);
  }

  @Test
  public void newDefinition_displayADefinition() {
    Definition testDefinition = new Definition("place for family");
    assertEquals("place for family", testDefinition.getDefinition());
  }
}
