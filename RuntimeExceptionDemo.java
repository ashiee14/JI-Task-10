import java.util.logging.Level;
import java.util.logging.Logger;

// Custom Checked Exception Class
class InvalidStudentMarksException extends Exception {
    public InvalidStudentMarksException(String message) {
        super(message);
    }
}

public class RuntimeExceptionDemo {

    // Create Logger instance for this class
    private static final Logger LOGGER = Logger.getLogger(RuntimeExceptionDemo.class.getName());

    public static void main(String[] args) {
        System.out.println("CHECKED vs UNCHECKED EXCEPTION HANDLING WITH LOGGING DEMO");

        // Unchecked exceptions (runtime) — no need to declare throws
        try {
            int result = divide(10, -1); // throws unchecked IllegalArgumentException
            System.out.println("Division result: " + result);
        } catch (ArithmeticException | IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, "Invalid division operation: {0}", e.toString());
            System.out.println("Error: Invalid division operation. " + e.getMessage());
        } finally {
            System.out.println("Cleanup done after division operation.\n");
        }

        try {
            int[] arr = {1, 2, 3};
            accessArray(arr, 5); // throws unchecked ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            LOGGER.log(Level.SEVERE, "Array access failure: {0}", e.toString());
            System.out.println("Error: Array access failure. " + e.getMessage());
        } finally {
            System.out.println("Cleanup done after array access attempt.\n");
        }

        try {
            printStringLength(null); // throws unchecked NullPointerException
        } catch (NullPointerException e) {
            LOGGER.log(Level.SEVERE, "Null string processing attempt: {0}", e.toString());
            System.out.println("Error: Attempted to process a null string. " + e.getMessage());
        } finally {
            System.out.println("Cleanup done after string length check.\n");
        }

        // Checked exception — must be declared and handled
        try {
            checkMarks(105); // throws checked InvalidStudentMarksException
        } catch (InvalidStudentMarksException e) {
            LOGGER.log(Level.SEVERE, "Invalid student marks detected: {0}", e.toString());
            System.out.println("Error: Invalid student marks detected. " + e.getMessage());
        } finally {
            System.out.println("Cleanup done after validating student marks.\n");
        }

        System.out.println("PROGRAM COMPLETED SUCCESSFULLY");
    }

    // Unchecked exception examples (no throws declaration needed)

    public static int divide(int a, int b) {
        if (b == 0) 
            throw new ArithmeticException("Cannot divide by zero — please provide a non-zero divisor.");
        if (b < 0) 
            throw new IllegalArgumentException("Negative divisor not allowed — please enter a positive number.");
        return a / b;
    }

    public static void accessArray(int[] arr, int index) {
        if (index < 0 || index >= arr.length)
            throw new ArrayIndexOutOfBoundsException("Index " + index + " is outside valid range (0 to " + (arr.length - 1) + ").");
        System.out.println("Array element at index " + index + ": " + arr[index]);
    }

    public static void printStringLength(String str) {
        if (str == null) 
            throw new NullPointerException("Provided string reference is null; cannot determine length.");
        System.out.println("String length: " + str.length());
    }

    // Checked exception example (must declare throws)
    public static void checkMarks(int marks) throws InvalidStudentMarksException {
        if (marks < 0 || marks > 100)
            throw new InvalidStudentMarksException("Received marks (" + marks + ") are invalid. Marks must be between 0 and 100 inclusive.");
        System.out.println("Marks " + marks + " are valid.");
    }
}
