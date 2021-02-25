import java.io.*;
import StringCalculator;

public class StringCalculator {
    public static final void add(final String numbers) {
        String[] numbersArray = numbers.split(",");
        if (numbersArray.length > 2) {
            throw new RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
        } else {
            for (String number : numbersArray) {
                Integer.parseInt(number); // If it is not a number, parseInt will throw an exception
            }
        }
    }
}

public static int add(final String numbers) {
    int returnValue = 0;
    String[] numbersArray = numbers.split(",");
    // Removed after exception
     if (numbersArray.length > 2) {
     throw new RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
     }
    for (String number : numbersArray) {
        if (!number.trim().isEmpty()) { // After refactoring
            returnValue += Integer.parseInt(number);
        }
    }
    return returnValue;
}

public static int add(final String numbers) {
    int returnValue = 0;
    String[] numbersArray = numbers.split(",|n"); // Added |n to the split regex
    for (String number : numbersArray) {
        if (!number.trim().isEmpty()) {
            returnValue += Integer.parseInt(number.trim());
        }
    }
    return returnValue;
}

public static int add(final String numbers) {
    String delimiter = ",|n";
    String numbersWithoutDelimiter = numbers;
    if (numbers.startsWith("//")) {
        int delimiterIndex = numbers.indexOf("//") + 2;
        delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
        numbersWithoutDelimiter = numbers.substring(numbers.indexOf("n") + 1);
    }
    return add(numbersWithoutDelimiter, delimiter);
}

private static int add(final String numbers, final String delimiter) {
    int returnValue = 0;
    String[] numbersArray = numbers.split(delimiter);
    for (String number : numbersArray) {
        if (!number.trim().isEmpty()) {
            returnValue += Integer.parseInt(number.trim());
        }
    }
    return returnValue;
}

private static int add(final String numbers, final String delimiter) {
    int returnValue = 0;
    String[] numbersArray = numbers.split(delimiter);
    List negativeNumbers = new ArrayList();
    for (String number : numbersArray) {
        if (!number.trim().isEmpty()) {
            int numberInt = Integer.parseInt(number.trim());
            if (numberInt < 0) {
                negativeNumbers.add(numberInt);
            }
            returnValue += numberInt;
        }
    }
    if (negativeNumbers.size() > 0) {
        throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
    }
    return returnValue;     
}


private static int add(final String numbers, final String delimiter) {
    int returnValue = 0;
    String[] numbersArray = numbers.split(delimiter);
    List negativeNumbers = new ArrayList();
    for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                    int numberInt = Integer.parseInt(number.trim());
                    if (numberInt < 0) {
                            negativeNumbers.add(numberInt);
                    } else if (numberInt <= 1000) {
                            returnValue += numberInt;
                    }
            }
    }
    if (negativeNumbers.size() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
    }
    return returnValue;                
}