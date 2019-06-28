import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NipValidatorTest {

    @Test
    public void testNipCorrect(){

        //given
        String nip = "7121809750";

        //when
        NipValidator nipValidator = new NipValidator();
        boolean valid = nipValidator.valid(nip);

        //then
        assertTrue(valid);
    }

    @Test
    public void testNipCorrect13(){

        //given
        String nip = "712-180-97-50";

        //when
        NipValidator nipValidator = new NipValidator();
        boolean valid = nipValidator.valid(nip);

        //then
        assertTrue(valid);
    }

    @Test
    public void testNipCorrect15(){

        //given
        String nip = "PL712-180-97-50";

        //when
        NipValidator nipValidator = new NipValidator();
        boolean valid = nipValidator.valid(nip);

        //then
        assertTrue(valid);
    }

    @Test
    public void testNipIncorrect(){

        //given
        String nip = "7121809751";

        //when
        NipValidator nipValidator = new NipValidator();
        boolean valid = nipValidator.valid(nip);

        //then
        assertFalse(valid);
    }

    @Test
    public void testNipIncorrect13(){

        //given
        String nip = "712-180-97-51";

        //when
        NipValidator nipValidator = new NipValidator();
        boolean valid = nipValidator.valid(nip);

        //then
        assertFalse(valid);
    }
    @Test
    public void testNipIncorrect15(){

        //given
        String nip = "PL712-180-97-51";

        //when
        NipValidator nipValidator = new NipValidator();
        boolean valid = nipValidator.valid(nip);

        //then
        assertFalse(valid);
    }



    @Test
    public void testNipLessThen10(){

        //given
        String nip = "712180975";

        //when
        NipValidator nipValidator = new NipValidator();
        boolean valid = nipValidator.valid(nip);

        //then
        assertFalse(valid);
    }


    @Test
    public void testNipMoreThen10AndLessThen13(){

        //given
        String nip = "71218097501";

        //when
        NipValidator nipValidator = new NipValidator();
        boolean valid = nipValidator.valid(nip);

        //then
        assertFalse(valid);
    }

    @Test
    public void testNipMoreThen13AndLessThen15(){

        //given
        String nip = "71218097501123";

        //when
        NipValidator nipValidator = new NipValidator();
        boolean valid = nipValidator.valid(nip);

        //then
        assertFalse(valid);
    }

    @Test
    public void testNipMoreThen15(){

        //given
        String nip = "71218097501123123";

        //when
        NipValidator nipValidator = new NipValidator();
        boolean valid = nipValidator.valid(nip);

        //then
        assertFalse(valid);
    }

    @Test
    public void testNipNoSeparator(){

        //given
        String nip = "PL712-180-97051";

        //when
        NipValidator nipValidator = new NipValidator();
        boolean valid = nipValidator.valid(nip);

        //then
        assertFalse(valid);
    }


    @Test
    public void testNipIsNullOrIsEmpty(){

        //given
        String nip = null;
        if (nip == null) {
            nip = "";
        }
        //when
        NipValidator nipValidator = new NipValidator();
        boolean valid = nipValidator.valid(nip);

        //then
        assertFalse(valid);
    }
}