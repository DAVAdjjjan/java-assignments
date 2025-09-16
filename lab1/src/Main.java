import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter sentence of words separated by spaces: ");
        String sentence = sc.nextLine();

        sc.close();

        System.out.println(Arrays.toString(Utils.filterDesireWords(sentence)));

    }
}
