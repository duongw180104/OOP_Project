import java.util.ArrayList;

public class Dictionary extends Word{
    public ArrayList<Word> wordList = new ArrayList<Word>();
    public void addWord(String word1, String word2) {
        Word w = new Word();
        w.setWord(word1, word2);
        this.wordList.add(w);
    }
}
