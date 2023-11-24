import java.util.Scanner;

public class DictionaryCommandLine {

    private Dictionary dictionary;

    public DictionaryCommandLine() {
        dictionary = new Dictionary();
    }

    public static void main(String[] args) {
        DictionaryCommandLine commandLine = new DictionaryCommandLine();
        commandLine.dictionaryAdvanced();
    }

    public void dictionaryAdvanced() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to My Application!");
            System.out.println("[0] Exit");
            System.out.println("[1] Add");
            System.out.println("[2] Remove");
            System.out.println("[3] Update");
            System.out.println("[4] Display");
            System.out.println("[5] Lookup");
            System.out.println("[6] Search");
            System.out.println("[7] Game");
            System.out.println("[8] Import from file");
            System.out.println("[9] Export to file");
            System.out.println("[10] Pronounce Word");
            System.out.println("[11] Translate Word");
            System.out.print("Your action: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 0 -> System.out.println("Exiting the application.");
                case 1 -> DictionaryManagement.insertFromCommandline(dictionary);
                case 2 -> {
                    System.out.print("Enter the word to remove: ");
                    String wordToRemove = scanner.nextLine();
                    dictionary.removeWord(wordToRemove);
                }
                // Add other cases for updateWord, displayWords, etc.
                default -> System.out.println("Action not supported.");
            }
        } while (choice != 0);
    }
}
