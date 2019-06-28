import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegonValidatorTest {

    @Test
    public void testRegonCorrect9() {

        //given
        String regon = "732065814";

        //when
        RegonValidator regonValidator = new RegonValidator();
        boolean valid = regonValidator.valid(regon);

        //then
        assertTrue(valid);
    }


    @Test
    public void testRegonCorrect14() {

        //given
        String regon = "23511332857188";

        //when
        RegonValidator regonValidator = new RegonValidator();
        boolean valid = regonValidator.valid(regon);

        //then
        assertTrue(valid);
    }


    @Test
    public void testRegonIncorrect9() {

        //given
        String regon = "732065813";

        //when
        RegonValidator regonValidator = new RegonValidator();
        boolean valid = regonValidator.valid(regon);

        //then
        assertFalse(valid);
    }


    @Test
    public void testRegonIncorrect14() {

        //given
        String regon = "23511332857189";

        //when
        RegonValidator regonValidator = new RegonValidator();
        boolean valid = regonValidator.valid(regon);

        //then
        assertFalse(valid);
    }


    @Test
    public void testRegonLessThen9() {

        //given
        String regon = "73206581";

        //when
        RegonValidator regonValidator = new RegonValidator();
        boolean valid = regonValidator.valid(regon);

        //then
        assertFalse(valid);
    }

    @Test
    public void testRegonMoreThen9AndLessThen14() {

        //given
        String regon = "7320658134";

        //when
        RegonValidator regonValidator = new RegonValidator();
        boolean valid = regonValidator.valid(regon);

        //then
        assertFalse(valid);
    }


    @Test
    public void testRegonMoreThen14() {

        //given
        String regon = "235113328571886";

        //when
        RegonValidator regonValidator = new RegonValidator();
        boolean valid = regonValidator.valid(regon);

        //then
        assertFalse(valid);
    }


    @Test
    public void testRegonIsNullOrIsEmpty() {

        //given
        String regon = null;
        if (regon == null) {
            regon = "";
        }

        //when
        RegonValidator regonValidator = new RegonValidator();
        boolean valid = regonValidator.valid(regon);


        //then
        assertFalse(valid);
    }
}