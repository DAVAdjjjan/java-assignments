import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileExecutor fe = new FileExecutor();
        String directoryPath = GetDirPath.getDirectoryPath(args);

        System.out.print(
                "If you enter more than one symbol, program will get the first\nEnter the letter you want words to start with: ");
        Scanner sc = new Scanner(System.in);
        var letter = sc.nextLine().charAt(0);

        sc.close();

        System.out.println("Searching in directory: " + directoryPath);
        var map = fe.findWordsByLetter(letter, directoryPath);

        System.out.println(map);
    }
}
