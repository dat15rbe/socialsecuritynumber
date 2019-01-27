public class PersonInfo {

    private boolean male;
    private String birthNumber;
    private String yyyy;
    private String mm;
    private String dd;
    private boolean invalid;

    public PersonInfo(String birthNumber) {
        this.birthNumber = birthNumber;
    }

    public PersonInfo setMale() {
        this.male = true;
        return this;
    }



    public PersonInfo yearOfBirth(String yyyy) {
        this.yyyy = yyyy;
        return this;
    }

    public PersonInfo monthOfBirth(String mm) {
        this.mm = mm;
        return this;
    }

    public PersonInfo dayOfBirth(String dd) {
        this.dd = dd;
        return this;
    }

    public PersonInfo setFemale() {
        this.male = false;
        return this;
    }
    public boolean isMale() {
        return male;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public String getYear2Digits() {
        return yyyy.substring(2, 4);
    }

    public String getYear4Digits() {
        return yyyy;
    }

    public String getMonth() {
        return mm;
    }

    public String getDay() {
        return dd;
    }

    public String getBirthNumber() {
        return birthNumber;
    }

    public PersonInfo setInvalid() {
        this.invalid = true;
        return this;
    }


}

