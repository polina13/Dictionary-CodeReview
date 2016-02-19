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

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition firstDefinition = new Definition("place for family");
    Definition secondDefinition = new Definition("the place where one lives permanently");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }

  @Test
  public void newId_DefinitionsInstantiatedWithAnId_true() {
    Definition testDefinition = new Definition("place for family");
    assertEquals(Definition.all().size(), testDefinition.getId());
  }
  @Test
  public void find_returnsDefinitionWithSameId_secondDefinition() {
    Definition firstDefinition = new Definition("place for family");
    Definition secondDefinition = new Definition("the place where one lives permanently");
    assertEquals(Definition.find(secondDefinition.getId()), secondDefinition);
  }

  // @Test
  // public void find_returnsNullWhenNoDefinitionFound_null() {
  //   assertTrue(Definition.find(999)== null);
  // }

  @Test
  public void clear_removesAllDefinitionInstancesFromMemory() {
    Definition testDefinition = new Definition("place for family");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }
}
