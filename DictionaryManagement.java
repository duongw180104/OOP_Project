import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DictionaryManagement {
    private  String FILENAME;
    private Dictionary dictionary;

    DictionaryManagement() {
    }

    public void addWord(String word_target, String word_explain) {
        dictionary.addWord(new Word(word_target, word_explain));
    }
    public static void insertFromCommandline(Dictionary dictionary) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng từ vựng: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập từ tiếng Anh: ");
            String word_target = scanner.nextLine();
            System.out.print("Nhập giải thích tiếng Việt: ");
            String word_explain = scanner.nextLine();

            dictionary.addWord(new Word(word_target, word_explain));
        }
    }

    public void insertFromFile() throws IOException {
        File f = new File(FILENAME);
        FILENAME = f.getAbsolutePath().substring(0, 1) + ":\\" + FILENAME;
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String line;
            br = new BufferedReader(new FileReader(FILENAME));
            while ((line = br.readLine()) != null) {
                String w[] = line.split("\t");
                this.addWord(w[0], w[1]);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(br != null) br.close();
                if(fr != null) fr.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
    public static void showAllWords(Dictionary dictionary) {
        dictionary.showAllWords();
    }

    public static void exportToFile(Dictionary dictionary, String filePath) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(dictionary);

        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static void searchVocabulary(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        StringBuilder text = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            text.append(line).append("\n");
        }
        reader.close();

        // Regex pattern để tìm các từ vựng có định dạng @a, @a b c
        Pattern pattern = Pattern.compile("@(\\w+)(?:\\s+\\w+)*\\s+/(.+?)/", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String word = matcher.group(1);
            String definition = matcher.group(2);
            System.out.println("Word: " + word);
            System.out.println("Definition: " + definition);
            System.out.println(); // In một dòng trống giữa từng cặp từ vựng và định nghĩa
        }
    }
}
