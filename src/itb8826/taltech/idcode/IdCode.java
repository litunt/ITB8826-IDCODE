package itb8826.taltech.idcode;

public class IdCode {

    private final String idCodeValue;

    private static String KURESSAARE = "Kuressaare";
    private static String TARTU = "Tartu";
    private static String TALLINN = "Tallinn";
    private static String KOHTLAJARVE = "Kohtla-Järve";
    private static String NARVA = "Narva";
    private static String PARNU = "Pärnu";
    private static String PAIDE = "Paide";
    private static String RAKVERE = "Rakvere";
    private static String VALGA = "Valga";
    private static String VILJANDI = "Viljandi";
    private static String VORU = "Võru";
    private static String UNKNOWN = "unknown";

    public enum Gender {
        MALE, FEMALE
    }

    /**
     * Method returns the id code.
     *
     * @return id code.
     */
    public String getIdCodeValue() {
        return idCodeValue;
    }

    public IdCode(String idCodeValue) {
        this.idCodeValue = idCodeValue;
    }

    /**
     * Check if the id code is valid or not.
     *
     * @return boolean describing whether or not the id code was correct.
     */
    public boolean isCorrect() {
        return false;
    }

    /**
     * Get all information about id code.
     *
     * @return String containing information.
     */
    public String getInformation() {
        return null;
    }

    /**
     * Get gender enum.
     *
     * @return enum describing person's gender
     */
    public Gender getGender() {
        int firstNum = Integer.parseInt(idCodeValue.substring(0, 1));
        if (firstNum % 2 != 0) {
            return Gender.MALE;
        }
        return Gender.FEMALE;
    }

    /**
     * Get person's birth location.
     *
     * @return String with the person's birth place.
     */
    public String getBirthPlace() {
        int placeNum = Integer.parseInt(idCodeValue.substring(8));
        if (placeNum == 0 || placeNum >= 711) {
            return UNKNOWN;
        }
        if (placeNum <= 10) {
            return KURESSAARE;
        }
        return "Tallinn";
    }

    /**
     * Get the year that the person was born in.
     *
     * @return int with person's birth year.
     */
    public int getFullYear() {
        int firstNum = Integer.parseInt(idCodeValue.substring(0, 1));
        int initYear = Integer.parseInt(idCodeValue.substring(1, 3));

        if (firstNum <= 2) {
            return 1800 + initYear;
        } else if (firstNum <= 4) {
            return 1900 + initYear;
        }
        return 2000 + initYear;
    }

    /**
     * Check if gender number is correct.
     *
     * @return boolean describing whether the gender number is correct.
     */
    private boolean isGenderNumberCorrect() {
        return false;
    }

    /**
     * Check if the year number is correct.
     *
     * @return boolean describing whether the year number is correct.
     */
    private boolean isYearNumberCorrect() {
        return false;
    }

    /**
     * Check if the month number is correct.
     *
     * @return boolean describing whether the month number is correct.
     */
    private boolean isMonthNumberCorrect() {
        return false;
    }

    /**
     * Check if the day number is correct.
     *
     * @return boolean describing whether the day number is correct.
     */
    private boolean isDayNumberCorrect() {
        return false;
    }

    /**
     * Check if the control number is correct.
     *
     * @return boolean describing whether the control number is correct.
     */
    private boolean isControlNumberCorrect() {
        return false;
    }

    /**
     * Check if the given year is a leap year.
     *
     * @param fullYear
     * @return boolean describing whether the given year is a leap year.
     */
    private boolean isLeapYear(int fullYear) {
        return false;
    }
}
