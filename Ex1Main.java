import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implements all needed functions.
 *
 */
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implements all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";

        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println("\nEx1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();

            if (!num1.equals(quit)) {
                // Check if num1 is a valid number
                boolean isValidNum1 = Ex1.isNumber(num1);
                int val1 = (isValidNum1) ? Ex1.number2Int(num1) : -1;
                System.out.println("num1= " + num1 + " is number: " + isValidNum1 + " , value: " + val1);

                // Enter number #2
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();

                if (!num2.equals(quit)) {
                    // Check if num2 is a valid number
                    boolean isValidNum2 = Ex1.isNumber(num2);
                    int val2 = (isValidNum2) ? Ex1.number2Int(num2) : -1;
                    System.out.println("num2= " + num2 + " is number: " + isValidNum2 + " , value: " + val2);

                    // Check if both numbers are valid
                    if (isValidNum1 && isValidNum2) {
                        // Ask for the base of the output
                        System.out.println("Enter a base for output: (a number [2,16])");
                        int base = sc.nextInt();

                        // Perform addition and multiplication in the given base
                        String sum = Ex1.int2Number(val1 + val2, base);
                        String product = Ex1.int2Number(val1 * val2, base);

                        // Print the results of addition and multiplication
                        System.out.println(num1 + " + " + num2 + " = " + sum);
                        System.out.println(num1 + " * " + num2 + " = " + product);

                        // Find the max number over the values
                        String[] numbers = {num1, num2, sum, product};
                        String maxNum = Ex1.int2Number(Ex1.number2Int(numbers[Ex1.maxIndex(numbers)]), base);
                        System.out.println("Max number over [" + String.join(",", numbers) + "] is: " + maxNum);
                    } else {
                        if (!isValidNum1) {
                            System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                        }
                        if (!isValidNum2) {
                            System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                        }
                    }
                }
            }
        }
        System.out.println("quitting now...");
        sc.close();
    }
}
