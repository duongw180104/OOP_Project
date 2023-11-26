import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {
    private  String FILENAME = "C:\\Users\\84976\\Desktop\\HDH\\src\\data.txt";

    public boolean insertFromCommandLine() {
        System.out.print("Số từ bạn muốn thêm là: ");
        int n = new Scanner(System.in).nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập từ bạn muốn thêm hoặc nhập 'ex' để thoát: ");
            String userInput = new Scanner(System.in).nextLine();

            if ("ex".equalsIgnoreCase(userInput.trim())) {
                System.out.println("Thoát khỏi thêm từ.");
                return false; // Trả về false để dừng lại
            }

            // Ngược lại, thêm từ vào từ điển
            String target = userInput;
            System.out.println("Nhập nghĩa của nó: ");
            String explain = new Scanner(System.in).nextLine();
            this.addWord(target, explain);
        }

        System.out.println("Xong!");
        return true; // Trả về true để tiếp tục vòng lặp
    }

    public void insertFromFile() throws IOException {
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 2) {
                    String target = parts[0].trim();
                    String explain = parts[1].trim();
                    this.addWord(target, explain);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void  dictionaryExportToFile() throws IOException {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            File file = new File(FILENAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            for(Word w : this.wordList){
                bw.write(w.getWord_target() + "\t" + w.getWord_explain() + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void dictionaryLookup() {
        System.out.print("Nhập từ bạn muốn dịch: ");
        String search = new Scanner(System.in).nextLine().toLowerCase().trim(); // Chuyển đổi và loại bỏ khoảng trắng ở đầu cuối
        boolean found = false;

        // Kiểm tra từ trong ArrayList
        for (Word w : this.wordList) {
            String wordTargetLowerCase = w.getWord_target().toLowerCase().trim();
            if (wordTargetLowerCase.equals(search)) {
                System.out.println(w.getWord_explain());
                found = true;
                break;
            }
        }

        // Kiểm tra từ trong file
        if (!found) {
            try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\t");
                    if (parts.length == 2) {
                        String word = parts[0].trim().toLowerCase();
                        String definition = parts[1].trim();
                        if (word.equals(search)) {
                            System.out.println(definition);
                            found = true;
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy từ!");
        }
    }

    public void editWord() {
        System.out.print("Nhập từ bạn muốn chỉnh sửa: ");
        String needEdit = new Scanner(System.in).nextLine();
        System.out.print("Nhập nghĩa bạn muốn chỉnh sửa: ");
        String edit = new Scanner(System.in).nextLine();
        for(Word w : this.wordList){
            if(w.getWord_target().equals(needEdit)) {
                w.setWord_explain(edit);
                break;
            }
        }
        System.out.println("Xong!");
    }
    public void deleteWord() {
        System.out.print("Nhập từ bạn muốn xóa: ");
        String delete = new Scanner(System.in).nextLine();
        for(Word w : this.wordList){
            if(w.getWord_target().equals(delete)) {
                this.wordList.remove(w);
                break;
            }
        }
        System.out.println("Xong!");
    }

    public void DictionarySearcher() {
        System.out.print("Nhập từ bạn muốn tìm kiếm trong từ điển: ");
        String search = new Scanner(System.in).nextLine().toLowerCase();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 2) {
                    String word = parts[0].trim().toLowerCase();
                    String definition = parts[1].trim();
                    if (word.equals(search)) {
                        System.out.println(definition);
                        found = true;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!found) {
            System.out.println("Không tìm thấy từ trong từ điển!");
        }
    }


}
