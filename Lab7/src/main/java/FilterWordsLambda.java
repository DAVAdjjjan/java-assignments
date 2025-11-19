public class FilterWordsLambda implements IFilterWords {

  @Override
  public String[] filterDesireWords(String sentence) {
    return Utils.filterDesireWords(sentence);
  }
}
