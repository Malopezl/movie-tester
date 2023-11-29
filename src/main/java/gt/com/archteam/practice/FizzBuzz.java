package gt.com.archteam.practice;

public class FizzBuzz {

    public static String fizzBuzz(int n) {
        StringBuilder response = new StringBuilder();
        if (n % 3 == 0) {
            response.append("Fizz");
        }
        if (n % 5 == 0) {
            response.append("Buzz");
        }
        return response.toString().length() > 0 ? response.toString() : String.valueOf(n);
    }
}
