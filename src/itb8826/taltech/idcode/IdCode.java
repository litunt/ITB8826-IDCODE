package itb8826.taltech.idcode;

public class IdCode {

    private final String idCodeValue;

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
        return null;
    }

    /**
     * Get the year that the person was born in.
     *
     * @return int with person's birth year.
     */
    public int getFullYear() {
        return 2021;
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
