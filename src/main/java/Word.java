import java.util.ArrayList;

public class Word {
  private static ArrayList<Word> instances = new ArrayList<Word>();

  private ArrayList<Definition> mDefinitions = new ArrayList<Definition>();
  private String mWord;
  private int mId;


  public Word (String word) {
    mWord = word;
    instances.add(this);
    mId = instances.size();

  }

  public String getWord() {
    return mWord;
  }

  public Integer getId() {
    return mId;
  }

  public ArrayList<Definition> getDefinitions() {
    return mDefinitions;
  }

  public void addDefinition(Definition definition) {
    mDefinitions.add(definition);
  }

  public static ArrayList<Word> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public static Word find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }
}
