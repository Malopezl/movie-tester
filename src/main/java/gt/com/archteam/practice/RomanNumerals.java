package gt.com.archteam.practice;

public class RomanNumerals {

    public static String arabicToRoman(int n) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            if (n >= 1000) {
                result.append("M");
                n -= 1000;
            } else if (n >= 900) {
                result.append("CM");
                n -= 900;
            } else if (n >= 500) {
                result.append("D");
                n -= 500;
            } else if (n >= 400) {
                result.append("CD");
                n -= 400;
            } else if (n >= 100) {
                result.append("C");
                n -= 100;
            } else if (n == 99) {
                result.append("XCIX");
                n -= 99;
            } else if (n >= 90) {
                result.append("XC");
                n -= 90;
            } else if (n >= 50) {
                result.append("L");
                n -= 50;
            } else if (n >= 49) {
                result.append("XLIX");
                n -= 49;
            } else if (n >= 40) {
                result.append("XL");
                n -= 40;
            } else if (n >= 10) {
                result.append("X");
                n -= 10;
            } else if (n == 9) {
                result.append("IX");
                n -= 9;
            } else if (n >= 5) {
                result.append("V");
                n -= 5;
            } else if (n == 4) {
                result.append("IV");
                n -= 4;
            } else if (n >= 1) {
                result.append("I");
                n -= 1;
            }
            System.out.println(result.toString());
        }
        return result.toString();
    }
}
