package Exceptions;
import java.util.Scanner;
class InvalidAgeException extends Exception {
	public InvalidAgeException (String message) {
		super(message);
	}
}
public class CustomExceptionExample {
	public static void validateAge(int age) throws InvalidAgeException 
	{
		if (age < 18) {
			throw new InvalidAgeException("Age must be 18 or above");
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your age: ");
		
		try {
			int age = scanner.nextInt();
			validateAge(age);
			System.out.println("Access granted");
		} catch (InvalidAgeException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Invalid input. Please enter a numeric age.");
		} 
	}
}
