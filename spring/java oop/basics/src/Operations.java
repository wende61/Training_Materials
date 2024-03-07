import java.util.Arrays;
import java.util.List;

public class Operations {

    public static void main(String[] args) {

        // Conditional Operator ( ? : )
            int a, b;
            a = 10;
            b = (a == 1) ? 20: 30;
            System.out.println( "Value of b is : " +  b );
    
            b = (a == 10) ? 20: 30;
            System.out.println( "Value of b is : " + b );

        // instanceof operator
            String name = "James";

            // following will return true since name is type of String
            boolean result = name instanceof String;
            System.out.println( result );
        //Data types 
            // primitive types
        
            byte byteValue1 = 2;
            byte byteValue2 = 4;
            byte byteResult = (byte)(byteValue1 + byteValue2);

            System.out.println("Byte: " + byteResult);

            short shortValue1 = 2;
            short shortValue2 = 4;
            short shortResult = (short)(shortValue1 + shortValue2);

            System.out.println("Short: " + shortResult);

            int intValue1 = 2;
            int intValue2 = 4;
            int intResult = intValue1 + intValue2;

            System.out.println("Int: " + intResult);

            long longValue1 = 2L;
            long longValue2 = 4L;
            long longResult = longValue1 + longValue2;

            System.out.println("Long: " + longResult);

            float floatValue1 = 2.0f;
            float floatValue2 = 4.0f;
            float floatResult = floatValue1 + floatValue2;

            System.out.println("Float: " + floatResult);

            double doubleValue1 = 2.0;
            double doubleValue2 = 4.0;
            double doubleResult = doubleValue1 + doubleValue2;

            System.out.println("Double: " + doubleResult);

            boolean booleanValue = true;

            System.out.println("Boolean: " + booleanValue);

            char charValue = 'A';

            System.out.println("Char: " + charValue);   

        //refrence types
            // Creating an object of 'String' class
            String myString = new String("Hello, World!");


        // conditional statments
        //for making desitions
            // if
            // if..else
            // nested if else
            // switch
            int x = 30;

            if( x < 20 ) {
                System.out.print("This is if statement");
            }else {
                System.out.print("This is else statement");
            }

            // nested if statements
            if( x == 10 ) {
                System.out.print("Value of X is 10");
             }else if( x == 20 ) {
                System.out.print("Value of X is 20");
             }else if( x == 30 ) {
                System.out.print("Value of X is 30");
             }else {
                System.out.print("This is else statement");
             }
            //switch

            char grade = 'C';

            switch(grade) {
                case 'A' :
                    System.out.println("Excellent!"); 
                    break;
                case 'B' :
                case 'C' :
                    System.out.println("Well done");
                    break;
                case 'D' :
                    System.out.println("You passed");
                case 'F' :
                    System.out.println("Better try again");
                    break;
                default :
                    System.out.println("Invalid grade");
            }
            System.out.println("Your grade is " + grade);
        // For loop
        // The for loop provides a concise way to iterate over a range of values or to perform repetitive tasks with a counter.
        // It consists of three parts: initialization (executed once at the beginning), condition (evaluated before each iteration), 
        // and update (executed after each iteration).
        for (int i = 0; i <= 10; i = i + 2) {
            System.out.println(i);
        }
        // the new for loop enhancements
        // enhanced for loop or for each
        String[] names = { "Alice", "Bob", "Charlie" };
        for (String n : names) {
            System.out.println(n);
        }

        // Nested For Loop
        // Nested loops are loops within loops. They are useful for iterating over
        // multi-dimensional
        // arrays or for performing more complex iteration patterns.
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        //labled for loop
        outer: for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i * j > 2) {
                    System.out.println("Breaking outer loop.");
                    break outer;
                }
                System.out.println(i + " " + j);
            }
        }

        // infinite loop

        // for( ;; ) {
        //     System.out.print("value of x : " + x );
        //     x++;
        //     System.out.print("\n");
        //  }
         
        // A while loop statement in Java programming language repeatedly executes a code block as long as a given condition is true.
        // The while loop is an entry control loop, where condition is checked before executing the loop's body.
        int condition = 10;
        while( condition < 20 ) {
           System.out.print("value of x : " + x );
           x++;
           System.out.print("\n");
        }

        //do-while
        // The do-while loop is similar to the while loop, but it executes the loop body at least once, regardless of the condition.
        // It evaluates the condition after each iteration, so the loop body is executed at least once before checking the condition.

        int i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i < 5);

        /*
        Operations in Java
            
        Java supports a wide range of operations, including arithmetic, comparison, and logical operations. Here are some examples:
        
        Arithmetic Operations:
            Addition: int sum = 5 + 3;
            Subtraction: int difference = 5 - 3;
            Multiplication: int product = 5 * 3;
            Division: int quotient = 5 / 3;
            Modulus: int remainder = 5 % 3;
        Comparison Operations:
            Equal to: boolean isEqual = 5 == 3;
            Not equal to: boolean isNotEqual = 5 != 3;
            Greater than: boolean isGreater = 5 > 3;
            Less than: boolean isLess = 5 < 3;
            Greater than or equal to: boolean isGreaterOrEqual = 5 >= 3;
            Less than or equal to: boolean isLessOrEqual = 5 <= 3;
        Logical Operations:
            AND: boolean isAnd = 5 > 3 && 5 < 10;
            OR: boolean isOr = 5 > 3 || 5 < 2;
            NOT: boolean isNot = !(5 > 3);        
        */

    }
}
