import java.io.Serializable;

class Word implements Serializable {
    private String word_target;
    private String word_explain;

    public Word(String word_target, String word_explain) {
        this.word_target = this.word_target;
        this.word_explain = this.word_explain;
    }

    public String getWordTarget() {
        return word_target;
    }

    public String getWordExplain() {
        return word_explain;
    }
}
