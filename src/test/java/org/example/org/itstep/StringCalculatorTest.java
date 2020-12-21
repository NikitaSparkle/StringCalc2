package org.example.org.itstep;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.example.org.itstep.StringCalculator.add;
import static org.example.org.itstep.StringCalculator.getDelimiters;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void kata01() throws SpliterFormatException, NumberNegativeException {
       assertEquals(0, add(null));
       assertEquals(0, add(""));
       assertEquals(1, add("1"));
       assertEquals(3, add(" 1,2 "));
       assertEquals(4, add("4"));
    }

    @Test
    public void kata02() throws SpliterFormatException, NumberNegativeException {
        assertEquals(6,add("1,2,3"));
        assertEquals(4,add("1,1,1,1"));
        assertEquals(3,add("1,2"));
        assertEquals(66,add("11,22,33"));
    }

    @Test
    public void kata03() throws SpliterFormatException, NumberNegativeException {
        assertEquals(6,add("1 \n2,3"));
        assertEquals(15,add("4\n5\n6"));
        assertEquals(77,add("77\n"));
    }

    @Test
    public void kata04() throws SpliterFormatException, NumberNegativeException {
        assertEquals(1,add("1, 1001"));
        assertEquals(2,add("1002 \n 2"));
        assertEquals(1001,add("1, 1000"));
        assertEquals(2000,add("1000, 1000"));
        assertEquals(0,add("1001\n10001"));
    }

    @Test
    public void kata05() throws SpliterFormatException, NumberNegativeException {
        assertEquals(3,add("//;\n1; 2"));
        assertEquals(5,add("//*\n2,3"));
        assertEquals(7,add("//#\n3# 4"));
    }

    @Test(expected = SpliterFormatException.class)
    public void kata05_4() throws SpliterFormatException, NumberNegativeException {
        add("//1\n1 1 1");
    }

    @Test(expected = SpliterFormatException.class)
    public void kata05_5() throws SpliterFormatException, NumberNegativeException {
      add("//;\n1#2");
    }

    @Test
    public void kata06() throws SpliterFormatException, NumberNegativeException {
        assertEquals(6,add("//[***]\n1 *** 2 *** 3"));
        assertEquals(20,add("//[xy]\n3xy4xy5xy8"));
    }

    @Test
    public void kata07() throws SpliterFormatException, NumberNegativeException {
        assertEquals(6,add("//[*][%]\n1*2%3"));
        assertEquals(8,add("//[&&][|||]\n3|||2&&3"));

    }

    @Test
    public void getDelimitersTest(){
        assertArrayEquals(new String[]{"*", "%"}, getDelimiters("[*][%]"));
        assertArrayEquals(new String[]{"&&", "|||"}, getDelimiters("[&&][|||]"));
    }

    @Test
    public void kata08() throws SpliterFormatException, NumberNegativeException {
        assertEquals(10,add("1","1,2","1\n2,3"));
    }

    @Test(expected = NumberNegativeException.class)
    public void kata09() throws SpliterFormatException, NumberNegativeException {
        add("1,-1");
        add("-1,1");
        add("-1,-1");
        add("-1,1\n-1");
    }

    @Test(timeout = 30)
    public void kata10() throws SpliterFormatException, NumberNegativeException {
        assertEquals(6,add("//[*][%]\n1*2%3"));
        assertEquals(8,add("//[&&][|||]\n3|||2&&3"));
        assertEquals(7,add("//[//]\n1//2//4"));
        assertEquals(1998,add("999,999"));
        assertEquals(3,add("3,1001"));
        assertEquals(6,add("//[*][%][]\n1*2%3"));
    }

}
