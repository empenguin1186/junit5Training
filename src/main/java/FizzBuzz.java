public class FizzBuzz {

  static String fizzBuzz(int n) {
    String result = "";
    boolean isDevided = false;

    if (n % 3 == 0) {
      isDevided = true;
      result += "Fizz";
    }

    if (n % 5 == 0) {
      isDevided = true;
      result += "Buzz";
    }

    if (!isDevided) {
      result += String.valueOf(n);
    }

    return result;
  }
}
