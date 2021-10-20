import itb8826.taltech.idcode.IdCode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static itb8826.taltech.idcode.IdCode.Gender.FEMALE;
import static itb8826.taltech.idcode.IdCode.Gender.MALE;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
