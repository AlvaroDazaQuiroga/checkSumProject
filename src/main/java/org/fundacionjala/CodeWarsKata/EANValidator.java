package org.fundacionjala.CodeWarsKata;

/**
 * Created by AlvaroDaza on 8/26/2016.
 */
public class EANValidator {

    private static final int CHECKSUM_FORMULA_CONDITION = 10;
    private static final int VALUE_OF_THE_FORMULA = 10;
    private static final int LENGTH_ARRAY_LIMIT = 2;
    private static final int ODD_MULTIPLICATOR_VALUE = 3;
    private static final int VECTOR_LENGTH_INIT = 13;
    private static final int PAIR_ODD_DIVIDER = 2;
    private static final int RESULT_CONDITION = 0;


    /**
     * calculate the total value of the pair and odd number
     *
     * @param code String , the code recived
     * @return shows the result , true or false
     */
    public static boolean validate(String code) {
        int lastValue = Character.getNumericValue(code.charAt(code.length() - 1));
        int[] checkSum = fillTheVector(code);
        int total = 0;
        for (int i = 0; i <= code.length() - LENGTH_ARRAY_LIMIT; i++) {
            total += i % PAIR_ODD_DIVIDER == 0 ? checkSum[i] : checkSum[i] * ODD_MULTIPLICATOR_VALUE;
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

    public static boolean checkSumResult(int lastValue, int total) {
        return checksumValue(total) == lastValue;
    }

    /**
     * this class is in charge to calculate the checkValue
     * @param total total added
     * @return return de add 
     */

    public static int checksumValue(int total) {
        return total % CHECKSUM_FORMULA_CONDITION == RESULT_CONDITION ? 0 :
                VALUE_OF_THE_FORMULA - (total % VALUE_OF_THE_FORMULA);
    }

    /**
     * fills the vector whit the code become integers
     *
     * @param code String , code received
     * @return int vector fill whit the code
     */
    public static int[] fillTheVector(String code) {
        int[] intCode = new int[VECTOR_LENGTH_INIT];
        for (int i = 0; i <= code.length() - LENGTH_ARRAY_LIMIT; i++) {
            intCode[i] = Character.getNumericValue(code.charAt(i));
        }
        return intCode;
    }

}
