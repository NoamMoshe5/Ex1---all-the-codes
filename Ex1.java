/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * If the given number is not in a valid format, returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return the decimal value of the number or -1 for invalid input
     */
    public static int number2Int(String num) {
        if (!isNumber(num)) {
            return -1;
        }
        String[] parts = num.split("b");
        String numberPart = parts[0];
        int base = getBase(parts[1]);
        try {
            return Integer.parseInt(numberPart, base);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Checks if the given String (g) is in a valid "number" format.
     * @param g a String representing a number
     * @return true if the given String is in a valid number format
     */
    public static boolean isNumber(String g) {
        if (g == null || !g.contains("b")) {
            return false;
        }
        String[] parts = g.split("b");
        if (parts.length != 2 || parts[0].equals("") || parts[1].equals("")) {
            return false;
        }
        String numberPart = parts[0];
        String basePart = parts[1];
        int base = getBase(basePart);
        if (base < 2 || base > 16) {
            return false;
        }
        for (char c : numberPart.toCharArray()) {
            if (!isValidDigit(c, base)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Converts an integer to a number in the given base.
     * If num < 0 or base is not in [2,16], returns an empty String.
     * @param num the natural number (including 0)
     * @param base the basis [2,16]
     * @return a String representing the number in the given base
     */
    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) {
            return "";
        }
        return Integer.toString(num, base).toUpperCase() + "b" + toBaseChar(base);
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true if the two numbers have the same values
     */
    public static boolean equals(String n1, String n2) {
        return number2Int(n1) == number2Int(n2);
    }

    /**
     * Searches for the array index with the largest number (in value).
     * If there are more than one maximum, returns the first index.
     * @param arr an array of numbers
     * @return the index in the array with the largest number
     */
    public static int maxIndex(String[] arr) {
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int value = number2Int(arr[i]);
            if (value > maxValue) {
                maxValue = value;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * Converts the base character to its integer value.
     * @param baseStr the base character
     * @return the integer value of the base or -1 if invalid
     */
    private static int getBase(String baseStr) {
        if (baseStr == null || baseStr.length() != 1) {
            return -1;
        }
        char baseChar = baseStr.charAt(0);
        if (baseChar >= '2' && baseChar <= '9') {
            return baseChar - '0';
        }
        if (baseChar >= 'A' && baseChar <= 'G') {
            return baseChar - 'A' + 10;
        }
        return -1;
    }

    /**
     * Checks if a character is a valid digit for the given base.
     * @param c the character to check
     * @param base the base
     * @return true if the character is valid in the base
     */
    private static boolean isValidDigit(char c, int base) {
        if (c >= '0' && c <= '9') {
            return (c - '0') < base;
        }
        if (c >= 'A' && c <= 'G') {
            return (c - 'A' + 10) < base;
        }
        return false;
    }

    /**
     * Converts a base integer to its character representation.
     * @param base the base
     * @return the character representation of the base
     */
    private static char toBaseChar(int base) {
        if (base >= 2 && base <= 9) {
            return (char) ('0' + base);
        }
        if (base >= 10 && base <= 16) {
            return (char) ('A' + (base - 10));
        }
        throw new IllegalArgumentException("Invalid base: " + base);
    }
}
