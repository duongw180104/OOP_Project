import java.util.ArrayList;
import java.util.Collections;

class Dictionary {
    private ArrayList<Word> words;

    public Dictionary() {
        words = new ArrayList<>();
    }

    public void addWord(Word word) {
        words.add(word);
    }

    public void showAllWords() {
        Collections.sort(words, (Word word1, Word word2) -> word1.getWordTarget().compareToIgnoreCase(word2.getWordTarget()));
        for (int i = 0; i < words.size(); i++) {
            System.out.printf("%d | %s | %s\n", i + 1, words.get(i).getWordTarget(), words.get(i).getWordExplain());
        }
    }

    public Word findWordByWordTarget(String word_target) {
        for (Word word : words) {
            if (word.getWordTarget().equals(word_target)) {
                return word;
            }
        }
        return null;
    }

    public void removeWord(String target) {
        for (Word word : words) {
            if (word.getWordTarget().equals(target)) {
                words.remove(word);
                System.out.println("Word removed successfully.");
                return;
            }
        }
        System.out.println("Word not found in the dictionary.");
    }
}
