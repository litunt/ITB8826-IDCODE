import itb8826.taltech.idcode.IdCode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static itb8826.taltech.idcode.IdCode.Gender.MALE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdCodeTest {

    @BeforeAll
    static void setup() {
//        log.info("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
//        log.info("@BeforeEach - executes before each test method in this class");
    }

    @Test
    public void givenIdCode_19912272016_whenGetGender_thenReturnMale() {
        assertEquals(new IdCode("19912272016").getGender(), MALE);
    }
}
