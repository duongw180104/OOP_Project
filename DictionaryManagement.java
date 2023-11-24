import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

class DictionaryManagement {

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
