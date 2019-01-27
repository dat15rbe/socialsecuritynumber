public final class BirthNumber {

    private final String birthNumber;

    private BirthNumber(String number) {
        if (!ValidateNumber.isValid(number)) {
            throw new IllegalArgumentException("Not a valid BirthNumber");
        }
        this.birthNumber = number;
    }


    public static BirthNumber valueOf(String birthNumber) throws IllegalArgumentException {
        return new BirthNumber(birthNumber);
    }

    public String getBirthYear2Digit() {
        return birthNumber.substring(4, 6);
    }

    public String getMonth() {
        return birthNumber.substring(2, 4);
    }

    public String getDay() {
        return birthNumber.substring(0, 2);
    }

    public boolean isMale() {
        return !isFemale();
    }


    public boolean isFemale() {
        String s = birthNumber.substring(8, 9);
        int sexDigit = Integer.valueOf(s);
        return sexDigit % 2 == 0;
    }

    @Override
    public String toString() {
        return birthNumber;
    }

    public String getBirthYear4Digit() {
        return getBirthCentury() + getBirthYear2Digit();
    }

    private String getBirthCentury() {
        int individSiffer = Integer.parseInt(getIndividualDigit());
        int birthYear = Integer.parseInt(getBirthYear2Digit());
        if (individSiffer > 0 && individSiffer <= 499 && birthYear >= 0 && birthYear < 99) {
            return "19";
        } else if (individSiffer >= 500 && individSiffer <= 999 && birthYear >= 0 && birthYear < 40) {
            return "20";
        } else if (individSiffer >= 500 && individSiffer <= 749 && birthYear >= 54 && birthYear <= 99) {
            return "18";
        } else if (individSiffer >= 900 && individSiffer <= 999 && birthYear >= 40 && birthYear <= 99) {
            return "19";
        } else {
            throw new IllegalStateException("Unexpected birth year" + birthNumber);
        }
    }

    private String getIndividualDigit() {
        return birthNumber.substring(6, 9);
    }

}