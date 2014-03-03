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

        assertThat(gg.getTestCasesTotal(), is(3));
    }

    @Test
    public void testReadTestCases() throws URISyntaxException, FileNotFoundException {
        Main gg = new Main();
        gg.processInput(new Scanner(new File(this.getClass().getResource("test01.txt").toURI())));

        assertThat(gg.getTestCase(0), is(notNullValue()));
        assertThat(gg.getTestCase(0).getHintsTotal(), is(2));

        assertThat(gg.getTestCase(1), is(notNullValue()));
        assertThat(gg.getTestCase(1).getHintsTotal(), is(3));

        assertThat(gg.getTestCase(2), is(notNullValue()));
        assertThat(gg.getTestCase(2).getHintsTotal(), is(6));
    }

    @Test
    public void testReadHints() throws URISyntaxException, FileNotFoundException {
        Main gg = new Main();
        gg.processInput(new Scanner(new File(this.getClass().getResource("test01.txt").toURI())));

        Main.TestCase testCase = gg.getTestCase(0);
        assertThat(testCase, is(notNullValue()));
        assertThat(testCase.getHintsTotal(), is(2));

        Main.Hint hint0 = testCase.getHints().get(0);
        assertThat(hint0.getOperator(), is(Main.Hint.Operator.LESS_THAN));
        assertThat(hint0.getValue(), is(100L));
        assertThat(hint0.isNo(), is(true));
    }

    @Test
    public void testHintIsCorrect() {
        Main.Hint hint1 = new Main.Hint(Main.Hint.Operator.LESS_THAN, 100L, false);
        Main.Hint hint2 = new Main.Hint(Main.Hint.Operator.GREATER_THAN, 100L, false);
        Main.Hint hint3 = new Main.Hint(Main.Hint.Operator.EQUALS, 100L, true);

        assertThat(hint1.isTrue(100L), is(true));
        assertThat(hint1.isLie(99L), is(true));

        assertThat(hint2.isTrue(100L), is(true));
        assertThat(hint3.isTrue(100L), is(true));
    }

    @Test
    public void testTestCaseLiesUsingNumber() throws URISyntaxException, FileNotFoundException {
        Main gg = new Main();
        gg.processInput(new Scanner(new File(this.getClass().getResource("test01.txt").toURI())));

        assertThat(gg.getTestCase(0).liesUsingNumber(100), is(0));
        assertThat(gg.getTestCase(0).liesUsingNumber(99), is(1));

        assertThat(gg.getTestCase(2).liesUsingNumber(1), is(2));
    }

    @Test
    public void testPlay() throws URISyntaxException, FileNotFoundException {
        Main gg = new Main();
        gg.processInput(new Scanner(new File(this.getClass().getResource("test01.txt").toURI())));

        assertThat(gg.minimalPossibleNumberOfLiesForTestCase(0), is(0L));
        assertThat(gg.minimalPossibleNumberOfLiesForTestCase(1), is(1L));
        assertThat(gg.minimalPossibleNumberOfLiesForTestCase(2), is(2L));
    }

    @Test
    public void testGetMaxNToSearch() throws URISyntaxException, FileNotFoundException {
        Main gg = new Main();
        gg.processInput(new Scanner(new File(this.getClass().getResource("test01.txt").toURI())));

        assertThat(gg.getTestCase(0).getMaxNToSearch(), is(100L));
    }
}
