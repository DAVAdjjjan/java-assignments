import java.util.Arrays;

public final class Utils {
  private Utils() {
  }

  public static boolean isWordPureLatin(String word) {
    return word.chars()
        .allMatch(c -> (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
  }

  public static long vowelsCount(String word) {
    return word.chars()
        .mapToObj(c -> (char) c)
        .filter(c -> Constants.VOWELS.indexOf(c) != -1)
        .count();
  }

  public static long consonantsCount(int wordLen, long vowelsCount) {
    if (vowelsCount > wordLen) {
      throw new IllegalArgumentException("vowelsCount must be less than wordLen");
    }
    return wordLen - vowelsCount;
  }

  public static String[] fromSentence2WordArray(String sentence) {
    return sentence.trim().split("\\s+");
  }

  public static String[] filterDesireWords(String sentence) {
    if (sentence == null || sentence.trim().isEmpty()) {
      return new String[0];
    }

    String[] givenWords = fromSentence2WordArray(sentence);

    return Arrays.stream(givenWords)
        .filter(word -> !word.isEmpty())
        .filter(word -> {
          if (!word.codePoints().allMatch(Character::isLetter)) {
            throw new IllegalArgumentException("Wrong format in word " + word);
          }
          return true;
        })
        .filter(Utils::isWordPureLatin)
        .filter(word -> {
          long vowels = vowelsCount(word);
          long consonants = consonantsCount(word.length(), vowels);
          return vowels == consonants;
        })
        .toArray(String[]::new);
  }
}
