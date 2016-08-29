package org.fundacionjala.CodeWarsKata;

/**
 * Created by AlvaroDaza on 8/26/2016.
 */
public class EANValidator {

    public static final int CHECKSUM_FORMULA_CONDITION = 10;
    public static final int VALUE_OF_THE_FORMULA = 10;
    public static final int FOR_INIT = 0;
    public static final int LENGTH_ARRAY_LIMIT = 2;
    public static final int ODD_MULTIPLICATOR_VALUE = 3;
    public static final int VECTOR_LENGTH_INIT = 13;
    public static final int PAIR_ODD_DIVIDER = 2;
    public static final int RESULT_CONDITION = 0;
    public static final int PENULT_VENTOR_POSITION = 1;

    /**
     * calculate the total value of the pair and odd number
     *
     * @param code String , the code recived
     * @return shows the result , true or false
     */
    public static boolean validate(String code) {
        int lastValue = Character.getNumericValue(code.charAt(code.length() - PENULT_VENTOR_POSITION));
        int[] checkSum = fillTheVector(code);
        int total = 0;
        for (int i = FOR_INIT; i <= code.length() - LENGTH_ARRAY_LIMIT; i++) {
            if (i % PAIR_ODD_DIVIDER == 0) {
                total += checkSum[i];
            } else {
                total += checkSum[i] * ODD_MULTIPLICATOR_VALUE;
            }
        }
        return checkSumResult(lastValue, total);
    }

    /**
     * calculate the boolean value
     *
     * @param lastValue integer the las value of the vector
     * @param total     integer, the result of the add of pair and add positions
     * @return return true or fale
     */

    private static boolean checkSumResult(int lastValue, int total) {
        int checkSumValue;
        if (total % CHECKSUM_FORMULA_CONDITION == RESULT_CONDITION) {
            checkSumValue = 0;
        } else {
            checkSumValue = VALUE_OF_THE_FORMULA - (total % VALUE_OF_THE_FORMULA);
        }
        if (checkSumValue == lastValue) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * fills the vector whit the code become integers
     *
     * @param code String , code received
     * @return int vector fiil whit the code
     */
    public static int[] fillTheVector(String code) {
        int[] intCode = new int[VECTOR_LENGTH_INIT];
        for (int i = FOR_INIT; i <= code.length() - LENGTH_ARRAY_LIMIT; i++) {
            intCode[i] = Character.getNumericValue(code.charAt(i));
        }
        return intCode;
    }

}
