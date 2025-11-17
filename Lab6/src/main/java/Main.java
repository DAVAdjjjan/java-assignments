import java.util.Scanner;

import Dictionary.EnglishUkrainianTranslator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EnglishUkrainianTranslator translator = new EnglishUkrainianTranslator();

        System.out.print("Хочете додати нові слова у словник? (y/n): ");
        String answer = scanner.nextLine();

        while (answer.equalsIgnoreCase("y")) {
            System.out.print("Англійське слово: ");
            String eng = scanner.nextLine();
            System.out.print("Український переклад: ");
            String ukr = scanner.nextLine();
            translator.addPair(eng, ukr);

            System.out.print("Продовжити додавати слова? (y/n): ");
            answer = scanner.nextLine();
        }

        System.out.print("Введіть англійську фразу для перекладу: ");
        String phrase = scanner.nextLine();

        scanner.close();

        String translated = translator.translatePhrase(phrase);
        System.out.println("Переклад: " + translated);
    }
}
