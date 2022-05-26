package katas;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata6Test {

    @Test
    public void testExecute() {
        Assert.assertEquals(Kata6.execute(), "http://cdn-0.nflximg.com/images/2891/Fracture300.jpg");
    }
}
