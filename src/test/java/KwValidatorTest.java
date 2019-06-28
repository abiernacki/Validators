import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KwValidatorTest {

    @Test
    public void testKwValidatorCorrect() {

        //given
        String kw = "WL1A/00272852/9";


        //when
        KwValidator kwValidator = new KwValidator();
        boolean valid = kwValidator.valid(kw);


        //then
        assertTrue(valid);
    }

    @Test
    public void testKwValidatorIncorrect() {

        //given
        String kw = "W31A/00272852/4";


        //when
        KwValidator kwValidator = new KwValidator();
        boolean valid = kwValidator.valid(kw);


        //then
        assertFalse(valid);
    }

    @Test
    public void testKwValidatorLessThen15Chars() {

        //given
        String kw = "WL1A/00272852/";


        //when
        KwValidator kwValidator = new KwValidator();
        boolean valid = kwValidator.valid(kw);


        //then
        assertFalse(valid);
    }

    @Test
    public void testKwValidatorMoreThen15Chars() {

        //given
        String kw = "WL1A/00272852/99";


        //when
        KwValidator kwValidator = new KwValidator();
        boolean valid = kwValidator.valid(kw);


        //then
        assertFalse(valid);
    }

    @Test
    public void testKwValidatorNoFirstSlash() {

        //given
        String kw = "WL1A800272852/99";


        //when
        KwValidator kwValidator = new KwValidator();
        boolean valid = kwValidator.valid(kw);


        //then
        assertFalse(valid);
    }

    @Test
    public void testKwValidatorNoSecondSlash() {

        //given
        String kw = "WL1A/00272852899";


        //when
        KwValidator kwValidator = new KwValidator();
        boolean valid = kwValidator.valid(kw);


        //then
        assertFalse(valid);
    }

    @Test
    public void testKwValidatorCheckFirstChar() {

        //given
        String kw = "8L1A/00272852899";


        //when
        KwValidator kwValidator = new KwValidator();
        boolean valid = kwValidator.valid(kw);


        //then
        assertFalse(valid);
    }

    @Test
    public void testKwValidatorIsNullOrIsEmpty() {

        //given
        String kw = null;
        //if (kw == null) {
        //    kw = "";
        //}

        //when
        KwValidator kwValidator = new KwValidator();
        boolean valid = kwValidator.valid(kw);


        //then
        assertFalse(valid);


    }
}