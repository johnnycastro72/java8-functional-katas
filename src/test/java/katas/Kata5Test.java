package katas;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata5Test {

    @Test
    public void testExecute() {
        Assert.assertEquals(Kata5.execute(), 5.0, 0.0);
    }
}
