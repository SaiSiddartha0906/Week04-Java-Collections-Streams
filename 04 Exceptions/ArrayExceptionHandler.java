package Exceptions;

import java.util.Scanner;

public class ArrayExceptionHandler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = null;  
        
        try {
            System.out.print("Enter index to access: ");
            int index = scanner.nextInt();

            int value = numbers[index];
            System.out.printf("Value at index %d: %d%n", index, value);
            
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } finally {
            scanner.close();
        }
    }
}
