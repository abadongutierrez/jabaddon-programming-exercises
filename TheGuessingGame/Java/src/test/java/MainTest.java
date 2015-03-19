import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class MainTest {

    @Test
    public void testReadTestCasesTotal() throws FileNotFoundException, URISyntaxException {
        Main gg = new Main();
        gg.processInput(new Scanner(new File(this.getClass().getResource("test01.txt").toURI())));

        assertThat(gg.getNumberOfTestCases(), is(3));
    }

    @Test
    public void testReadTestCases() throws URISyntaxException, FileNotFoundException {
        Main gg = new Main();
        gg.processInput(new Scanner(new File(this.getClass().getResource("test01.txt").toURI())));

        assertThat(gg.getTestCase(0).getHintsTotal(), is(2));
        assertThat(gg.getTestCase(1).getHintsTotal(), is(3));
        assertThat(gg.getTestCase(2).getHintsTotal(), is(6));
    }

    @Test
    public void testReadHints() throws URISyntaxException, FileNotFoundException {
        Main gg = new Main();
        gg.processInput(new Scanner(new File(this.getClass().getResource("test01.txt").toURI())));

        Main.TestCase testCase = gg.getTestCase(0);
        assertThat(testCase.getHintsTotal(), is(2));

        Main.Hint hint0 = testCase.getHints().get(0);
        assertThat(hint0.getOperator(), is(Main.Hint.Operator.LESS_THAN));
        assertThat(hint0.getValue(), is(100L));
        assertThat(hint0.isNo(), is(true));

        Main.Hint hint1 = testCase.getHints().get(1);
        assertThat(hint1.getOperator(), is(Main.Hint.Operator.GREATER_THAN));
        assertThat(hint1.getValue(), is(100L));
        assertThat(hint1.isNo(), is(true));
    }

    @Test
    public void testHintIsCorrect() {
        Main.Hint hint1 = new Main.Hint(Main.Hint.Operator.LESS_THAN, 100L, false);
        Main.Hint hint2 = new Main.Hint(Main.Hint.Operator.GREATER_THAN, 100L, false);
        Main.Hint hint3 = new Main.Hint(Main.Hint.Operator.EQUALS, 100L, true);

        assertThat(hint1.isCorrectFor(100L), is(true));
        assertThat(hint1.isCorrectFor(99L), is(false));

        assertThat(hint2.isCorrectFor(100L), is(true));
        assertThat(hint2.isCorrectFor(99L), is(true));
        assertThat(hint2.isCorrectFor(101L), is(false));

        assertThat(hint3.isCorrectFor(100L), is(true));
        assertThat(hint3.isCorrectFor(101L), is(false));
    }

    @Test
    public void testTestCaseLiesUsingNumber() throws URISyntaxException, FileNotFoundException {
        Main gg = new Main();
        gg.processInput(new Scanner(new File(this.getClass().getResource("test01.txt").toURI())));

        assertThat(gg.getTestCase(0).liesForNumber(100), is(0));
        assertThat(gg.getTestCase(0).liesForNumber(99), is(1));

        assertThat(gg.getTestCase(2).liesForNumber(1), is(2));
    }

    @Test
    public void testPlay() throws URISyntaxException, FileNotFoundException {
        Main gg = new Main();
        long start = System.currentTimeMillis();
        gg.processInput(new Scanner(new File(this.getClass().getResource("test01.txt").toURI())));
        System.out.println("ms for block 'processInput' was: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        assertThat(gg.minimalPossibleNumberOfLiesForTestCase(0), is(0L));
        System.out.println("ms for block 'testCase-0' was: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        assertThat(gg.minimalPossibleNumberOfLiesForTestCase(1), is(1L));
        System.out.println("ms for block 'testCase-1' was: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        assertThat(gg.minimalPossibleNumberOfLiesForTestCase(2), is(2L));
        System.out.println("ms for block 'testCase-2' was: " + (System.currentTimeMillis() - start));
    }
}
