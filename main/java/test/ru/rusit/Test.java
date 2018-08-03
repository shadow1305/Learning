package ru.rusit;

import org.junit.Assert;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;

/**
 * Сюда не заглядываем.
 */
public class Test {
    
    @org.junit.Test
    public void testMain() {
        Assert.assertThat(check(Main.excersize(new String[]{"1", "10", "5", "9", "100", "20", "11"})), is(true));
    }
    
    @org.junit.Test(expected = FileNotFoundException.class)
    public void testMainException() {
        Main.excersize(new String[]{"1", "10", "5", "nine", "100", "20", "11"});
    }
    
    private boolean check(Double[] excersize) {
        Iterator<Double> number = Arrays.asList(excersize).iterator();
        Double controlNumber = number.next();
        while (number.hasNext()) {
            Double currentNumber = number.next();
            if (controlNumber > currentNumber) {
                return false;
            }
            controlNumber = currentNumber;
        }
        return true;
    }
    
}
