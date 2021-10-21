package itb8826.taltech.idcode;

import java.util.Calendar;
import java.util.Scanner;

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
        return isCorrectBasic() && isYearNumberCorrect()
                && isGenderNumberCorrect() && isControlNumberCorrect()
                && isMonthNumberCorrect() && isDayNumberCorrect();
    }

    /**
     * Check if the id code is valid under basic cases or not.
     *
     * @return boolean describing whether or not the id code was correct.
     */
    private boolean isCorrectBasic() {
        return idCodeValue.length() == 11 && idCodeValue.matches("[0-9]+");
    }

    /**
     * Get all information about id code.
     *
     * @return String containing information.
     */
    public String getInformation() {
        String gender = getGender().name();
        String birthDate = getBirthDate();
        String birthPlace = getBirthPlace();
        return String.format("This is a %s born on %s in %s",
                gender, birthDate, birthPlace);
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
        int placeNum = Integer.parseInt(idCodeValue.substring(7, 10));
        if (placeNum == 0 || placeNum >= 711) {
            return UNKNOWN;
        } else if (placeNum <= 10) {
            return KURESSAARE;
        } else if (placeNum <= 20 || placeNum >= 271 && placeNum <= 370) {
            return TARTU;
        } else if (placeNum <= 220 || placeNum >= 471 && placeNum <= 490) {
            return TALLINN;
        } else if (placeNum <= 270) {
            return KOHTLAJARVE;
        } else if (placeNum <= 420) {
            return NARVA;
        } else if (placeNum <= 470) {
            return PARNU;
        } else if (placeNum <= 520) {
            return PAIDE;
        } else if (placeNum <= 570) {
            return RAKVERE;
        } else if (placeNum <= 600) {
            return VALGA;
        } else if (placeNum <= 650) {
            return VILJANDI;
        }
        return VORU;
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
     * Get the birthdate that the person was born.
     *
     * @return string with person's birth date.
     */
    public String getBirthDate() {
        String day = idCodeValue.substring(5, 7);
        String month = idCodeValue.substring(3, 5);
        int year = getFullYear();
        return String.format("%s.%s.%d", day, month, year);
    }

    /**
     * Check if gender number is correct.
     *
     * @return boolean describing whether the gender number is correct.
     */
    private boolean isGenderNumberCorrect() {
        int genderNum = Integer.parseInt(idCodeValue.substring(0, 1));
        return genderNum >= 1 && genderNum <= 6;
    }

    /**
     * Check if the year number is correct.
     *
     * @return boolean describing whether the year number is correct.
     */
    private boolean isYearNumberCorrect() {
        int genderNumber = Integer.parseInt(idCodeValue.substring(0, 1));
        int yearNumber = Integer.parseInt(idCodeValue.substring(1, 3));
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (genderNumber > 4) {
            return yearNumber + 2000 <= currentYear;
        } else {
            return true;
        }

    }

    /**
     * Check if the month number is correct.
     *
     * @return boolean describing whether the month number is correct.
     */
    private boolean isMonthNumberCorrect() {
        int month = Integer.parseInt(idCodeValue.substring(3, 5));
        return month > 0 && month <= 12;
    }

    /**
     * Check if the day number is correct.
     *
     * @return boolean describing whether the day number is correct.
     */
    public boolean isDayNumberCorrect() {
        int month = Integer.parseInt(idCodeValue.substring(3, 5));
        int day = Integer.parseInt(idCodeValue.substring(5, 7));
        int fullYear = getFullYear();
        if (day > 28) {
            if (month == 2) {
                return day < 30 && isLeapYear(fullYear);
            } else if (month <= 7 && month % 2 == 0 || month > 7 && month % 2 != 0) {
                return day < 31;
            }
        }
        return true;
    }

    /**
     * Check if the control number is correct.
     *
     * @return boolean describing whether the control number is correct.
     */
    private boolean isControlNumberCorrect() {
        try {
            int controlNumberFromIdCode = Integer.parseInt(idCodeValue.substring(10));

            int factor = 1;

            int controlNumber = 0;
            boolean controlNumberFound = false;
            int numberOfTries = 0;

            while (numberOfTries < 2 && !controlNumberFound) {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += Character.getNumericValue(idCodeValue.charAt(i)) * factor;
                    factor++;
                    if (factor > 9) {
                        factor = 1;
                    }
                }
                numberOfTries++;
                controlNumber = sum % 11;
                if (controlNumber != 10) {
                    controlNumberFound = true;
                }
                factor += 2;
            }
            return controlNumber == controlNumberFromIdCode;
        } catch (NumberFormatException x) {
            return false;
        }

    }

    /**
     * Check if the given year is a leap year.
     *
     * @param fullYear
     * @return boolean describing whether the given year is a leap year.
     */
    private boolean isLeapYear(int fullYear) {
        return ((fullYear % 4 == 0) && (fullYear % 100 != 0)) || (fullYear % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("Enter ID code");

        String idCodeString = consoleScanner.nextLine();
        IdCode idCode = new IdCode(idCodeString);

        if (!idCode.isCorrectBasic()) {
            System.out.println("Entered ID code is incorrect!");
            return;
        }

        System.out.println("Choose method (number): ");
        System.out.println("1 - getGender()\n2 - getFullYear()\n3 - getBirthPlace()\n" +
                "4 - getInformation()\n5 - getBirthDate()\n6 - isCorrect()");

        int methodNumber = Integer.parseInt(consoleScanner.nextLine());
        switch (methodNumber) {
            case 1:
                System.out.println("Gender: " + idCode.getGender());
            case 2:
                System.out.println("Full year: " + idCode.getFullYear());
            case 3:
                System.out.println("Birth place: " + idCode.getBirthPlace());
            case 4:
                System.out.println("Information: " + idCode.getInformation());
            case 5:
                System.out.println("Birthdate: " + idCode.getBirthDate());
            case 6:
                System.out.println("Is correct? " + (idCode.isCorrect() ? "YES" : "NO"));
            default:
                System.out.println("Wrong method number!");
        }
    }
}
