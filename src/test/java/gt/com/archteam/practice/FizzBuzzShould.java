package gt.com.archteam.practice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FizzBuzzShould {
    @Test
    public void return_fizz_when_number_is_divisible_by_3() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(9));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
    }

    @Test
    public void return_buzz_when_number_is_divisible_by_5() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(25));
    }

    @Test
    public void return_fizzbuzz_when_number_is_divisible_by_5_and_3() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
    }

    @Test
    public void return_number_when_it_is_not_divisible_by_5_and_3() {
        assertEquals("2", FizzBuzz.fizzBuzz(2));
        assertEquals("16", FizzBuzz.fizzBuzz(16));
    }
}
