import java.util.ArrayList;
import java.util.List;

public final class Utils {
    private Utils() {
    }

    public static boolean isWordPureLatin(String word) {
        for (char c : word.toCharArray()) {
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                return false;
            }
        }
        return true;
    }

    public static int vowelsCount(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (Constants.VOWELS.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static int consonantsCount(int wordLen, int vowelsCount) {
        if (vowelsCount > wordLen) {
            throw new IllegalArgumentException("vowelsCount must be less than wordLen");
        }
        return wordLen - vowelsCount;
    }

    public static String[] fromSentence2WordArray(String sentence) {
        return sentence.trim().split("\\s+");
    }

    public static String[] filterDesireWords(String sentence) {
        String[] givenWords = fromSentence2WordArray(sentence);
        List<String> desireWordsList = new ArrayList<>();

        for (String gw : givenWords) {
            if (!gw.codePoints().allMatch(Character::isLetter)) {
                throw new IllegalArgumentException("Wrong format in word " + gw);
            }

            if (!isWordPureLatin(gw)) continue;
            int vowelsCount = vowelsCount(gw);
            int consonantsCount = consonantsCount(gw.length(), vowelsCount);

            if (vowelsCount == consonantsCount) desireWordsList.add(gw);
        }

        return desireWordsList.toArray(String[]::new);
    }

}
