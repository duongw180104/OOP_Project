import java.io.IOException;
import java.util.Scanner;


public class Main extends DictionaryManagement{
    public static final int TRANSLATE = 1;
    public static final int SEARCH = 2;
    public static final int VIEW_THE_DICTIONARY = 3;
    public static final int ADD_WORD = 4;
    public static final int DELETE_WORD = 5;
    public static final int EDIT_WORD = 6;
    public static final int EXIT = 7;
    private static int functionChoice =0;


    public static int getFunctionChoice() {
        return functionChoice;
    }
    public static void setFunctionChoice(int functionChoice) {
        Main.functionChoice = functionChoice;
    }
    //
    public static void functions(){
        System.out.println(" TỪ ĐIỂN ANH - VIỆT ");
        System.out.println(" 1. DỊCH   :                                ");
        System.out.println(" 2. TRA TỪ :                                ");
        System.out.println(" 3. XEM TOÀN BỘ TỪ ĐIỂN :                   ");
        System.out.println(" 4. THÊM TỪ VÀO TỪ ĐIỂN :                   ");
        System.out.println(" 5. XÓA TỪ :                                ");
        System.out.println(" 6. SỬA TỪ :                                ");
        System.out.println(" 7. THOÁT KHỎI CHƯƠNG TRÌNH                 ");
        System.out.println("                                            ");
        System.out.println();

    }
    //
    public static void main(String[] args) throws IOException{
        DictionaryCommandLine dc = new DictionaryCommandLine();
        dc.insertFromFile();
        //

        while (getFunctionChoice()!= EXIT ){
            functions();
            Scanner sc = new Scanner(System.in);
            functionChoice = sc.nextInt();
            setFunctionChoice(functionChoice);

            // chức năng tra từ mới

            if (getFunctionChoice()== TRANSLATE){
                dc.dictionaryLookup() ;
            }
            // chức năng tìm kiếm từ

            if (getFunctionChoice()== SEARCH){
                dc.DictionarySearcher() ;
            }
            // chức năng xem toàn bộ từ điển

            if (getFunctionChoice()==VIEW_THE_DICTIONARY){

                dc.showAllWords();
            }

            // chức năng thêm từ mới vào

            if (getFunctionChoice() == ADD_WORD){
                dc.insertFromCommandLine();

            }
            // chức năng xóa từ
            if (getFunctionChoice() == DELETE_WORD ){
                dc.deleteWord();

            }

            if (getFunctionChoice() == EDIT_WORD){
                dc.editWord();
            }

            // kết thúc chương trình
            if (getFunctionChoice() == EXIT){
                break;
            }
        }
    }
}
