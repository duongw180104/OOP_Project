import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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
}
