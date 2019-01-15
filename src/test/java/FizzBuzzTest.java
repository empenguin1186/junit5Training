import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

  @ParameterizedTest
  @CsvSource({ "2, 2", "3, Fizz", "5, Buzz", "15, FizzBuzz" })
  @DisplayName("正常系")
  void testWithCsvSource(int first, String second) {
    assertEquals(second, FizzBuzz.fizzBuzz(first));
  }
}
