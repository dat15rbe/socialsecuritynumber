public class ValidateNumber {


    public static boolean isValid(String number) {
        return
                null != number
                        && ValidateNumber.isDigit(number)
                        && ValidateNumber.checkLength(number)
                        && ValidateNumber.checkControlDigits(number);
    }

    private static Integer getDigitAtPosition(String number, int i) {
        return Integer.valueOf("" + number.charAt(i));
    }


    private static boolean isDigit(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                System.out.println("BirthNumber not numeric, first char is: " + number.charAt(i));
                return false;
            }
        }

        return true;
    }

    private static boolean checkLength(String number) {
        if (11 == number.length()) {
            return true;
        }
        System.out.println("BirthNumber not length 11");
        return false;
    }


    private static boolean checkControlDigits(String number) {
        Integer controlDigit1 = 11 - (
                (3 * getDigitAtPosition(number, 0)
                        + 7 * getDigitAtPosition(number, 1)
                        + 6 * getDigitAtPosition(number, 2)
                        + 1 * getDigitAtPosition(number, 3)
                        + 8 * getDigitAtPosition(number, 4)
                        + 9 * getDigitAtPosition(number, 5)
                        + 4 * getDigitAtPosition(number, 6)
                        + 5 * getDigitAtPosition(number, 7)
                        + 2 * getDigitAtPosition(number, 8)) % 11);
        if (controlDigit1.equals(11)) {
            controlDigit1 = 0;
        }
        if (getDigitAtPosition(number, 9).equals(controlDigit1)) {
            Integer controlDigit2 = 11 - ((5 * getDigitAtPosition(number, 0)
                    + 4 * getDigitAtPosition(number, 1)
                    + 3 * getDigitAtPosition(number, 2)
                    + 2 * getDigitAtPosition(number, 3)
                    + 7 * getDigitAtPosition(number, 4)
                    + 6 * getDigitAtPosition(number, 5)
                    + 5 * getDigitAtPosition(number, 6)
                    + 4 * getDigitAtPosition(number, 7)
                    + 3 * getDigitAtPosition(number, 8)
                    + 2 * controlDigit1) % 11);

            if (controlDigit2.equals(11)) {
                controlDigit2 = 0;
            }
            if (getDigitAtPosition(number, 10).equals(controlDigit2)) {
                return true;
            } else {
                System.out.println("Invalid second control number digit " + getDigitAtPosition(number, 10));
                return false;
            }
        } else {
            System.out.println("Invalid first control number digit " + getDigitAtPosition(number, 9));
            return false;
        }
    }


}
