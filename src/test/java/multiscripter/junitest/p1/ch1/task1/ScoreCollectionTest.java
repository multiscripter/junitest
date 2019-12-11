package multiscripter.junitest.p1.ch1.task1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreCollectionTest {

    @Test
    public void testArithmeticMean() {
        ScoreCollection col = new ScoreCollection();
        col.add(() -> 5);
        col.add(() -> 7);

        int actual = col.arithmeticMean();

        assertEquals(6, actual);
    }
}
