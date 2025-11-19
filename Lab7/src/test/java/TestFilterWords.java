import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class TestFilterWords {

  static IFilterWords[] finders() {
    return new IFilterWords[] { new FilterWordsTraditional(), new FilterWordsLambda() };
  }

  @ParameterizedTest
  @MethodSource("finders")
  public void testFilterDesireWords(IFilterWords filter) {
    String[] result = filter.filterDesireWords("ab cd ef");
    assertNotNull(result);
    assertEquals(2, result.length);
    assertTrue(Arrays.asList(result).contains("ab"));
    assertTrue(Arrays.asList(result).contains("ef"));

    String[] result2 = filter.filterDesireWords("");
    assertNotNull(result2);
    assertEquals(0, result2.length);
  }

  @ParameterizedTest
  @MethodSource("finders")
  public void testFilterWithValidWords(IFilterWords filter) {
    String[] result = filter.filterDesireWords("ab");
    assertNotNull(result);
    assertEquals(1, result.length);
    assertEquals("ab", result[0]);

    String[] result2 = filter.filterDesireWords("ab cd ef");
    assertNotNull(result2);
    assertEquals(2, result2.length);
    assertTrue(Arrays.asList(result2).contains("ab"));
    assertTrue(Arrays.asList(result2).contains("ef"));
  }

  @ParameterizedTest
  @MethodSource("finders")
  public void testFilterWithInvalidFormat(IFilterWords filter) {
    assertThrows(IllegalArgumentException.class, () -> {
      filter.filterDesireWords("hello123 world");
    });
  }

  @Test
  public void testIsWordPureLatin() {
    assertTrue(Utils.isWordPureLatin("hello"));
    assertTrue(Utils.isWordPureLatin("WORLD"));
    assertFalse(Utils.isWordPureLatin("hello123"));
    assertFalse(Utils.isWordPureLatin("привіт"));
  }

  @Test
  public void testVowelsCount() {
    assertEquals(2, Utils.vowelsCount("hello"));
    assertEquals(1, Utils.vowelsCount("world"));
    assertEquals(0, Utils.vowelsCount("bcdfg"));
  }

  @Test
  public void testConsonantsCount() {
    assertEquals(3, Utils.consonantsCount(5, 2));
    assertEquals(4, Utils.consonantsCount(5, 1));
  }
}
