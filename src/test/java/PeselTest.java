import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PeselTest {

    @Test
    public void testPeselCorrect() {

        //given
        String pesel = "02070803628";


        //when
        Pesel peselValidator = new Pesel();
        boolean valid = peselValidator.valid(pesel);


        //then
        assertTrue(valid);

    }


    @Test
    public void testPeselIncorrect() {

        //given
        String pesel = "02070803625";


        //when
        Pesel peselValidator = new Pesel();
        boolean valid = peselValidator.valid(pesel);


        //then
        assertFalse(valid);

    }


    @Test
    public void testPeselLessThenElevenChars() {

        //given
        String pesel = "0207080362";


        //when
        Pesel peselValidator = new Pesel();
        boolean valid = peselValidator.valid(pesel);


        //then
        assertFalse(valid);

    }


    @Test
    public void testPeselMoreThenElevenChars() {

        //given
        String pesel = "0207080362";


        //when
        Pesel peselValidator = new Pesel();
        boolean valid = peselValidator.valid(pesel);


        //then
        assertFalse(valid);
    }


    @Test
    public void testPeselIsNullOrIsEmpty() {

        //given
        String pesel = null;
        if (pesel == null) {
            pesel = "";
        }

        //when
        Pesel peselValidator = new Pesel();
        boolean valid = peselValidator.valid(pesel);


        //then
        assertFalse(valid);

    }

}