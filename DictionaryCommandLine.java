import java.io.IOException;

public class DictionaryCommandLine extends DictionaryManagement {

    public void dictionaryBasic() throws IOException {
        super.insertFromCommandLine();
        this.showAllWords();
    }

    public void showAllWords(){
        String format = "%-8d %-25s %s \n";
        System.out.printf("No      |English %16s |Vietnamese \n", " ");
        int numerical_order=0;
        for(Word w : this.wordList) {
            System.out.format(format, numerical_order, w.getWord_target(), w.getWord_explain());
            numerical_order++;
        }
    }

    public void dictionaryAdvanced() throws IOException {
        super.insertFromFile();
        this.showAllWords();
        super.dictionaryLookup();
    }
}
