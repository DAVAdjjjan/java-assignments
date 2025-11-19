import java.util.ArrayList;
import java.util.List;

public class FilterWordsTraditional implements IFilterWords {

  @Override
  public String[] filterDesireWords(String sentence) {
    if (sentence == null || sentence.trim().isEmpty()) {
      return new String[0];
    }

    String[] givenWords = Utils.fromSentence2WordArray(sentence);
    List<String> desireWordsList = new ArrayList<>();

    for (String gw : givenWords) {
      if (gw.isEmpty())
        continue;

      if (!gw.codePoints().allMatch(Character::isLetter)) {
        throw new IllegalArgumentException("Wrong format in word " + gw);
      }

      if (!Utils.isWordPureLatin(gw))
        continue;
      long vowelsCount = Utils.vowelsCount(gw);
      long consonantsCount = Utils.consonantsCount(gw.length(), vowelsCount);

      if (vowelsCount == consonantsCount)
        desireWordsList.add(gw);
    }

    return desireWordsList.toArray(String[]::new);
  }
}
