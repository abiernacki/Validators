import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EanValidatorTest {

    @Test
    public void testEanCorrect() {

        //given
        String ean = "15916485101311";


        //when
        EanValidator eanValidator = new EanValidator();
        boolean valid = eanValidator.valid(ean);


        //then
        assertTrue(valid);

    }

    @Test
    public void testEanIncorrect() {

        //given
        String ean = "15916485101313";


        //when
        EanValidator eanValidator = new EanValidator();
        boolean valid = eanValidator.valid(ean);


        //then
        assertFalse(valid);
    }

    @Test
    public void testPeselLessThen14Chars() {

        //given
        String ean = "1591648510131";


        //when
        EanValidator eanValidator = new EanValidator();
        boolean valid = eanValidator.valid(ean);


        //then
        assertFalse(valid);


    }

    @Test
    public void testPeselMoreThen14Chars() {

        //given
        String ean = "159164851013111";


        //when
        EanValidator eanValidator = new EanValidator();
        boolean valid = eanValidator.valid(ean);


        //then
        assertFalse(valid);
    }

    @Test
    public void testEanIsNullOrIsEmpty() {

        //given
        String ean = null;
        if (ean == null) {
            ean = "";
        }

        //when
        EanValidator eanValidator = new EanValidator();
        boolean valid = eanValidator.valid(ean);


        //then
        assertFalse(valid);

    }
}