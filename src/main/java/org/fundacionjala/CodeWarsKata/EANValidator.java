package org.fundacionjala.CodeWarsKata;

/**
 * Created by AlvaroDaza on 8/26/2016.
 */
public class EANValidator {
    public static boolean validate(String code) {
        int checkSumValue = 0;
        int lastValue = Character.getNumericValue(code.charAt(code.length() - 1));
        int[] checkSum = fillTheVector(code);
        int sumPair = 0;
        int sumOdd = 0;
        int total = 0;
        for (int i = 0; i <= code.length() - 2; i++) {
            if (i % 2 == 0) {
                sumPair += checkSum[i];
            } else {
                sumOdd += checkSum[i];
            }
        }
        total = sumOdd + sumPair;
        System.out.println(total + " TOTAL");
        if (total % 10 == 0) {
            checkSumValue = 0;
        } else {
            checkSumValue = 10 - (total % 10);
        }

        if (checkSumValue == lastValue) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] fillTheVector(String code) {
        int[] intCode = new int[13];
        for (int i = 0; i <= code.length() - 2; i++) {
            intCode[i] = Character.getNumericValue(code.charAt(i));
        }
        return intCode;
    }

}
