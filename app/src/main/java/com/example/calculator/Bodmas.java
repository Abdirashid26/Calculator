package com.example.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bodmas {

    private String result;
    public String newAnswer;

   public Bodmas(String result){
       this.result = result;
       this.newAnswer = findValueInBraces(result);
       System.out.println(newAnswer);
   }

    public static String findValueInBraces(String finalStr) {

        while (finalStr.contains("(") && finalStr.contains(")")) {
            int fIndex = finalStr.indexOf("(");
            int nIndex = finalStr.indexOf(")");
            String subString = finalStr.substring(fIndex + 1, nIndex);
            finalStr = finalStr.substring(0, fIndex)
                    + calculate(subString)
                    + finalStr.substring(nIndex + 1,
                    finalStr.length());
        }
        return calculate(finalStr);

    }

    public static String calculate(String finalString) {

        while (finalString.contains("(") && finalString.contains(")")) {
            findValueInBraces(finalString);
        }
        while (!isNum(finalString)) {
            List<Integer> positions = getOperandPosition(finalString);
            int pos = positions.get(0);
            if (positions.size() >= 2 && positions.get(1) != null) {
                int nxtPos = positions.get(1);
                finalString = getValue(finalString.substring(0, nxtPos), pos)
                        + finalString.substring(nxtPos, finalString.length());
            } else {
                finalString = getValue(
                        finalString.substring(0, finalString.length()), pos);
            }
        }
        return finalString;

    }

    public static boolean isNum(String str) {
        if (str.contains("+") || str.contains("-") || str.contains("*")
                || str.contains("/")) {
            return false;
        }
        return true;
    }

    public static List<Integer> getOperandPosition(String str) {

        List<Integer> integers = new ArrayList<Integer>();

        if (str.contains("+")) {
            integers.add(str.indexOf("+"));
        }

        if (str.contains("-")) {
            integers.add(str.indexOf("-"));
        }

        if (str.contains("*")) {
            integers.add(str.indexOf("*"));
        }

        if (str.contains("/")) {
            integers.add(str.indexOf("/"));
        }

        Collections.sort(integers);
        return integers;
    }

    public static String getValue(String str, int pos) {
        double finalVal = 0;
        double a = Double.parseDouble(str.substring(0, pos));
        double b = Double.parseDouble(str.substring(pos + 1, str.length()));
        char c = str.charAt(pos);

        if (c == '*') {
            finalVal = a * b;
        } else if (c == '/') {
            finalVal = a / b;
        } else if (c == '+') {
            finalVal = a + b;
        } else if (c == '-') {
            finalVal = a - b;
        }
        return String.valueOf(finalVal);
    }
}
