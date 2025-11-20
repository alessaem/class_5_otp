package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

public class Laskin {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Laskin.class.getName());
        Scanner sc = new Scanner(System.in);
        logger.info("Enter the first number:");
        double num1 = sc.nextDouble();
        logger.info("Enter the second number:");
        double num2 = sc.nextDouble();

        logger.info("Select calculation: 1:sum, 2:subtract, 3:multiply, 4:divide ");
        int calculation = sc.nextInt();

        double result;
        switch (calculation) {
            case 1:
                result = addValues(num1, num2);
                break;
            case 2:
                result = subtract(num1, num2);
                break;
            case 3:
                result = multiply(num1, num2);
                break;
            case 4:
                if (num2 == 0) {
                    logger.info("Cannot divide by zero");
                    sc.close();
                    return;
                }
                result = divide(num1, num2);
                break;
            default:
                logger.warning("Unknown operation selected");
                sc.close();
                return;
        }

        logger.info(()->"The result is: " + result);

    }

    public static double addValues(double num1, double num2){
        return num1 + num2;
    }

    public static double multiply(double num1, double num2){
        return num1 * num2;
    }

    public static double divide(double num1, double num2){
        return num1 / num2;
    }

    public static double subtract(double num1, double num2){
        return num1-num2;
    }
}
