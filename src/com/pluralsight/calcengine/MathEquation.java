package com.pluralsight.calcengine;

public class MathEquation {
    double leftVal;
    double rightVal;
    char opCode;
    double result;

    public static int numberOfCalculations;

    private static double sumOfResults;

    public MathEquation() {}

    public MathEquation(char opCode) {
        this.opCode = opCode;
    }

    public MathEquation(char opCode, double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    void execute()
    {
        switch (opCode)
        {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = leftVal / rightVal;
                break;
            default:
                result = 0.0f;
                break;
        }
        numberOfCalculations++;
        sumOfResults += result;
    }

    public String toString()
    {
        char symbol = symbolFromOpCode();
        StringBuilder builder = new StringBuilder(20);
        builder.append(leftVal);
        builder.append(" ");
        builder.append(symbol);
        builder.append(" ");
        builder.append(rightVal);
        builder.append(" = ");
        builder.append(result);
        return builder.toString();
    }
    public char symbolFromOpCode()
    {
        char [] opCodes   = {'d','a','s','m'};
        char [] symbols   = {'-','+','*','/'};

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

    public void execute(double leftVal, double rightVal){
        this.leftVal  = leftVal;
        this.rightVal = rightVal;
         execute();
    }

    public void execute(int leftVal, int rightVal){
        this.leftVal  = leftVal;
        this.rightVal = rightVal;
        execute();
        result = (int) result;
    }

    public static double getAverageResult()
    {
        return sumOfResults / numberOfCalculations;
    }

    public double getLeftVal() {
        return leftVal;
    }

    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }

    public double getRightVal() {
        return rightVal;
    }

    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }

    public char getOpCode() {
        return opCode;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
