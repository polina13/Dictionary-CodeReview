import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void getWord_returnsWord_true() {
    Word testWord = new Word("home");
    assertEquals("home", testWord.getWord());
  }

  @Test
  public void getId_returnsWordId() {
    Word testWord = new Word("home");
    assertTrue(Word.all().size() == testWord.getId());
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word firstWord = new Word("home");
    Word secondWord = new Word("home");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }
  @Test
  public void find_returnsNullWhenNoWordFound_null() {
    assertTrue(Word.find(999)== null);
  }

  @Test
  public void clear_removesAllWordsFromArrayList() {
    Word testWord = new Word("home");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }

  @Test
  public void addDefinition_addsDefinitionToList() {
    Word testWord = new Word("home");
    Definition testInputDef = new Definition("place for family");
    testWord.addDefinition(testInputDef);
    assertTrue(testWord.getDefinitions().contains(testInputDef));
  }
}
