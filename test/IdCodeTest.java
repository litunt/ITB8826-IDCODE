import itb8826.taltech.idcode.IdCode;
import org.junit.jupiter.api.Test;

import static itb8826.taltech.idcode.IdCode.Gender.FEMALE;
import static itb8826.taltech.idcode.IdCode.Gender.MALE;
import static org.junit.jupiter.api.Assertions.*;

public class IdCodeTest {

    /* TEST GENDER */

    @Test
    public void givenIdCode_19912272016_whenGetGender_thenReturnMale() {
        assertEquals(new IdCode("19912272016").getGender(), MALE);
    }

    @Test
    public void givenIdCode_39912272017_whenGetGender_thenReturnMale() {
        assertEquals(new IdCode("39912272017").getGender(), MALE);
    }

    @Test
    public void givenIdCode_29912272017_whenGetGender_thenReturnFemale() {
        assertEquals(new IdCode("29912272017").getGender(), FEMALE);
    }

    /* TEST FULL YEAR */

    @Test
    public void givenIdCode_37605030299_whenGetFullYear_thenReturn1976() {
        int result = new IdCode("37605030299").getFullYear();
        assertEquals(result, 1976);
    }

    @Test
    public void givenIdCode_50005200009_whenGetFullYear_thenReturn2000() {
        int result = new IdCode("50005200009").getFullYear();
        assertEquals(result, 2000);
    }

    /* TEST BIRTHPLACE */

    @Test
    public void givenIdCode_37605030015_whenGetBirthPlace_thenReturnKuressaare() {
        String result = new IdCode("37605030015").getBirthPlace();
        assertEquals(result, "Kuressaare");
    }

    @Test
    public void givenIdCode_37605039991_whenGetBirthPlace_thenReturnNull() {
        String result = new IdCode("37605039991").getBirthPlace();
        assertEquals(result, "unknown");
    }

    @Test
    public void givenIdCode_37605030113_whenGetBirthPlace_thenReturnTartu() {
        String result = new IdCode("37605030113").getBirthPlace();
        assertEquals(result, "Tartu");
    }

    @Test
    public void givenIdCode_37605030211_whenGetBirthPlace_thenReturnTallinn() {
        String result = new IdCode("37605030211").getBirthPlace();
        assertEquals(result, "Tallinn");
    }

    @Test
    public void givenIdCode_37605032216_whenGetBirthPlace_thenReturnKohtlaJarveWithHyphen() {
        String result = new IdCode("37605032216").getBirthPlace();
        assertEquals(result, "Kohtla-Järve");
    }

    @Test
    public void givenIdCode_37605033714_whenGetBirthPlace_thenReturnNarva() {
        String result = new IdCode("37605033714").getBirthPlace();
        assertEquals(result, "Narva");
    }

    @Test
    public void givenIdCode_37605034210_whenGetBirthPlace_thenReturnParnu() {
        String result = new IdCode("37605034210").getBirthPlace();
        assertEquals(result, "Pärnu");
    }

    /* TEST INFORMATION */

    @Test
    public void givenIdCode_37605030299_whenGetInformation_thenReturnStringContainingGenderAndBirthDateAndLocation() {
        String result = new IdCode("37605030299").getInformation();
        assertEquals(result, "This is a MALE born on 03.05.1976 in Tallinn");
    }

    @Test
    public void givenIdCode_47605036009_whenGetInformation_thenReturnStringContainingGenderAndBirthDateAndLocation() {
        String result = new IdCode("47605036009").getInformation();
        assertEquals(result, "This is a FEMALE born on 03.05.1976 in Valga");
    }

    /* TEST BIRTHDATE */

    @Test
    public void givenIdCode_47605036009_whenGetBirtHDate_thenReturnStringContainingBirthDate() {
        String result = new IdCode("47605036009").getBirthDate();
        assertEquals(result, "03.05.1976");
    }

    @Test
    public void givenIdCode_47625116009_whenGetBirtHDate_thenReturnStringContainingBirthDate() {
        String result = new IdCode("47611256009").getBirthDate();
        assertEquals(result, "25.11.1976");
    }

    /* TEST IS CORRECT */

    @Test
    public void givenIdCode_376o5030299_notCorrect() {
        assertFalse(new IdCode("376o5030299").isCorrect());
    }

    @Test
    public void givenIdCode_37605030299_whenIsCorrect_thenReturnTrue() {
        assertTrue(new IdCode("49808270244").isCorrect());
    }

    @Test
    public void givenIdCode_37602300299_notCorrect() {
        assertFalse(new IdCode("37602300299").isCorrect());
    }

    /* TEST DAY NUMBER CORRECT */

    @Test
    public void givenIdCode_49802290244_dayNumberNotCorrect() {
        assertFalse(new IdCode("49802290244").isDayNumberCorrect());
    }

    @Test
    public void givenIdCode_49809310244_dayNumberNotCorrect() {
        assertFalse(new IdCode("49809310244").isDayNumberCorrect());
    }

    @Test
    public void givenIdCode_49808270244_dayNumberIsCorrect() {
        assertTrue(new IdCode("49808270244").isDayNumberCorrect());
    }
}
