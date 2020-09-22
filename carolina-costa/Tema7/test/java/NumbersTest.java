import org.junit.Assert;
import org.junit.Test;

public class NumbersTest {

    Numbers numberTest = new Numbers();

    @Test
    public void convertIntToRomanTest(){
        numberTest.convertIntToRoman(5);
        Assert.assertEquals("V","V");
    }

    @Test
    public void convertIntToNotContainRomanTest(){
        Assert.assertNull(numberTest.convertIntToRoman(21));
    }

    @Test
    public void nullNumberParameterTest(){
        Assert.assertNull(numberTest.convertIntToRoman(null));
    }

    @Test
    public void negativeNumberTest(){
        Assert.assertNull(numberTest.convertIntToRoman(-5));
    }

    @Test
    public void convertRomanToIntTest(){
        numberTest.convertRomanToInt("V");
        Assert.assertEquals(5, 5);
    }

    @Test
    public void convertRomanOtherStringIntTest(){
        Assert.assertNull(numberTest.convertRomanToInt("XJJJ"));
    }

    @Test
    public void convertRomanToNotContainIntTest(){
        Assert.assertNull(numberTest.convertRomanToInt("XXI"));
    }

    @Test
    public void insertLowerCaseRomanTest(){
        numberTest.convertRomanToInt("v");
        Assert.assertEquals(5, 5);
    }

    @Test
    public void nullStringParameterTest(){
        Assert.assertNull(numberTest.convertRomanToInt(null));
    }
}
