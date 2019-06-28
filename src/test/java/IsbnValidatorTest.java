import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsbnValidatorTest {

    @Test
    public void testIsbnCorrect10() {

        //given
        String isbn = "830901550X";

        //when
        IsbnValidator isbnValidator = new IsbnValidator();
        boolean valid = isbnValidator.valid(isbn);

        //then
        assertTrue(valid);
    }

    @Test
    public void testIsbnCorrect13() {

        //given
        String isbn = "83-87347-42-6";

        //when
        IsbnValidator isbnValidator = new IsbnValidator();
        boolean valid = isbnValidator.valid(isbn);

        //then
        assertTrue(valid);
    }

    @Test
    public void testIsbnCorrect15() {

        //given
        String isbn = "838734742650500";

        //when
        IsbnValidator isbnValidator = new IsbnValidator();
        boolean valid = isbnValidator.valid(isbn);

        //then
        assertTrue(valid);
    }

    @Test
    public void testIsbnCorrect19() {

        //given
        String isbn = "83-87347-42-6 50500";

        //when
        IsbnValidator isbnValidator = new IsbnValidator();
        boolean valid = isbnValidator.valid(isbn);

        //then
        assertTrue(valid);
    }

    @Test
    public void testIsbnIncorrect10() {

        //given
        String isbn = "809015504";

        //when
        IsbnValidator isbnValidator = new IsbnValidator();
        boolean valid = isbnValidator.valid(isbn);

        //then
        assertFalse(valid);
    }

    @Test
    public void testIsbnIncorrect13() {

        //given
        String isbn = "b3/09-01/5";

        //when
        IsbnValidator isbnValidator = new IsbnValidator();
        boolean valid = isbnValidator.valid(isbn);

        //then
        assertFalse(valid);
    }

    @Test
    public void testIsbnIncorrect15() {

        //given
        String isbn = "868b347423/0500";

        //when
        IsbnValidator isbnValidator = new IsbnValidator();
        boolean valid = isbnValidator.valid(isbn);

        //then
        assertFalse(valid);
    }

    @Test
    public void testIsbnIncorrect19() {

        //given
        String isbn = "83-87343-42-6 50500";

        //when
        IsbnValidator isbnValidator = new IsbnValidator();
        boolean valid = isbnValidator.valid(isbn);

        //then
        assertFalse(valid);
    }

    @Test
    public void testIsbnLessThen10(){

        //given
        String isbn = "838734742";

        //when
        IsbnValidator isbnValidator = new IsbnValidator();
        boolean valid = isbnValidator.valid(isbn);

        //then
        assertFalse(valid);
    }

    @Test
    public void testIsbnMoreThen10AndLessThen13(){

        //given
        String isbn = "83873474267";

        //when
        IsbnValidator isbnValidator = new IsbnValidator();
        boolean valid = isbnValidator.valid(isbn);

        //then
        assertFalse(valid);
    }

    @Test
    public void testIsbnMoreThen13AndLessThen15(){

        //given
        String isbn = "83873474267456";

        //when
        IsbnValidator isbnValidator = new IsbnValidator();
        boolean valid = isbnValidator.valid(isbn);

        //then
        assertFalse(valid);
    }

    @Test
    public void testIsbnMoreThen15AndLessThen19(){

        //given
        String isbn = "8387347426745634";

        //when
        IsbnValidator isbnValidator = new IsbnValidator();
        boolean valid = isbnValidator.valid(isbn);

        //then
        assertFalse(valid);
    }

    @Test
    public void testIsbnMoreThen19(){

        //given
        String isbn = "83873474267456345669";

        //when
        IsbnValidator isbnValidator = new IsbnValidator();
        boolean valid = isbnValidator.valid(isbn);

        //then
        assertFalse(valid);
    }

    @Test
    public void testIsbnIsNullOrIsEmpty(){

        //given
        String isbn = null;
        if (isbn == null) {
            isbn = "";
        }
        //when
        IsbnValidator isbnValidator = new IsbnValidator();
        boolean valid = isbnValidator.valid(isbn);

        //then
        assertFalse(valid);
    }
}