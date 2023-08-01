package com.pluralsight.calcengine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        double [] letVales   = {100.0d,25.0d,225.0d,11.0d};
//        double [] rightVales = {50.0d,92.0d,17.0d,3.0d};
//        char [] opCodes      = {'d','a','s','m'};
//        double [] results = new double[opCodes.length];
//
//        if (args.length == 0)
//        {
//            for (int i=0; i < opCodes.length; i++)
//            {
//                results[i] = execute(opCodes[i],letVales[i],rightVales[i]);
//            }
//
//            for (double currentResult : results)
//                System.out.println(currentResult);
//
//        }else if (args.length == 1 && args[0].equals("interactive"))
            executeInteractively();
//        else if (args.length == 3)
//                handleCommandLine(args);
//        else
//            System.out.println("Please provide an operation code and 2 numeric value");
//        performCalculation();
    }

    static void performCalculation()
    {
        MathEquation [] equations = new MathEquation[4];
        equations[0] = new MathEquation('d',100.0d,50.0d);
        equations[1] = new MathEquation('a',25.0d,92.0d);
        equations[2] = new MathEquation('s',225.0d,17.0d);
        equations[3] = new MathEquation('m',11.0d,3.0d);


        for (MathEquation equation : equations)
        {
            equation.execute();
            System.out.println(equation); // println will call toString
        }

        System.out.println("Average result + " + MathEquation.getAverageResult());

        useOverLoads();
    }

    static void useOverLoads()
    {
        System.out.println();
        System.out.println("Using execute overload");

        MathEquation equationOverload = new MathEquation('d');

        double leftDouble  = 9.0d;
        double rightDouble = 4.0d;
        equationOverload.execute(leftDouble,rightDouble);
        System.out.println("Overload result with double = " + equationOverload.getResult());

        int leftInt  = 9;
        int rightInt = 4;

        equationOverload.execute(leftInt,rightInt);
        System.out.println("Overload result with ints = " + equationOverload.getResult());
    }
//    private static MathEquation create(double leftVal, double rightVal, char opCode)
//    {
//        MathEquation equation = new MathEquation();
//        equation.setLeftVal(leftVal);
//        equation.setRightVal(rightVal);
//        equation.setOpCode(opCode);
//        return equation;
//    }
    static void executeInteractively()
    {
        System.out.println("Enter and operation and two numbers");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String [] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        char opCode       = opCodeFromString(parts[0]);
        double letVal   = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);
        MathEquation equation = new MathEquation(opCode,letVal,rightVal);
        equation.execute();
        System.out.println(equation);
    }

    private static void displayResult(char opCode, double letVales, double rightVales, double result) {
        char symbol = symbolFromOpCode(opCode);
        StringBuilder builder = new StringBuilder(20);
        builder.append(letVales);
        builder.append(" ");
        builder.append(symbol);
        builder.append(" ");
        builder.append(rightVales);
        builder.append(" = ");
        builder.append(result);
        String output = builder.toString();
        System.out.println(output);
    }

    private static char symbolFromOpCode(char opCode)
    {
        char [] opCodes   = {'d','a','s','m'};
        char [] symbols   = {'+','-','*','/'};

        char symbol = ' ';

        for (int index = 0; index < opCodes.length; index ++)
        {
            if (opCode == opCodes[index])
            {
                symbol = symbols[index];
                break;
            }
        }
        return symbol;
    }

    private static void handleCommandLine(String[] args) {
        char opCode       = args[0].charAt(0);
        double letVales   = Double.parseDouble(args[1]);
        double rightVales = Double.parseDouble(args[2]);
        double result     = execute(opCode,letVales,rightVales);
        System.out.println(result);
    }

    static double execute(char opCodes, double letVales, double rightVales)
    {
        double result;

        switch (opCodes)
        {
            case 'a':
                result = letVales + rightVales;
                break;
            case 's':
                result = letVales - rightVales;
                break;
            case 'm':
                result = letVales * rightVales;
                break;
            case 'd':
                result = letVales / rightVales;
                break;
            default:
                result = 0.0f;
                break;
        }

        return result;
    }

    static char opCodeFromString(String operationName)
    {
        char opCode = operationName.charAt(0);
        return opCode;
    }

    static double valueFromWord(String word)
    {
        String [] newWords = {
                    "zero","one","two","three","four",
                    "five", "six","seven","eight", "nine"
        };
        boolean isValueSet = false;
        double value = 0d;

        for (int index=0; index < newWords.length; index++)
        {
            if (word.equals(newWords[index]))
            {
                value = index;
                isValueSet = true;
                break;
            }
        }
        if (!isValueSet)
            value = Double.parseDouble(word);

        return value;

    }
}
